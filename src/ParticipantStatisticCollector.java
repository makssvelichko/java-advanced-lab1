import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

public class ParticipantStatisticCollector implements Collector<Participant, List<Integer>, ParticipantStatisticData> {
    public ParticipantStatisticCollector() {
    }

    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList();
    }

    public BiConsumer<List<Integer>, Participant> accumulator() {
        return (accumulator, value) -> accumulator.add(value.getMonthlyIncome());
    }

    public Function<List<Integer>, ParticipantStatisticData> finisher() {
        return (income) -> {
            Optional<Integer> minOptional = income.stream().min(Integer::compare);
            int min = (Integer)minOptional.orElse(0);
            Optional<Integer> maxOptional = income.stream().max(Integer::compare);
            int max = (Integer)maxOptional.orElse(0);
            OptionalDouble avgOptional = income.stream().mapToInt(Integer::intValue).average();
            double avg = avgOptional.orElse((double)0.0F);
            double stdDeviation = Math.sqrt(income.stream().mapToDouble((price) -> Math.pow((double)price - avg, (double)2.0F)).average().orElse((double)0.0F));
            return new ParticipantStatisticData(min, max, avg, stdDeviation);
        };
    }

    public BinaryOperator<List<Integer>> combiner() {
        return (left, right) -> {
            List<Integer> result = new ArrayList(left);
            result.addAll(right);
            return result;
        };
    }

    public Set<Collector.Characteristics> characteristics() {
        Set<Collector.Characteristics> characteristics = new HashSet();
        characteristics.add(Characteristics.CONCURRENT);
        return characteristics;
    }
}
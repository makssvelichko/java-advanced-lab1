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
/**
 * A custom collector implementation to calculate statistical data about participants' monthly incomes.
 * It computes the minimum, maximum, average, and standard deviation of incomes.
 */
public class ParticipantStatisticCollector implements Collector<Participant, List<Integer>, ParticipantStatisticData> {
    /**
     * Provides a supplier that initializes the accumulator as an empty list of integers.
     *
     * @return a supplier for the accumulator.
     */
    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<>();
    }

    /**
     * Provides an accumulator that adds the monthly income of a participant to the list.
     *
     * @return a BiConsumer to accumulate participant incomes.
     */
    public BiConsumer<List<Integer>, Participant> accumulator() {
        return (accumulator, value) -> accumulator.add(value.getMonthlyIncome());
    }

    /**
     * Provides a finisher function that calculates statistical data based on the collected incomes.
     *
     * @return a Function that converts the list of incomes into a {@link ParticipantStatisticData} object.
     *
     * @author Velichko Maksim
     */
    public Function<List<Integer>, ParticipantStatisticData> finisher() {
        return (income) -> {
            Optional<Integer> minOptional = income.stream().min(Integer::compare);
            int min = minOptional.orElse(0);
            Optional<Integer> maxOptional = income.stream().max(Integer::compare);
            int max = maxOptional.orElse(0);
            OptionalDouble avgOptional = income.stream().mapToInt(Integer::intValue).average();
            double avg = avgOptional.orElse(0.0F);
            double stdDeviation = Math.sqrt(income.stream()
                    .mapToDouble((price) -> Math.pow((double)price - avg, 2.0F))
                    .average()
                    .orElse(0.0F));
            return new ParticipantStatisticData(min, max, avg, stdDeviation);
        };
    }

    /**
     * Provides a combiner function to merge two accumulators.
     *
     * @return a BinaryOperator to combine two lists of incomes.
     */
    public BinaryOperator<List<Integer>> combiner() {
        return (left, right) -> {
            List<Integer> result = new ArrayList<>(left);
            result.addAll(right);
            return result;
        };
    }

    /**
     * Provides the characteristics of the collector.
     *
     * @return a set of characteristics that includes {@link Characteristics#CONCURRENT}.
     */
    public Set<Collector.Characteristics> characteristics() {
        Set<Collector.Characteristics> characteristics = new HashSet<>();
        characteristics.add(Characteristics.CONCURRENT);
        return characteristics;
    }
}
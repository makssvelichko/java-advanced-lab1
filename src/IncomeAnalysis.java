import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IncomeAnalysis {
    public IncomeAnalysis() {
    }

    public static Map<String, Long> incomeAnalysis(List<Participant> participants) {
        List<Integer> income = (List)participants.stream().map(Participant::getMonthlyIncome).sorted().collect(Collectors.toList());
        int Q1 = calculate(income, 25);
        int Q3 = calculate(income, 75);
        int IQR = Q3 - Q1;
        double lowerPart = (double)Q1 - (double)1.5F * (double)IQR;
        double upperPart = (double)Q3 + (double)1.5F * (double)IQR;
        Map<Boolean, Long> res = (Map)participants.stream().collect(Collectors.partitioningBy((participant) -> (double)participant.getMonthlyIncome() >= lowerPart && (double)participant.getMonthlyIncome() <= upperPart, Collectors.counting()));
        Map<String, Long> Result = new HashMap();
        Result.put("data", (Long)res.get(true));
        Result.put("outliers", (Long)res.get(false));
        return Result;
    }

    private static int calculate(List<Integer> sortedIncome, int percentile) {
        int index = (int)Math.ceil((double)percentile / (double)100.0F * (double)sortedIncome.size()) - 1;
        return (Integer)sortedIncome.get(index);
    }
}

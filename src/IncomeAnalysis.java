import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * A utility class for analyzing participants' income data, including detecting outliers
 * and providing statistical insights using the Interquartile Range (IQR) method.
 *
 * @author Velichko Maksim
 */
public class IncomeAnalysis {

    /**
     * Performs income analysis on a list of participants.
     * The method uses the Interquartile Range (IQR) to separate income data into two groups:
     * within the typical range (non-outliers) and outliers.
     *
     * @param participants a list of participants with their income data.
     * @return a map containing:
     *         - "data": the count of participants with typical income values.
     *         - "outliers": the count of participants with outlier income values.
     */
    public static Map<String, Long> incomeAnalysis(List<Participant> participants) {
        List<Integer> income = participants.stream()
                .map(Participant::getMonthlyIncome)
                .sorted()
                .collect(Collectors.toList());

        // Calculate the 25th percentile (Q1) and 75th percentile (Q3)
        int Q1 = calculate(income, 25);
        int Q3 = calculate(income, 75);

        // Calculate the interquartile range (IQR)
        int IQR = Q3 - Q1;

        // Define lower and upper bounds for outlier detection
        double lowerPart = (double)Q1 - (double)1.5F * (double)IQR;
        double upperPart = (double)Q3 + (double)1.5F * (double)IQR;
        Map<Boolean, Long> res = participants.stream()
                .collect(Collectors.partitioningBy(
                        (participant) -> (double)participant.
                                getMonthlyIncome() >= lowerPart && (double)participant
                                .getMonthlyIncome() <= upperPart, Collectors.counting()));

        // Map the results into "data" (typical incomes) and "outliers"
        Map<String, Long> Result = new HashMap<>();
        Result.put("data", res.get(true));
        Result.put("outliers", res.get(false));
        return Result;
    }

    /**
     * Calculates the value at a given percentile in a sorted list of incomes.
     *
     * @param sortedIncome the sorted list of income values.
     * @param percentile   the percentile to calculate (e.g., 25 for Q1 or 75 for Q3).
     * @return the income value at the specified percentile.
     */
    private static int calculate(List<Integer> sortedIncome, int percentile) {
        int index = (int)Math.ceil((double)percentile / (double)100.0F * (double)sortedIncome.size()) - 1;
        return sortedIncome.get(index);
    }
}

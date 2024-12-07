/**
 * The ParticipantStatisticData class represents statistical data about participants' incomes.
 * It includes the minimum income, maximum income, average income, and standard deviation of incomes.
 *
 * @author Velichko Maksim
 */
public class ParticipantStatisticData {
    private final int minIncome;
    private final int maxIncome;
    private final double avgIncome;
    private final double stdDeviation;

    /**
     * Constructs a ParticipantStatisticData object with the specified statistical values.
     *
     * @param minIncome    the minimum income among the participants.
     * @param maxIncome    the maximum income among the participants.
     * @param avgIncome    the average income of the participants.
     * @param stdDeviation the standard deviation of the participants' incomes.
     */
    public ParticipantStatisticData(int minIncome, int maxIncome, double avgIncome, double stdDeviation) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.avgIncome = avgIncome;
        this.stdDeviation = stdDeviation;
    }

    /**
     * Returns a string representation of the statistical data.
     *
     * @return a string containing the minimum, maximum, average, and standard deviation of incomes.
     */
    public String toString() {
        return "ParticipantStatisticData{" +
                "minIncome=" + this.minIncome + "," +
                " maxIncome=" + this.maxIncome + "," +
                " avgIncome=" + this.avgIncome + "," +
                " stdDeviation=" + this.stdDeviation + "}";
    }
}
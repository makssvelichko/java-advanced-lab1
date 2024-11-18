public class ParticipantStatisticData {
    private final int minIncome;
    private final int maxIncome;
    private final double avgIncome;
    private final double stdDeviation;

    public ParticipantStatisticData(int minIncome, int maxIncome, double avgIncome, double stdDeviation) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
        this.avgIncome = avgIncome;
        this.stdDeviation = stdDeviation;
    }

    public String toString() {
        return "ParticipantStatisticData{minIncome=" + this.minIncome + ", maxIncome=" + this.maxIncome + ", avgIncome=" + this.avgIncome + ", stdDeviation=" + this.stdDeviation + "}";
    }
}
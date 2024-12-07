import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Main class that demonstrates filtering, grouping, statistical analysis,
 * and income analysis of a list of participants.
 *
 * @author Velichko Maksim
 */
public class Main {
    /**
     * Main entry point of the program.
     */
    public static void main(String[] args) {
        int N = 30;
        String cityToSkip = "Kyiv";

        // Generate and filter
        List<Participant> participant = ParticipantGenerator.generateParticipants()
                .gather(new ParticipantGatherer(N, cityToSkip))
                .limit(500)
                .collect(Collectors.toList());
        for (Participant participants : participant) {
            System.out.println(participants);
        }

        // Group participants by name if their age is under 40
        Map<String, List<Participant>> groupedParticipant = participant.stream()
                .filter(item -> item.getDateBirth().isAfter(LocalDate.now().minusYears(40)))
                .collect(Collectors.groupingBy(Participant::getName));
        for (Map.Entry<String, List<Participant>> entry : groupedParticipant.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }

        // Collect participant statistics
        ParticipantStatisticData statistic = participant.stream()
                .collect(new ParticipantStatisticCollector());
        System.out.println(statistic);

        // Analyze income distribution and other metrics
        Map<String, Long> incomeAnalysis = IncomeAnalysis.incomeAnalysis(participant);
        System.out.println(incomeAnalysis);
    }
}
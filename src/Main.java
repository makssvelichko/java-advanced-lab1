import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
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

        Map<String, List<Participant>> groupedParticipant = participant.stream()
                .filter(item -> item.getDateBirth().isAfter(LocalDate.now().minusYears(40)))
                .collect(Collectors.groupingBy(Participant::getName));
        for (Map.Entry<String, List<Participant>> entry : groupedParticipant.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }

        ParticipantStatisticData statistic = participant.stream()
                .collect(new ParticipantStatisticCollector());
        System.out.println(statistic);

        Map<String, Long> incomeAnalysis = IncomeAnalysis.incomeAnalysis(participant);
        System.out.println(incomeAnalysis);
    }
}
import java.util.Optional;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;
/**
 * The ParticipantGatherer class filters participants based on a specified city and a skip count.
 * It implements the {Gatherer} interface to customize the behavior of processing streams of participants.
 *
 * @author Velichko Maksim
 */
public class ParticipantGatherer implements Gatherer<Participant, Optional<Participant>, Participant> {
    private int skipCount;
    private final String skipCity;
    /**
     * Constructs a ParticipantGatherer with the given skip count and city to skip.
     *
     * @param skipCount the number of participants from the specified city to skip.
     * @param skipCity  the city whose participants should be skipped.
     */
    public ParticipantGatherer(int skipCount, String skipCity) {
        this.skipCount = skipCount;
        this.skipCity = skipCity;
    }
    /**
     * Provides an integrator that applies the skipping logic based on the specified city and count.
     */
    public Gatherer.Integrator<Optional<Participant>, Participant, Participant> integrator() {
        return Integrator.of((_, element, downstream) -> {
            boolean shouldSkip = element.getCity().equals(this.skipCity) && this.skipCount > 0;
            if (shouldSkip) {
                this.skipCount--;
                return true;
            } else {
                return downstream.push(element);
            }
        });
    }
}
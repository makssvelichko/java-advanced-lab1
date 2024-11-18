import java.util.Optional;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;

public class ParticipantGatherer implements Gatherer<Participant, Optional<Participant>, Participant> {
    private int skipCount;
    private final String skipCity;

    public ParticipantGatherer(int skipCount, String skipCity) {
        this.skipCount = skipCount;
        this.skipCity = skipCity;
    }

    public Gatherer.Integrator<Optional<Participant>, Participant, Participant> integrator() {
        return Integrator.of((var1, element, downstream) -> {
            boolean shouldSkip = element.getCity().equals(this.skipCity) && this.skipCount > 0;
            if (shouldSkip) {
                --this.skipCount;
                return true;
            } else {
                return downstream.push(element);
            }
        });
    }
}
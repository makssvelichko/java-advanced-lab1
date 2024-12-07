import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;
/**
 * The ParticipantGenerator class generates a stream of random participants with
 * randomized attributes such as name, surname, city, date of birth, and monthly income.
 *
 * @author Velichko Maksim
 */
public class ParticipantGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] NAMES = new String[]{"Alexander", "Maria", "Andrew", "Artem", "Catherine", "Maksim"};
    private static final String[] SURNAMES = new String[]{"Miller", "Shevchenko", "Kovalenko", "Kravchenko", "Boyko", "Bondarenko"};
    private static final String[] CITIES = new String[]{"Kyiv", "Odesa", "Kharkiv", "Lviv", "Zhytomyr", "Dnipro"};

    /**
     * Generates an infinite stream of random {@link Participant} objects.
     *
     * @return a stream of participants with randomized attributes.
     */
    public static Stream<Participant> generateParticipants() {
        return Stream.generate(() -> new Participant(getRandomNames(),
                getRandomSurNames(),
                getRandomCities(),
                LocalDate.now().minusYears(18 + RANDOM.nextInt(53)),
                (int) (10000 + (120000 * RANDOM.nextDouble()))));
    }

    /**
     * Selects a random name from the predefined list.
     *
     * @return a random first name.
     */
    private static String getRandomNames() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    /**
     * Selects a random surname from the predefined list.
     *
     * @return a random last name.
     */
    private static String getRandomSurNames() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    /**
     * Selects a random city from the predefined list.
     *
     * @return a random city name.
     */
    private static String getRandomCities() {
        return CITIES[RANDOM.nextInt(CITIES.length)];
    }
}
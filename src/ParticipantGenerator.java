import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

public class ParticipantGenerator {
    private static final Random RANDOM = new Random();
    private static final String[] NAMES = new String[]{"Alexander", "Maria", "Andrew", "Artem", "Catherine", "Maksim"};
    private static final String[] SURNAMES = new String[]{"Miller", "Shevchenko", "Kovalenko", "Kravchenko", "Boyko", "Bondarenko"};
    private static final String[] CITIES = new String[]{"Kyiv", "Odesa", "Kharkiv", "Lviv", "Zhytomyr", "Dnipro"};

    public ParticipantGenerator() {
    }

    public static Stream<Participant> generateParticipants() {
        return Stream.generate(() -> new Participant(getRandomNames(), getRandomSurNames(), getRandomCities(), LocalDate.now().minusYears((long)(18 + RANDOM.nextInt(63))), (int)((double)10000.0F + (double)120000.0F * RANDOM.nextDouble())));
    }

    private static String getRandomNames() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    private static String getRandomSurNames() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    private static String getRandomCities() {
        return CITIES[RANDOM.nextInt(CITIES.length)];
    }
}
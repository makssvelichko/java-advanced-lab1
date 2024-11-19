import java.time.LocalDate;

/**
 * The Participant class represents a participant with personal and financial details.
 * This includes their name, surname, city of residence, date of birth, and monthly income.
 */
public class Participant {
    /**
     * Constructs a Participant instance with the specified details.
     *
     * @param name          the participant's first name.
     * @param surname       the participant's last name.
     * @param city          the city of residence.
     * @param dateBirth     the participant's date of birth.
     * @param monthlyIncome the participant's monthly income.
     */
    private String name;
    private String surname;
    private String city;
    private LocalDate dateBirth;
    private int monthlyIncome;

    public Participant(String name, String surname, String city, LocalDate dateBirth, int monthlyIncome) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.city = city;
        this.monthlyIncome = monthlyIncome;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public String getCity() {
        return this.city;
    }

    public int getMonthlyIncome() {
        return this.monthlyIncome;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    /**
     * Returns a string representation of the participant's details.
     *
     * @return a string containing the participant's name, surname, city, date of birth, and monthly income.
     */
    public String toString() {
        return "Participants{name='" + this.name + "'" +
                ", surname='" + this.surname + "'," +
                " dateBirth=" + this.dateBirth + "," +
                " city='" + this.city + "'," +
                " monthlyIncome=" + this.monthlyIncome + "}";
    }
}

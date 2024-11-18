import java.time.LocalDate;

public class Participant {
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

    public String toString() {
        String var10000 = this.name;
        return "Participants{name='" + var10000 + "', surname='" + this.surname + "', dateBirth=" + String.valueOf(this.dateBirth) + ", city='" + this.city + "', monthlyIncome=" + this.monthlyIncome + "}";
    }
}

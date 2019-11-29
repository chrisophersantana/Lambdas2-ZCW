import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person {
    String name;
    LocalDate birthdate;
    Sex gender;
    String emailAddress;
    ArrayList<Person> people = new ArrayList<Person>();

    public enum Sex {
        MALE,FEMALE
    }

    public Person(String name, LocalDate birthdate, Sex gender, String emailAddress) {
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getAge(){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public void printPerson(){
        System.out.print(String.format("Person Objects{Name: %s, Gender: %s, EmailAddress: %s}\n", name, birthdate, gender, emailAddress));
    }


}

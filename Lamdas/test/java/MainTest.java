import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;

public class MainTest {
    Person tp, tp1, tp2, tp3, tp4;
    ArrayList<Person> myPeeps = new ArrayList<>();
     @Before
    public void setUp() {
         tp = new Person("Chris Santana", LocalDate.of(1990, Month.JANUARY, 19), Person.Sex.MALE, "Christoph@gmail.com");
         tp1 = new Person("Lola Sanchez", LocalDate.of(1995, Month.MARCH, 19), Person.Sex.MALE, "Lola@gmail.com");
         tp2 = new Person("Carlos Santana", LocalDate.of(2000, Month.JULY, 22), Person.Sex.FEMALE, "Carlos@gmail.com");
         tp3 = new Person("Rocky Balboa", LocalDate.of(1998, Month.NOVEMBER, 4), Person.Sex.FEMALE, "Rocky@gmail.com");
         tp4 = new Person("Goku Kakarot", LocalDate.of(1500, Month.APRIL, 6), Person.Sex.MALE, "Goku@gmail.com");
         myPeeps.add(tp);
         myPeeps.add(tp1);
         myPeeps.add(tp2);
         myPeeps.add(tp3);
         myPeeps.add(tp4);
     }



    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test

    public void PrintPersonAnonymous(){
        String expected = "Person Object{ Name: Luis,Birthday: 2002-3-06, Gender: MALE, EmailAddress: Luis@gmail.com}";
        Main.printPersons(myPeeps, new CheckPerson() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() <= 18;
            }
        });
        Assert.assertEquals(expected, systemOutRule.getLog());
    }

    @Test
    public void printPersonsLambda () {
        String expected = "Person Object{ Name: Luis,Birthday: 2002-3-06, Gender: MALE, EmailAddress: Luis@gmail.com}";
        Main.printPersons(myPeeps,(Person p) -> p.getAge() >= 45 );
    }

}

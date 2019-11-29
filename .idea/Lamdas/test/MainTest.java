import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Map;

public class MainTest {




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
        Main.printPersons(myPeeps, -> person.getAge() >= 45 && person.Sex.FEMALE)
    }

}

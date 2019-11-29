import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster){
            if(tester.test(p)){
                p.printPerson();
            }
        }

    }


    public static void main(String[] args){
        Person tp, tp1, tp2, tp3, tp4;
        ArrayList<Person> myPeeps = new ArrayList<>();

        tp = new Person("Chris Santana", LocalDate.of(1990, Month.JANUARY, 19), Person.Sex.MALE, "Christoph@gmail.com");
        tp1 = new Person("Lola Sanchez", LocalDate.of(1995, Month.MARCH, 19), Person.Sex.MALE, "Lola@gmail.com");
        tp2 = new Person("Carlos Santana", LocalDate.of(2000, Month.JULY, 22), Person.Sex.FEMALE, "Carlos@gmail.com");
        tp3 = new Person("Rocky Balboa", LocalDate.of(1998, Month.NOVEMBER, 4), Person.Sex.FEMALE, "Rocky@gmail.com");
        tp4 = new Person("Goku Kakarot", LocalDate.of(2010, Month.APRIL, 6), Person.Sex.MALE, "Goku@gmail.com");
        myPeeps.add(tp);
        myPeeps.add(tp1);
        myPeeps.add(tp2);
        myPeeps.add(tp3);
        myPeeps.add(tp4);

        class checkForOver18 implements CheckPerson {
            @Override
            public  Boolean test(Person person) {
                return person.getAge()>=18;
            }
        }

        printPersons(myPeeps, new CheckPerson() {
          @Override  public Boolean test(Person person){
              return person.getAge() >= 18;
          }
        });


        printPersons(myPeeps, person -> person.getAge() >=45);
    }
}

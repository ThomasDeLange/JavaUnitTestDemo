import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PersonTest extends TestCase {

    @Test
    public void testSetPostalCodeWithValidPostalCodeReturnsTrue() {
        //Arange
        Person person = new Person();
        //Act
        boolean returnValue = person.setPostalCode("4800AA");
        //Assert
        Assertions.assertTrue(returnValue);
    }

    @Test
    public void testSetPostalCodeWithInvalidPostalCodeReturnsFalse() {
        //Arange
        Person person = new Person();
        //Act
        boolean returnValue = person.setPostalCode("0800AA");
        //Assert
        Assertions.assertFalse(returnValue);
    }


    @Test
    public void testGetAgeWithWithCurrentDateMinus3CodeReturns3() {
        //Arragne
        Person person = new Person();
        LocalDate dob = LocalDate.of(LocalDate.now().getYear()-3, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        person.setBirthday(dob);

        //Act
        int age = person.getAge();

        //Assert
        Assertions.assertEquals(3, age);

    }
    @Test
    public void testGetAgeWithWithCurrentDateMinus3YearsMinus1DayCodeReturns3() {
        //Arragne
        Person person = new Person();
        LocalDate dob = LocalDate.now().minusYears(3).minusDays(1);
        person.setBirthday(dob);
        //Act
        int age = person.getAge();

        //Assert
        Assertions.assertEquals(3, age);

    }
    @Test
    public void testGetAgeWithWithCurrentDateMinus3YearsPlus1DayCodeReturns2() {
        //Arrange
        Person person = new Person();
        LocalDate dob = LocalDate.now().minusYears(3).plusDays(1);
        person.setBirthday(dob);
        //Act
        int age = person.getAge();

        //Assert
        Assertions.assertEquals(2, age);

    }

    @Test
    public void TestGetDaysUntilBirthdayWithDayIsBirthdayReturns0() {
        //Arrange
        Person person = new Person();
        LocalDate dob = LocalDate.now();
        person.setBirthday(dob);

        //Act
        int days = person.getDaysUntilBirthday();
        //Assert
        Assertions.assertEquals(0,days);

    }

    @Test
    public void TestGetDaysUntilBirthdayWithDayIsBirthdayplus364Returns1() {
        //Arrange
        Person person = new Person();
        LocalDate dob = LocalDate.now().plusDays(364);
        person.setBirthday(dob);

        //Act
        int days = person.getDaysUntilBirthday();
        //Assert
        Assertions.assertEquals(1,days);

    }
    @Test
    public void TestGetDaysUntilBirthdayWithDayIsBirthdayMinus1Returns1() {
        //Arrange
        Person person = new Person();
        LocalDate dob = LocalDate.now().minusDays(1);
        person.setBirthday(dob);

        //Act
        int days = person.getDaysUntilBirthday();
        //Assert
        Assertions.assertEquals(1,days);

    }
}


package iegcode.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest{

    @Test
    void testContainerData() {

    Person person = new Person();
    person.setFirstName("Gibran");
    person.setLastName("Ibrahim");
    person.setAddress(new Address());
    person.getAddress().setCity("Sleman");
    person.getAddress().setCountry("Indonesia");
    person.getAddress().setStreet("Monjali");

    person.setHobbies(new ArrayList<>());
    person.getHobbies().add("");
    person.getHobbies().add(" ");
    person.getHobbies().add("Gaming");

    validate(person);
    }
}

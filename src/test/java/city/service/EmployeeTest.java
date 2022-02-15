package city.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {

    public Address stubAddress() {
        return new Address("Address1", "City1");
    }

    @Test
    public void testCapitalize() {
        Address stubAddress = stubAddress();
        Employee employee = new Employee("bob", 1, 20000, stubAddress);
        assertEquals(employee.getCapitalizedName(), "Bob");

    }
}

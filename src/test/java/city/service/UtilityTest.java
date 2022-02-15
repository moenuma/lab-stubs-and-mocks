package city.service;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import salary.service.City;
import salary.service.Salary;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilityTest {

    @Test
    public void getAddresses() {
        City city = mock(City.class);
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("address 1", "city 1"));
        addresses.add(new Address("address 2", "city 1"));
        addresses.add(new Address("address 3", "city 1"));
        addresses.add(new Address("address 4", "city 2"));
        when(city.listAddresses()).thenReturn(addresses);

        Utility utility = new Utility();

        List<Address> correctAddresses = new ArrayList<>();
        correctAddresses.add(new Address("address 1", "city 1"));
        correctAddresses.add(new Address("address 2", "city 1"));
        correctAddresses.add(new Address("address 3", "city 1"));

        List<Address> testAddresses = utility.getAddressesByCity(city, "city 1");

        for (int i = 0; i < testAddresses.size(); i++) {
            assertEquals(testAddresses.get(i).address, correctAddresses.get(i).address);
        }
    }

    @Test
    public void testSalaryFiltering() {
        Salary salary = mock(Salary.class);
        List<Integer> mockedSalaries = new ArrayList<>();
        mockedSalaries.add(40000);
        mockedSalaries.add(45000);
        mockedSalaries.add(50000);
        mockedSalaries.add(55000);
        mockedSalaries.add(60000);
        mockedSalaries.add(65000);

        when(salary.returnSalaries()).thenReturn(mockedSalaries);

        List<Integer> correctSalaries = new ArrayList<>();
        correctSalaries.add(55000);
        correctSalaries.add(60000);
        correctSalaries.add(65000);

        Utility utility = new Utility();
        List<Integer> salaries = utility.getSalariesOver(salary, 50000);

        for (int i = 0; i < salaries.size(); i++) {
            assertEquals(salaries.get(i), correctSalaries.get(i));
        }
    }
}

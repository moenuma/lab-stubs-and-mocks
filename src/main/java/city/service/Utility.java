package city.service;

import salary.service.City;
import salary.service.Salary;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public List<Address> getAddressesByCity(City city, String cityName) {
        List<Address> addresses = city.listAddresses();
        List<Address> filteredAddresses = new ArrayList<>();
        for (Address address: addresses) {
            if (address.city.equals(cityName)) {
                filteredAddresses.add(address);
            }
        }

        return filteredAddresses;
    }

    public List<Integer> getSalariesOver(Salary employeeSalaries, Integer filter) {
        List<Integer> salaries = employeeSalaries.returnSalaries();
        List<Integer> filteredSalaries = new ArrayList<>();
        for (Integer salary: salaries) {
            if (salary > filter) {
                filteredSalaries.add(salary);
            }
        }
        return filteredSalaries;
    }
}

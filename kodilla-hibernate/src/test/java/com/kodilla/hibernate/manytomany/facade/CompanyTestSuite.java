package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyTestSuite {

    @Autowired
    private CompanyAndEmployeeSearch search;

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void shouldSearchACompanyByAnyNameFragment() {

        //Given
        Company company1 = new Company("Nokia");
        Company company2 = new Company("Redmi");
        Company company3 = new Company("Xiaomi");

        companyDao.save(company1);
        int company1Id = company1.getId();
        companyDao.save(company2);
        int company2Id = company2.getId();
        companyDao.save(company3);
        int company3Id = company3.getId();

        //When
        List<Company> resultList1 = search.getCompanyByNameFragment("no");
        List<Company> resultList2 = search.getCompanyByNameFragment("red");
        List<Company> resultList3 = search.getCompanyByNameFragment("i");

        //Then
        try {
            assertEquals(1, resultList1.size());
            assertEquals("Nokia", resultList1.get(0).getName());
            assertEquals(1, resultList2.size());
            assertEquals("Redmi", resultList2.get(0).getName());
            assertEquals(3, resultList3.size());
            assertEquals("Nokia", resultList3.get(0).getName());
            assertEquals("Redmi", resultList3.get(1).getName());
            assertEquals("Xiaomi", resultList3.get(2).getName());
        } finally {
            //CleanUp
            companyDao.deleteById(company1Id);
            companyDao.deleteById(company2Id);
            companyDao.deleteById(company3Id);
        }
    }

    @Test
    void shouldSearchAEmployeeByAnyLastNameFragment() {

        //Given
        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Jacob", "Williams");
        Employee employee3 = new Employee("Bob", "Garcia");

        employeeDao.save(employee1);
        int employee1Id = employee1.getId();
        employeeDao.save(employee2);
        int employee2Id = employee2.getId();
        employeeDao.save(employee3);
        int employee3Id = employee3.getId();

        //When
        List<Employee> resultList1 = search.getEmployeeByLastNameFragment("th");
        List<Employee> resultList2 = search.getEmployeeByLastNameFragment("will");
        List<Employee> resultList3 = search.getEmployeeByLastNameFragment("a");

        //Then
        try {
            assertEquals(1, resultList1.size());
            assertEquals("Smith", resultList1.get(0).getLastname());
            assertEquals(1, resultList2.size());
            assertEquals("Williams", resultList2.get(0).getLastname());
            assertEquals(2, resultList3.size());
            assertEquals("Williams", resultList3.get(0).getLastname());
            assertEquals("Garcia", resultList3.get(1).getLastname());
        } finally {
            //CleanUp
            employeeDao.deleteById(employee1Id);
            employeeDao.deleteById(employee2Id);
            employeeDao.deleteById(employee3Id);
        }
    }
}

package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    final private String peselId;
    final private String firstame;
    final private String lastname;
    final private BigDecimal baseSalary;

    public Employee(String peselId, String firstame, String lastname, BigDecimal baseSalary) {
        this.peselId = peselId;
        this.firstame = firstame;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getFirstame() {
        return firstame;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(peselId, employee.peselId) && Objects.equals(firstame, employee.firstame) && Objects.equals(lastname, employee.lastname) && Objects.equals(baseSalary, employee.baseSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peselId, firstame, lastname, baseSalary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstame='" + firstame + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}

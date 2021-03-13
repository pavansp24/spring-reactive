package com.spring.reactive.demo;

public class Employee {

    private String firstName;

    private String lastName;

    private String designation;

    private String qualification;

    private String department;


    public Employee() {

    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public Employee setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    public String getQualification() {
        return qualification;
    }

    public Employee setQualification(String qualification) {
        this.qualification = qualification;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }

}

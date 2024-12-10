package com;

import java.util.Date;

public class User {
    private String id;
    private String name;
    private String gender;
    private Date birthday;
    private char division;
    private int salary;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public char getDivision() {
        return division;
    }
    public void setDivision(char division) {
        this.division = division;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public User(String id, String name, String gender, Date birthday, char division, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.division = division;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", division=" + division +
                ", salary=" + salary +
                '}';
    }
}

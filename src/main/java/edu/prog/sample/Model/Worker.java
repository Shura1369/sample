package edu.prog.sample.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;
@Document
public class Worker {
    @Id
    private  String id;
    private  String name;
    private String occupation;
    private int salary;
    private Speciality speciality;
    private LocalDate employmentDate;

    public Worker() {
    }

    public Worker(String id, String name, String occupation, int salary, Speciality speciality, LocalDate employmentDate) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
        this.salary = salary;
        this.speciality = speciality;
        this.employmentDate = employmentDate;
    }

    public Worker(String name, String occupation, int salary, Speciality speciality, LocalDate employmentDate) {
        this.name = name;
        this.occupation = occupation;
        this.salary = salary;
        this.speciality = speciality;
        this.employmentDate = employmentDate;
    }

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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", salary=" + salary +
                ", speciality=" + speciality +
                ", employmentDate=" + employmentDate +
                '}';
    }
}

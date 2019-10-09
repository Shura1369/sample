package edu.prog.sample.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Speciality {
    @Id
    private String id;
    private String name;
    private int rate;
    private  int demand;

    public Speciality() {
    }

    public Speciality(String name, int rate, int demand) {
        this.name = name;
        this.rate = rate;
        this.demand = demand;
    }

    public Speciality(String id, String name, int rate, int demand) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.demand = demand;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", demand=" + demand +
                '}';
    }
}

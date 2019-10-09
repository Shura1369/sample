package edu.prog.sample.Services.Speciality.interfaces;

import edu.prog.sample.Model.Speciality;

import java.util.List;

public interface IspecialitiService {

    List<Speciality> getAll();
    Speciality get(String id);
}

package edu.prog.sample.Services.Speciality.impls;

import edu.prog.sample.Model.Speciality;
import edu.prog.sample.Repository.SpecialityRepository;
import edu.prog.sample.Services.Speciality.interfaces.IspecialitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecialityServiceImpls implements IspecialitiService {
    List<Speciality> specialities = new ArrayList<>(
            Arrays.asList(
                    new Speciality("1","coder",25,100),
                    new Speciality("2","designer",15,10),
                    new Speciality("3","tester",3,50)
            )
    );

    @Autowired
    SpecialityRepository repository;
    public List<Speciality> getSpecialities()
    {
        return specialities;
    }

    @PostConstruct
    void init(){
        repository.deleteAll();
        repository.saveAll(specialities);
    }


    @Override
    public List<Speciality> getAll() {
        return repository.findAll();
    }

    @Override
    public Speciality get(String id) {
        return repository.findById(id).orElse(null);
    }
}

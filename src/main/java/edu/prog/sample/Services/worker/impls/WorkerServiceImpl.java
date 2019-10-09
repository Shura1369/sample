package edu.prog.sample.Services.worker.impls;

import edu.prog.sample.Model.Speciality;
import edu.prog.sample.Model.Worker;
import edu.prog.sample.Repository.WorkerRepository;
import edu.prog.sample.Services.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {

    List<Worker> workers = new ArrayList<>();
    List<Speciality> specialities;

    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){
       specialities = new ArrayList<>(
                Arrays.asList(
                        new Speciality("1","coder",25,100),
                        new Speciality("2","designer",15,10),
                        new Speciality("3","tester",3,50)
                )
        );
        repository.deleteAll();
        Worker ivan = new Worker("Ivan", "coder",1000,specialities.get(0));
        Worker stephan = new Worker("Stephan", "coder1",2000,specialities.get(1));
        Worker johnLenon = new Worker("John Lenon", "guitar",20000, specialities.get(2));
        workers.add(ivan);
        workers.add(stephan);
        workers.add(johnLenon);
        repository.saveAll(workers);
    }


    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Worker create(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = this.get(id);
        repository.deleteById(id);
        return worker;
    }
    public List<Speciality> getSpecialities()
    {
        return specialities;
    }

}

package edu.prog.sample.Services.impls;

import edu.prog.sample.Model.Worker;
import edu.prog.sample.Repository.WorkerRepository;
import edu.prog.sample.Services.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {

    List<Worker> workers = new ArrayList<>();

    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){
        Worker ivan = new Worker("Ivan", "coder",1000);
        Worker stephan = new Worker("Stephan", "coder1",2000);
        Worker johnLenon = new Worker("John Lenon", "guitar",20000);
        workers.add(ivan);
        workers.add(stephan);
        workers.add(johnLenon);
        //repository.saveAll(workers);
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
}

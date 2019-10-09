package edu.prog.sample.Services.worker.interfaces;

import edu.prog.sample.Model.Worker;

import java.util.List;

public interface IWorkerService {
    List<Worker> getAll();
    Worker get(String id);
    Worker create (Worker worker);
    Worker update (Worker worker);
    Worker delete (String id);
}

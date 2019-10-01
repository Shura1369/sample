package edu.prog.sample.Repository;

import edu.prog.sample.Model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends MongoRepository<Worker,String> {
}

package edu.prog.sample.Repository;

import edu.prog.sample.Model.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality, String> {
}

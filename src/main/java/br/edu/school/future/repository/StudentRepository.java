package br.edu.school.future.repository;

import br.edu.school.future.domain.RegisterStudents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<RegisterStudents, String>{

    @Query("{'registrationNumber':?0}")
    List<RegisterStudents> findBynumber(String registrationNumber);

    @Query("{'registrationNumber':?0}")
    RegisterStudents findBynumberForUpdate(String registrationNumber);
}

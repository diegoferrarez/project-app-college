package br.edu.school.future.repository;

import br.edu.school.future.domain.FinanceStudents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceRepository extends MongoRepository<FinanceStudents, String> {
    @Query("{ 'numberRegistration' : ?0 }")
    List<FinanceStudents> findByNumberRegistration(String NumberRegistration);

    @Query("{ 'numberRegistration' : ?0 }")
    FinanceStudents findByNumberRegistrationForChange(String NumberRegistration);
}

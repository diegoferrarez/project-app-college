package br.edu.school.future.repository;

import br.edu.school.future.domain.RegisterStudents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<RegisterStudents, String>{

    @Query("select p from students p where p.numberDoc=:numberDoc")
    List<Optional<RegisterStudents>> findByNumberDoc(String numberDoc);
}

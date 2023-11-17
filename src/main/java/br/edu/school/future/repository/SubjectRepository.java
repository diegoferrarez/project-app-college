package br.edu.school.future.repository;

import br.edu.school.future.domain.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subjects, String> {
}

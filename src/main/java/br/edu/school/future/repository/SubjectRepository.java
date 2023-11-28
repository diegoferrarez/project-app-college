package br.edu.school.future.repository;

import br.edu.school.future.domain.CurricularStructure;
import br.edu.school.future.domain.RegisterStudents;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<CurricularStructure, String> {

    @Query("{'curricularStructure':?0}")
    CurricularStructure findBySerie(String curricularStructure);
}

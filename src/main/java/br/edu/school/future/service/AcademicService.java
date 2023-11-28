package br.edu.school.future.service;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;

import java.util.Optional;

public interface AcademicService {

    Optional<RegisterStudents> insertNote(String registrationNumber, String[] notes, String nameSubject);
}

package br.edu.school.future.service;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    List<RegisterResponse> findAll();

    List<RegisterStudents> findByregistrationNumber(String registrationNUmber);

    Object createStudents(RegisterRequest request);

    Object update(String registrationNumber, RegisterRequest request);

    Optional<RegisterStudents> changeStatus(String registrationNumber);
}

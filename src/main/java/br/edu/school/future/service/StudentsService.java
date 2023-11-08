package br.edu.school.future.service;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;

import java.util.List;
import java.util.Optional;

public interface StudentsService {

    List<RegisterResponse> findAll();

    RegisterResponse createStudents(RegisterRequest request);

    Optional<RegisterStudents> update(String id, RegisterRequest request);

    Optional<RegisterStudents> changeStatus(String id);
}

package br.edu.school.future.service;

import br.edu.school.future.domain.dto.request.SubjectRequest;
import br.edu.school.future.domain.dto.response.SubjectResponse;

import java.util.List;

public interface SubjectService {

    SubjectResponse insertSubject(SubjectRequest request);

    List<SubjectResponse> findAll();
}

package br.edu.school.future.service;

import br.edu.school.future.domain.dto.request.StructureRequest;
import br.edu.school.future.domain.dto.response.StructureResponse;

import java.util.List;

public interface SubjectService {

    StructureResponse insertSubject(StructureRequest request);

    List<StructureResponse> findAll();
}

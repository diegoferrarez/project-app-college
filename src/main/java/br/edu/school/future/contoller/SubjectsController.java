package br.edu.school.future.contoller;

import br.edu.school.future.domain.dto.request.SubjectRequest;
import br.edu.school.future.domain.dto.response.SubjectResponse;
import br.edu.school.future.service.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/subjects/")
public class SubjectsController {

    @Autowired
    private SubjectService service;

    @PostMapping("insertNewSubject")
    public SubjectResponse insertSubject(SubjectRequest request){
        return service.insertSubject(request);
    }
}

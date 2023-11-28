package br.edu.school.future.contoller;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;
import br.edu.school.future.service.AcademicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/academic/")
public class AcademicController {

    @Autowired
    private AcademicService service;

    @PatchMapping("insertNote/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RegisterStudents> insertNoteStudent(@PathVariable String registrationNumber,
                                                        @RequestBody String[] notes,
                                                        @RequestParam String nameSubject){
        return service.insertNote(registrationNumber, notes, nameSubject);
    }

}

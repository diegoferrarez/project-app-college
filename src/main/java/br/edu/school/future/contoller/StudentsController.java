package br.edu.school.future.contoller;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;
import br.edu.school.future.service.StudentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/students/")
public class StudentsController {

    @Autowired
    private StudentsService service;

    @GetMapping("findAllStudents")
    @ResponseStatus(HttpStatus.OK)
    public List<RegisterResponse> getall(){
        return service.findAll();
    }

    @GetMapping("findByRegistration/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public List<RegisterStudents> getByregistration(@PathVariable String registrationNumber){
        return service.findByregistrationNumber(registrationNumber);
    }

    @PostMapping("registerStudents")
    public Object createFormStudent(@RequestBody RegisterRequest request){
        return service.createStudents(request);
    }

    @PutMapping("updateStudent/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Object updateStudent(@PathVariable String registrationNumber,
                                @RequestBody RegisterRequest request){
        return service.update(registrationNumber, request);
    }

    @PatchMapping("changeStatusStudent/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<RegisterStudents> inactiveOrActive(@PathVariable String registrationNumber){
        return service.changeStatus(registrationNumber);
    }

    //Transferir para o SubjectsController
    @PutMapping("selectSubjects/{registrationNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Object updateRegisterSubject(@PathVariable String registrationNumber,
                                        @RequestBody RegisterRequest request){
        return service.registerSubjects(registrationNumber, request);
    }
}

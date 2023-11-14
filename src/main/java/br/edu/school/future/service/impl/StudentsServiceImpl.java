package br.edu.school.future.service.impl;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;
import br.edu.school.future.domain.enums.StatusStudent;
import br.edu.school.future.repository.StudentRepository;
import br.edu.school.future.service.StudentsService;
import br.edu.school.future.util.mapper.RegisterStudentsMapper;
import br.edu.school.future.util.message.InfoMessages;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentsServiceImpl implements StudentsService {

    private final RegisterStudentsMapper mapper;
    private final ModelMapper modelMapper;

    @Autowired
    private StudentRepository repository;

    @Override
    @Transactional
    public List<RegisterResponse> findAll(){
        ModelMapper mapper = new ModelMapper();
        List<RegisterStudents> studentsList = repository.findAll();
        return Arrays.asList(modelMapper.map(studentsList, RegisterResponse[].class));
    }

    @Override
    @Transactional
    public List<RegisterStudents> findByregistrationNumber(String registrationNumber) {
        return repository.findBynumber(registrationNumber);
    }

    @Override
    @Transactional
    public Object createStudents(RegisterRequest dto) {
        var checkNumber = repository.findBynumber(dto.getRegistrationNumber());
        if(checkNumber.isEmpty()){
        var formStudents = saveStudent(dto);
        formStudents.setStatusStudent(StatusStudent.ACTIVE);
        formStudents.getValue().setValueMensality(dto.getValue().getValueTotal().subtract(dto.getValue().getDiscount()));
        var registerStudentsDatabase = this.repository.save(formStudents);
        return this.mapper.toResponse(HttpStatus.OK, registerStudentsDatabase);
    } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.FOUND_NUMBER_REPOSITORY);
        }
    }

    @Override
    @Transactional
    public Object update(String registrationNumber, RegisterRequest dto) {
        var checkNumber = repository.findBynumber(registrationNumber);
        if (checkNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.NOT_FOUND_NUMBER_REPOSITORY);
        } else {
            var validate = repository.findBynumberForUpdate(registrationNumber);
            return repository.findById(validate.getId()).map(form -> {
                form.setName(dto.getName());
                form.setSurname(dto.getSurname());
                form.setRegistrationNumber(dto.getRegistrationNumber());
                form.setBirthDay(dto.getBirthDay());
                form.setAge(dto.getAge());
                form.setGender(dto.getGender());
                form.setNumberFone(dto.getNumberFone());
                form.setValue(dto.getValue());
                form.setType(dto.getType());
                return repository.save(form);
            });
        }
    }

    @Override
    public Optional<RegisterStudents> changeStatus(String id) {
        return repository.findById(id).map(formStatus -> {
           if (formStatus.getStatusStudent() == StatusStudent.ACTIVE){
               formStatus.setStatusStudent(StatusStudent.INACTIVE);
           } else {
               formStatus.setStatusStudent(StatusStudent.ACTIVE);
           }
           return repository.save(formStatus);
        });
    }


    private RegisterStudents saveStudent(RegisterRequest register){
        return RegisterStudents.builder()
                .name(register.getName())
                .surname(register.getSurname())
                .registrationNumber(register.getRegistrationNumber())
                .age(register.getAge())
                .birthDay(register.getBirthDay())
                .numberFone(register.getNumberFone())
                .gender(register.getGender())
                .type(register.getType())
                .value(register.getValue())
                .build();
    }

    public StudentsServiceImpl(RegisterStudentsMapper mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}

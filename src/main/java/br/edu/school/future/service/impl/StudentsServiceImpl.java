package br.edu.school.future.service.impl;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.request.RegisterRequest;
import br.edu.school.future.domain.dto.response.RegisterResponse;
import br.edu.school.future.domain.enums.StatusStudent;
import br.edu.school.future.repository.StudentRepository;
import br.edu.school.future.repository.SubjectRepository;
import br.edu.school.future.service.StudentsService;
import br.edu.school.future.util.mapper.MapperConfig;
import br.edu.school.future.util.message.InfoMessages;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentsServiceImpl implements StudentsService {

    private final MapperConfig mapper;
    private final ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional
    public List<RegisterResponse> findAll(){

        ModelMapper mapper = new ModelMapper();
        List<RegisterStudents> studentsList = studentRepository.findAll();
        return Arrays.asList(modelMapper.map(studentsList, RegisterResponse[].class));
    }

    @Override
    @Transactional
    public List<RegisterStudents> findByregistrationNumber(String registrationNumber) {
        return studentRepository.findByNumber(registrationNumber);
    }

    @Override
    @Transactional
    public Object createStudents(RegisterRequest dto) {

        var checkNumber = studentRepository.findByNumber(dto.getRegistrationNumber());
        var curricular =  subjectRepository.findBySerie(dto.getSerieNumber());

        if(checkNumber.isEmpty()){

            var formStudents = saveStudent(dto);

            formStudents.setCurriculum(curricular);
            formStudents.setStatusStudent(StatusStudent.ACTIVE);
            var registerStudentsDatabase = this.studentRepository.save(formStudents);
            return this.mapper.toResponse(HttpStatus.OK, registerStudentsDatabase);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.FOUND_NUMBER_REPOSITORY);
        }
    }

    @Override
    @Transactional
    public Object update(String registrationNumber, RegisterRequest dto) {

        var checkNumber = studentRepository.findByNumber(registrationNumber);

        if (checkNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.NOT_FOUND_NUMBER_REPOSITORY);
        } else {
            var validate = studentRepository.findBynumberForUpdate(registrationNumber);
            return studentRepository.findById(validate.getId()).map(form -> {
                form.setName(dto.getName());
                form.setSurname(dto.getSurname());
                form.setRegistrationNumber(registrationNumber);
                form.setBirthDay(dto.getBirthDay());
                form.setNumberFone(dto.getNumberFone());
                form.setValue(dto.getValue());
                form.setSerieNumber(dto.getSerieNumber());
                return studentRepository.save(form);
            });
        }
    }

    @Override
    public Optional<RegisterStudents> changeStatus(String registrationNumber) {
        var checkNumber = studentRepository.findByNumber(registrationNumber);
        if (checkNumber.isEmpty()) {
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(InfoMessages.NOT_FOUND_NUMBER_REPOSITORY);
        }
        var validate = studentRepository.findBynumberForUpdate(registrationNumber);
        return studentRepository.findById(validate.getId()).map(formStatus -> {
            if (formStatus.getStatusStudent() == StatusStudent.ACTIVE) {
                formStatus.setStatusStudent(StatusStudent.INACTIVE);
            } else {
                formStatus.setStatusStudent(StatusStudent.ACTIVE);
            }
            return studentRepository.save(formStatus);
        });
    }

    @Override
    @Transactional
    public Object registerSubjects(String registrationNumber, RegisterRequest dto) {
        var checkNumber = studentRepository.findByNumber(registrationNumber);
        if (checkNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(InfoMessages.NOT_FOUND_NUMBER_REPOSITORY);
        } else {

            var validate = studentRepository.findBynumberForUpdate(registrationNumber);

            return studentRepository.findById(validate.getId()).map(form -> {
                form.setName(dto.getName());
                form.setSurname(dto.getSurname());
                form.setRegistrationNumber(dto.getRegistrationNumber());
                form.setBirthDay(dto.getBirthDay());
                form.setNumberFone(dto.getNumberFone());
                form.setValue(dto.getValue());
                form.setSerieNumber(dto.getSerieNumber());

                return studentRepository.save(form);
            });
        }
    }

    private RegisterStudents saveStudent(RegisterRequest register){
        return RegisterStudents.builder()
                .name(register.getName())
                .surname(register.getSurname())
                .registrationNumber(register.getRegistrationNumber())
                .birthDay(register.getBirthDay())
                .numberFone(register.getNumberFone())
                .serieNumber(register.getSerieNumber())
                .value(register.getValue())
                .build();
    }

    public StudentsServiceImpl(MapperConfig mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}

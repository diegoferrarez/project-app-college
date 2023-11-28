package br.edu.school.future.service.impl;

import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.repository.StudentRepository;
import br.edu.school.future.service.AcademicService;
import br.edu.school.future.util.mapper.MapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AcademicServiceImpl implements AcademicService {

    private final MapperConfig mapper;
    private final ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<RegisterStudents> insertNote(String registrationNumber, String[] notes, String nameSubject) {
        return null;
    }

    public AcademicServiceImpl(MapperConfig mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}
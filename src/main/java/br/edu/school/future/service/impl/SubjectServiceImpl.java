package br.edu.school.future.service.impl;

import br.edu.school.future.domain.Subjects;
import br.edu.school.future.domain.dto.request.SubjectRequest;
import br.edu.school.future.domain.dto.response.SubjectResponse;
import br.edu.school.future.repository.SubjectRepository;
import br.edu.school.future.service.SubjectService;
import br.edu.school.future.util.mapper.MapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final MapperConfig mapper;

    private final ModelMapper ModelMapper;

    @Autowired
    private SubjectRepository repository;

    @Override
    public SubjectResponse insertSubject(SubjectRequest dto) {
        var prepareSubject = saveSubject(dto);
        var saveSubjectDataBase =  this.repository.save(prepareSubject);
        return this.mapper.toResponseSubject(HttpStatus.CREATED, saveSubjectDataBase);
    }


    private Subjects saveSubject(SubjectRequest register){
        return Subjects.builder()
                .idSubject(register.getIdSubject())
                .nameSubject(register.getNameSubject())
                .workload(register.getWorkload())
                .build();
    }


    public SubjectServiceImpl(MapperConfig mapper, org.modelmapper.ModelMapper modelMapper) {
        this.mapper = mapper;
        ModelMapper = modelMapper;
    }
}

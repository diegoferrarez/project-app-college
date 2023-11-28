package br.edu.school.future.service.impl;

import br.edu.school.future.domain.CurricularStructure;
import br.edu.school.future.domain.Subjects;
import br.edu.school.future.domain.dto.request.StructureRequest;
import br.edu.school.future.domain.dto.response.StructureResponse;
import br.edu.school.future.repository.SubjectRepository;
import br.edu.school.future.service.SubjectService;
import br.edu.school.future.util.mapper.MapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final MapperConfig mapper;

    private final ModelMapper ModelMapper;

    @Autowired
    private SubjectRepository repository;

    @Override
    public List<StructureResponse> findAll() {
        List<CurricularStructure> subjectsList = repository.findAll();
        return Arrays.asList(ModelMapper.map(subjectsList, StructureResponse[].class));
    }

    @Override
    public StructureResponse insertSubject(StructureRequest dto) {
        var prepareSubject = saveSubject(dto);
        var saveSubjectDataBase = this.repository.save(prepareSubject);
        return this.mapper.toResponseSubject(HttpStatus.CREATED, saveSubjectDataBase);
    }

    private CurricularStructure saveSubject(StructureRequest register){
        return CurricularStructure.builder()
                .curricularStructure(register.getCurricularStructure())
                .subjects(register.getSubjects())
                .build();
    }


    public SubjectServiceImpl(MapperConfig mapper, org.modelmapper.ModelMapper modelMapper) {
        this.mapper = mapper;
        ModelMapper = modelMapper;
    }
}

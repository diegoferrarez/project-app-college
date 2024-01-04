package br.edu.school.future.service.impl;

import br.edu.school.future.domain.FinancePlan;
import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.enums.StatusStudent;
import br.edu.school.future.repository.StudentRepository;
import br.edu.school.future.service.AcademicService;
import br.edu.school.future.util.mapper.MapperConfig;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class AcademicServiceImpl implements AcademicService {

    private static final String VALOR = "valor";
    private static final String PERCENT = "percentual";

    private final MapperConfig mapper;
    private final ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<RegisterStudents> insertValuePlan(String registrationNumber, String typeDiscount,
                                                      BigDecimal value, BigDecimal discount) {

        var searchStudent = studentRepository.findBynumberForUpdate(registrationNumber);

        return studentRepository.findById(searchStudent.getId()).map(updateregister -> {
            if(typeDiscount.equals(VALOR)){

                var finalValueMensality = value.subtract(discount);

                searchStudent.setValue(FinancePlan.builder()
                        .valueMensality(value)
                        .discount(discount)
                        .valueTotal(finalValueMensality)
                        .build());
            }
            else {

                var finalValueMensality = value.subtract(value.multiply(discount));

                searchStudent.setValue(FinancePlan.builder()
                        .valueMensality(value)
                        .discount(discount)
                        .valueTotal(finalValueMensality)
                        .build());

            }
            return studentRepository.save(updateregister);
        });
    }

    @Override
    public Optional<RegisterStudents> insertNote(String registrationNumber, String[] notes, String nameSubject) {
        return null;
    }

    public AcademicServiceImpl(MapperConfig mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}
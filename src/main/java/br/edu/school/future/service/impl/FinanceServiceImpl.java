package br.edu.school.future.service.impl;

import br.edu.school.future.domain.FinanceStudents;
import br.edu.school.future.domain.enums.InfoMessage;
import br.edu.school.future.domain.enums.StatusStudent;
import br.edu.school.future.repository.FinanceRepository;
import br.edu.school.future.service.FinanceService;
import br.edu.school.future.util.mapper.RegisterStudentsMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class FinanceServiceImpl implements FinanceService {

    private static final String NOT_FOUND = "Não localizamos ou não existe a matrícula informada";

    private final RegisterStudentsMapper mapper;
    private final ModelMapper modelMapper;

    @Autowired
    private FinanceRepository repository;

    @Override
    @Transactional
    public FinanceStudents createFinancialStatement(FinanceStudents dto) {
        var financialForm = saveFormFinancial(dto);
        var registerFormFinancialDataBase = this.repository.save(financialForm);
        return this.mapper.toResponseFinance(registerFormFinancialDataBase);
    }

    @Override
    @Transactional
    public Object getByNumberRegistration(String numberRegistration) {
        var checkNumber = repository.findByNumberRegistration(numberRegistration);
        if (checkNumber.isEmpty()) {
            return InfoMessage.NOT_FOUND_REGISTRATION_NUMBER;
        } else {
            List<FinanceStudents> financeStudentsList = repository.findByNumberRegistration(numberRegistration);
            return Arrays.asList(modelMapper.map(financeStudentsList, FinanceStudents[].class));
        }
    }

    @Override
    @Transactional
    public Object changeValueMensality(String numberRegistration, FinanceStudents dto) {
        var checkNumber = repository.findByNumberRegistration(numberRegistration);
        if (checkNumber.isEmpty()) {
            return InfoMessage.NOT_FOUND_REGISTRATION_NUMBER;
        } else {
            var financeStudents = repository.findByNumberRegistrationForChange(numberRegistration);
            financeStudents.setValue(dto.getValue());
            var registerChanges = this.repository.save(financeStudents);
            return this.mapper.toResponseFinance(registerChanges);
        }
    }

    private FinanceStudents saveFormFinancial(FinanceStudents students){
        return FinanceStudents.builder()
                .id(students.getId())
                .numberRegistration(students.getNumberRegistration())
                .value(students.getValue())
                .build();
    }

    public FinanceServiceImpl(RegisterStudentsMapper mapper, ModelMapper modelMapper) {
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }
}

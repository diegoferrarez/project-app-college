package br.edu.school.future.contoller;

import br.edu.school.future.domain.FinanceStudents;
import br.edu.school.future.service.FinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/finance")
public class FinanceController {

    @Autowired
    private FinanceService service;

    @GetMapping("/findByRegistration/{numberRegistration}")
    @ResponseStatus(HttpStatus.OK)
    public Object findByNumberRegistration(@PathVariable String numberRegistration){
        return service.getByNumberRegistration(numberRegistration);
    }

    @PostMapping("/insertMonthlyValue")
    @ResponseStatus(HttpStatus.OK)
    public FinanceStudents insertValueStudent(@RequestBody FinanceStudents students){
        return service.createFinancialStatement(students);
    }

    @PatchMapping("/changeValueMensality/{numberRegistration}")
    @ResponseStatus(HttpStatus.OK)
    public Object changeMensality(@PathVariable String numberRegistration,
                                  @RequestBody FinanceStudents students){
        return service.changeValueMensality(numberRegistration, students);
    }
}

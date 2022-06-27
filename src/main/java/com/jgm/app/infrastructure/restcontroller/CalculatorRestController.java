package com.jgm.app.infrastructure.restcontroller;

import com.jgm.app.application.BinaryOperationUseCase;
import com.jgm.app.application.BinaryOperationUseCaseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(Uris.calculator)
@Slf4j
public class CalculatorRestController {

    private final BinaryOperationUseCase binaryOperationUseCase;

    public CalculatorRestController(BinaryOperationUseCase binaryOperationUseCase) {
        this.binaryOperationUseCase = binaryOperationUseCase;
    }

    @GetMapping(Uris.binaryOperation)
    public ResponseEntity<BigDecimal> binaryOperationExecute(@RequestParam String operation,
                                                             @RequestParam BigDecimal operand1,
                                                             @RequestParam BigDecimal operand2) {

        BinaryOperationUseCaseRequest binaryOperationUseCaseRequest = BinaryOperationUseCaseRequest.builder()
                .operation(operation)
                .operand1(operand1)
                .operand2(operand2)
                .build();

        log.info("CalculatorRestController: binaryOperationExecute() -> binaryOperationUseCaseRequest[ {} ]",
                binaryOperationUseCaseRequest);

        BigDecimal result = binaryOperationUseCase.execute(binaryOperationUseCaseRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

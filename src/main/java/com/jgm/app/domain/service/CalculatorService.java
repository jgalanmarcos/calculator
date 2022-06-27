package com.jgm.app.domain.service;

import com.jgm.app.application.CalculatorServiceI;
import com.jgm.app.domain.vo.AdditionOperation;
import com.jgm.app.domain.vo.Operation;
import com.jgm.app.domain.vo.SubtractionOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CalculatorService implements CalculatorServiceI {

    private final BinaryOperationService binaryOperationService;

    public CalculatorService(BinaryOperationService binaryOperationService) {
        this.binaryOperationService = binaryOperationService;
    }

    public BigDecimal binaryOperationExecute(String operation, BigDecimal operand1, BigDecimal operand2) {
        log.info("CalculatorService: exec() -> operation[ {} ],operand1[ {} ], operand2[ {} ]",
                operation, operand1, operand2);

        Operation op = Operation.fromDisplayName(operation);

        if(op == null) {
            throw new RuntimeException("Operation not allowed");
        }

        switch (op) {
            case ADDITION:
                binaryOperationService.setBinaryOperation(new AdditionOperation(operand1, operand2));
                break;
            case SUBTRACTION:
                binaryOperationService.setBinaryOperation(new SubtractionOperation(operand1, operand2));
                break;
            default:
                throw new RuntimeException("Operation not allowed");
        }

        return binaryOperationService.execute();
    }

}

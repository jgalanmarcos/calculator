package com.jgm.app.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class BinaryOperationUseCase {

    private final CalculatorServiceI calculatorService;

    public BinaryOperationUseCase(CalculatorServiceI calculatorService) {
        this.calculatorService = calculatorService;
    }

    public BigDecimal execute(BinaryOperationUseCaseRequest binaryOperationUseCaseRequest) {
        log.info("BinaryOperationUseCase: execute() -> binaryOperationUseCaseRequest[ {} ]", binaryOperationUseCaseRequest);

        return calculatorService.binaryOperationExecute(
                binaryOperationUseCaseRequest.getOperation(),
                binaryOperationUseCaseRequest.getOperand1(),
                binaryOperationUseCaseRequest.getOperand2());
    }

}

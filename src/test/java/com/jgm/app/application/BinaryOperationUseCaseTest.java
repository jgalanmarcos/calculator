package com.jgm.app.application;

import com.jgm.app.domain.service.CalculatorService;
import com.jgm.app.domain.vo.Operation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BinaryOperationUseCaseTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private BinaryOperationUseCase binaryOperationUseCase;

    @Test
    public void additionOperationTest() {
        String operation = Operation.ADDITION.getDisplayName();
        BigDecimal operand1 = BigDecimal.valueOf(1.0);
        BigDecimal operand2 = BigDecimal.valueOf(3.5);

        BinaryOperationUseCaseRequest request = BinaryOperationUseCaseRequest.builder()
                .operation(operation)
                .operand1(operand1)
                .operand2(operand2)
                .build();

        BigDecimal expected = operand1.add(operand2);

        when(calculatorService.binaryOperationExecute(operation, operand1, operand2)).thenReturn(expected);

        BigDecimal result = binaryOperationUseCase.execute(request);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void subtractionOperationTest() {
        String operation = Operation.SUBTRACTION.getDisplayName();
        BigDecimal operand1 = BigDecimal.valueOf(1.0);
        BigDecimal operand2 = BigDecimal.valueOf(3.5);

        BinaryOperationUseCaseRequest request = BinaryOperationUseCaseRequest.builder()
                .operation(operation)
                .operand1(operand1)
                .operand2(operand2)
                .build();

        BigDecimal expected = operand1.subtract(operand2);

        when(calculatorService.binaryOperationExecute(operation, operand1, operand2)).thenReturn(expected);

        BigDecimal result = binaryOperationUseCase.execute(request);

        assertNotNull(result);
        assertEquals(expected, result);
    }

}

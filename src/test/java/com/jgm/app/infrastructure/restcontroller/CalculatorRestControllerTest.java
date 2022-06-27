package com.jgm.app.infrastructure.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgm.app.application.BinaryOperationUseCase;
import com.jgm.app.domain.vo.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorRestController.class)
public class CalculatorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinaryOperationUseCase binaryOperationUseCase;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void binaryOperationExecuteAdditionTest() throws Exception {
        String operation = Operation.ADDITION.getDisplayName();
        BigDecimal operand1 = BigDecimal.valueOf(5.0);
        BigDecimal operand2 = BigDecimal.valueOf(2.5);

        BigDecimal expected = operand1.add(operand2);
        String expectedStr = objectMapper.writeValueAsString(expected);

        when(binaryOperationUseCase.execute(any())).thenReturn(expected);

        mockMvc.perform(
                get(Uris.calculator + Uris.binaryOperation + "?" +
                        "operation=" + operation +
                        "&operand1="+ operand1 +
                        "&operand2=" + operand2)
                        .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedStr)
        );
    }

    @Test
    public void binaryOperationExecuteSubtractionTest() throws Exception {
        String operation = Operation.SUBTRACTION.getDisplayName();
        BigDecimal operand1 = BigDecimal.valueOf(5.0);
        BigDecimal operand2 = BigDecimal.valueOf(2.5);

        BigDecimal expected = operand1.subtract(operand2);
        String expectedStr = objectMapper.writeValueAsString(expected);

        when(binaryOperationUseCase.execute(any())).thenReturn(expected);

        mockMvc.perform(
                get(Uris.calculator + Uris.binaryOperation + "?" +
                        "operation=" + operation +
                        "&operand1="+ operand1 +
                        "&operand2=" + operand2)
                        .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedStr)
        );
    }

}

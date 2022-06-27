package com.jgm.app.application;

import java.math.BigDecimal;

public interface CalculatorServiceI {

    BigDecimal binaryOperationExecute(String operation, BigDecimal operand1, BigDecimal operand2);

}

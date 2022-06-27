package com.jgm.app.domain.vo;

import java.math.BigDecimal;

public class SubtractionOperation extends BinaryOperation {

    public SubtractionOperation(BigDecimal operand1, BigDecimal operand2) {
        super(operand1, operand2);
    }

    @Override
    public BigDecimal execute() {
        return operand1.subtract(operand2);
    }

}

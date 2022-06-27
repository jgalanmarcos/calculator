package com.jgm.app.domain.vo;

import java.math.BigDecimal;

public abstract class BinaryOperation {

    protected BigDecimal operand1;

    protected BigDecimal operand2;

    public BinaryOperation(BigDecimal operand1, BigDecimal operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract BigDecimal execute();

}

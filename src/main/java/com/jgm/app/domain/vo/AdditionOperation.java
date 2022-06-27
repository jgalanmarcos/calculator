package com.jgm.app.domain.vo;

import java.math.BigDecimal;

public class AdditionOperation extends BinaryOperation{

    public AdditionOperation(BigDecimal operand1, BigDecimal operand2) {
        super(operand1, operand2);
    }

    @Override
    public BigDecimal execute() {

        return operand1.add(operand2);
    }

}

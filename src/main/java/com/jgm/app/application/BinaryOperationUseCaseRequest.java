package com.jgm.app.application;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BinaryOperationUseCaseRequest {

    private String operation;

    private BigDecimal operand1;

    private BigDecimal operand2;

}

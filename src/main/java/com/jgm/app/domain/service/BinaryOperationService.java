package com.jgm.app.domain.service;

import com.jgm.app.domain.vo.BinaryOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class BinaryOperationService {

    private BinaryOperation binaryOperation;

    public BigDecimal execute() {
        log.info("BinaryOperationService: execute()");

        return binaryOperation.execute();
    }

    public void setBinaryOperation(BinaryOperation binaryOperation) {
        this.binaryOperation = binaryOperation;
    }

}

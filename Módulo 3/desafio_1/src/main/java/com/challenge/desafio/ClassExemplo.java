package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class ClassExemplo {

    @Subtrair
    private final BigDecimal number1 = BigDecimal.valueOf(5);

    @Subtrair
    private final BigDecimal number2 = BigDecimal.valueOf(10);

    @Somar
    private final BigDecimal number3 = new BigDecimal("0.67");

    @Somar
    private final BigDecimal  number4 = new BigDecimal("0.67");

    public BigDecimal numerSemMarcacao = new BigDecimal("0.56");

}

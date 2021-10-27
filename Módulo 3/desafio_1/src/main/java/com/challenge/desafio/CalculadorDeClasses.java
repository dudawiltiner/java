package com.challenge.desafio;

import com.challenge.annotation.GetValue;
import com.challenge.annotation.Operator;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;


public class CalculadorDeClasses implements Calculavel {

    private Object objectX;

    /**
     * @param name // um objeto NÃO CONHECIDO que vai servir de parametro para função
     * @return // vai retornar um BigDecimal com todos os atributos, da classe do objeto que estão marcados com "@Somar", SOMADOS.
     */

    @Override
    public BigDecimal somar(Object name) {
        objectX = name;
        try {
            BigDecimal resultadoDaSomaDoGrupoSomar = operation("+", name.getClass().getDeclaredFields());
            return resultadoDaSomaDoGrupoSomar;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }

    }

    /**
     * @param name // um objeto NÃO CONNHECIDO que vai servir de parametro para função
     * @return // vai retornar um BigDecimal com todos os atributos, da classe do objeto que estão marcados com "@Subtrair", SOMADOS.
     */

    @Override
    public BigDecimal subtrair(Object name) {
        objectX = name;
        try {
            return operation("-", name.getClass().getDeclaredFields());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    /**
     * @param name // um objeto NÃO CONNHECIDO que vai servir de parametro para função
     * @return // vai retornar um BigDecimal a subtração do resultado do método SUBTRAIR com o método SOMAR.
     */

    @Override
    public BigDecimal totalizar(Object name) {
        objectX = name;
        try {
            BigDecimal Soma = operation("+", name.getClass().getDeclaredFields());
            BigDecimal Sub = operation("-", name.getClass().getDeclaredFields());
            return Sub.subtract(Soma).abs();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return BigDecimal.ZERO;
        }
    }

    /**
     * @param operador // identificador para saber se a soma será dos marcados com "@Somar" ou "@Subtrair"
     * @param fields // uma lista dos campos ou atributos que serão verificados de acordo com a sua ANNOTATION
     * @return // vai retornar os atributos  somados de acordo coma sua MARCAÇÃO ou ANOTAÇÃO: "@Somar" ou "@Subtrair"
     * @throws IllegalAccessException // tratamento de uma execeção recomendado pela IDE
     */

    @Operator(Objective="Auxilia na identificação da anotação de cada atributo para separar em dois grupos: Somar e Subtrair")
    private BigDecimal operation(String operador, Field[] fields) throws IllegalAccessException {

        BigDecimal result = BigDecimal.ZERO;
        BigDecimal bigResult = BigDecimal.ZERO;

        for(Field field: fields){

                BigDecimal value = getValueField(field);

                if (operador.equals("+") && field.getDeclaredAnnotation(Somar.class) != null) {
                    bigResult = result.add(value);
                } else if(operador.equals("-") && field.getDeclaredAnnotation(Subtrair.class) != null) {
                    bigResult = result.add(value);
                }

                result = bigResult.abs();
            }

        return result;
    }

    /**
     * @param field // o campo ou atributo a ser usado para encontrar o seu valor
     * @return // valor do atributo em BigDecimal
     * @throws IllegalAccessException // tratamento de uma execeção recomendado pela IDE
     */

    @GetValue(Objective="Auxilia, através da utilização de métodos da reflection, para adquirir os valores de cada atributo em BigDecimal")
    private BigDecimal getValueField(Field field) throws IllegalAccessException {
        field.setAccessible(true);

        String value = "0";

        if(field.getType().equals(BigDecimal.class)){
            value = field.get(objectX).toString();
        }

        return new BigDecimal(value);

    }
}

package com.challenge.desafio;

public class TesteDesafio {
    public static void main(String[] args) {
        ClassExemplo classEx = new ClassExemplo();
        System.out.println(getCalculadorClassesClass().getClass());
        try {
            Object obj = getCalculadorClassesClass().newInstance();
            System.out.println(obj.getClass().getMethod("somar", Object.class).invoke(obj, classEx));
        } catch (Exception e) {
            System.out.println(new RuntimeException(e));
        }

        return;

    }

    private static Class<?> getCalculadorClassesClass() {
        try {
            return Class.forName("com.challenge.desafio.CalculadorDeClasses");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

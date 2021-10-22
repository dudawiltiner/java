package br.com.Trybe;

public class Alunos extends Member{
    public Alunos(String primeiro, String meio, String ultimo) {
        super(primeiro, meio, ultimo);
    }

    public double getDescontoCamisa(Integer valorCamisa) {
        double valorFinal = valorCamisa - 0.2 * valorCamisa;
        return valorFinal;
    }
}

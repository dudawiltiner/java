package br.com;

import br.com.Trybe.Alunos;
import br.com.Trybe.Instrutores;


public class Principal {
    public static void main(String[] args) { // ponto de entrada
        Instrutores instrutor = new Instrutores("Um", "nome", "Fictício", "estagio");
        Alunos aluno = new Alunos("Uma", "pessoa", "estudante");
        System.out.println("Instrutor - " + instrutor.getNomeCompleto());
        System.out.println("------------------------------------------------");
        System.out.println("O valor da camisa com desconto será de R$ " + instrutor.getDescontoCamisa(80));
        System.out.println("O salario é de R$ " + instrutor.getSalario());

        System.out.println("------------------------------------------------");

        System.out.println("Aluno - " + aluno.getNomeCompleto());
        System.out.println("------------------------------------------------");
        System.out.println("O valor da camisa com desconto será de R$ " + aluno.getDescontoCamisa(80));
    }

}

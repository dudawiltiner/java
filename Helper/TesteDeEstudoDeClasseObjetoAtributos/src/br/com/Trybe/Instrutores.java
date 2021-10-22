package br.com.Trybe;

public class Instrutores extends Member{
    private String tipoSalario;

    public Instrutores(String primeiro, String meio, String ultimo, String tipoSalario) {
        super(primeiro, meio, ultimo);
        this.tipoSalario = tipoSalario;
    }

    public int getSalario(){
        int salario = 0;

        if (tipoSalario == "estagio") {
            salario = 2000;
        }

        if(tipoSalario == "junior") {
            salario = 3000;
        }

        return salario;
    }
}

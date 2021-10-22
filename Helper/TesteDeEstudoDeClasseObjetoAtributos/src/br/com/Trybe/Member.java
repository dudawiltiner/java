package br.com.Trybe;

public class Member {
    private String primeiroNome;
    private String ultimoNome;
    private String nomeDoMeio;

    public Member(String primeiro, String meio, String ultimo) {
        primeiroNome = primeiro;
        ultimoNome = ultimo;
        nomeDoMeio = meio;
    }

    public final String getNomeCompleto() {
        String nomeCompleto = primeiroNome + " " + nomeDoMeio + " " + ultimoNome;
        return nomeCompleto;
    }

    public double getDescontoCamisa(Integer valorCamisa) {
        double valorFinal = valorCamisa - 0.5 * valorCamisa;
        return valorFinal;
    }
}

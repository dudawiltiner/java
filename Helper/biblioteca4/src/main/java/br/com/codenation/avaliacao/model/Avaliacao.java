package br.com.codenation.avaliacao.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoIdentity avaliacaoIdentity;

    @Max(5)
    @Min(1)
    @NotNull
    private Integer nota;

    @NotBlank
    @NotNull
    private String avaliacao;

    public AvaliacaoIdentity getAvaliacaoIdentity() {
        return avaliacaoIdentity;
    }

    public void setAvaliacaoIdentity(AvaliacaoIdentity avaliacaoIdentity) {
        this.avaliacaoIdentity = avaliacaoIdentity;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}

package com.br.biblioteca.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Contato {
    private String numero;

    public Contato(String numero) {
        this.numero = numero;
    }

    public Contato() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "numero='" + numero + '\'' +
                '}';
    }
}

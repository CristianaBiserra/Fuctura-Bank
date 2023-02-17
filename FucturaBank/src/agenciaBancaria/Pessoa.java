package agenciaBancaria;

import java.util.Date;

import utilitarios.Utils;

public class Pessoa {

    private static int counter = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
    private String email;

    public Pessoa() { }

    public Pessoa(String name, String cpf, String email) {
        this.numeroPessoa = Pessoa.counter;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
package agenciaBancaria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import utilitarios.Utils;

public class ContaPoupanca extends Conta {
	
    static ArrayList<ContaPoupanca> cp;



	public ContaPoupanca(Pessoa pessoa) {
		super(pessoa);
	}
		

	public String toString() {

        return "\nNumero da Conta Poupança: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +        
                "\n" ;
    }
	

	 
	
}

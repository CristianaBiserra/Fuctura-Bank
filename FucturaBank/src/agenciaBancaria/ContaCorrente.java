package agenciaBancaria;

import utilitarios.Utils;

public class ContaCorrente extends Conta{

	
	
	public ContaCorrente(Pessoa pessoa) {
		super(pessoa);	
	}	
	

	public String toString() {

        return "\nNumero da Conta Corrente: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
    }
	
	

}

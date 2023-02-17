package agenciaBancaria;

import javax.swing.JOptionPane;

import utilitarios.Utils;

public class Conta {
	
	private static int accountCounter = 1;

	private int numeroConta;
    protected Pessoa pessoa;
    protected Double saldo = 0.0;


    public Conta(Pessoa pessoa) { 
    	this.numeroConta = Conta.accountCounter;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.accountCounter += 1;
    }
    
    public int getNumeroConta() {
  		return numeroConta;
  	}


   public Pessoa getCliente() {
        return pessoa;
   }
   
   public void setCliente(Pessoa pessoa) {
       this.pessoa = pessoa;
  
   }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }
  

    public void depositar(Double valor) {
        if(valor > 0) {
            this.saldo = this.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "--- Seu depósito foi realizado com sucesso! ---");
        }else {
        	JOptionPane.showMessageDialog(null, "--- Não foi possível realizar o depósito! ---");   
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "--- Saque realizado com sucesso! ---");     
        }else {
        	JOptionPane.showMessageDialog(null, "--- Não foi possível realizar o saque! ---");        
        }
    }


	public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            this.saldo = this.getSaldo() - valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "--- Transferência realizada com sucesso! ---");
        }else {
        	JOptionPane.showMessageDialog(null, "--- Não foi possível realizar a tranferência ---");     
        }

    }
   
}

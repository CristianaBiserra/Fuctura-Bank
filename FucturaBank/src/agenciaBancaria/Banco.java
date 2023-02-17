package agenciaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Banco{

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    static ArrayList<ContaCorrente> cc;
    static ArrayList<ContaPoupanca> cp;
    

    public static void main(String[] args) {
    	contasBancarias = new ArrayList<Conta>();
        cc = new ArrayList<ContaCorrente>();
        cp = new ArrayList<ContaPoupanca>();
        
        operacoes();
    }

    public static void operacoes() {

        int operacao = 
    	    	Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +	   
    			        "\n   Opção 1 - Criar Conta "+
    			        "\n   Opção 2 - Depositar   "+
    			        "\n   Opção 3 - Sacar       "+
    			        "\n   Opção 4 - Transferir  "+     			        
    			        "\n   Opção 5 - Listar Contas Correntes  "+
    			        "\n   Opção 6 - Listar Contas Poupanças  "+
    			        "\n   Opção 0 - Sair        "));

        switch (operacao) {
            case 1:
            	int opcao = 
            	Integer.parseInt(JOptionPane.showInputDialog("--- Selecione um tipo de Conta ---" +	   
            		     "\n   Opção 1 - Conta Corrente "+
            		     "\n   Opção 2 - Conta Poupança "+
            		     "\n   Opção 0 - Voltar para menu principal"));
            
            	switch (opcao) {
            		case 1:
            			criarContaCorrente();
            		
            		case 2:
            			criarContaPoupanca();
            		
            		case 0:	
            			operacoes();
            			
            		default:
	            	JOptionPane.showMessageDialog(null, "--- Opção invalida ! ---");
	                operacoes();
	                break;
            	}
            
            break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;
       
            case 5:
                listarContasCorrentes();
                operacoes();
                break;
                
            case 6:
                listarContasPoupancas();
                operacoes();
                break;    

            case 0:
            	JOptionPane.showMessageDialog(null, "--- Obrigado por usar nossa agencia. Volte sempre! ---");
           
                System.exit(0); // para o sistema

            default:
            	JOptionPane.showMessageDialog(null, "--- Opção invalida ! ---");
                operacoes();
                break;
        }
    }

    public static void criarContaCorrente() {
    	JOptionPane.showMessageDialog(null, "--- CADASTRO CONTA POUPANÇA ---");
	      
    	Pessoa pessoa = new Pessoa();
    	
    	pessoa.setName(JOptionPane.showInputDialog("Nome: "));
    	
    	pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
    	
    	pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        ContaCorrente contaCC = new ContaCorrente(pessoa);
        
        double valorDepositoIncial =
    			Double.parseDouble(JOptionPane.showInputDialog("\"Qual o valor do deposito inicial? "));
        contaCC.depositar(valorDepositoIncial);

        cc.add(contaCC);
        
        JOptionPane.showMessageDialog(null, "--- Sua conta foi criada com sucesso! ---");
      
        operacoes();
    }
    
    public static void criarContaPoupanca() {
    	
    	JOptionPane.showMessageDialog(null, "--- CADASTRO CONTA POUPANÇA ---");
	      
    	Pessoa pessoa = new Pessoa();
    	
    	pessoa.setName(JOptionPane.showInputDialog("Nome: "));
    	
    	pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
    	
    	pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        ContaPoupanca contaCP = new ContaPoupanca(pessoa);
        
        double valorDepositoIncial =
    			Double.parseDouble(JOptionPane.showInputDialog("\"Qual o valor do deposito inicial? "));
        contaCP.depositar(valorDepositoIncial);

        cp.add(contaCP);
        
        JOptionPane.showMessageDialog(null, "--- Sua conta foi criada com sucesso! ---");
      
        operacoes();

    }
    
    
    private static ContaCorrente encontrarContaCorrente(int numeroConta) {
        ContaCorrente contaCC = null;
        if(cc.size() > 0) {
            for(ContaCorrente contaa : cc) {
                if(contaa.getNumeroConta() == numeroConta) {
                    contaCC = contaa;
                }
            }
        }
        return contaCC;
    }
    
    
    private static ContaPoupanca encontrarContaPoupanca(int numeroConta) {
        ContaPoupanca contaCP = null;
        if(cp.size() > 0) {
            for(ContaPoupanca contaa : cp) {
                if(contaa.getNumeroConta() == numeroConta) {
                	contaCP = contaa;
                }
            }
        }
        return contaCP;
    }

    public static void depositar() {
    	
    	int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito: "));
  
        ContaCorrente contaCC = encontrarContaCorrente(numeroConta);
        ContaPoupanca contaCP = encontrarContaPoupanca(numeroConta);

        if(contaCC != null ) {
        	double valorDeposito =
        			Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor deseja depositar? "));
            contaCC.depositar(valorDeposito);
       
        }else if (contaCP != null){
        	double valorDeposito =
        			Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor deseja depositar? "));
            contaCP.depositar(valorDeposito);
        
        }else {
        	JOptionPane.showMessageDialog(null, "--- Conta não encontrada ---");
        }
          
        operacoes();

    }

    public static void sacar() {
	      
        int numeroConta = 
        		Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque: "));

        ContaCorrente contaCC = encontrarContaCorrente(numeroConta);
        ContaPoupanca contaCP = encontrarContaPoupanca(numeroConta);

        if(contaCC != null) {
            Double valorSaque =
            		Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor que deseja sacar? "));
            contaCC.sacar(valorSaque);
            
        }else if (contaCP != null){
        	Double valorSaque =
            		Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor que deseja sacar? "));
            contaCP.sacar(valorSaque);
            
        }else {
        	JOptionPane.showMessageDialog(null, "--- Conta não encontrada ---");
        }

        operacoes();

    }
    
    public static void transferir() { //estudar um metodo para liberar transferencia para qualquer conta: Poupança/Poupança e Corrente/Corrente
        
    	int opcao = 
            	Integer.parseInt(JOptionPane.showInputDialog("--- Selecione o tipo de Transferencia ---" +	   
            		     "\n   Opção 1 - Conta Corrente para Poupança "+
            		     "\n   Opção 2 - Conta Poupança para Corrente"+
            		     "\n   Opção 0 - Voltar para menu principal"));
            
            	switch (opcao) {
            	
            		case 1:
            			
            			int numeroContaCorrente = 
                		Integer.parseInt(JOptionPane.showInputDialog("Número da conta Corrente que vai enviar a transferência: "));

            			ContaCorrente contaRemetente = encontrarContaCorrente(numeroContaCorrente);
                

		                if(contaRemetente != null) {
		                	
		                    int numeroContaPoupanca = 
		                    	Integer.parseInt(JOptionPane.showInputDialog("Número da conta Poupanca que vai receber a transferencia: "));
		                    
		                    ContaPoupanca contaDestinatario = encontrarContaPoupanca(numeroContaPoupanca);
		
		                    if(contaDestinatario != null) {            	          
		                        Double valor = 
		                        		Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor que deseja transferir? "));
		
		                        contaRemetente.transferir(contaDestinatario, valor);
		
		                    }else {
		                    	JOptionPane.showMessageDialog(null, "--- A conta para depósito não foi encontrada ---");
		                    }
		                    
		                }else {
		                	JOptionPane.showMessageDialog(null, "--- Conta para transferência não encontrada ---");
		                }
		               
		                operacoes();
		                
		                break;
            		
            		case 2:
            			
            			int numeroContaPoupanca = 
                		Integer.parseInt(JOptionPane.showInputDialog("Número da conta Poupança que vai enviar a transferência: "));

            			ContaPoupanca contaRemetente2 = encontrarContaPoupanca(numeroContaPoupanca);
                

		                if(contaRemetente2 != null) {
		                	
		                    int numeroContaCorrente2 = 
		                    	Integer.parseInt(JOptionPane.showInputDialog("Número da conta Corrente que vai receber a transferencia: "));
		                    
		                    ContaCorrente contaDestinatario = encontrarContaCorrente(numeroContaCorrente2);
		
		                    if(contaDestinatario != null) {            	          
		                        Double valor = 
		                        		Double.parseDouble(JOptionPane.showInputDialog("\"Qual valor que deseja transferir? "));
		
		                        contaRemetente2.transferir(contaDestinatario, valor);
		                       
		                    }else {
		                    	JOptionPane.showMessageDialog(null, "--- A conta para depósito não foi encontrada ---");
		                    }
		                }else {
		                	JOptionPane.showMessageDialog(null, "--- Conta para transferência não encontrada ---");
		                }
		                
            		case 0:
            			
            			operacoes();
		                
            		default:
    	            	JOptionPane.showMessageDialog(null, "--- Opção invalida ! ---");
    	               
    	            	operacoes();
    	               
    	            	break;		             
            	}
    }  

    public static void listarContasCorrentes() {
        if(cc.size() > 0) {
            for(ContaCorrente contaCC: cc) {    
                JOptionPane.showMessageDialog(null, contaCC);
            }
        }else {
        	JOptionPane.showMessageDialog(null, "--- Não há contas cadastradas ---");
        }

        operacoes();
    }
    
    public static void listarContasPoupancas() {
        if(cp.size() > 0) {
            for(ContaPoupanca contaCP: cp) {    
                JOptionPane.showMessageDialog(null, contaCP);
            }
        }else {
        	JOptionPane.showMessageDialog(null, "--- Não há contas cadastradas ---");
        }

        operacoes();
    }
}
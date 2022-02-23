package iondan88.com.github.poo1;

import java.text.DecimalFormat;

public class Conta {
	
	private String nomeTitular;
	private Double saldoConta;
	private String numeroConta;
	private String tipoConta;
	private Integer numeroSaques = 0;
	
	public Conta(String nomeTitular, Double saldoConta, String numeroConta, String tipoConta) {
		super();
		this.nomeTitular = nomeTitular;
		this.saldoConta = saldoConta;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
	}
	
	public void depositar(Double valor) {
		if(tipoConta.equals("PF")) {
			valor -= valor * 0.02;
		} else {
			valor -= valor * 0.01;
		}
		saldoConta = saldoConta + valor;
		imprimeSaldo();
	}
	
	public Double sacar(Double valor) {
		Double valorSacado = valor;
		if(valor > saldoConta && tipoConta.equals("PF")) {
			valor = 0.0;
			System.out.println("Nao permitido saque maior que o valor da conta de " +  getSaldoContaFormatado());
		} else {
			saldoConta = saldoConta - valor;
			if(numeroSaques > 3) {
				if(tipoConta.equals("PF")) {
					valorSacado -= valorSacado * 0.02;
				} else {
					valorSacado -= valorSacado * 0.01;
				}
			}
			imprimeSaldo();
		}
		numeroSaques++;
		return valorSacado;
	}
	
	private String getSaldoContaFormatado() {
		return new DecimalFormat("#0.00").format(saldoConta);
	}
	
	public void imprimeSaldo() {
		System.out.println(nomeTitular + " tem R$" + getSaldoContaFormatado() + " na conta.");
	}
	
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public Double getSaldoConta() {
		return saldoConta;
	}
	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
}

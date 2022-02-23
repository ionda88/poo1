package iondan88.com.github.poo1;

import java.text.DecimalFormat;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conta conta1 = new Conta("João da Silva", 799.99, "123456", "PF");
		conta1.depositar(100.0);
		for(int i = 0; i < 5; i++) {
			System.out.println("Sacou:" + new DecimalFormat("#0.00").format(conta1.sacar(100.0))); 
		}
	}

}

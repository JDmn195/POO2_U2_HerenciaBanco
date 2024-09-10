/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Jd
 */
public class SavingsAccount extends Account{
    private double interest;
    
    public SavingsAccount(int n) {
        super(n); 
        this.interest=0.2;
                
    }
    
    @Override
    public void deposit(double sum) {
        sum+=(getBalance()*interest);
        super.deposit(sum);
    }
    
     @Override
    public void withdraw(double sum) {
		if(sum<0) throw new RuntimeException("No se puede retirar negativamente");
		if (sum <= this.getBalance())
			super.withdraw(sum);
                else throw new RuntimeException("No se puede retirar porque sobrepasa el Balance");
	}

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}

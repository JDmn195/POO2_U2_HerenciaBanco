/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.modelo;

/**
 *
 * @author Jd
 */
public class CurrentAcount extends Account{
    private double limiteDeSobregiro;
    
    public CurrentAcount(int a) {
        super(a);
        this.limiteDeSobregiro=15;
    }
    
    @Override
    public void withdraw(double sum) {
                if(sum<0) throw new RuntimeException("No se puede retirar negativamente");
		if (sum <= this.getBalance()+limiteDeSobregiro)
			super.withdraw(sum);
                else throw new RuntimeException("No se puede retirar porque sobrepasa el Balance y el límite de sobregiro");
 
    }
	

    public double getLimiteDeSobregiro() {
        return limiteDeSobregiro;
    }

    public void setLimiteDeSobregiro(int limiteDeSobregiro) {
        this.limiteDeSobregiro = limiteDeSobregiro;        
    }
    
}

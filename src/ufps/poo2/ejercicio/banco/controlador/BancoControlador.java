/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import ufps.poo2.ejercicio.banco.modelo.Account;
import ufps.poo2.ejercicio.banco.modelo.Bank;
import ufps.poo2.ejercicio.banco.vista.BancoVista;

/**
 *
 * @author Boris Perez
 */
public class BancoControlador {
    
    private BancoVista frame;
    private Bank banco;

    public BancoControlador(BancoVista frame) {
        this.frame = frame;
        this.banco = new Bank();
    }

    public void abrirCuenta() {
        char tipo = frame.getRbAhorros().isSelected() ? 'A' : 'C';
        int accnum = Integer.parseInt(frame.getTxtNumeroCuenta().getText());
        double saldo = Double.parseDouble(frame.getTxtSaldoCuenta().getText());
        banco.openAccount(tipo, accnum);
        Account cuenta = banco.buscarCuenta(accnum);
        banco.depositarCuenta(cuenta, saldo);
        if(tipo=='A') frame.getTaMensajes().append("Se abrió cuenta de Ahorros num: "+accnum+" con saldo: "+saldo+"\n");
        else frame.getTaMensajes().append("Se abrió cuenta Corriengte num: "+accnum+" con saldo: "+saldo+"\n");
        
    }

    public void cancelarAbrirCuenta() {
        frame.getTxtNumeroCuenta().setText("");
        frame.getTxtSaldoCuenta().setText("");
        frame.getRbAhorros().setSelected(false);
        frame.getRbCorriente().setSelected(false);        
    }

    public void aplicarAccion() {
        int accnum = Integer.parseInt(frame.getTxtNumeroCuentaAcciones().getText());
        double valor = Double.parseDouble(frame.getTxtValor().getText());
        if (frame.getRbDividendos().isSelected()){
            banco.payDividend(accnum, valor);
            frame.getTaMensajes().append("Pago de dividendos Cuenta num: "+accnum+" por: $"+valor+"\n");
        } else {
            banco.withdrawAccount(accnum, valor);
            frame.getTaMensajes().append("Retiro a Cuenta num: "+accnum+" por: $"+valor+"\n");
        }
    }

    public void cancelarAccion() {
        frame.getTxtNumeroCuentaAcciones().setText("");
        frame.getTxtValor().setText("");
        frame.getRbDividendos().setSelected(false);
        frame.getRbRetirar().setSelected(false);
    }

    public void enviarCorreos() {
        frame.getTaMensajes().append(banco.sendLetterToOverdraftAccounts());
    }

    
    
    
    
    
}

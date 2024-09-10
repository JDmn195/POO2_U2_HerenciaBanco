/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.poo2.ejercicio.banco.controlador;

import javax.swing.JOptionPane;
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
        try {
            banco.openAccount(tipo, accnum);
            Account cuenta = banco.buscarCuenta(accnum);
            banco.depositarCuenta(cuenta, saldo);
            if(tipo=='A') frame.getTaMensajes().append("Se abrió cuenta de Ahorros "+banco.buscarCuenta(accnum).toString()+"\n");
            else frame.getTaMensajes().append("Se abrió cuenta Corriente "+banco.buscarCuenta(accnum).toString()+"\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
        
        
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
        try {
            if (frame.getRbDividendos().isSelected()){
                banco.payDividend(accnum, valor);
                frame.getTaMensajes().append("Pago de dividendos por: $"+valor+" a: "+banco.buscarCuenta(accnum).toString()+"\n");
            } else {
                banco.withdrawAccount(accnum, valor);
                frame.getTaMensajes().append("Retiro por: $"+valor+" a: "+banco.buscarCuenta(accnum).toString()+"\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

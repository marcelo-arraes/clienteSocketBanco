/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Marcelo
 */
public class Conta {
    private String numeroAgencia;
    private String nomeCliente;
    private String numeroConta;
    private String nomeAgencia;
    private double saldo;
    private String tipoConta;

    public Conta() {
    }

    public Conta(String numAgencia,String numeroConta, String nomeAgencia, String tipoConta, String nomeCliente, double saldo) {
        this.numeroAgencia = numAgencia;
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.nomeAgencia = nomeAgencia;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    
}

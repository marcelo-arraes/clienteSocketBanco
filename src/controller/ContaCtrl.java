/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Conta;
import core.ContaException;
import enuns.ParametrosEnum;
import java.io.IOException;

/**
 *
 * @author Marcelo
 */
public class ContaCtrl {
    private Conta contaView;

    public ContaCtrl() {
    }

    public Conta getContaView() {
        return contaView;
    }

    public void setContaView(Conta contaView) {
        this.contaView = contaView;
    }
    
    public void setContaView(String dados[]){
        this.contaView = new Conta(dados[0], dados[1], dados[2], dados[3], dados[4], Double.parseDouble(dados[5]));
    }
    
    public boolean logar(String numAgencia,String numConta, String senha) throws ContaException {
        String dados = numAgencia+"|"+numConta+"|"+senha;
        String retorno[];
        try {
            retorno = SocketCtrl.enviar(ParametrosEnum.LOGAR_CONTA.getNomeParametro(), dados).split("\t");
        } catch (IOException ex) {
            throw new ContaException("Ocorreu um erro inesperado");
        }
        
        String dadosAux[] = retorno[1].split("[|]");
        
        if(retorno[0].equals(ParametrosEnum.ERRO.getNomeParametro())){
            throw new ContaException(dadosAux[1]);
        }
        
        this.setContaView(new Conta(dadosAux[0], dadosAux[1], dadosAux[2], dadosAux[3],dadosAux[4], Double.parseDouble(dadosAux[5])));
        return true;
    }
    
    public String depositar(ParametrosEnum tipoDeposito, String numAgencia,String numConta, double valor) throws ContaException {
        String dados = numAgencia+"|"+numConta+"|"+String.valueOf(valor);
        String retorno[];
        
        if(!tipoDeposito.getNomeParametro().equals(ParametrosEnum.DEPOSITAR_PROPRIA.getNomeParametro()) &&
                !tipoDeposito.getNomeParametro().equals(ParametrosEnum.DEPOSITAR_TERCEIRO.getNomeParametro())){
            throw new ContaException("Tipo de deposito Invalido");
        }
        
        try {
            retorno = SocketCtrl.enviar(tipoDeposito.getNomeParametro(), dados).split("\t");
        } catch (IOException ex) {
            throw new ContaException("Ocorreu um erro inesperado");
        }
        
        String dadosAux[] = retorno[1].split("[|]");
        
        if(retorno[0].equals(ParametrosEnum.ERRO.getNomeParametro())){
            throw new ContaException(dadosAux[1]);
        }else if(retorno[0].equals(ParametrosEnum.SUCESSO.getNomeParametro())){
            return dadosAux[1];
        }else{
            this.setContaView(new Conta(dadosAux[0], dadosAux[1], dadosAux[2], dadosAux[3],dadosAux[4], Double.parseDouble(dadosAux[5])));
        }
        
        return "";
    }
    
    public boolean saque(String numAgencia,String numConta, double valor) throws ContaException {
        String dados = numAgencia+"|"+numConta+"|"+String.valueOf(valor);
        String retorno[];
        try {
            retorno = SocketCtrl.enviar(ParametrosEnum.SAQUE.getNomeParametro(), dados).split("\t");
        } catch (IOException ex) {
            throw new ContaException("Ocorreu um erro inesperado");
        }
        
        String dadosAux[] = retorno[1].split("[|]");
        
        if(retorno[0].equals(ParametrosEnum.ERRO.getNomeParametro())){
            throw new ContaException(dadosAux[1]);
        }
        
        this.setContaView(new Conta(dadosAux[0], dadosAux[1], dadosAux[2], dadosAux[3],dadosAux[4], Double.parseDouble(dadosAux[5])));
        return true;
    }
    
    public boolean tranferencia(String agOri,String contaOri,String agDest,String contaDest, double valor) throws ContaException {
        String dados = agOri+"|"+contaOri+"|"+agDest+"|"+contaDest+"|"+String.valueOf(valor);
        String retorno[];
        try {
            retorno = SocketCtrl.enviar(ParametrosEnum.TRANSFERENCIA.getNomeParametro(), dados).split("\t");
        } catch (IOException ex) {
            throw new ContaException("Ocorreu um erro inesperado");
        }
        
        String dadosAux[] = retorno[1].split("[|]");
        
        if(retorno[0].equals(ParametrosEnum.ERRO.getNomeParametro())){
            throw new ContaException(dadosAux[1]);
        }
        
        this.setContaView(new Conta(dadosAux[0], dadosAux[1], dadosAux[2], dadosAux[3],dadosAux[4], Double.parseDouble(dadosAux[5])));
        return true;
    }
}

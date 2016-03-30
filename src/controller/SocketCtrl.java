/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Marcelo
 */
public class SocketCtrl {
    private static final String endereco = "127.0.0.1";
    private static final int porta = 5400;

    public static String enviar(String param, String dados) throws IOException {
        Socket sock = new Socket(endereco, porta);
        PrintWriter w = new PrintWriter(sock.getOutputStream(), true);
        String msg = param + "\t" + dados;
        w.println(msg);

			//DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, 5400);
        //chat.send(data);
        //DataInputStream recebido = new DataInputStream(chat.getInputStream());
        BufferedReader recebido = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        msg = recebido.readLine();
        
        recebido.close();
        w.close();
        sock.close();
        
        return msg;
    }
}

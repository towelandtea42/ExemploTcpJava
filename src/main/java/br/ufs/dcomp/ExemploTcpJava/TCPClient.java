/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            String msg;
            Scanner sc = new Scanner(System.in);
            byte[] bufout;
            byte[] bufin;
            
            while(true) {
                /*Início do send*/
                msg = sc.nextLine();
                bufout = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
    
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(bufout);
                System.out.println("[OK] ]");
                /*Fim do send*/
                
                /*Início do receive*/
                bufin = new byte[200];
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(bufin); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                msg = new String(bufin); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: "+ msg);
                /*Fim do receive*/
                
            }
                
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}
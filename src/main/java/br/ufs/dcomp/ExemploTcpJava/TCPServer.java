/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPServer{
    public static void main(String[] args){
        
        try {
            System.out.print("[ Iniciando Servidor TCP    .........................  ");
            ServerSocket ss = new ServerSocket(3300, 5, InetAddress.getByName("127.0.0.1"));
            System.out.println("[OK] ]");
            
            System.out.print("[ Aquardando pedidos de conexão    ..................  ");
            Socket sock = ss.accept(); // Operação bloqueante (aguardando pedido de conexão)
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); //Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); //Canal de saída de dados
            byte[] bufin; // buffer de recepção]
            byte[] bufout;
            String msg;
            Scanner sc = new Scanner(System.in);
            
            while(true) {
                /*Início do receive*/
                bufin = new byte[200];
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(bufin); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                msg = new String(bufin); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: "+ msg);
                /*Fim do receive*/
                
                /*Início do send*/
                msg = sc.nextLine();
                bufout = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
    
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(bufout);
                System.out.println("[OK] ]");
                /*Fim do send*/
            }
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}
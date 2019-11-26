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
            
            String ip, msg;
            int porta;
            Scanner sc = new Scanner(System.in);
            byte[] bufin, bufout; // buffers de envio e recepção
            
            
            System.out.print("Digite o IP: ");
            ip = sc.next();
            System.out.print("Digite a porta: ");
            porta = sc.nextInt();
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket(ip, porta);
            System.out.println("[OK] ]");
            
            System.out.println("[ Chat iniciado ]");
            
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            msg = sc.nextLine();
            
            while(true) {
                /*Início do send*/
                System.out.print("Digite mensagem: ");
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

package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPConnect{
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            int resposta;
            
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Solicitar conexão a uma máquina");
            System.out.println("2 - Aguardar pedido de conexão");
            System.out.print("Digite a opção correspondente: ");
            resposta = sc.nextInt();
            
            do {
                switch (resposta) {
                    case 1: TCPClient.main(args);
                            break;
                    case 2: TCPServer.main(args);
                            break;
                    default: System.out.println("");
                            System.out.println("O número digitado é inválido!");
                            System.out.println("O que deseja fazer?");
                            System.out.println("1 - Solicitar conexão a uma máquina");
                            System.out.println("2 - Aguardar pedido de conexão");
                            System.out.print("Digite a opção correspondente: ");
                            resposta = sc.nextInt();
                }
            } while(resposta != 1 && resposta != 2);

                
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}
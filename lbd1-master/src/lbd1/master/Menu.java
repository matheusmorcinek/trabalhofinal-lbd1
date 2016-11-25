/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbd1.master;

import java.util.Scanner;

/**
 *
 * @author marthi
 */
public final class Menu {
    
    boolean roda;
    
    public Menu(){
        inicia();
        this.roda = true;
        
    }
    
    public void inicia(){
        while(roda){
            Scanner get = new Scanner(System.in);
            System.out.println("Tecle '1' para Listagem de produtos em ordem alfabética: ");
            System.out.println("Tecle '2' para Busca de Produto por nome: ");
            System.out.println("Tecle '3' para Busca de Cliente por nome: ");
            System.out.println("Tecle '4' para Efetuar um novo pedido: ");
            System.out.println("Tecle '5' para Visualizar a quantidade de pedidos de um determinado produto e a quantidade total: ");
            System.out.println("Tecle '6' para Listar os clientes, o número de pedidos e o valor total dos pedidos para o cliente: ");
            System.out.println("Tecle '7' para Visualizar relatório de pedidos por data: ");
            System.out.println("Tecle '8' para Listar o produto mais caro comprado por cada cliente: ");
            System.out.println("Tecle '0' Sair: ");
            int opcao = get.nextInt();
            switch(opcao){
                case 1:
                    //comando
                    break;
                case 2:
                    //comando
                    break;
                case 3:
                    //comando
                    break;
                case 4:
                    //comando
                    break;
                case 5:
                    //comand
                    break;
                case 6:
                    //comando 
                    break;
                case 7:
                    //comando
                    break;
                case 8:
                    this.roda = false;
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
    }
    
}
    
    public void setOpcao(boolean op){
        this.roda = op;
    }
}


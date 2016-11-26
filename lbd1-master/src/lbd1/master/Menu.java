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
public  class Menu {
    
    public static void main(String[] args) {
        boolean roda = true;
        
         masterController master = new masterController();
       
     
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
            System.out.println("Tecle '9' Sair: ");
            int opcao = get.nextInt();
            switch(opcao){
                case 1:
                    master.RetornaProdutos();
                    break;
                case 2:
                    System.out.println("Entre com o nome do produto: ");
                    String produto = get.next();
                    master.RetornaProdutoPorNome(produto);
                    break;
                case 3:
                    System.out.println("Entre com o nome do cliente: ");
                    String cliente = get.next();
                    master.RetornaClientePorNome(cliente);
                    break;
                case 4:
                    System.out.println("Digite codigo do produto: ");
                    int cod_cat = get.nextInt();
                    
                    System.out.println("Entre com o código do cliente: ");
                    int cod_cli = get.nextInt();
                    //pegar total clientes
                    
                   
                    System.out.println("Entre a quantidade de produtos: ");
                    int qtde = get.nextInt();
                    if(qtde < 0){
                        qtde = get.nextInt();
                    }
                    System.out.println("Entre com o valor total: ");
                    double vTotal = get.nextDouble();
                    if(vTotal < 0){
                        qtde = get.nextInt();
                    }
                 
                    
                    String totalPedidos = Integer.toString(master.retornaTotalDePedidos()+2);
                    master.FazerNovoPedido(totalPedidos, cod_cat, cod_cli, qtde, vTotal);
                    
                    break;
                case 5:
                    System.out.println("digite nome do produto");
                    String nomedoproduto = get.next();
                    master.RetornaPedidosPorProduto(nomedoproduto);
                    
                    break;
                case 6:
                    master.RetornaListaDeClientesEnumeroPedidosComTotal();
                    break;
                case 7:
                  master.retornaPrecoDeProdutoComPedido();
                    
                    break;
                case 8:
                   master.RelatorioDePedidos();
                    break;
                case 9:
                   roda = false;
                    break;
                default:
                    System.out.println("Comando inválido");
//                    System.out.println("Tecle 'enter' para continuar"); 
//                    get.next();
                    System.out.print("\f");
                    //break;
            }
    }
        
        
    }
}


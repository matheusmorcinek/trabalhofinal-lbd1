/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbd1.master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import master_DB.conexao_DB;
import static master_DB.conexao_DB.conexao;
import master_RN.Cliente;
import master_RN.Pedido;
import master_RN.Produto;

/**
 *
 * @author 16111201
 */
public class masterController {
    
  

    //1. Listagem de todos os produtos, em ordem alfabética.
    public void RetornaProdutos(){
                conexao_DB db = new conexao_DB();
		ArrayList<Produto> produtos = new ArrayList<>();
		db.conectarBanco();
		String sql = "SELECT * FROM PRODUTOS ORDER BY (NOME)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Produto produto = new Produto(resultado.getInt("CODIGOPRODUTO"),
                                                              resultado.getDouble("PRECO"),
                                                                resultado.getString("NOME"),
                                                                   resultado.getInt("CODIGOCATEGORIA"));
				produtos.add(produto);				
                      }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();

                //imprime array
                if(produtos.size() > 0){
                    for(Produto produto : produtos){
                        System.out.println(produto.toString());
                    }
                }   
                
	}

    //2. Busca de um cliente ou produto por nome ou descrição.
    public void RetornaProdutoPorNome(String nome){
        
                conexao_DB db = new conexao_DB();
		
		db.conectarBanco();
                //select * from produtos where nome like 'entrada'
		String sql = "SELECT * FROM PRODUTOS WHERE NOME LIKE '"+nome+"'";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Produto produto = new Produto(resultado.getInt("CODIGOPRODUTO"),
                                                              resultado.getDouble("PRECO"),
                                                                resultado.getString("NOME"),
                                                                   resultado.getInt("CODIGOCATEGORIA"));
				System.out.println(produto.toString());
                      }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();
    }
    //2.1
    public void RetornaClientePorNome(String nome){
         conexao_DB db = new conexao_DB();
		
		db.conectarBanco();
                //select * from produtos where nome like 'entrada'
		String sql = "SELECT * FROM CLIENTES WHERE NOME LIKE '"+nome+"'";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Cliente cliente = new Cliente(resultado.getInt("CODIGOCLIENTE"),
                                                              resultado.getString("NOME"),
                                                                resultado.getString("STATUS"),
                                                                   resultado.getInt("TELEFONE"),
                                                                    resultado.getString("ENDERECO"),
                                                                     resultado.getDouble("LIMITE"));
				System.out.println(cliente.toString());
                      }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();
    }
    
    
    //3. Fazer um novo pedido (inserção de um registro de pedido).
    public void FazerNovoPedido(){
        
                conexao_DB db = new conexao_DB();
		
		db.conectarBanco();
                /*
		String sql = "insert into pedidos (CODIGOPEDIDO, DATAPEDIDO, CODIGOPRODUTO, QUANTIDADE, VALORTOTAL, CODIGOCLIENTE)\n" 
                                +"values("+ Integer.toString(pedido.getCodPedido())
                                +",to_date ('25-11-2016', 'DD-MM-YYYY'),"
                                +Integer.toString(pedido.getCodProduto())+", "+Integer.toString(pedido.getQuantidade())
                                +" ,"+Double.toString(pedido.getValorTotal())
                                +","+Integer.toString(pedido.getCodCliente())+")";
		*/
                
                String sql = "insert into pedidos (CODIGOPEDIDO, DATAPEDIDO, CODIGOPRODUTO, QUANTIDADE, VALORTOTAL, CODIGOCLIENTE) values (7,to_date ('25-11-2016', 'DD-MM-YYYY'),1,3123,3333,2)";
                     
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        /*
                            stmt.setInt(1, pedido.getCodPedido()); // CHAR(8)
                            stmt.setString(2, "to_date ('25-11-2016', 'DD-MM-YYYY')"); 
                            stmt.setInt(3, pedido.getCodProduto()); 
                            stmt.setInt(4, pedido.getQuantidade()); 
                            stmt.setInt(5, pedido.getValorTotal()); 
                            stmt.setInt(6, pedido.getCodCliente()); 
                            */
                        stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();        
    }
    
    //4. elatório de pedidos (qual cliente comprou qual produto, em que data e qual o valor
    //do pedido), ordenado pela data.
    public void RelatorioDePedidos(){
                conexao_DB db = new conexao_DB();
		
		db.conectarBanco();
		
                String sql = " select cl.NOME, prod.NOME as NOMEPRODUTO , ped.DATAPEDIDO, ped.VALORTOTAL\n" +
                                "from clientes cl, PRODUTOS prod, pedidos ped\n" +
                                "where cl.codigocliente = ped.codigocliente and ped.CODIGOPRODUTO = prod.codigoproduto\n" +
                                "order by ped.DATAPEDIDO";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				System.out.println("Nome cliente: "+resultado.getString("NOME")+
                                                   " - Nome do produto: "+resultado.getString("NOMEPRODUTO")+
                                                    "Data Pedido: "+resultado.getString("DATAPEDIDO")+
                                                    "Valor Total: "+resultado.getString("VALORTOTAL")
                                );				
                        }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();
    }
    
    
    //5. Visualizar a quantidade de pedidos de um determinado produto e a quantidade total
    //e o valor total vendido correspondente (e eventuais descontos).
    public void RetornaPedidosPorProduto(String produto){
        
                conexao_DB db = new conexao_DB();
		
		db.conectarBanco();
                //select * from produtos where nome like 'entrada'
		String sql = "select count(*) qtde_pedidos, sum(ped.QUANTIDADE) as QTDPEDIDOS, sum(ped.VALORTOTAL) AS TOTAL\n" +
                                "from PRODUTOS pd, pedidos ped\n" +
                                    "where pd.NOME like '"+produto+"' and pd.CODIGOPRODUTO = ped.CODIGOPRODUTO";
                
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
			System.out.println("Qtd Pedidos :"+resultado.getInt("QTDE_PEDIDOS")+
                                            "Quantidade pedidos: " +resultado.getInt("QTDPEDIDOS")+
                                                "TOTAL: " +resultado.getInt("TOTAL")
                                );
                      }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();
        
    }
    
    
    
    //6. Listar os clientes, o número de pedidos e o valor total dos pedidos para o cliente.
      //Ordenar pelo valor total dos pedidos, do maior para o menor.
    public void RetornaListaDeClientesEnumeroPedidosComTotal(){
        /*(select cl.NOME, count(ped.CODIGOPEDIDO) as TotalPedidos, sum(valortotal) as ValorTotal
from clientes cl inner join pedidos ped on cl.CODIGOCLIENTE = ped.CODIGOCLIENTE
group by cl.NOME) ORDER BY NOME ASC;*/
    }
    
    public void padrao(){
                conexao_DB db = new conexao_DB();
		ArrayList<Produto> produtos = new ArrayList<>();
		db.conectarBanco();
		String sql = "SELECT * FROM PRODUTOS ORDER BY (NOME)";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        ResultSet resultado = stmt.executeQuery();
			while(resultado.next()){
				Produto produto = new Produto(resultado.getInt("CODIGOPRODUTO"),
                                                              resultado.getDouble("PRECO"),
                                                                resultado.getString("NOME"),
                                                                   resultado.getInt("CODIGOCATEGORIA"));
				produtos.add(produto);				
                      }			
			resultado.close();
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
		}
		db.fechaConexao();
    }
    
}

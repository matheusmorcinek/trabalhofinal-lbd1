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

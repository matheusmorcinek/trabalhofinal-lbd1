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
import master_RN.Produto;

/**
 *
 * @author 16111201
 */
public class masterController {
    
  

    //1. Listagem de todos os produtos, em ordem alfabética.
    public ArrayList<Produto> RetornaProdutos(){
                conexao_DB db = new conexao_DB();
		ArrayList<Produto> produtos = new ArrayList<>();
		db.conectarBanco();
		String sql = "SELECT * FROM PRODUTOS ORDER BY (NOME)";
		
		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);

			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next()){
				System.out.println("achou");
                              
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
		return produtos;	
	}

    
    
    
}

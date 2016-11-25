/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbd1.master;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import master_DB.conexao_DB;
import static master_DB.conexao_DB.conexao;



/**
 *
 * @author Matheus
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        
         conexao_DB db = new conexao_DB();
         //db.conectarBanco();
     
 
           
        String sql = "SELECT NOME FROM SYSTEM.PRODUTOS";
          PreparedStatement stmt = conexao.prepareStatement(sql); 
                 ResultSet rs = stmt.executeQuery();
                 
                 while (rs.next()) {
                     
                     String nome = rs.getString("NOME");
                     System.out.println(nome);
                 }
                 
                 rs.close();
                 stmt.execute();
             
      
        
        conexao.close();
            
      
        
        db.fechaConexao();
            
    }
         
         
         
    }
    
    
   
    

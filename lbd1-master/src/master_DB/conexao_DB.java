/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class conexao_DB {
    
    public static Connection conexao;

    public conexao_DB(){
    	conectarBanco();
    }
    
	public void conectarBanco() {
			
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", "BG111201");
		connectionProps.put("password", "BG111201");
		try{
                  conexao = DriverManager.getConnection("jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g",connectionProps);  
                  System.out.println("Conexão bem sucedida!");
                  
                } catch(SQLException e){
                    System.out.println("Falha na conexo!");                    
                }
		}
        
        public static Connection getConexao(){
            return conexao;
        }
        
        public void fechaConexao(){
            try {
                this.conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	
       
        
//        public void cadastraItem(String s){
//        try {
//            PreparedStatement stmt = this.conexao.prepareStatement(s);
//            stmt.execute();
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(conexao_DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        }
        
        
	
}

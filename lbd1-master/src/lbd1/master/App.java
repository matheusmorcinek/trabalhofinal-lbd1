/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lbd1.master;

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
 * @author Matheus
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        
         masterController master = new masterController();
         
         
         //1. Listagem de todos os produtos, em ordem alfabética.
         ArrayList<Produto> produtos = master.RetornaProdutos();
         for(Produto produto : produtos){
             System.out.println(produto.toString());
         }
         
         
         
    }
         
         
         
    }
    
    
   
    

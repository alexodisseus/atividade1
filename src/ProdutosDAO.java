/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto(ProdutosDTO produto) {
        conn = new conectaDAO().connectDB(); 
        PreparedStatement prep = null;
        try {
            conn = new conectaDAO().connectDB(); 
            if (conn != null) {

                String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
                prep = conn.prepareStatement(sql);
                prep.setString(1, produto.getNome()); 
                prep.setInt(2, produto.getValor());   
                prep.setString(3, produto.getStatus());
                int rowsAffected = prep.executeUpdate(); 

                return rowsAffected > 0;
            }

        } catch (SQLException erro) {
            // Tratamento de erro 
        } finally {

            try {
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                // Tratamento de erro 
            }
        }
        return false; 
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }


    
    
    
        
}


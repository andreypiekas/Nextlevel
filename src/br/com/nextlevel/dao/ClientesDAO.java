/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.dao;

import br.com.nextlevel.jdbc.ConnectionFactory;
import br.com.nextlevel.model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.nextlevel.model.Enderecos;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey.piekas
 */
public class ClientesDAO {
    
    private Connection conexao;
    ///Construtor
    //EnderecosDAO enderecos = new EnderecosDAO();

    public ClientesDAO() {
        //Garante que uma conexao esteja aberta com o banco de dados

        this.conexao = ConnectionFactory.getConnection();
        
    }
    
    public void CadastrarCliente(Clientes objCliente) {
        try {
            String sql = "insert into tb_clientes(id, nome, email, cpf, telefone) values (?,?,?,?,?)";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, objCliente.getId());
            comando.setString(2, objCliente.getNome());
            comando.setString(3, objCliente.getEmail());
            comando.setString(4, objCliente.getCpf());
            comando.setString(5, objCliente.getTelefone());
            
            comando.execute();
            comando.close();
            
            sql = "select id from tb_clientes where cpf=?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, objCliente.getCpf());
            
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()) {
                objCliente.setId(resultado.getInt("id"));
            }
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}

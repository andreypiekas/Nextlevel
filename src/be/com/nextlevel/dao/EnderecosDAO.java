/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.com.nextlevel.dao;

import br.com.nextlevel.jdbc.ConnectionFactory;
import java.sql.*;
import br.com.nextlevel.model.Enderecos;

/**
 *
 * @author andrey.piekas
 */
public class EnderecosDAO {

    private Connection conexao;
    ///Construtor
    EnderecosDAO enderecos = new EnderecosDAO();

    public EnderecosDAO() {
        //Garante que uma conexao esteja aberta com o banco de dados
        this.conexao = ConnectionFactory.getConnection();

    }

    //metodos
    //metodos para cadastrar os enderecos
    
    public void cadastrarEndereco(Enderecos objEndereco){
        try {
            String sql = "insert into enderecos_entrega(Clientes_idClientes, cep, rua, numero, complemento, bairro, cidade, estado) "
                    + "values(?,?,?,?,?,?,?,?)";
            //
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, objEndereco.getCep());
            comando.setString(2, objEndereco.getRua());
            comando.setInt(3, objEndereco.getNumero());
            comando.setString(4, objEndereco.getComplemento());
            comando.setString(5, objEndereco.getBairro());
            comando.setString(6, objEndereco.getCidade());
            comando.setString(7, objEndereco.getEstado());
            
            
            
            
        } catch (Exception e) {
        }

        
    }
    
}

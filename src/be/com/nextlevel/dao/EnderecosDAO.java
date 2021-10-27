/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.com.nextlevel.dao;

import br.com.nextlevel.jdbc.FabricaConexao;
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
        this.conexao = FabricaConexao.criaConexao();

    }

    //metodos
    //metodos para cadastrar os enderecos
    
    public void cadastrarEndereco(Enderecos obj){
        try {
            String sql = "insert into enderecos_entrega(idEndereco_entrega, Pedido_idPedido, cep, rua, numero, complemento, bairro, cidade, estado) "
                    + "values(?,?,?,?,?,?,?,?,?)";
            
        } catch (Exception e) {
        }

        
    }
    
}

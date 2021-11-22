/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.dao;

import br.com.nextlevel.jdbc.ConnectionFactory;
import java.sql.*;
import br.com.nextlevel.model.Enderecos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey.piekas
 */
public class EnderecosDAO {

    private Connection conexao;
    ///Construtor
    //EnderecosDAO enderecos = new EnderecosDAO();

    public EnderecosDAO() {
        //Garante que uma conexao esteja aberta com o banco de dados

        this.conexao = ConnectionFactory.getConnection();

    }

    //metodos
    //metodos para cadastrar os enderecos
    public void cadastrarEndereco(Enderecos objEndereco) {
        try {
              //2º passo: criar uma string de comando SQL
            String sql = "insert into tb_enderecos(cep, rua, numero, complemento, bairro, cidade, uf, id_cliente)"
                    + "values (?,?,?,?,?,?,?,?)";

            //3º passo: preparar o comando SQL para o driver
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, objEndereco.getCep());
            comando.setString(2, objEndereco.getRua());
            comando.setInt(3, objEndereco.getNumero());
            comando.setString(4, objEndereco.getComplemento());
            comando.setString(5, objEndereco.getBairro());
            comando.setString(6, objEndereco.getCidade());
            comando.setString(7, objEndereco.getUf());
            comando.setInt(8, objEndereco.getCliente().getId());

            //4º passo: executar o comando sql e fechar a conexão
            comando.execute();
            comando.close();

            //Se chegar aqui o cadastro foi efetuado com sucesso
            JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public List<Enderecos> listarEnderecos() {

        try {
            List<Enderecos> lista = new ArrayList<>();
            String sql = "select * from endereco";
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            // System.out.println("RESULT SET" + rs);

            while (rs.next()) {
                Enderecos obj = new Enderecos();

                obj.setId(rs.getInt("id"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("rua"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));

                // System.out.println("OBJETO" + obj);
                lista.add(obj);

            }
            // System.out.println("LISTA" + lista);

            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}

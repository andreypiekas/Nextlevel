/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nextlevel.dao;

import br.com.nextlevel.jdbc.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.nextlevel.model.Enderecos;
import javax.swing.JOptionPane;

/**
 *
 * @author andrey.piekas
 */
public class TestaDAO {

    public static void main(String[] args) {
        Enderecos enderecoTeste = new Enderecos();

        enderecoTeste.setClientes_idClientes(1);
        enderecoTeste.setCep("1");
        enderecoTeste.setRua("Quatorze de agosto, 3161");
        enderecoTeste.setNumero(3161);
        enderecoTeste.setComplemento("Epros Atacado");
        enderecoTeste.setBairro("Líder");
        enderecoTeste.setCidade("Chapecó");
        enderecoTeste.setEstado("SC");
        
        
        EnderecosDAO dao = new EnderecosDAO();
        
        dao.cadastrarEndereco(enderecoTeste);
        

    }

}

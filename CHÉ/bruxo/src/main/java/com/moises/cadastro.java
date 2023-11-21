package com.moises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cadastro {
    public static void main(String[] args) {
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        String nome = "Tiago Nunes";
        String email = "tiagonunes2018@gmail.com";
        Double telefone = 34.991084657;


        String sql = "INSERT INTO cadastro_usuario (nome, email, telefone) VALUES(?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1,nome);
        statement.setString(2, email);
        statement.setDouble(3, telefone);


    int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
        System.out.println("Usuário adicionado com sucesso!");
        } else {
        System.out.println("Erro ao inserir Usuário.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
                
    }
}


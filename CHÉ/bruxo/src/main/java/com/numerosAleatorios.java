package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class numerosAleatorios {
    public static void main(String[] args) {
        
        Random random = new Random();
    
    String host = "localhost";
    String database = "exercicios2";
    String usuario = "root";
    String senha = "";
    
    try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, usuario, senha)) {
    
        Double numero =  random.nextDouble() * 100; //Número aleatório de 0 à 100

        String sql = "INSERT INTO numeros_aleatorios (numero) VALUES(?)";
        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setDouble(1,numero);

    int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
        System.out.println("Número adicionado com sucesso!");
        } else {
        System.out.println("Erro ao inserir Número.");
        }

    } catch (SQLException e) {
        System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
                
    }
}


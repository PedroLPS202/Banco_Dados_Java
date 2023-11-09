package com.produtosprojeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
        //Informações de conexão 
        private static final String hosy = "localhost";
        private static final String database = "cadastro_produto";
        private static final String usuario ="root";
        private static final String senha = "";

        public static void main(String[] args) {
            try (Connection conexao = DriverManager.getConnection("jdbc:mysql://" + hosy + ":3306/" + database, usuario, senha)) {
                String nome = "Produtos de Teste";
                String descricao = "Descrição do Produto de Teste";
                int preco = 100;
                double quantidade = 10.0;
                String dataCadstro = "2023-10-27";

                String sql = "INSERT INTO produtos (nome, descricao, preco, quantidade, data_cadastro) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, descricao);
                stmt.setDouble(3, quantidade);
                stmt.setInt(4, preco);
                stmt.setString(5, dataCadstro);

                int linhaAfetadas = stmt.executeUpdate();

                if (linhaAfetadas > 0) {
                    System.out.println("Produtos inseridos com sucesso!");
                } else {
                    System.out.println("Não foi possível inserir o produto.");
            }
        } 
        catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}

       
            

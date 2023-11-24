package com.javat;

import java.sql.*;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca2", "root", "");

            Statement statement = connection.createStatement();

            // Criação das tabelas
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Cliente (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(50), email VARCHAR(50), sexo VARCHAR(10))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Livro (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(50), autor VARCHAR(50), tipo VARCHAR(50), status VARCHAR(20) DEFAULT 'disponivel')");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Emprestimo (id INT AUTO_INCREMENT PRIMARY KEY, id_cliente INT, id_livro INT, status VARCHAR(20), data DATE, FOREIGN KEY (id_cliente) REFERENCES Cliente(id), FOREIGN KEY (id_livro) REFERENCES Livro(id))");
   

            // Trigger Atualização do Status do Livro para "emprestado" ao fazer um empréstimo
            statement.executeUpdate("CREATE TRIGGER atualizaStatusEmprestimo AFTER INSERT ON Emprestimo FOR EACH ROW " +
                    "BEGIN " +
                    "UPDATE Livro SET status = 'Emprestado' WHERE id = NEW.id_livro; " +
                    "END");

            // crie o Trigger Atualização do Status do Livro para "disponível" ao devolver um livro
            statement.executeUpdate("CREATE TRIGGER atualizaStatusDisponivel AFTER INSERT ON Disponivel  FOR EACH ROW " +
            "BEGIN " +
            "IF NEW.status = 'Devolvido' THEN" +
            "UPDATE Livro SET status = 'DiSponivel' Where id = New.id_livro; " +
            "END");


            Scanner scanner = new Scanner(System.in);

            // Inserção de dados para a tabela Cliente
            System.out.println("\nInserir novo cliente:");

            System.out.print("Nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Email do cliente: ");
            String emailCliente = scanner.nextLine();

            System.out.print("Sexo do cliente: ");
            String sexoCliente = scanner.nextLine();

            String inserirClienteQuery = "INSERT INTO Cliente (nome, email, sexo) VALUES (?, ?, ?)";
            PreparedStatement inserirCliente = connection.prepareStatement(inserirClienteQuery);
            inserirCliente.setString(1, nomeCliente);
            inserirCliente.setString(2, emailCliente);
            inserirCliente.setString(3, sexoCliente);
            inserirCliente.executeUpdate();

            

            // Inserção de dados para a tabela Empréstimo
            System.out.println("\nRealizar empréstimo:");
            System.out.print("ID do cliente: ");
            int idClienteEmprestimo = scanner.nextInt();
            System.out.print("ID do livro: ");
            int idLivroEmprestimo = scanner.nextInt();

            String inserirEmprestimoQuery = "INSERT INTO Emprestimo (id_cliente, id_livro, status, data) VALUES (?, ?, 'emprestado', NOW())";
                PreparedStatement inserirEmprestimo = connection.prepareStatement(inserirEmprestimoQuery);
                inserirEmprestimo.setInt(1, idClienteEmprestimo);
                inserirEmprestimo.setInt(2, idLivroEmprestimo);
                inserirEmprestimo.executeUpdate();

          // Inserção de dados para a tabela Livro
            System.out.println("\nInserir novo livro:");
            
            System.out.print("Nome do livro: ");
            String nomeLivro = scanner.nextLine();

            System.out.print("Autor do livro: ");
            String autorLivro = scanner.nextLine();

            System.out.print("Tipo do livro: ");
            String tipoLivro = scanner.nextLine();

            System.out.print("Status do livro: ");
            String statusLivro = scanner.nextLine();

            String inserirLivroQuery = "INSERT INTO Livro (nome, autot, tipo, status) VALUES (?, ?, ?, ?)";
            PreparedStatement inserirLivro = connection.prepareStatement(inserirLivroQuery);
            inserirLivro.setString(1, nomeLivro);
            inserirLivro.setString(2, autorLivro);
            inserirLivro.setString(3, tipoLivro);
            inserirLivro.setString(4, statusLivro);
            inserirLivro.executeUpdate();

            // Consulta de Livros
            ResultSet resultSetLivros = statement.executeQuery("SELECT * FROM Livro");
            while (resultSetLivros.next()) {
                System.out.println("Livro ID: " + resultSetLivros.getInt("id") + ", Nome: " + resultSetLivros.getString("nome") + ", Status: " + resultSetLivros.getString("status"));
            }

            resultSetLivros.close();
            inserirCliente.close();
            statement.close();
            connection.close();

            System.out.println("Operações concluídas com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
}
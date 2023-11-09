package com.example2;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
    public static void main(String[] args) {
       //Configuração da conexão
       String url = "jdbc:mysql//local:3306/meubanco";
       String ususario = "seuUsuario";
       String senha = "suaSenha";
    
    try {
        //Coxenão da consulta
        Statement statement = conexao.createStatement();
        String consulta = "SELECT nome, idade FROM usuarios ";
        
        //Execução da consulta
        ResultSet resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            int idade = resultSet.getInt("idade");
            System.out.println("Nome: " + nome + ", Idade: " + idade );
        }

        //Fechamento da conexao
        conexao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    

package javamysql;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class TesteConexaoBanco {
    @Test
    public void TesteConexao(){
        String url = "jdbc:mysql://localhost:3306/meubanco";
        String usuario = "seuUsuario";
        String senha = "suaSenha";
    
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            assertNotNull(conexao); //Verifica se a conexao nao e nula
            conexao.close();
        } catch(SQLException e) {
            fail("Erro ao conectar ao banco de dados.");
        }
    }
}

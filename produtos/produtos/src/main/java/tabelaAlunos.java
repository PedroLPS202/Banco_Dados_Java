import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class tabelaAlunos {
       public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cadastro_produto";
        String usuario = "root";
        String senha = "";
        int variavelIdade = 18;
        String variavelNome = "Pedro";
        String variavelSexo = "M";
        String variavelSigno = "Gêmeos";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            // Parte 1: Criar a tabela 'alunos'
            String sqlCriarTabela = "CREATE TABLE IF NOT EXISTS alunos (" + "id INT AUTO_INCREMENT PRIMARY KEY," + "nome VARCHAR(100)," + "idade INT," + "signo VARCHAR(50)," + "sexo CHAR(1)" + ")";
            Statement statement = conexao.createStatement();
            statement.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'alunos' criada com sucesso.");

            // Parte 2: Inserir um aluno

            String sqlInserirAluno = "INSERT INTO alunos (nome, idade, signo, sexo) VALUES (?, ?, ?, ?)";
            PreparedStatement statementInserir = conexao.prepareStatement(sqlInserirAluno);
            statementInserir.setString(1, variavelNome);
            statementInserir.setInt(2, variavelIdade);
            statementInserir.setString(3, variavelSigno);
            statementInserir.setString(4, variavelSexo);

            int linhasAfetadas = statementInserir.executeUpdate();
            System.out.println(linhasAfetadas + " aluno inserido.");

            statementInserir.close();
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
}


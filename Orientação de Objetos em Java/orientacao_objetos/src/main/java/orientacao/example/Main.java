package orientacao.example;

class Pessoa {
    String nome;
    int idade;

    void saudacao() {
        System.out.println("Olá, meu nome é " + nome + "e tenho " + idade + "anos");
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Alice";
        pessoa1.idade = 30;
        pessoa1.saudacao(); // Saída Olá, meu nome é Alice e tenho 30 anos.

        Pessoa pessoa2 = new Pessoa();
        pessoa2.nome = "Bob";
        pessoa2.idade = 25;
        pessoa2.saudacao(); // Saída Olá, meu nome é Bob e tenho 25 anos.

    }
}
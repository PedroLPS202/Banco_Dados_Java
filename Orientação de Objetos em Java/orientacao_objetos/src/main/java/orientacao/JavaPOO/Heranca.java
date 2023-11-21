package orientacao.JavaPOO;

class Animal {
    void emitirSom() {
        System.out.println("Som  genérico de um animal");
    }
}

class Cachorro extends Animal {
    void emitirSom(){
        System.out.println("Latido de um cachorro.");
    }
}

class Gato extends Animal {
    void emitirSom(){
        System.out.println("Miado de um gato.");
    }
}

public class Heranca {
    public static void main(String[] args) {
        
    Animal animal1 = new Cachorro();
    animal1.emitirSom(); // Saída: Latido de um cachorro.

    Animal animal2 = new Gato();
    animal2.emitirSom(); // Saída: Miado de um gato.

    }
}

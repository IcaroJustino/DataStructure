package arvorebinaria;

public class Arvore_Teste {

    public static void main(String[] args) {
        Arvore_Binaria arvore = new Arvore_Binaria();
        arvore.insert(null, 20); // criando o primeiro Nó da arvore com o elemento 20
        arvore.insert(arvore.root(), 30);
        // System.out.println(arvore.mostraArvore());
    }

}

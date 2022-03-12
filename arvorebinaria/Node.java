package arvorebinaria;

public class Node {
    int elemento;
    Node esquerdo,direito,pai;
    // Construtor dos items do Nó
    


    public Node(int elemento, Node esquerdo, Node direito, Node pai) {
        this.elemento = elemento;
        this.esquerdo = esquerdo;
        this.direito = direito;
        this.pai = pai;
    }



    public int getElemento() {
        return elemento;
    }



    public void setElemento(int elemento) {
        this.elemento = elemento;
    }



    public Node getEsquerdo() {
        return esquerdo;
    }



    public void setEsquerdo(Node esquerdo) {
        this.esquerdo = esquerdo;
    }



    public Node getDireito() {
        return direito;
    }



    public void setDireito(Node direito) {
        this.direito = direito;
    }



    public Node getPai() {
        return pai;
    }



    public void setPai(Node pai) {
        this.pai = pai;
    }
    
    //Metodo Para Rezetar o valor dos elementos 
    public void clear() {
		this.setPai(null);
		this.setEsquerdo(null);
		this.setDireito(null);
	}

}

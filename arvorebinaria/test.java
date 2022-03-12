package arvorebinaria;

public class test {
    class Node 
{
    int data;
    Node left, right;
 
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree 
{
     Node root;
 
    /* Compute the "maxDepth" of a tree -- the number of 
       nodes along the longest path from the root node 
       down to the farthest leaf node.*/
    int maxDepth(Node node) 
    {
        if (node == null)
            return -1;
        else 
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
 
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else 
                return (rDepth + 1);
        }
    }
     
    /* Driver program to test above functions */
    public static void main(String[] args) 
    {
        BinaryTree tree = new BinaryTree();
 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("Height of tree is : " + 
                                      tree.maxDepth(tree.root));
    }
}

// This code has been contributed by Amit Srivastav
}




// Pratica da avaliação 




public int verifica_sub_esquerda(Node no, boolean visitado) {
    int elemento_esquerdo = 0;
    if(!visitado) {
        listaPreOrder = new ArrayList<Node>();
    }
    listaPreOrder.add(no);
    if(no.getEsquerdo() != null) {
        elemento_esquerdo += no.elemento;
        preOrder(no.getEsquerdo(), true);
    }
    return elemento_esquerdo;
}
    public int verifica_sub_direita(Node no, boolean visitado) {    
    int elemento_direito = 0;
    if(!visitado) {
        listaPreOrder = new ArrayList<Node>();
    }
    listaPreOrder.add(no);
    if(no.getDireito() != null) {
        elemento_direito += no.elemento;
        preOrder(no.getDireito(), true);
    }
    return elemento_direito;
}
public boolean éÁrvoreBináriaDePesqusa(Arvore_Binaria A){
    if (A.root() != null){
     int raiz = A.elementos(A.root());
     int elemento_filho_esquerdo = A.verifica_sub_esquerda(root(), true);  //vai verificar os nos da sub arvore esquerda e retornar a soma dos seus elementos 
     int elemento_filho_direito =  A.verifica_sub_direita(root(), true);   //vai verificar os nos da sub arvore direita e retornar a soma de seus elementos
        if(raiz < elemento_filho_direito){
            if(raiz > elemento_filho_esquerdo){
                return true;
            }
        }
    }
    return false;
}
public int altura_geral(Node no){
        if (no == null)
            return -1;
        else 
        {
            /* Calcular a profundidade de cada sub arvore */
            int leftDepth = altura_geral(no.esquerdo);
            int rightDepth = altura_geral(no.direito);
 
            /* usar a que tem o maior caminho */
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
             else 
                return (rightDepth + 1);
        }
}
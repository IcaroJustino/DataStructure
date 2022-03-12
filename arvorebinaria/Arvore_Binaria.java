package arvorebinaria;

import java.util.ArrayList;

public class Arvore_Binaria {
    private Node raiz;
    private int tamanho;
    private ArrayList<Node> listaPreOrder, listaInOrder, listaPosOrder;

    public Arvore_Binaria() {
        raiz = null;
        tamanho = 0;
    }

    // Metodo que retorna o tamanho da arvore
    public int elementos(Node no) {
        return no.getElemento();
    }

    public int size() {
        return this.tamanho;
    }

    // Metodo que Verifica se a arvore está vazia ()
    public boolean isEmpty() {
        return (raiz == null) ? true : false;
    }

    // Retorna o Nó raiz da arvore
    public Node root() {
        return raiz;
    }

    // Retorna o pai daquele Nó
    public Node parent(Node no) {
        return no.getPai();
    }

    // Retorna os s daquele nó
    public ArrayList<Node> children(Node pai) {
        ArrayList<Node> s = new ArrayList<Node>();
        if (pai.getEsquerdo() != null) {
            s.add(pai.getEsquerdo());
        }
        if (pai.getDireito() != null) {
            s.add(pai.getDireito());
        }
        return s;
    }

    // verifica se o o nó possui s
    public boolean isInternal(Node no) {
        return (this.isExternal(no)) ? true : false;
    }

    // verifica se o nó não possui s
    public boolean isExternal(Node no) {
        if (no.getDireito() == null && no.getEsquerdo() == null) {
            return true;
        } else
            return false;
    }

    // Verifica se aquele nó é o mesmo da raiz
    public boolean isRoot(Node no) {
        if (raiz != no) {
            return true;
        } else
            return false;
    }

    // verifica a profundidade daquele nó verificando o pai dele de maneira
    // recursiva
    public int depth(Node no) {
        if (no == null)
            return -1;
        if (this.isRoot(no))
            return 0;
        else
            return 1 + depth(no.getPai());
    }

    // Retorna a altura daquela arvore
    public int height(Node no) {
        if (no == null || this.isExternal(no)) {
            return 0;
        } else {
            int left = height(no.getEsquerdo());
            int right = height(no.getDireito());
            if (left > right) {
                return left + 1;
            }
            return right + 1;
        }
    }

    // retorna o esquerdo
    public Node leftChild(Node no) {
        return no.getEsquerdo();
    }

    // retorna o direito
    public Node rightChild(Node no) {
        return no.getDireito();
    }

    // verifica se aquele nó possui esquerdo
    public boolean hasLeftChild(Node no) {
        if (no.getEsquerdo() == null) {
            return false;
        } else
            return true;
    }

    // verifica se aquele nó possui direito
    public boolean hasRightChild(Node no) {
        if (no.getDireito() == null) {
            return false;
        } else
            return true;
    }

    // listagem Pre Order
    public ArrayList<Node> preOrder(Node no, boolean visitado) {
        if (!visitado) {
            listaPreOrder = new ArrayList<Node>();
        }
        listaPreOrder.add(no);
        if (no.getEsquerdo() != null) {
            preOrder(no.getEsquerdo(), true);
        }
        if (no.getDireito() != null) {
            preOrder(no.getDireito(), true);
        }
        return listaPreOrder;
    }

    // Listagem in order
    public ArrayList<Node> inOrder(Node no, boolean visitado) {
        if (!visitado) {
            listaInOrder = new ArrayList<Node>();
        }
        if (no.getEsquerdo() != null) {
            inOrder(no.getEsquerdo(), true);
        }
        listaInOrder.add(no);
        if (no.getDireito() != null) {
            inOrder(no.getDireito(), true);
        }
        return listaInOrder;
    }

    // listagem Pos order
    public ArrayList<Node> posOrder(Node no, boolean visitado) {
        if (!visitado) {
            listaPosOrder = new ArrayList<Node>();
        }
        if (no.getEsquerdo() != null) {
            posOrder(no.getEsquerdo(), true);
        }
        if (no.getDireito() != null) {
            posOrder(no.getDireito(), true);
        }
        listaPosOrder.add(no);
        if (!visitado) {
            return listaPosOrder;
        }
        return null;
    }

    // Metodo para pesquisar um nó especifico dentro da arvore
    public Node search(int valor, Node no) {
        Node aux = null;
        if (valor == no.getElemento()) {
            return no;
        }
        if (valor < no.getElemento()) {
            aux = this.search(valor, no.getEsquerdo());
        }
        if (valor > no.getElemento()) {
            aux = this.search(valor, no.getDireito());
        }
        no = aux;
        return no;
    }

    // ------------------> Metodos de inserção remoção e troca de elementos na
    // arvore

    // Metodo de insert
    public void insert(Node no, int valor) {

        if (raiz == null) {
            raiz = new Node(valor, null, null, null); // se tentar inserir em uma arvore vazia ele cria a raiz
        } else {
            if (valor < no.getElemento()) { // Verifica se o nó esquerdo está livre
                if (no.getEsquerdo() != null) {
                    insert(no.getEsquerdo(), valor);
                } else {
                    Node novo = new Node(valor, no, null, null);
                    no.setEsquerdo(novo);
                }
            } else { // verifica se o nó direito está livre
                if (no.getDireito() != null) {
                    insert(no.getDireito(), valor);
                } else {
                    Node novo = new Node(valonor, no, null, null);
                    no.setDireito(novo);
                }
            }
        }
    }

    // Metodo de remover nós
    public int remove(Node no) {
        int valor = 0;
        // folha
        if (this.isExternal(no)) {
            valor = no.getElemento();
            if (no.getPai().getEsquerdo() == no) {
                no.getPai().setEsquerdo(null);
            } else {
                no.getPai().setDireito(null);
            }
        } else {
            int qtdF = this.children(no).size();
            // 1
            if (qtdF == 1) {
                valor = no.getElemento();
                if (no.getPai().getDireito() == no) { // eh o direito do pai
                    if (no.getEsquerdo() != null) { // so tem na esquerda
                        no.getPai().setDireito(no.getEsquerdo());
                        no.getEsquerdo().setPai(no.getPai());
                        no.clear();
                    } else { // so tem na direita
                        no.getPai().setDireito(no.getDireito());
                        no.getDireito().setPai(no.getPai());
                        no.clear();
                    }
                } else {
                    if (no.getEsquerdo() != null) { // so tem na esquerda
                        no.getPai().setEsquerdo(no.getEsquerdo());
                        no.getEsquerdo().setPai(no.getPai());
                        no.clear();
                    } else { // so tem na direita
                        no.getPai().setEsquerdo(no.getDireito());
                        no.getDireito().setPai(no.getPai());
                        no.clear();
                    }
                }
            } else { // 2 s
                valor = no.getElemento();
                Node aux = no.getDireito();
                Node sub = null; // o substituto do nó que sera removido
                while (aux != null) {
                    sub = aux; // nó mais a esquerda da sub-arvore direita
                    aux = aux.getEsquerdo();
                }
                no.setElemento(sub.getElemento());
                this.remove(sub);
            }
        }
        return valor;
    }

    // Metodo que ira criar imprimir a arvore no terminal
    public String mostraArvore() {
        String arvoreCompleta = "";

        ArrayList<Node> nos = this.inOrder(this.raiz, false);

        int largura = nos.size();
        int altura = this.height(this.raiz);

        String[][] arvore = new String[altura + 1][largura];

        Node no = null;
        int l = 0;

        for (int i = 0; i < largura; i++) {
            no = nos.get(i);
            l = this.depth(no);

            arvore[l][i] = String.valueOf(no.getElemento());
        }

        for (int i = 0; i < altura + 1; i++) {
            for (int j = 0; j < largura; j++) {
                if (arvore[i][j] == null) {
                    arvoreCompleta += "  ";
                } else {

                    arvoreCompleta += arvore[i][j];
                }
            }
            arvoreCompleta += "\n";
        }
        return arvoreCompleta;
    }

}
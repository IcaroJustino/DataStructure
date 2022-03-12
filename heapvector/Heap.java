package heapvector;

public class Heap {
    private int Heap[];
    private int capacidade;
    private int posicao;

    public Heap() {
        posicao = 1;
        capacidade = 10;
        Heap = new int[capacidade];
    }

    public void insert(int valor) {
        if (posicao == capacidade) { // quando o array ficar cheio duplicar o tamanho
            Heap = new int[capacidade * 2];
            // to do transferir os items para um novo array
        } else {
            Heap[posicao++] = valor;
            upheap();
        }
    }

    public void upheap() {
        // organizar o heap
        int child = posicao - 1;
        int parent = child / 2;
        while (Heap[parent] > Heap[child] && parent > 0) {
            // switch
            int tmp = Heap[parent];
            Heap[parent] = Heap[child];
            Heap[child] = tmp;
            // test
            child = parent;
            parent = child / 2;
        }
    }

    public void downheap() {
        int parents = 1;
        int leftChildren = 2 * parents;
        int rigthChildren = 2 * parents + 1;
        while ((Heap[leftChildren] < Heap[parents] && leftChildren < posicao) ||
                (Heap[rigthChildren] < Heap[parents] && rigthChildren < posicao)) {

            if (Heap[parents] > Heap[rigthChildren] && Heap[rigthChildren] < Heap[leftChildren]) {
                int aux = Heap[parents];
                Heap[parents] = Heap[rigthChildren];
                Heap[rigthChildren] = aux;
                parents = rigthChildren;
                rigthChildren = 2 * parents + 1;
                leftChildren = 2 * parents;

            } else {
                int aux = Heap[parents];
                Heap[parents] = Heap[leftChildren];
                Heap[leftChildren] = aux;
                parents = leftChildren;
                leftChildren = 2 * parents;
                rigthChildren = 2 * parents + 1;

            }
        }

    }

    public void isEmpty() {
        if (Heap.length > 0) {
            System.out.println("não está vazio");
        } else {
            System.out.println("está vazio");
        }
    }

    public void size() {
        System.out.println(capacidade);
    }

    public void removemin() {
        Heap[1] = Heap[posicao--];
        downheap();
    }

    public void min() {
        System.out.println(Heap[1]);
    }

    public void printheap() {
        for (int i = 1; i < posicao; i++) {
            System.out.print(Heap[i] + ",");
        }
    }

    public void print() {
        System.out.print("{");
        printheap();
        System.out.print("}");
    }
}

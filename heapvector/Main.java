package heapvector;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(12);
        heap.insert(7);
        heap.insert(6);
        heap.insert(10);
        heap.insert(8);
        heap.insert(20);
        heap.insert(21);
        heap.insert(30);
        System.out.println("\n" + "root");
        heap.min();
        System.out.println("\n" + "tamanho");
        heap.size();
        System.out.println("\n" + "array sem remoção");
        heap.print();
        System.out.println("\n");
        heap.removemin();
        System.out.println("\n" + "array após remoção");
        heap.print();
        System.out.println("\n" + "array vazio?");
        heap.isEmpty();
    }
}

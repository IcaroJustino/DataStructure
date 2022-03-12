package arvorebinaria;

public class prova {
    public class FilaComPilhas { 
        private PilhaArray P1,P2; 
        public FilaComPilhas(){ 
        P1 =new PilhaArray(0,1); 
        P2 =new PilhaArray(0,1); 
        } 
         
        public void enqueue(Object o){ 
        //IMPLEMENTE ESSE MÉTODO 
            pilha1.push(item);

        } 
         
        public Object dequeue(){ 
        //IMPLEMENTE ESSE MÉTODO
        if (P2.isEmpty()) {
            while (P1.isEmpty()) {
               P2.push(P1.pop());
            }
        }
        return P2.pop();
        } 
         
        public void mostra(){ 
        P1.mostra(); 
        } 
       } 
    }
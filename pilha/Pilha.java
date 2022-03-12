package pilha;

import exceptions.PilhaVaziaException;

public class Pilha implements PilhaInterface{
	
	private int top;
	private int total;
	private Object[] pilha;
	
	public Pilha(int tam) {
		top = -1;
		total = 0;
		pilha = new Object[tam];
	}

	@Override
	public int size() {
		return total;
	}

	@Override
	public boolean isEmpty() {
		return (total == 0)?true:false;
	}

	@Override
	public Object top() throws PilhaVaziaException {
		if(this.isEmpty()) throw new PilhaVaziaException("pilha vazia");
		return pilha[top];
	}

	@Override
	public void push(Object o) {
		if(this.size() == pilha.length-1) {
			Object[] aux = new Object[pilha.length*2];
			for(int i = 0; i < pilha.length; i++)
				aux[i] = pilha[i];
			pilha = aux;
		}
		pilha[++top] = o;
		total++;
	}

	@Override
	public Object pop() throws PilhaVaziaException {
		if(this.isEmpty()) throw new PilhaVaziaException("pilha vazia");
		total--;
		return pilha[--top];
	}

	@Override
	public String mostrarPilha() {
		String p = "";
		for(int i = 0; i <= top; i++) {
			p += pilha[i] + " "; 
		}
		p += "|qtd: "+this.size() + "|";
		return p;
	}
	

}

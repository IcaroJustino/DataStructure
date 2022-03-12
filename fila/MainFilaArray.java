package fila;

import exceptions.FilaVaziaException;

public class MainFilaArray {

	public static void main(String[] args) throws FilaVaziaException {
	
		FilaArray fila = new FilaArray(4);
		
		fila.enfileirar(99);
		fila.enfileirar(77);
		fila.enfileirar(44);
		//System.out.println(fila.realSize());
		fila.enfileirar(33);
		System.out.println(fila.size());
		System.out.println(fila.inicio());
		System.out.println(fila.mostrarFila());
		fila.enfileirar(66);
		System.out.println(fila.mostrarFila());
		//System.out.println(fila.realSize());
		//System.out.println(fila.size());
		fila.desenfileirar();
		fila.desenfileirar();
		System.out.println(fila.mostrarFila());
		System.out.println(fila.inicio());
	}

}

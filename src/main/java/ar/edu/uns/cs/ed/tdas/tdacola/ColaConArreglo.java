package ar.edu.uns.cs.ed.tdas.tdacola;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;

public class ColaConArreglo<E> implements Queue<E>{
	
	protected E[] arreglo;
	protected int frente;
	protected int fondo;
	protected int cantidad;
	
	@SuppressWarnings("unchecked")
	public ColaConArreglo() {
		arreglo= (E[]) new Object [10]; 
		frente=0;
		fondo=0;
		cantidad=0;
	}
        @Override
	public int size() {
		return cantidad;
	}

	@Override
	public boolean isEmpty() {
		return cantidad==0;
	}

	@Override
	public E front() {
		if(cantidad==0)
			throw new EmptyQueueException("");
		return arreglo[frente];
	}

	@Override
	public void enqueue(E element) {
		if(cantidad==arreglo.length) {
			agrandarArreglo();
		}
		arreglo[fondo]=element;
		fondo++;
		cantidad++;
	}
	
	@SuppressWarnings("unchecked")
	public void agrandarArreglo() {
		int nuevoTamano= arreglo.length*2;
		E[] nuevo= (E []) new Object [nuevoTamano];
		
		for(int i=0; i<cantidad;i++)
			nuevo[i]=arreglo[i];
		
		arreglo=nuevo;
	}
	
        @Override
	public E dequeue() {
		if(cantidad==0) {
			throw new EmptyQueueException("no se puede eliminar de una cola vacia");
		}	
		
		E toRet=arreglo[frente];
		arreglo[frente]=null;
		frente++;
		cantidad--;
		
		/* desde afuera for(int i=0; i<cantidad;i++) {
			arreglo[i]=arreglo[i+1];
		}*/
		
	return toRet;
	}

	
}


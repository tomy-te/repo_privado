package ar.edu.uns.cs.ed.tdas.tdalista;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
    	
	protected int cantidad;
	protected DNode<E> lista;
	protected DNode<E> ultimo;
	
	public ListaDoblementeEnlazada() {
		this.cantidad = 0;
		this.lista = new DNode<>(null);
		this.ultimo = new DNode<>(null);
		this.lista.setSiguiente(this.ultimo);
		this.ultimo.setAnterior(this.lista);
		
	}

	@Override
	public int size() {
		return this.cantidad;
	}

	@Override
	public boolean isEmpty() {
		return this.cantidad == 0;
	}

	@Override
	public Position<E> first() {
		if(this.isEmpty()) {
			throw new EmptyListException("Se intento first de lista vacia");
		}
		return this.lista.getSiguiente();
	}

	@Override
	public Position<E> last() {
		if(this.isEmpty()) {
			throw new EmptyListException("Se intento first de lista vacia");
		}
		return this.ultimo.getAnterior();
	}

	@Override
	public Position<E> next(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> prev(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(E element) {
		agregarEnElMedio(this.lista, this.lista.getSiguiente(), element);
	}

	@Override
	public void addLast(E element) {
		agregarEnElMedio(this.ultimo.getAnterior(), this.ultimo, element);
	}

	@Override
	public void addAfter(Position<E> p, E element) {
		if(this.isEmpty()) {throw new InvalidPositionException(null);}

		DNode<E> anterior = checkPosition(p);
		agregarEnElMedio(anterior, anterior.getSiguiente(), element);
	}

	@Override
	public void addBefore(Position<E> p, E element) {
		if(this.isEmpty()) {throw new InvalidPositionException(null);}

		DNode<E> siguiente = checkPosition(p);
		agregarEnElMedio(siguiente.getAnterior(), siguiente, element);
		
	}

	@Override
	public E remove(Position<E> p) {
		if(this.isEmpty()) {throw new InvalidPositionException(null);}
		
		return null;
	}

	@Override
	public E set(Position<E> p, E element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void agregarEnElMedio(DNode<E> anterior, DNode<E> siguiente, E elemento) {
		DNode<E> nuevoNodo = new DNode<>(elemento);
		nuevoNodo.setSiguiente(siguiente);
		nuevoNodo.getSiguiente().setAnterior(nuevoNodo);
		anterior.setSiguiente(nuevoNodo);
		nuevoNodo.setAnterior(anterior);
		this.cantidad++;
	}
	
	private DNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
		DNode<E> n;
		if( p == null ) {
			throw new InvalidPositionException("Posición Nula. Posición Inválida");
		}
		if(this.isEmpty()) {
			throw new EmptyListException("No puede operar sobre una lista vacía");
		}
		try {
		     n= (DNode<E>) p;
		} catch( ClassCastException e ) { 
		throw new InvalidPositionException("Posicion invalida");  }
		return n;
		}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'positions'");
	}

}



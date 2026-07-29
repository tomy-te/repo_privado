package ar.edu.uns.cs.ed.tdas.tdagrafo;

import ar.edu.uns.cs.ed.tdas.Position;

public class Arco<E, V> implements Edge<E>{

	protected E element;
	protected Position<Arco<E,V>> posicion;
	protected Vertice<V, E> adyacente1;
	protected Vertice<V, E> adyacente2;
	
	public Arco(E e, Vertice<V, E> v1, Vertice<V, E> v2) {
		this.element = e;
		this.adyacente1 = v1;
		this.adyacente2 = v2;
		v1.agregarAdyacente(this);
		v2.agregarAdyacente(this);
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return this.element;
	}

	public void setPositionInLista(Position<Arco<E, V>> last) {
		this.posicion = last;
		
	}

}

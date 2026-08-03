package ar.edu.uns.cs.ed.tdas.tdagrafo;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Vertice<V, E> implements Vertex<V> {
    protected V element;
	protected Position<Vertice<V, E>> posicion;
	protected PositionList<Edge<E>> listaAdyacencia;
	
	public Vertice( V elemento ) {
		this.element = elemento;
		this.listaAdyacencia = new ListaDoblementeEnlazada<>();
	}
	
	@Override
	public V element() {
		return this.element;
	}

	public void setPositionInLista(Position<Vertice<V, E>> last) {
		this.posicion = last;
	}

	public void agregarAdyacente(Arco<E, V> arco) {
		this.listaAdyacencia.addLast(arco);
		//arco.agregarPosicionAdyacente(this, this.listaAdyacencia.last());
	}
}

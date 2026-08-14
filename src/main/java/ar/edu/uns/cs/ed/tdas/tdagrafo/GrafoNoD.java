package ar.edu.uns.cs.ed.tdas.tdagrafo;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class GrafoNoD<V, E> implements Graph<V, E>{
	
	protected PositionList<Vertice<V,E>> listadeVertices;
	protected PositionList<Arco<E,V>> listadeArcos;
	
	public GrafoNoD() {
		this.listadeArcos = new ListaDoblementeEnlazada<>();
		this.listadeVertices = new ListaDoblementeEnlazada<>();
	}
	
	
	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vertex<V>[] endvertices(Edge<E> e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public V replace(Vertex<V> v, V x) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vertex<V> insertVertex(V x) {
		Vertice<V, E> v = new Vertice<>(x);
		this.listadeVertices.addLast(v);
		v.setPositionInLista(this.listadeVertices.last());
		return v;
	}
	@Override
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) {
		Vertice<V, E> v1 = checkVertex(v);
		Vertice<V, E> v2 = checkVertex(w);
		Arco<E, V> arco = new Arco<>(e, v1, v2);
		this.listadeArcos.addLast(arco);
		arco.setPositionInLista(this.listadeArcos.last());
		return arco;
	}
	
	@SuppressWarnings("unchecked")
	private Vertice<V, E> checkVertex(Vertex<V> v) {
		Vertice<V, E> resultado = null;
		if( this.listadeVertices.size() == 0) { throw new InvalidPositionException(null); }
		try {
			resultado = (Vertice<V, E>)v;
		} catch( ClassCastException e ) {
			throw new InvalidPositionException(null);
		}	
		return resultado;
	}


	@Override
	public V removeVertex(Vertex<V> v) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E removeEdge(Edge<E> e) {
		// TODO Auto-generated method stub
		return null;
	}


    @Override
    public E replace(Edge<E> e, E x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

}
    


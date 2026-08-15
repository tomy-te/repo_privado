package ar.edu.uns.cs.ed.tdas.ejercicios.ejecicios_LM_DFS;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.GraphD;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;


public class Ejercicio_LM_4<V, E> {
    public PositionList<Vertex<V>> hojasDigrafo(GraphD<V, E> g){
        if(g == null){
            throw new InvalidOperationException("El grafo es nulo");
        }

        PositionList<Vertex<V>> lista = new ListaDoblementeEnlazada<>();

        for(Vertex<V> v : g.vertices()){
            Iterable<Edge<E>> e = g.incidentEdges(v);
            if(!e.iterator().hasNext()){
                lista.addLast(v);
            }
        }
        return lista;
    }
}

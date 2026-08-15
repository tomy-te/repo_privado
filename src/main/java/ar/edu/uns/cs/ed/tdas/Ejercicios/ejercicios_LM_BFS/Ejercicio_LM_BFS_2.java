package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_BFS_2<V, E> {
    public PositionList<Vertex<V>> listaAlcanzables(Graph<V, E> g, Vertex<V> v){
        if(v == null){
            throw new InvalidVertexException("el vertice es nulo");
        }
        PositionList<Vertex<V>> lista = new ListaDoblementeEnlazada<>();
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        Queue<Vertex<V>> cola = new ColaConArreglo<>();

        marca.put(v, true);
        cola.enqueue(v);
        lista.addLast(v);
        while(!cola.isEmpty()){
            Vertex<V> ver = cola.dequeue();

            for(Edge<E> e : g.incidentEdges(ver)){
                Vertex<V> vecino = g.opposite(ver, e);

                if(marca.get(vecino) == null){
                    marca.put(vecino, true);
                    lista.addLast(vecino);
                    cola.enqueue(vecino);
                }
            }
        }
        return lista;
    }
}

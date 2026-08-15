package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;

public class Ejercicio_LM_1<V, E> {
    public int caminoMasCorto(Graph<V, E> g, Vertex<V> v, Vertex<V> w){
        if(v == null || w == null){
            throw new InvalidVertexException("vertice nulo");
        }
        Map<Vertex<V>, Integer> marca = new MapeoConLista<>();
        Queue<Vertex<V>> cola = new ColaConArreglo<>();

        cola.enqueue(v);
        marca.put(v, 0);
        int cont = 0;

        while(cola.isEmpty()){
            Vertex<V> vertice = cola.dequeue();
            
            if(vertice.equals(w)){
                cont = marca.get(v);
            }
            for(Edge<E> e : g.incidentEdges(vertice)){
                Vertex<V> vecino = g.opposite(vertice, e);
                if(marca.get(vecino) == null){
                    marca.put(vecino, marca.get(vecino) + 1);
                    cola.enqueue(vecino);
                }
            }
        }
        return cont;
    }
}

package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_2<V, E> {
    public int caminoMasCorto(Graph<V, E> g, Vertex<V> v, Vertex<V> d){
        int cont = 0;
        if(v.equals(d)){
            return cont;
        }
        else{
            Map<Vertex<V>, Integer> marca = new MapeoConLista<>();

            cont = BFS(g, v, d, marca);
        }
        return cont;
    }


    private int BFS(Graph<V, E> g, Vertex<V> v, Vertex<V> d, Map<Vertex<V>, Integer> marca) {
        Queue<Vertex<V>> cola = new ColaConArreglo<>();
        cola.enqueue(v);
        marca.put(v, 0);
        while(!cola.isEmpty()){
            Vertex<V> actual = cola.dequeue();
            int dist = marca.get(actual);
            if(actual.equals(d)){
                return dist;
            }
            for(Edge<E> e : g.incidentEdges(actual)){
                Vertex<V> vecino = g.opposite(actual, e);
                if(marca.get(vecino) == null){
                    marca.put(vecino, dist + 1);
                    cola.enqueue(vecino);
                }
            }
        }
        return -1; //no hay camino entre v y d
    }
}

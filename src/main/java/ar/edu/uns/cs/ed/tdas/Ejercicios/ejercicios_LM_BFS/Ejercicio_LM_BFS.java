package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_BFS<V, E> {
    public boolean esAlcanzable(Graph<V, E> g, Vertex<V> v, Vertex<V> w){
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        Queue<Vertex<V>> cola = new ColaConArreglo<>();

        marca.put(v, true);
        cola.enqueue(v);
        boolean es = false;
        while(!cola.isEmpty()){
            Vertex<V> ver = cola.dequeue();

            if(ver.equals(w)){
                es = true;
            }
            for(Edge<E> e : g.incidentEdges(ver)){
                Vertex<V> vecino = g.opposite(ver, e);
                if(marca.get(vecino) == null){
                    marca.put(vecino, true);
                    cola.enqueue(vecino);
                }
            }
        }
        return es;
    }
}

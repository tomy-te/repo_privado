package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_BFS_3<V, E> {
    public Map<Vertex<V>, Integer> mapeoNiveles(Graph<V, E> g, Vertex<V> v){
        Map<Vertex<V>, Integer> mapa = new MapeoConLista<>();
        Queue<Vertex<V>> cola = new ColaConArreglo<>();

        cola.enqueue(v);
        mapa.put(v, 0);

        while(!cola.isEmpty()){
            Vertex<V> ver = cola.dequeue();

            for(Edge<E> e : g.incidentEdges(ver)){
                Vertex<V> vecino = g.opposite(ver, e);

                if(mapa.get(vecino) == null){
                    mapa.put(vecino, mapa.get(vecino) + 1);
                    cola.enqueue(vecino);
                }
            }
        }
        return mapa;
    }
}

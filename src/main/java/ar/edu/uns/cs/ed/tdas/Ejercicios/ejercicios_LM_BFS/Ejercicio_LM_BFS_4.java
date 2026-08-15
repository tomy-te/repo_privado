package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_BFS_4<V, E> {
    public boolean esConexoBFS(Graph<V, E> g){
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        int cont = 0;

        for(Vertex<V> v : g.vertices()){
            if(marca.get(v) == null){
                marca.put(v, true);
                cont ++;
                BFS(g, v, marca);
            }
        }
        if(cont == 1){
            return true;
        }
        
        return false;
    }

    private void BFS(Graph<V, E> g, Vertex<V> v, Map<Vertex<V>, Boolean> marca){
        Queue<Vertex<V>> cola = new ColaConArreglo<>();
        cola.enqueue(v);

        while(!cola.isEmpty()){
            Vertex<V> ver = cola.dequeue();

            for(Edge<E> e : g.incidentEdges(ver)){
                Vertex<V> vecino = g.opposite(ver, e);

                if(marca.get(vecino) == null){
                    marca.put(vecino, true);
                    cola.enqueue(vecino);
                }
            }
        }
    }
}

package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_5<V, E> {
    public boolean esBipartito(Graph<V, E> g){
       
        Map<Vertex<V>, Integer> marca = new MapeoConLista<>();

        for(Vertex<V> ver : g.vertices()){
            if(marca.get(ver) == null){
                if(!BFS(g, ver, marca)){
                    return false;
                }
            }
        }
        return true;
    }



    private boolean BFS(Graph<V, E> g, Vertex<V> v, Map<Vertex<V>, Integer> marca){
        Queue<Vertex<V>> cola = new ColaConArreglo<>();

        marca.put(v, 0);
        cola.enqueue(v);

        while(!cola.isEmpty()){
            Vertex<V> u = cola.dequeue();

            int nivel = marca.get(u);

            for(Edge<E> e : g.incidentEdges(v)){
                Vertex<V> vecino = g.opposite(u, e);

                if(marca.get(vecino) == null){
                    marca.put(vecino, nivel + 1);
                    cola.enqueue(vecino);
                }

                else{
                    if(marca.get(vecino) == nivel){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

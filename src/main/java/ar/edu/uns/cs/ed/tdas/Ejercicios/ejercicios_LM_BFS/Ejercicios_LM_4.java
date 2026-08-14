package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_BFS;

import ar.edu.uns.cs.ed.tdas.tdacola.ColaConArreglo;
import ar.edu.uns.cs.ed.tdas.tdacola.Queue;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicios_LM_4<V, E> {
    public PositionList<Vertex<V>> distanciaK(Graph<V, E> g, Vertex<V> v, int k) {
        PositionList<Vertex<V>> lista = new ListaDoblementeEnlazada<>();

        if(k == 0){
            lista.addLast(v);
        }
        else{
            Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();

            Queue<Vertex<V>> cola = new ColaConArreglo<>();

            cola.enqueue(v);
            marca.put(v, true);
            int nivel = 0;

            while(!cola.isEmpty() && nivel < k){
                nivel ++;
                Vertex<V> ver = cola.dequeue();

                for(Edge<E> a : g.incidentEdges(ver)){
                    Vertex<V> vecino = g.opposite(ver, a);

                    if(!marca.get(vecino)){
                        marca.put(vecino, true);
                        cola.enqueue(vecino);
                    }
                }
            }

            if(nivel == k){
                while(!cola.isEmpty()){
                    lista.addLast(cola.dequeue());
                }
            }
        }
        return lista;
    }

}

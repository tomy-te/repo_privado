package ar.edu.uns.cs.ed.tdas.ejercicios.ejecicios_LM_DFS;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_7<V, E> {
    public int cantConexas(Graph<V, E> g){
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        int cont = 0;
        for(Vertex<V> v : g.vertices()){
            if(!marca.get(v)){
                cont += DFS(g, v, marca);
            }
        }
        return cont;
    }

    private int DFS(Graph<V, E> g, Vertex<V> v, Map<Vertex<V>, Boolean> marca){
        marca.put(v, true);
        int cont = 1;

        for(Edge<E> e : g.incidentEdges(v)){
            Vertex<V> vecino = g.opposite(v, e);
            if(marca.get(vecino) == null){
                cont += DFS(g, vecino, marca);
            }
        }
        return cont;
    }
}

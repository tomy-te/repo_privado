package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_1<V, E> {
    public int contarConexos(Graph<V, E> g){
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        int cont = 0;

        for(Vertex<V> v : g.vertices()){
            if(marca.get(v) == null){
                cont++;

                DFS(g, v, marca);
            }            
        }
        return cont;
    }

    private void DFS(Graph<V, E> g, Vertex<V> v, Map<Vertex<V>, Boolean> marca){
        marca.put(v, true);

        for(Edge<E> arco : g.incidentEdges(v)){
            Vertex<V> vecino = g.opposite(v, arco);

            if(marca.get(vecino) == null){
                DFS(g, vecino, marca);
            }
        }
    }
}

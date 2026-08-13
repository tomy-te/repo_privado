package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;
import java.util.Iterator;

public class Ejercicio_1<V, E> {
    public boolean esConexo(Graph<V, E> g){
        boolean conexo = true;
        Map<Vertex<V>, Boolean> visitado = new MapeoConLista<>();
        for(Vertex<V> v : g.vertices()){
            visitado.put(v, false);
        }
        Vertex<V> ver = g.vertices().iterator().next();
        DFS(g, ver, visitado);
        
        //testeo de conexidad
        Iterator<Vertex<V>> ite = g.vertices().iterator();
        while(ite.hasNext() && conexo){
            if(!visitado.get(ite.next())){
                conexo = false;
            }
        }
        return conexo;
    }

    private void DFS(Graph<V, E> g, Vertex<V> v, Map<Vertex<V>, Boolean> marca){
        marca.put(v, true);
        for(Edge<E> e : g.incidentEdges(v)){
            Vertex<V> w = g.opposite(v, e);
            if(!marca.get(w)){
                DFS(g, w, marca);
            }
        }
    }
}

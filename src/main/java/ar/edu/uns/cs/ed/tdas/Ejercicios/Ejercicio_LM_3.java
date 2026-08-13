package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.excepciones.InvalidVertexException;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_3<V, E> {
    public boolean existeCamino(Graph<V, E> g, Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
        if(v == null || w == null){
            throw new InvalidVertexException("vertice/s nulos");
        }
        else{
            Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
            for(Vertex<V> vertice : g.vertices()){
                marca.put(vertice, false);
            }
            if(DFS(g, v, w, marca)){
                return true;
            }
        }
        return false;
    }

    private boolean DFS(Graph<V, E> g, Vertex<V> v, Vertex<V> w, Map<Vertex<V>, Boolean> marca){
        marca.put(v, true);

        if(v.equals(w)){
            return true;
        }
        else{
            for(Edge<E> arco : g.incidentEdges(v)){
                Vertex<V> vecino = g.opposite(v, arco);

                if(!marca.get(vecino)){
                    if(DFS(g, vecino, w, marca)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

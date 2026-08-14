package ar.edu.uns.cs.ed.tdas.ejercicios.ejecicios_LM_DFS;

import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_2<V, E> {
    public boolean ciclosSimples(Graph<V, E> g){
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();

        for(Vertex<V> v : g.vertices()){
            if(marca.get(v) == null){
                if(DFS(g, v, null, marca)){
                    return true;
                }
            }            
        }
        return false;
    }

    private boolean DFS(Graph<V, E> g, Vertex<V> v, Vertex<V> padre, Map<Vertex<V>, Boolean> marca){
        marca.put(v, true);

        for(Edge<E> arco : g.incidentEdges(v)){
            Vertex<V> vecino = g.opposite(v, arco);

            if(marca.get(vecino) != null){
                if(vecino != padre){
                    return true;
                }
                
            }
            else{
                if(DFS(g, vecino, v, marca)){
                    return true;
                }
            }
        }
        return false;
    } 
}

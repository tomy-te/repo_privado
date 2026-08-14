package ar.edu.uns.cs.ed.tdas.ejercicios.ejecicios_LM_DFS;


import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_6_MAL<V> {
    public int costoTotal(Graph<V, Integer> g, PositionList<Vertex<V>> lista){
        if(lista.size() <= 2){
            return 0;
        }
        Position<Vertex<V>> pos = lista.first();
        Map<Vertex<V>, Boolean> marca = new MapeoConLista<>();
        for(Vertex<V> v : g.vertices()){
            marca.put(v, false);
        }
        int cont = DFS(g, lista, marca, pos);
        
        return cont;
    }

    private int DFS(Graph<V, Integer> g, PositionList<Vertex<V>> lista, Map<Vertex<V>, Boolean> marca, Position<Vertex<V>> pos){
        marca.put(pos.element(), true);
        int cont = 1;
        if(pos.element().equals(lista.last())){
            cont = cont + 1;
        }
        
        for (Edge<Integer> e : g.incidentEdges(pos.element())){
            Vertex<V> vecino = g.opposite(lista.next(pos).element(), e);
            if(!marca.get(vecino)){
                cont += DFS(g, lista, marca, pos);
            }
        }
        return cont;
    }
}

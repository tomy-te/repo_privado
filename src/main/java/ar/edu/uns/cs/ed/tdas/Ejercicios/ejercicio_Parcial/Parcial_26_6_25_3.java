package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicio_Parcial;


import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Edge;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Graph;
import ar.edu.uns.cs.ed.tdas.tdagrafo.Vertex;

public class Parcial_26_6_25_3{
    @SuppressWarnings("unused")
    public Map<Vertex<Character>, Integer> adyacentes(Graph<Character, Integer> g){
        Map<Vertex<Character>, Integer> mapa = new MapeoConLista<>();

        for(Vertex<Character> v : g.vertices()){
            mapa.put(v, 0);
            for(Edge<Integer> e : g.incidentEdges(v)){
                mapa.put(v, mapa.get(v) + 1);
            }
        }
        return mapa;
    }
}
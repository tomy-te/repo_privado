package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_2 {
    public Map<Character, Integer> cantidadRepeticiones(Tree<Character> t){
        Map<Character, Integer> mapa = new MapeoConLista<>();
        Position<Character> raiz = t.root();
        if(!t.isEmpty()){
            preOrden(t, raiz, mapa);
        }
        return mapa;
    }

    private void preOrden(Tree<Character> t, Position<Character> raiz, Map<Character, Integer> mapa){
        Character e = raiz.element();
        Integer cant = mapa.get(e);
        if (cant == null){
            mapa.put(e, 1);
        }
        else{
            mapa.put(e, cant + 1);
        }
        for(Position<Character> hijo : t.children(raiz)){
            preOrden(t, hijo, mapa);
        }
    }
}

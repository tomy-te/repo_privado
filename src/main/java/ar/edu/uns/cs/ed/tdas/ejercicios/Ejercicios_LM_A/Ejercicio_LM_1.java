package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_LM_A;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;

public class Ejercicio_LM_1 {
    public Map<Character, Integer> conteoCaracteres(Tree<Character> a){
        Map<Character, Integer> mapa = new MapeoConLista<>();
        
        preOrden(a, a.root(), mapa);

        return mapa;
    }

    @SuppressWarnings("null")
    private void preOrden(Tree<Character> a, Position<Character> r, Map<Character, Integer> mapa){
        if(r == null){
            mapa.put(r.element(), 1);
        }
        else{
            mapa.put(r.element(), mapa.get(r.element()) + 1);
        }

        for(Position<Character> pos : a.children(r)){
            preOrden(a, pos, mapa);
        }

    }
}

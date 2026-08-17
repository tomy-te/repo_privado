package ar.edu.uns.cs.ed.tdas.ejercicios.ejercicios_LM_A;

import ar.edu.uns.cs.ed.tdas.tdamapeo.Map;
import ar.edu.uns.cs.ed.tdas.tdamapeo.MapeoConLista;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.*;;

public class Ejercicio_LM_4 {
    public Map<Character, Integer> contarFrecuencia(Tree<Character> a){
        Map<Character, Integer> mapa = new MapeoConLista<>();
        
        preOrden(a, a.root(), mapa);
        return mapa;
    }

    private void preOrden(Tree<Character> a, Position<Character> p, Map<Character, Integer> mapa){

        if(mapa.get(p.element()) == null){
            mapa.put(p.element(), 1);
        }
        else{
            mapa.put(p.element(), mapa.get(p.element()) + 1);
        }

        for(Position<Character> pos : a.children(p)){
            preOrden(a, pos, mapa);
        }
    }
}

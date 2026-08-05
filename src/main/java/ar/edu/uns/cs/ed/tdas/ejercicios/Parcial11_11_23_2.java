package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

public class Parcial11_11_23_2 {
    public void insertarANivel(Tree<Character> a, int x, char c){
         
        if(!a.isEmpty()){
            recorridoPorNiveles(a, a.root(), 0, x, c);
        }
    }

    private void recorridoPorNiveles(Tree<Character> a, Position<Character> p, int nivel, int x, char c){
        if(nivel == x){
            if(a.isExternal(p)){
                a.addLastChild(p, c);
            }
        }
        else{
            if(nivel < x){
                for(Position<Character> pos : a.children(p)){
                    recorridoPorNiveles(a, pos, nivel + 1, x, c);
                }    
            }
        }
    }
}

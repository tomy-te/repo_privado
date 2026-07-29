package ar.edu.uns.cs.ed.tdas.ejercicios;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;
import java.util.Iterator;

public class Ejercicio_5 {
    public boolean pertenece(Tree<Integer> t, int x){
        boolean pertenece = false;
        if(t.isEmpty()){
            return pertenece;
        }
        else{
            Iterator<Integer> ite = t.iterator();
            while(ite.hasNext() && !pertenece){
                if(ite.next() == x){
                    pertenece = true;
                }
            }
        }
        return pertenece;
    }
}

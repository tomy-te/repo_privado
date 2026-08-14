package ar.edu.uns.cs.ed.tdas.ejercicios.Ejercicios_LM_A;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.tdaarbol.Tree;

public class Ejercicio_LM_2 {
    public boolean existeN(Tree<Integer> a, int n){
        boolean pertenece = false;
        if(a.isEmpty()){
            return pertenece;
        }
        else{
            Iterator<Integer> ite = a.iterator();

            while(ite.hasNext() && !pertenece){
                if(ite.next().equals(n)){
                    pertenece = true;
                }
            }
        }
        return pertenece;
    }
}

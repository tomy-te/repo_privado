package ar.edu.uns.cs.ed.tdas;

public class Entrada<K, V> implements Entry<K,V> {
    private K key;
    private V value;
    
    public Entrada(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }
    
    public void setValue(V value) {
        this.value = value;
    }
    
}

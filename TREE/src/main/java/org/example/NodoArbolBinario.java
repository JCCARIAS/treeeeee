package  org.example;

public class NodoArbolBinario {
    private int valor;
    private NodoArbolBinario izquierdo;
    private NodoArbolBinario derecho;

    public NodoArbolBinario(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoArbolBinario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbolBinario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbolBinario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbolBinario derecho) {
        this.derecho = derecho;
    }

    public int profundidad() {
        int profIzq = (izquierdo == null) ? 0 : izquierdo.profundidad();
        int profDer = (derecho == null) ? 0 : derecho.profundidad();
        return 1 + Math.max(profIzq, profDer);
    }
}

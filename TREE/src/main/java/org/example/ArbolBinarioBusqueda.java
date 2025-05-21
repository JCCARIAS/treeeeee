package org.example;
public class ArbolBinarioBusqueda {
    private NodoArbolBinario raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbolBinario insertarRec(NodoArbolBinario nodo, int valor) {
        if (nodo == null) {
            return new NodoArbolBinario(valor);
        }

        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(insertarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(insertarRec(nodo.getDerecho(), valor));
        }

        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoArbolBinario nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.getValor()) {
            return true;
        }

        return valor < nodo.getValor()
                ? buscarRec(nodo.getIzquierdo(), valor)
                : buscarRec(nodo.getDerecho(), valor);
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoArbolBinario eliminarRec(NodoArbolBinario nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.getValor()) {
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), valor));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            nodo.setValor(encontrarMinimo(nodo.getDerecho()));
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), nodo.getValor()));
        }

        return nodo;
    }

    private int encontrarMinimo(NodoArbolBinario nodo) {
        int minimo = nodo.getValor();
        while (nodo.getIzquierdo() != null) {
            minimo = nodo.getIzquierdo().getValor();
            nodo = nodo.getIzquierdo();
        }
        return minimo;
    }

    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void inordenRec(NodoArbolBinario nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo(), sb);
            sb.append(nodo.getValor()).append(" ");
            inordenRec(nodo.getDerecho(), sb);
        }
    }

    public int profundidad() {
        if (raiz == null) {
            return 0;
        }
        return raiz.profundidad();
    }
}
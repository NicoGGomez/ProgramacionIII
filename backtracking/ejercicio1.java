// Ejercicio 1

// Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada puerta es un arco dirigido hacia otra habitación.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ejercicio1<T> {

    public List<Vertice<T>> obtenerCaminoMasLargo(Vertice<T> entrada, Vertice<T> salida){

        ArrayList<Vertice<T>> mejorCamino = new ArrayList<>();
        ArrayList<Vertice<T>> caminoActual = new ArrayList<>();
        HashSet<Vertice<T>> visitados = new HashSet<>();

        backtracking(entrada, salida, mejorCamino, caminoActual, visitados);

        return mejorCamino;
    }

    public void backtracking(
            Vertice<T> actual,
            Vertice<T> salida,
            ArrayList<Vertice<T>> mejorCamino,
            ArrayList<Vertice<T>> caminoActual,
            HashSet<Vertice<T>> visitados){

        visitados.add(actual);
        caminoActual.add(actual);

        if(actual.equals(salida)){

            if(caminoActual.size() > mejorCamino.size()){
                mejorCamino.clear();
                mejorCamino.addAll(caminoActual);
            }

        } else {

            for(Vertice<T> vecino : g.obtenerAdyacente(actual)){

                if(!visitados.contains(vecino)){
                    backtracking(vecino, salida, mejorCamino, caminoActual, visitados);
                }

            }

        }

        visitados.remove(actual);
        caminoActual.remove(caminoActual.size()-1);
    }


}
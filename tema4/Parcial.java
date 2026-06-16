package tema4;

import java.util.Iterator;
import tema4.GrafoDirigido;
import tema4.Vertice;

public class Parcial {

    public void mergeSort(int[] arr, int ini, int fin){
        if(ini >= fin){
            return;
        }
    
        int medio = (ini + fin) / 2;

        mergeSort(arr, ini, medio);
        mergeSort(arr, medio+1, fin);

        merge(arr, ini, medio, fin);
    }

    public void merge(int[] arr, int ini, int medio, int fin){
        int[] aux = new int[fin - ini +1];

        if (arr[ini] > arr[fin]){
            aux[ini++] = arr[fin++];
        }

    }

    public <T> boolean DFSrun(GrafoDirigido<T> g, Vertice<T> v, Vertice<T> w){
    
        Iterator<T> it = g.obtenerVertices();

        while(it.hasNext()){
            Vertice<T> ver = g.obtenerVertice(it.next());
            ver.setColor('B');
        }

        return DFSvisit(g, v, w);;
    }

    public <T> boolean DFSvisit(GrafoDirigido<T> g, Vertice<T> ini, Vertice<T> fin){

        if (ini.equals(fin)) {
            return true;
        }

        ini.setColor('R');

        Iterator<Integer> itAdy = g.obtenerAdyacentes(ini.getId());

        while(itAdy.hasNext()){
            
            Vertice<Integer> vert = g.obtenerVertice(itAdy.next());

            if(vert.getColor() == 'B'){
                if(DFSvisit(g, vert, fin)){
                    return true;
                } 
            }
        }

        ini.setColor('N');

        return false;

    }


}


// public tipoRetorno dfsRun(GrafoDirigido<Integer> g) {

//     Iterator<Integer> it = g.obtenerVertices();

//     while (it.hasNext()) {
//         Vertice<Integer> v = g.obtenerVertice(it.next());
//         v.setColor('B'); // Blanco = no visitado
//     }

//     it = g.obtenerVertices();

//     while (it.hasNext()) {
//         Vertice<Integer> v = g.obtenerVertice(it.next());
//         if(v.getColor() == 'B'){
//          dfsVisit(g, v)
//         }
//     }

//     return tipoRetorno;
// }

// private boolean dfsVisit(GrafoDirigido<Integer> g, Vertice<Integer> v) {

//     // Caso base
//     if (actual.equals(destino)) {
//         return true;
//     }

//     actual.setColor('G');

//     Iterator<Integer> ady = g.obtenerAdyacentes(actual.getId());

//     while (ady.hasNext()) {

//         Vertice<Integer> vecino = g.obtenerVertice(ady.next());

//         if (vecino.getColor() == 'B') {

//             if (dfsVisit(g, vecino))
//         }
//     }

//     actual.setColor('N'); // Negro = procesado

//     return tipoRetorno;
// }
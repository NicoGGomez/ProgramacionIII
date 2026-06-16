/*

Ejercicio 4

Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma.

{1,2,5,3,4,1}

*/

import java.util.ArrayList;

public class ejercicio4 {

    private boolean obtCombinaciones(ArrayList<Integer> enterosN, int pos, int suma, int objetivo, ArrayList<Integer> subconjunto){

        if (suma == objetivo)
            return true;

        if (suma > objetivo)
            return false;

        for(int i = pos; i < enterosN.size(); i++){

            subconjunto.add(enterosN.get(i));

            if (obtCombinaciones(enterosN, i + 1, suma + enterosN.get(i), objetivo, subconjunto)) {
                return true;
            }

            subconjunto.remove(subconjunto.size() - 1);

        }

        return false;

    }
    
}

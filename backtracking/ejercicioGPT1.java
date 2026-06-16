/*

1. Subconjunto suma M

Dado un conjunto de enteros positivos y un valor M, determinar si existe un subconjunto cuya suma sea exactamente M.

*/

import java.util.ArrayList;

public class ejercicioGPT1 {

    public boolean existeConjunto(ArrayList<Integer> numeros,int pos, int m, int suma){

        if (suma == m) {
            return true;
        }

        for(int i = pos; i < numeros.size(); i++){

            if (suma + numeros.get(i) <= m) {

                if (existeConjunto(numeros, i + 1, m, suma + numeros.get(i)))
                    return true;

            }

        }

        return false;

    }
    
}

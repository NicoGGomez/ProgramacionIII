/*

4. Partición de conjunto

Dado un conjunto de enteros, determinar si puede dividirse en dos subconjuntos con igual suma.

*/

import java.util.ArrayList;

public class ejercicioGPT4 {

    public boolean puedeDividirse(ArrayList<Integer> numeros){

        ArrayList<Integer> retorno = new ArrayList<>();

        int total = 0;

        for(Integer numero : numeros)
            total += numero;

        if(total % 2 != 0)
            return false;

        return puedeDividirse(numeros, retorno, 0, 0, total/2);

    }

    public boolean puedeDividirse(ArrayList<Integer> numeros, ArrayList<Integer> subConjunto, int pos, int suma, int objetivo){

        if (suma > objetivo) 
            return false;

        if (suma == objetivo) {
            return true;
        }

        for(int i = pos; i < numeros.size(); i++){

            subConjunto.add(numeros.get(i));

            if(puedeDividirse(numeros, subConjunto, i + 1, suma + numeros.get(i), objetivo)){
                return true;
            }

            subConjunto.remove(subConjunto.size() - 1);

        }

        return false;

    }

}
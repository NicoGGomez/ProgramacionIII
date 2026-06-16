
/*

Ejercicio 10
Utilizando la técnica Backtracking, escriba un algoritmo que dado un conjunto de números enteros,devuelva (si existen) todos los subconjuntos de tamaño N (dado como parámetro), cuyas sumas sean exactamente cero. Por ejemplo dado el conjunto {-7, -3, -2, -1, 5, 8 } y N = 3, los subconjuntos que suman cero son: {-7, -1, 8} y {-3, -2, 5}.

*/

import java.util.ArrayList;

public class ejercicio10 {

    public void devolverSubConjuntos(ArrayList<ArrayList<Integer>> subconjuntos, ArrayList<Integer> subconjunto,ArrayList<Integer> numeros, int suma, int pos ,int n){

        if (subconjunto.size() == n) {

            if (suma == 0)
            subconjuntos.add( new ArrayList<>(subconjunto));    

            return;
        }

        for(int i = pos; i < numeros.size() ; i ++){
                
                subconjunto.add(numeros.get(i));

                devolverSubConjuntos(subconjuntos, subconjunto, numeros, suma + numeros.get(i), i + 1, n);

                subconjunto.remove(subconjunto.size() - 1 );

        }
        
    }
    
}

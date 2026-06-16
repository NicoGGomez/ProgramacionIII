/*

Ejercicio 3
Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las combinaciones de esos números tal que la suma sea igual a M.

*/

import java.util.ArrayList;

public class ejercicio3 {

    public ArrayList<ArrayList<Integer>> obtCombinaciones(ArrayList<Integer> numeros, int m){

        ArrayList<Integer> combinacion = new ArrayList<>();
        ArrayList<ArrayList<Integer>> combinaciones = new ArrayList<>();
        int suma = 0;

        obtCombinaciones(numeros, combinacion, combinaciones, suma, m);

        return combinaciones;
    }

    private void obtCombinaciones(ArrayList<Integer> numeros, 
                               ArrayList<Integer> combinacion,
                               ArrayList<ArrayList<Integer>> combinaciones, 
                               int suma, 
                               int m){

        if (suma == m) {
            combinaciones.add(new ArrayList<>(combinacion));
            return;
        }

        for (Integer numero : numeros) {

            if (suma + numero <= m) {
            combinacion.add(numero);
            ArrayList<Integer> restantes = new ArrayList<>(numeros);
            restantes.remove(numero);

            obtCombinaciones(restantes, combinacion, combinaciones, suma + numero, m);

            combinacion.remove(combinacion.size() -1);
            }
        }

    }
    
}


/*
 
### 5. Permutaciones

Dado un conjunto de números, generar todas las permutaciones posibles.

*/

import java.util.ArrayList;

public class ejercicioGPT5 {
    
    public ArrayList<ArrayList<Integer>> generarPermutaciones(ArrayList<Integer> numeros){

        ArrayList<ArrayList<Integer>> permutaciones = new ArrayList<>();
        ArrayList<Integer> permutacion = new ArrayList<>();
        ArrayList<Integer> visitados = new ArrayList<>();

        generarPermutaciones(numeros, permutacion, permutaciones, visitados);

        return permutaciones;

    }

    private void generarPermutaciones(ArrayList<Integer> numeros, ArrayList<Integer> permutacion, ArrayList<ArrayList<Integer>> permutaciones, ArrayList<Integer> visitados){

        if (permutacion.size() == numeros.size()) {
            permutaciones.add(new ArrayList<>(permutacion));
            return;
        }

        for(Integer numero : numeros){

            if (!visitados.contains(numero)){
                permutacion.add(numero);
                visitados.add(numero);

                generarPermutaciones(numeros, permutacion, permutaciones, visitados);

                permutacion.remove(permutacion.size() - 1);
                visitados.remove(visitados.size() - 1);
            }
                
        }

    }

}

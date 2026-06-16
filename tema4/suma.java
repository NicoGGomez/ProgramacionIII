package tema4;

import java.util.ArrayList;

// Implementar un algoritmo de Backtracking que genere
// todas las combinaciones de exactamente 
// 3 números cuya suma sea menor o igual a 8.}


// [1, 2, 3, 4, 5]

// n = 8
// numeros = [1, 2, 3, 4, 5]

public class suma {
    
    public ArrayList<ArrayList<Integer>> combinaciones(int n, ArrayList<Integer> numeros){
        ArrayList<ArrayList<Integer>> combinacionesPosibles = new ArrayList<>();
        ArrayList<Integer> combinacionesNumeros = new ArrayList<>();
        int pos = 0;

        backtracking(combinacionesPosibles, combinacionesNumeros, n, numeros, pos);

        return combinacionesPosibles;
    }

    public void backtracking(ArrayList<ArrayList<Integer>> combinacionesPosibles, ArrayList<Integer> combinacionesNumeros ,int n, ArrayList<Integer> numeros, int pos){

        if (combinacionesNumeros.size() == 3) {

            int nuevaSuma = 0;

            for(int num : combinacionesNumeros){
                nuevaSuma += num;
            }

            if (nuevaSuma <= n) {
                combinacionesPosibles.add(
                    new ArrayList<>(combinacionesNumeros)
                );
            }

            return;

        }

        for(int num : numeros){

            combinacionesNumeros.add(num);

            backtracking(combinacionesPosibles, combinacionesNumeros, num, numeros, pos);

            combinacionesNumeros.remove(
                combinacionesNumeros.size()-1
            );

        }



    }


}

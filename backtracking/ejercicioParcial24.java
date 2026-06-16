/*

Ejercicio 3
Dado un conjunto C de letras (que tiene más de 4 elementos), se desean generar todas las palabras válidas que contengan exactamente 4 letras sin repetir y no empiecen con una letra vocal. Se supone que contamos con una clase Diccionario que nos permite verificar si una secuencia de letras es una palabra válida
<Diccionario.esPalabraValida(string)>.
Por ejemplo, con C={E, R, N, O, M, A, T} se debería generar una solución compuesta por {MANO, MONA, REMO,MORA, RAMO, ROEN, TOMA, ROTA, etc… }

*/

import java.util.ArrayList;

public class ejercicioParcial24 {

    public void palabrasValidas(ArrayList<String> palabras,String palabra, ArrayList<String> letras, int maxLetras){

        if (palabra.length() == maxLetras) {
            
            if (Diccionario.esPalabraValida(palabra))           
                palabras.add(palabra);

            return;

        }

        for(String letra : letras){

            if (!(palabra.length() == 0 && esVocal(letra))){

            ArrayList<String> letrasRestantes = new ArrayList<>(letras);
            letrasRestantes.remove(letra);

            palabrasValidas(palabras, palabra + letra, letrasRestantes, maxLetras);

            }

        }


    }
    
}

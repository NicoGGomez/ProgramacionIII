/*

Se tiene una palabra P dada como parámetro, en la que algunas letras ya han sido descubiertas y otras están ocultas
con guiones bajos por ej. P = "E_A_ N".
También se da como parámetro una lista L de letras disponibles que pueden usarse para adivinar las letras ocultas.
Suponga que se cuenta con una clase Diccionario de lengua española con el método:
public boolean existe(String palabra)
que retorna true si la palabra pasada como parámetro existe en el diccionario. Se desean encontrar todas las palabras válidas que puedan formarse usando las letras disponibles y la configuración inicial de la palabra P.


*/

import java.util.ArrayList;

public class EjercicioParcial25 {

    public void palabrasValidas(char[] palabra,
                                ArrayList<String> letras,
                                ArrayList<String> resultado) {

        int pos = -1;

        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i] == '_') {
                pos = i;
                break;
            }
        }

        // Caso base
        if (pos == -1) {
            String p = new String(palabra);

            if (diccionario.existe(p))
                resultado.add(p);

            return;
        }

        for (int i = 0; i < letras.size(); i++) {

            String letra = letras.get(i);

            palabra[pos] = letra.charAt(0);
            letras.remove(i);

            palabrasValidas(palabra, letras, resultado);

            letras.add(i, letra);
            palabra[pos] = '_'; // backtracking
        }
    }
    
}
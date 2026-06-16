import java.util.ArrayList;
import java.util.List;

public class parcial2024 {
    
    // 1. se crea secuencia N de tareas vacia, se verifica
    // q tarea tiene la c mas pequeña y de la mas pequeña se 
    // busca el puntaje mas alto, esta se suma a la secuencia de 
    // tareas y se busca la siguiente tarea diferente de c 
    // ya registado

    public ArrayList<String> palabrasVal(List<String> c){
        ArrayList<String> palabras = new ArrayList<>();
        int nivel = 0;
        String palabra = "";

        backtracking(palabras, c, nivel, palabra);

        return palabras;
    }

    public void backtracking(ArrayList<String> palabras, List<String> letras, int niv, String palabra){
        
        if (niv == 4) {
            
            if (diccionario.esPalabraValida(palabra)) {
                palabras.add(palabra);
            }

            return;
        }

        for (String letra : letras){
        
            boolean primerNivel = niv == 0 && esVocal(letra);

            if (!primerNivel) {
                
                String nuevaPalabra = palabra + letra;
                List<String> restantes = new ArrayList<>(letras);
                restantes.remove(letra);
                
                backtracking(palabras, restantes, niv + 1, nuevaPalabra);

            }

        }

    }

}

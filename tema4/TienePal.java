package tema4;

import java.util.ArrayList;
import java.util.List;

public class TienePal {

    public ArrayList<String> palabras(List<String> c){
        ArrayList<String> retorno = new ArrayList<>();
        String palabra = "";
        String letra = "";
        int nivel = 0;

        backtracking(retorno, palabra, nivel, c);

        return retorno;
    }

    private void backtracking(ArrayList<String> retorno, String pal, int niv, List<String> c){

        // caso base de corte
        if(niv == 4){

            if (diccionario.esPalabra(pal))
            retorno.add(pal);

            return;
        }

        // recorro los demas 
        for(String letra: c){
            
            String nuevaPal = pal;

            boolean empiezaConVocal = niv == 0 && esVocal(letra);

            if (!empiezaConVocal) {
                
                nuevaPal += letra;

                backtracking(retorno, nuevaPal, niv + 1, c);

            }
        }

    }

}
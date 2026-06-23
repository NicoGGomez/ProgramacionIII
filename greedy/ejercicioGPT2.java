package greedy;

import java.util.ArrayList;

/*

### 2. Mochila fraccionaria

Cada objeto tiene:

* peso
* valor

Podés llevar fracciones de un objeto.

**Objetivo:** maximizar el valor transportado.

*/ 

public class ejercicioGPT2 {
    
    public ArrayList<Objeto> mochila(ArrayList<Objeto> objetos){

        objetos.sort((obj1, obj2) -> Integer.compare(obj1.getValor() / obj1.getPeso(), obj2.getValor() / obj1.getPeso()));

        ArrayList<Objeto> retorno = new ArrayList<>();

        for(Objeto objeto : objetos){

            if () {
                
            }

        }

        return retorno;

    }


}

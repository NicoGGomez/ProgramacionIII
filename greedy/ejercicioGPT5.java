package greedy;

import java.util.ArrayList;

/*

### 5. Asignación de aulas

Cada clase tiene:

* inicio
* fin

**Objetivo:** determinar la cantidad mínima de aulas necesarias.

Ejemplo:

(8,10)
(9,11)
(10,12)

*/

public class ejercicioGPT5 {

    public int asignarAulas(ArrayList<Clase> clases){

        clases.sort((c1,c2) -> Integer.compare(c1.getInicio(), c2.getInicio()));
        ArrayList<Clase> aulas = new ArrayList<>();

        for(Clase clase : clases){

            boolean asignada = false;

            for(int i = 0; i < aulas.size() && !asignada; i++){

                if(aulas.get(i).getFin() <= clase.getInicio()){
                    aulas.set(i, clase); // reutilizo el aula
                    asignada = true;
                }
                
            }

            if(!asignada){
                aulas.add(clase); // necesito una nueva aula
            }
        }

        return aulas.size();

    }
    
}

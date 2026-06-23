package greedy;

import java.util.ArrayList;

/*

### 3. Asignación de actividades

Tenés actividades con:

* hora inicio
* hora fin

**Objetivo:** seleccionar la mayor cantidad de actividades sin superposición.

Ejemplo:

(1,4)
(3,5)
(0,6)
(5,7)
(8,9)

*/

public class ejercicioGPT3 {

    public ArrayList<Tarea> seleccionarAct(ArrayList<Tarea> tareas){

        tareas.sort((t1,t2) -> Integer.compare(t1.getFin(), t2.getFin()));

        ArrayList<Tarea> retorno = new ArrayList<>();

        for(Tarea tarea : tareas){

            if (retorno.isEmpty()) {
                retorno.add(tarea);   
            } else {
                Tarea ultima = tareas.get(tareas.size() -1); 
                
                    if (tarea.getInicio() >= ultima.getFin()) {
                        retorno.add(tarea);
                    }
            }

        }

        return retorno;

    }

    
}

/*

Ejercicio 5

Asignación de tareas a procesadores. Se tienen m procesadores idénticos y n tareas con un tiempo de ejecución dado. Se requiere encontrar una asignación de tareas a procesadores de manera de minimizar el tiempo de ejecución del total de tareas.

*/

import java.util.ArrayList;

public class ejercicio5 {

    public void minimizarTareas(ArrayList<Procesador> procesadores, ArrayList<Tarea> tareas, ArrayList<Tarea> mejor, ArrayList<Tarea> actual ){

        if (actual) {
        
            if (actual > mejor) {
                
                mejor = actual

            }
            return;

        }

        for(Tarea t : tareas){

            if (t.tiempo() < procesador.) {
                
            }

            

        }

    }
    
}

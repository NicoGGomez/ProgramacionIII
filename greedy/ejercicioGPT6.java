package greedy;

import java.util.ArrayList;

/*

### 6. Cubrir una ruta con estaciones

Tenés estaciones de servicio ubicadas sobre una ruta.

Un vehículo recorre como máximo K km con un tanque.

**Objetivo:** minimizar la cantidad de paradas.

Ejemplo:

```
Autonomía = 100 km

Estaciones:
50 80 140 220 310

*/ 

public class ejercicioGPT6 {

    public ArrayList<Integer> minimizarParadas(ArrayList<Integer> kmParadas,int autonomia){

        kmParadas.sort((p1, p2) -> Integer.compare(p1, p2));

        ArrayList<Integer> paradasMinimas = new ArrayList<>(); 
        int posicionActual = 0;
        int ultimaAlcanzable = posicionActual;

        for (int index = 0; index < kmParadas.size(); index++) {
            
            if (kmParadas.get(index) - posicionActual <= autonomia) {
                ultimaAlcanzable = kmParadas.get(index);
            } else {
                kmParadas.add(ultimaAlcanzable);
                posicionActual = ultimaAlcanzable;
                index--;
            }

        }

        return paradasMinimas;

    }
    
}

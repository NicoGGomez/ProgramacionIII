package greedy;

import java.util.ArrayList;

/*

### 4. Cargar camiones

Tenés un camión con capacidad C y paquetes de distintos pesos.

**Objetivo:** cargar la mayor cantidad posible de paquetes.

Ejemplo:

```
Capacidad = 15

Paquetes:
1 2 3 5 7 8

Salida:
1 2 3 5

*/

public class ejercicioGPT4 {

    public ArrayList<Paquete> cargarCamiones(int capacidad, ArrayList<Paquete> paquetes){

        paquetes.sort((p1, p2) -> Integer.compare(p1.getPeso(), p2.getPeso()));

        ArrayList<Paquete> retorno = new ArrayList<>();
        int pesoAlMomento = 0;

        for(Paquete paquete : paquetes){

            if (pesoAlMomento + paquete.getPeso() <= capacidad) {
                retorno.add(paquete);
                pesoAlMomento += paquete.getPeso();
            }

        }

        return retorno;
    }
    
}

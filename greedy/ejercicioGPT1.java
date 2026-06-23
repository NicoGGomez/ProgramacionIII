package greedy;

import java.util.ArrayList;

/*

### 1. Cambio de monedas

Tenés monedas de valores distintos y cantidad ilimitada de cada una.

**Objetivo:** obtener un monto M usando la menor cantidad de monedas posible.

Ejemplo:

Monedas = [100, 50, 10, 5, 1]
Monto = 286

Salida:
[100,100,50,10,10,10,5,1]

*/

public class ejercicioGPT1 {

    public ArrayList<Integer> obtCantMinima(ArrayList<Integer> monedas, int m){

        monedas.sort((m1,m2) -> Integer.compare(m1, m2));

        ArrayList<Integer> retorno = new ArrayList<>();

        for (int moneda : monedas) {

            while(m >= moneda){
                retorno.add(moneda);
                m -= moneda;
            }

        }

        return retorno;

    }
    
}

package tema1.tp1;

public class Main<T> {

    // ejercicio 5
    public static ListaVinculada<Integer> interseccion(
            ListaVinculada<Integer> l1,
            ListaVinculada<Integer> l2) {

        ListaVinculada<Integer> resultado = new ListaVinculada<>();

        for (Integer e1 : l1) {
            for (Integer e2 : l2) {
                if (e1.equals(e2) && resultado.indexOf(e1) == -1) {
                    resultado.insertFront(e1);
                }
            }
        }

        return resultado;
    }

    // ejercico 6
    public static ListaVinculada<Integer> diferencia(
            ListaVinculada<Integer> l1,
            ListaVinculada<Integer> l2) {

        ListaVinculada<Integer> resultado = new ListaVinculada<>();

        for (Integer e1 : l1) {
            if (l2.indexOf(e1) == -1) { // no está en l2
                resultado.insertFront(e1);
            }
        }

        return resultado;
    }

}

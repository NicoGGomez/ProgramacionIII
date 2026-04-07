package tema1.tp2;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arrDos = {-3, -1, 0, 2, 4, 6, 10};

        int pos = buscar(arr, 2, arr.length -1, 0);
        int binario = convBinario(26);

        System.out.println(pos);
        System.out.println(binario);
        fibonacci(10, 0, 1);
        System.out.println(valorIgualPosicion(arrDos, 0));
        System.out.println(factorial(5));

    }

    // EJERCICIO 1 
    public static boolean estaOrdenado(int[] arr, int i) {
        if (i >= arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return estaOrdenado(arr, i + 1);
    }

    // EJERCICIO 2 
    public static int buscar(int[] arr, int n, int posFin, int indice){
        
        if (indice > posFin) {
            return -1;
        }

        if (arr[indice] == n) {
            return indice;
        }
        
        return buscar(arr, n, posFin, indice +1);
    }

    // EJERCICIO 3 
    public static int convBinario(int n){
        if (n == 0) {
            return 0;
        }

        return n % 2 + 10 * convBinario(n / 2);
    }

    // EJERCICIO 4
    public static void fibonacci(int nCorte, int primero, int segundo) {
        if (nCorte == 0) return;

        System.out.print(primero + " ");
        fibonacci(nCorte - 1, segundo, primero + segundo);
    }

    // EJERCICIO 5
    public static boolean valorIgualPosicion(int[] arr, int pos){
        if (pos >= arr.length-1)
            return false;

        if (arr[pos] == pos)
            return true;

        return valorIgualPosicion(arr, pos + 1);
    }

    // FACTORIAL
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,21,3};
        estaOrdenado(arr, 0);
    }

    public static boolean estaOrdenado(int[] arr, int i) {
        if (i == arr.length - 1) return true; // caso base

        if (arr[i] > arr[i + 1]) return false;

        return estaOrdenado(arr, i + 1);
    }

}

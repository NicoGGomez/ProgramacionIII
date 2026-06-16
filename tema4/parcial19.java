import java.util.ArrayList;
import java.util.List;

public class parcial19 {
    
    public ArrayList<ArrayList<Integer>> backtracking(List<Integer> n, ArrayList<ArrayList<Integer>> permutaciones, ArrayList<Integer> permutacion){

        if(n.isEmpty()){
            permutaciones.add(new ArrayList<>(permutacion));
            return permutaciones;
        }

        for(int numero : n){
            permutacion.add(numero);
            ArrayList<Integer> restantes = new ArrayList<>(n);
            restantes.remove(numero);

            backtracking(restantes, permutaciones, permutacion);
            
            permutacion.remove(permutacion.size()-1);
        }

        return permutaciones;
    }

}

package tema4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tema4.Vertice;
import tema4.GrafoNoDirigido;


public class Parcial2025 {

    // EJERCICIO 1 

    public <T> ArrayList<ArrayList<Integer>> obtenerComponentes(GrafoNoDirigido<T> g){

        ArrayList<ArrayList<Integer>> componentesConexas = new ArrayList<>();

        Iterator<Vertice<T>> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() == 'B') {
                ArrayList<Integer> visitados = new ArrayList<>();
                DFS(v, g, visitados);
                componentesConexas.add(
                    new ArrayList<>(visitados)
                );
            }
        }

        return componentesConexas;

    }

    public <T> void DFS(Vertice<T> v, GrafoNoDirigido<T> g, ArrayList<Integer> visitados){

        v.setColor('A');
        visitados.add(v.getId());

        Iterator<Vertice<T>> itAdyacentes = g.obtenerAdyacentes(v.getId());
        
        while (itAdyacentes.hasNext()) {
            Vertice<T> ver = g.getVertice(itAdyacentes.next().getId());
            if (ver.getColor() == 'B') {
                DFS(ver, g, visitados);
                ver.setColor('N');
            }
        }

        v.setColor('N');

    }

    // EJERCICO 2

    // Los jugadores más fuertes son los que más desequilibran.
    // Cada vez que tomo uno, lo agrego al equipo más débil hasta ese momento.
    // Así intento mantener las sumas de habilidades de los equipos lo más parejas posible.

    public ArrayList<Jugador> asignarEquipos(List<Jugador> jugadores, int k){

            ArrayList<Jugador> retorno = new ArrayList<>();

            for (Jugador j : jugadores) {
                
                

            }

    }

    public ArrayList<String> backtracking(String palabra, ArrayList<String> letras){

        ArrayList<String> palabras = new ArrayList<>();

        // condicion de corte 
        if (letras.isEmpty()) {
            if (existe(palabra)) {
            palabras.add(palabra);
            }
            return palabras;
        }
        

        // 
        for (String l : letras) {

            ArrayList<String> letrasRestantes = new ArrayList<>(letras);
            letrasRestantes.remove(l)
            
            String palabraNueva = palabra + l;

            palabras.addAll(
                backtracking(palabraNueva, letras);
            );

        }

        return palabras;

    }


}
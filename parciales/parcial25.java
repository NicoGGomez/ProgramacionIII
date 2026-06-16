package ProgramacionIII.parciales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ProgramacionIII.tema4.Vertice;
import ProgramacionIII.tema4.GrafoNoDirigido;

public class parcial25<T> {
    
    // 1 
    private GrafoNoDirigido<T> g;

    public <T> ArrayList<ArrayList<Integer>> obtenerComponentes(){

        ArrayList<ArrayList<Integer>> componentes = new ArrayList<>();

        Iterator<T> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            if (v.getColor() != 'B') {
                v.setColor('B');
            }
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            ArrayList<Integer> componente = new ArrayList<>();
            if (v.getColor() == 'B') {
                DFS(v, componente);
                componentes.add(componente);
            }
        }

        return componentes;

    }

    public <T> void DFS(Vertice<T> actual, ArrayList<Integer> componente){

        actual.setColor('A');
        componente.add(actual.getId()); 

        Iterator<T> itVecinos = g.obtenerAdyacentes(actual.getId());

        while (itVecinos.hasNext()) {
            Vertice<T> vecino = g.obtenerVertices(itVecinos.next());
            if (vecino.getColor() == 'B') {
                DFS(vecino, componente);
            }
        }

        actual.setColor('N');

    }

    // 2

    public ArrayList<ArrayList<Jugador>> asignarEquipos(List<Jugador> jugadores, int k){
        ArrayList<ArrayList<Jugador>> equipos = new ArrayList<>();

        jugadores.sort((a,b) -> b.getNivel() - a.getNivel());

        for (int i = 0; i < k ; i++) {
            equipos.add(new ArrayList<>());
        }

        for(Jugador j : jugadores){
        
            int equipoMinIdx = 0;
            int sumaMin = sumaEquipo(equipos.get(0));

            for (int i = 1; i < k; i++) {
                int sumaActual = sumaEquipo(equipos.get(i));
                if (sumaActual < sumaMin) {
                    sumaMin = sumaActual;
                    equipoMinIdx = i;
                }
            }

            equipos.get(equipoMinIdx).add(j);
            
        }

        return equipos;
    }

    public int sumaEquipo(ArrayList<Jugador> equipo){
        int suma = 0;
        for (Jugador j : equipo) {
            suma += j.getNivel();
        }
        return suma;
    }

}

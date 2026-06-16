package ProgramacionIII.greedy;

import java.util.ArrayList;
import java.util.List;

// Se tienen N jugadores con diferentes niveles de habilidad expresados como nuun número integer asignado a cada
// jugador. Se deben formar K equipos (K< N), de manera que todos los jugadores queden asignados a algún equipo. Se
// desea lograr la distribución de habilidades más equilibrada posible, es decir, minimizar la diferencia entre el equipo
// más fuerte y el más débil.
// Implemente en JAVA el siguiente método que resuelva el problema mediante una estrategia greedy.
// ArrayList<ArrayList<Jugador>> asignarEquipos(List<Jugador> jugadores, int k);

public class ejerUno {

    public ArrayList<ArrayList<Jugador>> asignarEquipos(List<Jugador> jugadores, int k){

            jugadores.sort((j1,j2) -> Integer.compare(j2.getHabilidad(), j1.getHabilidad()));

            ArrayList<ArrayList<Jugador>> equipos = new ArrayList<>();
            int fuerzaEquipos[] = new int[k];

            for (int index = 0; index < k; index++) {
                equipos.add( new ArrayList<>() );
                fuerzaEquipos[index] = 0;
            }

            for (Jugador jug : jugadores) {
                
                int menorHabilidad = 0;

                for (int index = 0; index < k; index++) {
                    if (fuerzaEquipos[index] < fuerzaEquipos[menorHabilidad]) {
                        menorHabilidad = index;
                    }
                }

                equipos.get(menorHabilidad).add(jug);
                fuerzaEquipos[menorHabilidad] += jug.getHabilidad();
            }

            return equipos;
        }

    // 1 Se tienen N cursos con distinta cantidad de alumnos y K aulas con distinta capacidad.

    public ArrayList<ArrayList<Curso>> asignarAulas(List<Curso> cursos, List<Aula> aulas){

        cursos.sort((c1, c2) -> Integer.compare(c1.getCantidadaAlumnos(), c2.getCantidadAlumnos()));

        ArrayList<ArrayList<Curso>> retorno = new ArrayList<>();
        
        for (int i = 0; i < aulas.size(); i++) {
            retorno.add(new ArrayList<>());
        }

        boolean[] ocupada = new boolean[aulas.size()];

        for(Curso c : cursos){

            int mejorAula = -1;

            for(int i = 0; i < aulas.size(); i++ ){
                
                if (!ocupada[i] &&
                aulas.get(i).getCapacidad() >= c.getCantidadAlumnos()) {

                if (mejorAula == -1 ||
                    aulas.get(i).getCapacidad() < aulas.get(mejorAula).getCapacidad()) {

                    mejorAula = i;
                }
                
            }

            if (mejorAula != -1) {
                retorno.get(mejorAula).add(c);
                ocupada[mejorAula] = true;
            }

            }

            return retorno;
        }

    }

    // 2 Se tienen N paquetes con distinto peso y K camiones.

    public ArrayList<ArrayList<Paquete>> cargarCamiones(List<Paquete> paquetes, int k){

        paquetes.sort((p1,p2) -> Integer.compare(p2.getPeso(), p1.getPeso()));

        ArrayList<ArrayList<Paquete>> camiones = new ArrayList<>();
        int[] cantidadPaquetes = new int[k];

        for(int i = 0; i < k; i++){
            camiones.add( new ArrayList<>() );
            cantidadPaquetes[i] = 0;
        }

        for(Paquete pack : paquetes){

            int camionMasLiviano = 0;

            for (int i = 0; i < k; i++) {
                if (cantidadPaquetes[i] < cantidadPaquetes[camionMasLiviano]) {
                    camionMasLiviano = i;
                }
            }

            camiones.get(camionMasLiviano).add(pack);
            cantidadPaquetes[camionMasLiviano] += pack.getPeso();
        }

        return camiones;
    }

    // 3 Planificación de tareas

    public ArrayList<Tarea> planificar(List<Tarea> tareas){

        tareas.sort((t1,t2) -> Integer.compare(t1.getLimite(), t2.getLimite()));

        ArrayList<Tarea> tareasARealizar = new ArrayList<>();
        
        int tiempoActual = 0;

        for(Tarea t : tareas){

            if (tiempoActual + t.getDuracion() <= t.getLimite()) {
                tareasARealizar.add(t);
                tiempoActual += t.getDuracion();
            }

        }

        return tareasARealizar;

    }

    // 6 Se tienen N jugadores con habilidad y K equipos.

    public ArrayList<ArrayList<Jugador>> formarEquipos(List<Jugador> jugadores, int k){

        jugadores.sort((j1,j2) -> Integer.compare(j1.getHabilidad(), j2.getHabilidad()));

        ArrayList<ArrayList<Jugador>> equipos = new ArrayList<>();
        int[] habilidadDeEquipo = new int[k];

        for(int i = 0; i < k; i++){
            equipos.add( new ArrayList<>() );
            habilidadDeEquipo[i] = 0;
        }

        for(Jugador jugador : jugadores){

            int menosHabilidoso = 0;
            
            for(int i = 0; i < k ; i++){
                if (habilidadDeEquipo[i] < habilidadDeEquipo[menosHabilidoso]) {
                    menosHabilidoso = i;
                }
            }

            equipos.get(menosHabilidoso).add(jugador);
            habilidadDeEquipo[menosHabilidoso] = jugador.getHabilidad();
        }

        return equipos;
    }

    // 7 Se tiene un monto M y monedas de distintos valores.

    public ArrayList<Integer> cambio(int monto, ArrayList<Integer> monedas){

        monedas.sort((m1,m2) -> Integer.compare(m2, m1));

        ArrayList<Integer> necesarias = new ArrayList<>();

        for(int moneda : monedas){

            if (moneda <= monto) {
                necesarias.add(moneda);
                monto -= moneda;
            }

        }

        return necesarias;
    }

    public ArrayList<Actividad> seleccionarActividades(List<Actividad> actividades){

        actividades.sort((a1,a2) -> Integer.compare(a1.getHoraFin(), a2.getHoraFin()));

        ArrayList<Actividad> seleccionadas = new ArrayList<>();

        Actividad ultima = null;

        for(Actividad act : actividades){

            if(ultima == null || act.getHoraInicio() >= ultima.getHoraFin()){

                seleccionadas.add(act);
                ultima = act;

            }

        }

        return seleccionadas;

    }
    
}

import java.util.ArrayList;
import java.util.Iterator;
import GrafoDirigido;
import Vertice;
import tema1.tp1.Nodo;

public class recu24 {

    // 1

    public <T> boolean recorrido(GrafoDirigido<T> g, Vertice<T> ini, Vertice<T> destino){

        Iterator<T> it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        // si es mentira q hay camino de a->b
        if (!visit(g, ini, destino)) {
            return false;
        }

        it = g.obtenerVertices();

        while (it.hasNext()) {
            Vertice<T> v = g.getVertice(it.next());
            v.setColor('B');
        }

        // si es mentira q hay camino de b->a
        if (!visit(g, destino, ini)) {
            return false;
        }

        return true;

    }

    public <T> boolean visit(GrafoDirigido<T> g, Vertice<T> actual, Vertice<T> destino){

        if (actual.equals(destino)) {
            return true;
        }

        actual.setColor('G');

        Iterator<T> it = g.obtenerAdyacentes(actual.getId());

        while (it.hasNext()) {
            Vertice<T> vecino = g.getVertice(it.next());
            if (vecino.getColor() == 'B') {
                if (visit(g, vecino, destino)) {
                    return true;
                }
            }
        }

        actual.setColor('N');
        return false;

    }

    // 3

    // conjunto p de consultas (c/u con tiempo de atencion)
    // operadores contestan consultas (c/u dedica x tiempo)
    // cada operador contesta maximo m consultas tecnicas
    // boolean esConsultaTecnica(consulta)

    // dado p determinar numero minimo de operadores q seran
    // requeridos 

    // 1 vamos a recorrer la lista de consultas
    // 2 agarro una consulta
    // verifico el tiempo de la consulta
    // 3 vamos a recorrer la lista de operadores hasta encontrar el adecuado al tiempo
    // 4 agarro un operador
    // 6 verifico si es consulta tecnica (boolean esConsultaTecnica(consulta))
    // 6 (verdad) si es consulta tecnica verifico si la cantidad de consultas tecnicas del operador (m) son menores a las ya respondidas. si la puede responer lo sumo a la lista de operadores y le saco el tiempo usado y le sumo a la variable consultas tecnicas respondidas. si no la puede responder corto, pasando al siguiente operador
    // 6 (falso) si no es consulta tecnica lo sumo a la lista de operadores 

    public <T> int operadoresRequeridos(ArrayList<Consulta> p, ArrayList<Operador> operadores){
        
        ArrayList<Operador> retorno = new ArrayList<>();

        for (Consulta cons : p) {
            
           for(Operador op: operadores){
                int consultasTecnicas = 0;
                boolean tiempo = op.tiempoMax() >= cons.getTiempo();

                if (tiempo) {
                    
                    if (esConsultaTecnica()) {
                        
                        if (op.getConsultas() < ){

                        }

                    }

                }
           } 

        }

        

    }

    // 4 

    public 

}

// 2

public class LinkedList<T> {

    private Nodo<T> first;

    public <T> void agregarAlPrincipio(T info) {
		Nodo<T> tmp = new Nodo<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}

    public void agregarAlFinal(T info){
        if (this.first != null) {
            Nodo<T> tmp = new Nodo<T>(info, null);
            Nodo<T> nodo = this.first;
            while (nodo.getNext() != null) {
                nodo = nodo.getNext();
            }
            nodo.setNext(tmp);
        }
    }

    public boolean eliminarElemento(T info){
        if (this.first != null) {

            if (first.getInfo().equals(info)) {
                first = first.getNext();
                return true;
            }

            Nodo<T> nodo = this.first;

            while (nodo.getNext() != null) {

                if (nodo.getNext().getInfo().equals(info)) {
                    nodo.setNext(nodo.getNext().getNext());
                    return true;   
                }

                nodo = nodo.getNext();

            }

        }

        return false;
    }

    public void eliminarUltimo(){
        if (this.first != null ) {

            if (this.first.getNext() != null) {
                first = null;
                return;
            }
            
            Nodo<T> nodo = this.first;

            while(nodo.getNext().getNext() != null){
                nodo = nodo.getNext();
            }

            nodo.setNext(null);

        }
    }

}

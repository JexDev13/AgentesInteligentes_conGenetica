package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import modelo.Cliente;

/**
 *
 * @author Isma2
 */
public class Agente1 extends Agent {

    private boolean bandera = true;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends SimpleBehaviour {

        @Override
        public void action() {

            //x, Y del AG
            Genetica gen = new Genetica();
            int poblacion = 5;
            int longCrom = 12;
            int iteraccion = 5;
            int evoluciones = 10;
            int[] Xy = gen.evolucionar(gen.get_Poblacion(gen.configuracionAG(poblacion, longCrom)), evoluciones, iteraccion);
            int X = Xy[0];
            int Y = Xy[1];
            
            //enviar al Agente 2
            Comunicacion.msj(ACLMessage.INFORM, getAgent(), "Ag2", X+";"+Y, null, "CD-01-02-AG");
            /*System.out.println("CD-01-02");
            System.out.println("Agente 1 y La edad es: 23");
            System.out.println("--------------------------");
            System.out.println(" ");
            blockingReceive();*/
        }

        @Override
        public boolean done() {
            return true;
        }
        
        
    }
}

package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Isma2
 */
public class Agente2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {

            ACLMessage aclmsj = blockingReceive();
            String conversationId = aclmsj.getConversationId();
            switch (conversationId) {
                case "CD-01-02-AG" -> {
                    System.out.println("Recibe info");
                    System.out.println(aclmsj.getContent());
                    System.out.println(aclmsj);
                }
            }
        }
    }
}

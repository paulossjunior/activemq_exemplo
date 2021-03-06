package br.edu.ifes.les.app;

import javax.jms.*;
import javax.naming.InitialContext;


/**
 * Created by paulosantosjunior on 10/05/17.
 */
public class MessageProducerX {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination fila = (Destination) context.lookup("financeiro");
        MessageProducer producer = session.createProducer(fila);
        Message message = session.createTextMessage("<pedido><id>123</id></pedido>");

        producer.send(message);


    }
}

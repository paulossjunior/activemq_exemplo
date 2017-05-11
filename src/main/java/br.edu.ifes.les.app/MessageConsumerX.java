package br.edu.ifes.les.app;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by paulosantosjunior on 10/05/17.
 */
public class MessageConsumerX {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("financeiro");
        javax.jms.MessageConsumer consumer = session.createConsumer(fila);

        Message message = consumer.receive();

        System.out.println("Recebendo msg: "+ message);

        connection.close();
        context.close();
    }

}

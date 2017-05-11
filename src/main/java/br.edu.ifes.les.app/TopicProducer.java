package br.edu.ifes.les.app;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by paulosantosjunior on 10/05/17.
 */
public class TopicProducer {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

        Connection connection = factory.createConnection();

        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination topico = (Destination) context.lookup("loja");

        MessageProducer producer = session.createProducer(topico);

        Message message = session.createTextMessage("<pedido><id>222</id></pedido>");

        message.setBooleanProperty("ebook", false);

        producer.send(message,DeliveryMode.NON_PERSISTENT, 3, 5000);

        session.close();
        connection.close();
        context.close();
    }

}

package br.edu.ifes.les.app;

import javax.jms.*;
import javax.naming.InitialContext;

/**
 * Created by paulosantosjunior on 10/05/17.
 */
public class MessageConsumerListener {

    public static void main(String[] args) throws Exception {

        InitialContext context = new InitialContext();

        //imports do package javax.jms
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("financeiro");

        MessageConsumer consumer = session.createConsumer(fila);



        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {

                TextMessage textMessage  = (TextMessage)message;

                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });

        Message message = consumer.receive();


        connection.close();
        context.close();
    }

}

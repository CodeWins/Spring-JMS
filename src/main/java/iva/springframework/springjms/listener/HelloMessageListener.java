package iva.springframework.springjms.listener;

import iva.springframework.springjms.config.JmsConfig;
import iva.springframework.springjms.model.HelloWorldMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * Created By iVa on 2/26/2021.
 */
@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.My_QUEUE)
    public void  listen(@Payload HelloWorldMessage helloWorldMessage,
                        @Headers MessageHeaders headers,
                        Message message){

        System.out.println("I got a message!");
        System.out.println(helloWorldMessage);

//        throw  new RuntimeException("foo");
    }
}

package iva.springframework.springjms.sender;

import iva.springframework.springjms.config.JmsConfig;
import iva.springframework.springjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created By iVa on 2/26/2021.
 */
@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    @Scheduled(fixedRate = 2000)
    public void sendMessage(){

        System.out.println("I amd sending message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.My_QUEUE,message);
        System.out.println("Message Sent");
    }
}

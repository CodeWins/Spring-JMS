package iva.springframework.springjms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Created By iVa on 2/26/2021.
 */
@Configuration
public class JmsConfig {

    public  static final  String My_QUEUE = "my-hello-world";
    public  static final  String My_SEND_RECEIVE_QUEUE = "replybacktome";
    @Bean
    public MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}

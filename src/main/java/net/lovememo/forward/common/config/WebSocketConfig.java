package net.lovememo.forward.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by lovememo on 17-4-30.
 */
@Configuration
//开始使用STOMP协议来传输基于代理的消息，控制器使用@MessageMapping，就像使用RequestMapping一样
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    //指定STOMP协议的节点，并映射指定URL
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //使用SockJS协议
        stompEndpointRegistry.addEndpoint("/endpointLovememo").withSockJS();
    }

    @Override
    //配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式应配置一个/topic代理
        registry.enableSimpleBroker("/topic");
    }

}

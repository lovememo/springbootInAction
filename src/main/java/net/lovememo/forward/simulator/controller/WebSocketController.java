package net.lovememo.forward.simulator.controller;

import net.lovememo.forward.simulator.model.WebSocketRequestMessage;
import net.lovememo.forward.simulator.model.WebSocketResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by lovememo on 17-5-4.
 */
@SuppressWarnings("unused")
@Controller
public class WebSocketController {
    @MessageMapping("/welcome")
    @SendTo("/topic/notification")
    public WebSocketResponseMessage connect(WebSocketRequestMessage requestMessage) {
        WebSocketResponseMessage message = new WebSocketResponseMessage();
        message.setResponseMessage("welcome, " + requestMessage.getName() + "!");
        return message;
    }
}

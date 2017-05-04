package net.lovememo.forward.simulator.controller;

import net.lovememo.forward.simulator.model.WebSocketResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by lovememo on 17-5-4.
 */
@RestController
public class TestController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/simulator/test")
    public Object test(String name) {
        WebSocketResponseMessage responseMessage = new WebSocketResponseMessage();
        responseMessage.setResponseMessage("welcome, " + name);
        this.simpMessagingTemplate.setUserDestinationPrefix("/topic");
        this.simpMessagingTemplate
                .convertAndSendToUser("",
                        "notification",
                        responseMessage
                );


        HashMap mp = new HashMap();
        mp.put("flag", "0");
        mp.put("msg", "success");
        mp.put("name", name);
        return mp;
    }
}

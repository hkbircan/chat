package com.coding.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;   // bununlada mesaji kendimiz ozellestirip gonderebiliyoruz

    @MessageMapping("/chat")
    //@SendTo("/topic")      herkese gonderiyor ama icerisinde parametre olarak hangi path hangi kanla gondermesini istiyor
    //@SendToUser() spesifik bir user a gonderiyor. bir kanal channel istiyor path, user brotcast yani herkese yayinla
    public void chatEndPoint(@Payload WsMessage wsMessage) {

        System.out.println(wsMessage);
//        messagingTemplate.convertAndSendToUser();
        messagingTemplate.convertAndSend("/topic", wsMessage);

    }

}

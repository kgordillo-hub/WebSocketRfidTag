package co.agro.chain.WebSocketRfidTag;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

import co.agro.chain.WebSocketRfidTag.dto.InboundMessage;
import co.agro.chain.WebSocketRfidTag.dto.OutboundMessage;

@Controller
public class AppController {

	@MessageMapping("/sendRfidTag")
	@SendTo("/topic/rfidInfo")
	public OutboundMessage recibirSenal(String message) throws Exception {
		final Gson gson = new Gson();
		final InboundMessage inMessage = gson.fromJson(message, InboundMessage.class);
		return new OutboundMessage(inMessage.getIdUsuario(), inMessage.getEtiquetaRfid());
	}

}

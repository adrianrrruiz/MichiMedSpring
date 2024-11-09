package com.example.demo.controlador;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatRequest;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;

@RestController
@RequestMapping("/gpt")
@CrossOrigin(origins = "http://localhost:4200")
public class GPTController {

  @Autowired
  private ChatgptService chatgptService;

  @GetMapping("/chat")
  public String chatWith(@RequestParam String message) {
    return chatgptService.sendMessage(message);
  }

  @GetMapping("/prompt")
  public String prompt(@RequestParam String message) {

    Integer maxTokens = 200;
    String model = "gpt-4o-mini";
    Double temperature = 0.5;
    Double topP = 1.0;

    List<MultiChatMessage> messages = Arrays.asList(
        new MultiChatMessage("system",
            """
                  Eres un asistente virtual especializado en la clínica veterinaria Michimed, dedicada al cuidado de gatos. Cuando recibas información sobre un gato, proporciona una respuesta útil, enfocada y detallada en cuanto a salud, alimentación, ejercicio y bienestar, considerando la raza, edad y peso del gato.

                  Tu respuesta debe ser breve pero precisa, con un máximo de 200 tokens. Evita formular preguntas o abrir temas adicionales que requieran más interacción. Limítate a información de utilidad en una sola respuesta.
                """),
        new MultiChatMessage("user", message));

    MultiChatRequest multiChatRequest = new MultiChatRequest(model, messages, maxTokens, temperature, topP);
    MultiChatResponse chatResponse = chatgptService.multiChatRequest(multiChatRequest);

    return chatResponse.getChoices().get(0).getMessage().getContent();
  }

}

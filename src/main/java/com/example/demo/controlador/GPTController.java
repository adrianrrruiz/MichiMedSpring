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

  @GetMapping("/frase-motivacional")
  public String fraseMotivacional() {
    Integer maxTokens = 35; // Reducido para una frase corta
    String model = "gpt-4o-mini";
    Double temperature = 0.9;
    Double topP = 1.0;

    // Define el mensaje para el modelo
    String message = "Imagina que eres el líder del equipo de MichiMed, una clínica veterinaria especializada en el cuidado y bienestar de gatos. Genera una frase motivacional creativa y única para inspirar a nuestro personal en solo 20 palabras o menos. Alterna entre estilos como citas inspiradoras, mensajes personalizados o recordatorios de impacto positivo. La frase debe ser corta, alentadora y debe variar en cada generación.";

    List<MultiChatMessage> messages = Arrays.asList(
        new MultiChatMessage("user", message));
    // Envía la solicitud

    MultiChatRequest multiChatRequest = new MultiChatRequest(model, messages, maxTokens, temperature, topP);
    MultiChatResponse chatResponse = chatgptService.multiChatRequest(multiChatRequest);

    return chatResponse.getChoices().get(0).getMessage().getContent();
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

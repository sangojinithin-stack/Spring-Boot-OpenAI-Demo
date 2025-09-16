package com.example.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class OpenAIServiceImpl {

    private final OpenAiService openAiService;

    public OpenAIServiceImpl(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String getResponse(String prompt) {
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(Arrays.asList(new ChatMessage("user", prompt)))
                .maxTokens(100)
                .build();
        return  openAiService.createCompletion(request)   // FIXED

        		              .getChoices()
        		              .get(0)
        		              .getMessage()
        		              .getContent();
      
        

    }
}

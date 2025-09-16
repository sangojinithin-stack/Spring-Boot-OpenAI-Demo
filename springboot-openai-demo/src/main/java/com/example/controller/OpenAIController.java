package com.example.controller;

import com.example.service.OpenAIServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
public class OpenAIController {

    private final OpenAIServiceImpl openAIService;

    public OpenAIController(OpenAIServiceImpl openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/chat")
    public String chat() {
        return "Spring Boot OpenAI API is Running !";
    }

    @PostMapping("/ask")
    public String askAI(@RequestBody String question) {
        return openAIService.getResponse(question);
    }
}

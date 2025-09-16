package com.example.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Bean
    public OpenAiService openAiService() {
        var apiKey = System.getenv("OPENAI_API_KEY");
        return new OpenAiService();
    }
}

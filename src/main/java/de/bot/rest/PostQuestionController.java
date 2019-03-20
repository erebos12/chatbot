package de.bot.rest;

import de.bot.ChatBot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostQuestionController {

    private ChatBot chatBot = new ChatBot();

    @PostMapping("/")
    public ResponseEntity<String> postQuestion(@RequestBody String message) {
       String reply = chatBot.getReply(message);
       return new ResponseEntity<String>(reply, HttpStatus.OK);
    }

}

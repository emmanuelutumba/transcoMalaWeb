package com.ml.transco.controller;


import com.ml.transco.model.Message;
import com.ml.transco.service.MessageService;
import com.ml.transco.utils.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity getList() {
        return ResponseEntity.ok(this.messageService.getList());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Message message) {
        HttpResponse httpResponse = new HttpResponse();
        try {
            Message message1 = this.messageService.save(message);
            if (message1 != null) {
                httpResponse.setCode("200");
            } else {
                httpResponse.setCode("400");
                httpResponse.setMessage("Echec d'enregistrement");
            }
            return ResponseEntity.ok(httpResponse);
        } catch (Exception e) {
            httpResponse.setMessage(e.getMessage());
        }
        httpResponse.setCode("500");
        return ResponseEntity.ok(httpResponse);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Message message) {
        HttpResponse httpResponse = new HttpResponse();
        try {
            Message message1 = this.messageService.update(message);
            if (message1 != null) {
                httpResponse.setCode("200");
            } else {
                httpResponse.setCode("400");
                httpResponse.setMessage("Echec d'enregistrement");
            }
            return ResponseEntity.ok(httpResponse);
        } catch (Exception e) {
            httpResponse.setMessage(e.getMessage());
        }
        httpResponse.setCode("500");
        return ResponseEntity.ok(httpResponse);
    }

    @DeleteMapping(value = "/{messageId}")
    public ResponseEntity delete(@PathVariable("messageId") long messageId) {
        HttpResponse httpResponse = new HttpResponse();
        try {
            boolean isDeleted = this.messageService.delete(messageId);
            if (isDeleted) {
                httpResponse.setCode("200");
            } else {
                httpResponse.setCode("400");
                httpResponse.setMessage("Echec de suppression");
            }
            return ResponseEntity.ok(httpResponse);
        } catch (Exception e) {
            httpResponse.setMessage(e.getMessage());
        }
        httpResponse.setCode("500");
        return ResponseEntity.ok(httpResponse);
    }
}

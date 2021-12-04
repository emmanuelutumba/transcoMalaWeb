package com.ml.transco.service;

import com.ml.transco.model.Message;
import com.ml.transco.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public List<Message> getList() {
        return this.messageRepo.findAll();
    }

    @Override
    public Message save(Message message) {
        return this.messageRepo.save(message);
    }

    @Override
    public Message update(Message message) {
        return this.messageRepo.save(message);
    }

    @Override
    public boolean delete(long id) {
        Optional<Message> message = this.messageRepo.findOne(Example.of(new Message(id)));
        if (message.isPresent())
            return true;
        return false;
    }
}

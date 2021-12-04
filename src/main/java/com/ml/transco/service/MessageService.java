package com.ml.transco.service;

import com.ml.transco.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageService {

    public List<Message> getList();

    public Message save(Message message);

    public Message update(Message message);

    public boolean delete(long id);

}

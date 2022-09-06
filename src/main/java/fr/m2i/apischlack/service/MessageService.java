/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.apischlack.service;

import fr.m2i.apischlack.dto.MessageMapper;
import fr.m2i.apischlack.exception.NotFoundException;
import fr.m2i.apischlack.model.Message;
import fr.m2i.apischlack.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ben
 */
@Service
public class MessageService implements IMessageService{
    
    private final MessageRepository repo;
    
    @Autowired
    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<Message> findAllMessageByChannel(Long id) {
        return repo.getAllMessageFromChannel(id);
    }

    @Override
    public Message MessageFindById(Long id) throws NotFoundException{
        return repo.MessageFindById(id);
    }

    @Override
    public Message MessageFindByIdPut(Long id) throws NotFoundException{
        return repo.MessageFindById(id);
    }
    
    @Override
    public void delete(Long id) {
        Message toDelete = MessageFindById(id);
        repo.delete(toDelete);
    }

    @Override
    public Message save(Message message) {
         return repo.save(message);
    }

    @Override
    public Message update(Long id, Message content) {
        Message toUpdate = MessageFindByIdPut(id);
        System.out.println("update toUpdate : "+toUpdate.toString());
        toUpdate = MessageMapper.copy(toUpdate, content);
        System.out.println("update toUpdate 2 : "+toUpdate.toString());

        return save(toUpdate);
    }
    
    
    
}

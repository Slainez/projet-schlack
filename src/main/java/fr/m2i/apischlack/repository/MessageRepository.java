
package fr.m2i.apischlack.repository;


import fr.m2i.apischlack.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    
    
    @Query("SELECT m FROM Message m WHERE m.channel = :channel_id")
    List<Message> getAllMessageFromChannel(@Param("channel_id") Long channelId);
}
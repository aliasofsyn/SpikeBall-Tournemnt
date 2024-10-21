package dev.ssef.Pickleball_Tournement.gameSessionFolder;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    public Integer isCollectionEmpty(String collectionName) {
        Long count = sessionRepository.count();
        return count.intValue();
    }

    public Session getSessionById(String id) {
        return sessionRepository.findById(new ObjectId(id)).get();
    }

    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }
}

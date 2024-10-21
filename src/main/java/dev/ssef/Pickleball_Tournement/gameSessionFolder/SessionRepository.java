package dev.ssef.Pickleball_Tournement.gameSessionFolder;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends MongoRepository<Session, ObjectId> {

}

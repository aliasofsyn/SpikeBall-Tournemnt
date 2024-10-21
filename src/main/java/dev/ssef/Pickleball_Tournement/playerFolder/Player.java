package dev.ssef.Pickleball_Tournement.playerFolder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "players")
@Data
public class Player {
    @Id
    private ObjectId id;
    private String name;
    private int gamesWon, gamesLost;
    private String[] gameHistory;

}

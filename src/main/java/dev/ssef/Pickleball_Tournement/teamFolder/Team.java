package dev.ssef.Pickleball_Tournement.teamFolder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import dev.ssef.Pickleball_Tournement.playerFolder.Player;

import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    @Id
    private ObjectId id;
    private String teamName;
    @DocumentReference
    private Player[] players = new Player[2];

    public boolean addPlayer(Player p) {
        if (players[0] == null) {
            players[0] = p;
            return true;
        } else if (players[1] == null) {
            players[1] = p;
            return true;
        }
        return false;

    }
}
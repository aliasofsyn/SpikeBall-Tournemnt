package dev.ssef.Pickleball_Tournement.gameSessionFolder;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import dev.ssef.Pickleball_Tournement.teamFolder.Team;
import dev.ssef.Pickleball_Tournement.playerFolder.Player;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gameSessions")
@Data
public class Session {
    @Id
    private ObjectId id;
    private String sessionName;
    @DocumentReference
    private ArrayList<Team> teams = new ArrayList<Team>();
    @DocumentReference
    private ArrayList<Player> players = new ArrayList<Player>();
    private int tournementSizeIndex = 0;
    private int[] tournmenetSize = { 2, 4, 8, 16, 32 };
}

package dev.ssef.Pickleball_Tournement.playerFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MongoTemplate mt;

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }
}

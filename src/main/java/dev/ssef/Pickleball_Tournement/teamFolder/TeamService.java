package dev.ssef.Pickleball_Tournement.teamFolder;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.ssef.Pickleball_Tournement.playerFolder.Player;

import java.util.*;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(ObjectId id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Optional<Team> addPlayerToTeam(String teamId, Player player) {
        Optional<Team> teamOptional = teamRepository.findById(new ObjectId(teamId));
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            if (!team.addPlayer(player)) {
                throw new IllegalArgumentException("Team is full");
            }
            teamRepository.save(team);
            return Optional.of(team);
        }
        return Optional.empty();
    }

}

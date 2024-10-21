package dev.ssef.Pickleball_Tournement.teamFolder;

import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ssef.Pickleball_Tournement.playerFolder.Player;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<List<Team>>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable ObjectId id) {
        return new ResponseEntity<Team>(teamService.getTeamById(id), HttpStatus.OK);
    }

    @PostMapping("/{teamId}/players")
    public ResponseEntity<Team> addPlayerToTeam(@PathVariable String teamId, @RequestBody Player player) {
        Optional<Team> updatedTeam = teamService.addPlayerToTeam(teamId, player);
        if (updatedTeam.isPresent()) {
            return new ResponseEntity<>(updatedTeam.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

package dev.ssef.Pickleball_Tournement.gameSessionFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @PostMapping("/addSession")
    public void addSession(@RequestBody Session session) {
        sessionService.addSession(session);
    }

    @GetMapping("/isEmpty/{collectionName}")
    public ResponseEntity<Integer> isCollectionEmpty(@PathVariable String collectionName) {
        return new ResponseEntity<Integer>(sessionService.isCollectionEmpty(collectionName), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Session>> getAllSession() {
        return new ResponseEntity<List<Session>>(sessionService.getAllSession(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable String id) {
        return new ResponseEntity<Session>(sessionService.getSessionById(id), HttpStatus.OK);
    }

}

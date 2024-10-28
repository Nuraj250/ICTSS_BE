package com.esoft.ICTSS.controller;

import com.esoft.ICTSS.dto.PlaygroundDto;
import com.esoft.ICTSS.service.PlaygroundService;
import com.esoft.ICTSS.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playgrounds")
@Slf4j
@RequiredArgsConstructor
public class PlaygroundController {


    private final PlaygroundService playgroundService;

    /**
     * Adds a new playground.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addPlayground(@RequestBody PlaygroundDto playgroundDto) {
        PlaygroundDto playgroundAdded = playgroundService.addPlayground(playgroundDto);
        if (playgroundAdded != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(201, "Playground added successfully.", playgroundAdded));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(400, "Failed to add playgoround.", null));
    }

    /**
     * Updates an existing playground.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePlayground(@PathVariable Long id, @RequestBody PlaygroundDto playgroundDto) {
        try {
            playgroundService.updatePlayground(id, playgroundDto);
            return ResponseEntity.ok(new ResponseMessage(200,"Playground updated successfully.", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Deletes a playground by ID.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayground(@PathVariable Long id) {
        try {
            playgroundService.deletePlayground(id);
            return ResponseEntity.ok(new ResponseMessage(200,"Playground deleted successfully.", null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Retrieves a playground by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlaygroundById(@PathVariable Long id) {
        try {
            PlaygroundDto playgroundDto = playgroundService.getPlaygroundById(id);
            return ResponseEntity.ok(playgroundDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(404,e.getMessage(), null));
        }
    }

    /**
     * Retrieves all playgrounds.
     */
    @GetMapping("/all")
    public ResponseEntity<List<PlaygroundDto>> getAllPlaygrounds() {
        List<PlaygroundDto> playgrounds = playgroundService.getAllPlaygrounds();
        return ResponseEntity.ok(playgrounds);
    }
}

package br.com.vinicius.dslist.controllers;

import br.com.vinicius.dslist.dto.GameListDTO;
import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.dto.ReplacementDTO;
import br.com.vinicius.dslist.services.GameListService;
import br.com.vinicius.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> games = gameListService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.fingByList(listId);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

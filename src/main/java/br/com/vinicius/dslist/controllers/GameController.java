package br.com.vinicius.dslist.controllers;

import br.com.vinicius.dslist.dto.GameDTO;
import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll(){
        List<GameMinDTO> games = gameService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
        GameDTO dto = gameService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}

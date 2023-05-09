package br.com.vinicius.dslist.services;

import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.entities.Game;
import br.com.vinicius.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }
}

package br.com.vinicius.dslist.services;

import br.com.vinicius.dslist.dto.GameDTO;
import br.com.vinicius.dslist.dto.GameMinDTO;
import br.com.vinicius.dslist.entities.Game;
import br.com.vinicius.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}

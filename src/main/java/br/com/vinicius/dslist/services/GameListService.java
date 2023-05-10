package br.com.vinicius.dslist.services;

import br.com.vinicius.dslist.dto.GameListDTO;
import br.com.vinicius.dslist.entities.GameList;
import br.com.vinicius.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(x -> new GameListDTO(x)).collect(Collectors.toList());
    }
}

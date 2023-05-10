package br.com.vinicius.dslist.repositories;

import br.com.vinicius.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}

package br.com.vinicius.dslist.repositories;

import br.com.vinicius.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

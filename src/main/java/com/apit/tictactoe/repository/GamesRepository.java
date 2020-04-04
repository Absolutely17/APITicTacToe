package com.apit.tictactoe.repository;

import com.apit.tictactoe.entity.GamesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamesRepository extends JpaRepository<GamesEntity, Long> {
    @Query("from GamesEntity r where r.opened =:isOpened")
    List<GamesEntity> findOpenGames(@Param("isOpened") boolean isOpened);
    @Query("from GamesEntity r where (r.closedByPlayer <> true and r.winner is null)")
    List<GamesEntity> findAllGames();
}

package com.apit.tictactoe.service;

import com.apit.tictactoe.entity.GamesEntity;
import com.apit.tictactoe.request.MoveRequest;
import com.apit.tictactoe.response.ConnectResponse;
import com.apit.tictactoe.response.GameSimpleResponse;
import com.apit.tictactoe.response.MoveResponse;

import java.util.List;

public interface IGameService {
    List<GameSimpleResponse> getOpenGames();
    List<GameSimpleResponse> getAllGames();
    GamesEntity getGamesById(Long id);
    ConnectResponse edit(GamesEntity game);
    GameSimpleResponse addGame(String name);
    MoveResponse doMove(GamesEntity game, MoveRequest moveRequest);
    GameSimpleResponse exitGame(Long id, String name);
}

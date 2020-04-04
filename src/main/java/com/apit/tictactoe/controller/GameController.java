package com.apit.tictactoe.controller;

import com.apit.tictactoe.entity.GamesEntity;
import com.apit.tictactoe.request.MoveRequest;
import com.apit.tictactoe.response.GameSimpleResponse;
import com.apit.tictactoe.response.MoveResponse;
import com.apit.tictactoe.response.StateResponse;
import com.apit.tictactoe.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(
            method = RequestMethod.GET,
            path="/game/{id}/state",
            produces="application/json"
    )
    public StateResponse getState(@PathVariable(name="id") Long id)
    {
        return new StateResponse(gameService.getGamesById(id));
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/game/{id}/move",
            consumes="application/json",
            produces="application/json"
    )
    public MoveResponse moveTo(@PathVariable(name="id") Long id, @RequestBody MoveRequest moveRequest)
    {
        GamesEntity game = gameService.getGamesById(id);
        return gameService.doMove(game, moveRequest);
    }

    @RequestMapping(
            method=RequestMethod.POST,
            path="/game/{id}/exit",
            consumes="application/json",
            produces="application/json"
    )
    public GameSimpleResponse exitGame(@PathVariable(name="id") Long id, @RequestBody Map<String, String> request)
    {
        return gameService.exitGame(id, request.get("name"));
    }
}


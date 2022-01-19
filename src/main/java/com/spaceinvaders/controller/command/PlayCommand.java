package com.spaceinvaders.controller.command;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.Arena;
import com.spaceinvaders.model.ArenaBuilder;
import com.spaceinvaders.state.PlayingState;

public class PlayCommand extends ButtonCommand{
    protected PlayCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        Arena arena = new ArenaBuilder().createArena(game.getWidth(), game.getHeight());
        game.setGameState(new PlayingState(arena, game.getGui()));
    }
}

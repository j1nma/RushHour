package controller.handlers;

import controller.GameStateManager;
import controller.states.DifficultyMenuState;
import controller.states.State;
import view.panes.PlayMenuPane;

public class PlayMenuHandler extends Handler<PlayMenuPane>{

    public PlayMenuHandler(GameStateManager gsm, State state){
        super(gsm,state);
    }
    @Override
    public void handle(long now) {
        if(pane.isBackPressed()){
            gsm.pop();
        }
        if(pane.isSinglePlayerPressed()){
            gsm.push(new DifficultyMenuState(gsm));
        }
        if(pane.isTwoPlayersPressed()){
            gsm.push(new DifficultyMenuState(gsm));
        }
    }
}

package controller.handlers;

import controller.GameStateManager;
import controller.states.DifficultyMenuState;
import controller.states.InstructionsMenuState;
import controller.states.State;
import view.PlayMenuScene;

public class PlayMenuHandler extends Handler{

    private PlayMenuScene scene;

    public PlayMenuHandler(GameStateManager gsm, State state){
        super(gsm,state);
        scene = (PlayMenuScene) state.getScene();
    }
    @Override
    public void handle(long now) {
        if(scene.isBackPressed()){
            gsm.pop();
        }
        if(scene.isSinglePlayerPressed()){
            gsm.push(new DifficultyMenuState(gsm));
        }
        if(scene.isTwoPlayersPressed()){
            gsm.push(new DifficultyMenuState(gsm));
        }
    }
}

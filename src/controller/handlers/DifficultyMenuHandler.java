package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import view.DifficultyMenuScene;

public class DifficultyMenuHandler extends Handler{

    private DifficultyMenuScene scene;

    public DifficultyMenuHandler(GameStateManager gsm, State state) {
        super(gsm, state);
        scene = (DifficultyMenuScene) state.getScene();
    }

    @Override
    public void handle(long now) {
        if(scene.isEasyPressed()){
            System.out.println("Easy");
        }
        if(scene.isMediumPressed()){
            System.out.println("Medium");
        }
        if(scene.isHardPressed()){
            System.out.println("Hard");
        }
        if(scene.isExpertPressed()){
            System.out.println("Expert");
        }
        if(scene.isBackPressed()){
            gsm.pop();
        }
    }
}

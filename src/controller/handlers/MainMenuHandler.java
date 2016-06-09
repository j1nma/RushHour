package controller.handlers;

import controller.GameStateManager;
import controller.states.InstructionsMenuState;
import controller.states.PlayMenuState;
import controller.states.State;
import view.MainMenuScene;

public class MainMenuHandler extends Handler{

    private MainMenuScene scene;

    public MainMenuHandler(GameStateManager gsm, State state) {
        super(gsm,state);
        scene = (MainMenuScene) state.getScene();
    }

    @Override
    public void handle(long now) {
        if(scene.isPlayPressed()){
            gsm.push(new PlayMenuState(gsm));
        }

        if(scene.isLoadPressed()){
            System.out.println("Load");
        }

        if(scene.isInstructionsPressed()){
            gsm.push(new InstructionsMenuState(gsm));
        }
        if(scene.isExitPressed()){
            System.exit(0);
        }

    }
}

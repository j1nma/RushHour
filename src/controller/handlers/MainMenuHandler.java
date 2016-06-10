package controller.handlers;

import controller.GameStateManager;
import controller.states.InstructionsMenuState;
import controller.states.PlayMenuState;
import controller.states.State;
import view.GameScene;
import view.panes.MainMenuPane;

public class MainMenuHandler extends Handler<MainMenuPane>{

    public MainMenuHandler(GameStateManager gsm, State state) {
        super(gsm,state);
    }

    @Override
    public void handle(long now) {
        if(pane.isPlayPressed()){
            gsm.push(new PlayMenuState(gsm));
        }

        if(pane.isLoadPressed()){
//            gsm.push(new TestState(gsm,));
        }

        if(pane.isInstructionsPressed()){
            gsm.push(new InstructionsMenuState(gsm));
        }
        if(pane.isExitPressed()){
            System.exit(0);
        }

    }
}

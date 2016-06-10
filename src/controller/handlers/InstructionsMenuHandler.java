package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import view.panes.InstructionsMenuPane;

public class InstructionsMenuHandler extends Handler<InstructionsMenuPane>{

    public InstructionsMenuHandler(GameStateManager gsm, State state) {
        super(gsm, state);
    }

    @Override
    public void handle(long now) {
        if(pane.isBackPressed()){
            System.out.println("BACK PRESSED");
            gsm.pop();
        }
    }
}

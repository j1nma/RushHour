package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import view.panes.DifficultyMenuPane;

public class DifficultyMenuHandler extends Handler<DifficultyMenuPane>{

    public DifficultyMenuHandler(GameStateManager gsm, State state) {
        super(gsm, state);
    }

    @Override
    public void handle(long now) {
        if(pane.isEasyPressed()){
            System.out.println("Easy");
        }
        if(pane.isMediumPressed()){
            System.out.println("Medium");
        }
        if(pane.isHardPressed()){
            System.out.println("Hard");
        }
        if(pane.isExpertPressed()){
            System.out.println("Expert");
        }
        if(pane.isBackPressed()){
            gsm.pop();
        }
    }
}

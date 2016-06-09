package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import javafx.animation.AnimationTimer;

public abstract class Handler extends AnimationTimer{

    protected GameStateManager gsm;
    protected State state;

    Handler(GameStateManager gsm, State state){
        this.gsm = gsm;
        this.state = state;
    }

    public State getState(){
        return state;
    }
}

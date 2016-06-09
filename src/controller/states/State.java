package controller.states;

import controller.handlers.Handler;
import controller.GameStateManager;
import view.GameScene;

/*
    Comentario: puede ser que las clases xState sean redundantes,
    posiblemente reemplazar todas por un simple agregado del handelr al constructor
    sea una mejor implementacion.
 */


public abstract class State {
    protected GameStateManager gsm;
    protected Handler handler;
    protected GameScene scene;

    public State(GameStateManager gsm){
        this.gsm = gsm;
    }

    public void entered(){
        handler.start();
    }

    public void leaving(){
        handler.stop();
    }

    public GameScene getScene(){
        return scene;
    }


}

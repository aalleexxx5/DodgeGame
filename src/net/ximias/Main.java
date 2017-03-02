package net.ximias;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Program initializer and transient functions to allow a DrawableObject to removeObject itself or end the game
 */
public class Main {
	static Timer timer;
	static Game game;
	public static void main(String[] args) {
		game = new Game();
		timer = new Timer("game loop");
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				game.play();
			}
		},0,16);
    }

    //Transient functions

    public static void end(){
		game.end();
		timer.cancel();
	}

	public static void unregisterObject(DrawableObject o){
    	game.removeObject(o);
	}
	public static void registerObject(DrawableObject o){
		game.addObject(o);
	}
}

/*
Thread 1, game logic
Thread 2, Renderer
|------      |------      |-------------            |
|-------     |-------     |-------                  |-------
frame       frame        frame        skipped      frame



Vsync event
	if gamelogic is ready and renderer is ready
		Renderer.update
		gamelogic.update
 */
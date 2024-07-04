package com.bloodiey.game;


import com.bloodiey.GGL.*;
import com.bloodiey.GGL.GameLoop;
import com.bloodiey.GGL.SoundClip;
import com.bloodiey.GGL.Image;
import com.bloodiey.GGL.GenericRender;

public class GameManager extends Abstract {
	
	public SoundClip mus_title;
	public Image example;
	
	public GameManager() 
	{
		mus_title = new SoundClip("/music/mus_lib.mid");
		example = new Image("/sprites/example.png");
	}
	
	@Override
	public void update(GameLoop gc, float dt) {
		
	}

	@Override
	public void render(GameLoop gc, GenericRender r) {
		if(!mus_title.isRunning()) {
			mus_title.play();
		}
		
		r.clear(0xff000000);
		r.drawText("Use this as a library For Eclipse See documentation For more information", 0, 0, 0xffffffff);
		r.drawImage(example, 160-32, 120-32);
		//r.drawText("FPS: " + gc.getFps(), 0, 0, 0xffffffff);;
	}
	public static void main (String args[]) {
		GameLoop gc = new GameLoop(new GameManager());
		gc.start();
	}
	
}

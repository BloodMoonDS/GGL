package com.furside.game;

import java.awt.event.KeyEvent;

import com.furside.ovinEngine.Abstract;
import com.furside.ovinEngine.FormClass;
import com.furside.ovinEngine.GameLoop;
import com.furside.ovinEngine.Image;
import com.furside.ovinEngine.SoundClip;
import com.furside.ovinEngine.TiledImage;

import bx.generic.render.GenericRender;

public class GameManager extends Abstract {
	

	public GameManager() 
	{

	}
	
	@Override
	public void update(GameLoop gc, float dt) {

	}

	@Override
	public void render(GameLoop gc, GenericRender r) {
		r.clear();
		r.drawText("Use this as a library For Eclipse See documentation For more information", 0, 8, 0xffffffff);
		
	}
	public static void main (String args[]) {
		GameLoop gc = new GameLoop(new GameManager());
		gc.start();
	}
	
}

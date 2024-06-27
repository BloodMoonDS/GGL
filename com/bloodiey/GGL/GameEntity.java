package com.bloodiey.GGL;

public abstract class GameEntity {
	
	public int posx,posy;
	public float health;
	public abstract void entityUpdate(GameLoop gc, float dt);
	public abstract void entityRender(GameLoop gc, GenericRender r);
}

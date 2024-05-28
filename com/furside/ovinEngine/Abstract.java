package com.furside.ovinEngine;
import bx.generic.render.GenericRender;
public abstract class Abstract {

	public abstract void update(GameLoop gc, float dt);
	public abstract void render(GameLoop gc, GenericRender r);
}

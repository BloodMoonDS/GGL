package com.bloodiey.GGL;

public class Vector2 {
	
	public float xPos,yPos;
	
	public Vector2(float x, float y) 
	{
		xPos = x;
		yPos = y;
	}

	public void add(float x, float y) {
		xPos += x;
		yPos += y;
	}
	public void subtract(float x, float y) {
		xPos -= x;
		yPos -= y;
	}
	
}

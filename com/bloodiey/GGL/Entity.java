package com.bloodiey.GGL;

public class Entity extends Abstract{

	public Vector2 Position = new Vector2(0,0);
	public Vector2 Size = new Vector2(0,0);
	public int SpritePosX = 0,SpritePosY = 0;
	
	public TiledImage Img;
	
	public Entity(String ImagePath, Vector2 Pos, Vector2 S, int TileWidth, int TileHeight)
	{
		Img = new TiledImage(ImagePath, TileWidth, TileHeight);
		Position = Pos;
		Size = S;
	}	
	
	@Override
	public void update(GameLoop gc, float dt) {
		
	}

	@Override
	public void render(GameLoop gc, GenericRender r) {
		r.drawTiledImage(Img, (int)Position.xPos, (int)Position.yPos, SpritePosX, SpritePosY);
		
		
	}
	public void move(float x,float y) {
		Position.add(x, y);
		
	}
	public void setImage(String Path, int TileSizeX,int TileSizeY) 
	{
		Img = new TiledImage(Path, TileSizeX, TileSizeY);
		
	}
	public void setTilePos(int TX,int TY)
	{
		SpritePosX = TX;
		SpritePosY = TY;
	}	
	public void updateEntity(GameLoop Gl, GenericRender Gr, float dt) {
		this.render(Gl, Gr);
		this.update(Gl, dt);
	}
}

package com.bloodiey.GGL;

public class TiledImage extends Image{
	
	private int TileW, TileH;
	
	public TiledImage(String Path, int TileW, int TileH) {
		
		super(Path);
		this.TileH = TileH;
		this.TileW = TileW;
	}

	public int getTileW() {
		return TileW;
	}

	public void setTileW(int tileW) {
		TileW = tileW;
	}

	public int getTileH() {
		return TileH;
	}

	public void setTileH(int tileH) {
		TileH = tileH;
	}
	
}

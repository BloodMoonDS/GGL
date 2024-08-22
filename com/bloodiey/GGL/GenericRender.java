package com.bloodiey.GGL;

import java.awt.image.DataBufferInt;



public class GenericRender {
  private int pW;
  
  private int pH;
  
  private int[] p;
  
  private Font font = Font.STANDARD;
  
  public GenericRender(GameLoop gc) {
    this.pH = gc.getHeight();
    this.pW = gc.getWidth();
    this.p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
  }
  
  public void clear(int color) {
    for (int i = 0; i < this.p.length; i++) {
      this.p[i] = color;
      //this.p[i] = this.p[i] +i; 
    }
  }
  public void colorswitch() {
	    for (int i = 0; i < this.p.length; i++) {
	      //this.p[i] = 0x000000; //clears the screen with a black background
	      this.p[i] = this.p[i] +i; //render testing doesn't do anything useful
	    }
	  }
  public void SetPixel(int x, int y, int value) {
	  if ((x<0 || x >= pW || y<0 || y >=pH) || value == 0xffff00ff || value == 0xff00ff || value == 0x00000000) //doesn't render the pixels if they're full alpha or a pink color
	  {
		  return;
	  }
	  p[x + y * pW] = value;
	  
  }
  public void addcolor(int add) {
	    for (int i = 0; i < this.p.length; i++) {
	      //this.p[i] = 0x000000;
	      //this.p[i] = this.p[i] +i;
	    this.p[i] = this.p[i] + add; 
	    }
	  }
  public void multiplycolor(int add) {
	    for (int i = 0; i < this.p.length; i++) {
	      //this.p[i] = 0x000000;
	      //this.p[i] = this.p[i] +i;
	    this.p[i] = this.p[i] * add; 
	    }
	  }
  public void subtractaddcolor(int add) {
	    for (int i = 0; i < this.p.length; i++) {
	      //this.p[i] = 0x000000;
	      //this.p[i] = this.p[i] +i;
	    this.p[i] = this.p[i] - add; 
	    }
	  }
  
  public void drawImage(Image image,int offx,int offy) {
	  //don't render if it is not on Screen
	  if(offx < -image.getW()) return;
	  if(offy < -image.getH()) return;
	  if(offx >= pW) return;
	  if(offy >= pH) return;
	  
	  int NewX=0,NewY=0,NewW=image.getW(),NewH=image.getH();
	 
	  //clipping code
	  if(NewX + offx < 0){NewX =-offx;}
	  if(NewY + offy < 0){NewY =-offy;}
	  if(NewW + offx >= pW){NewW -= NewW + offx -pW;}
	  if(NewH + offy >= pH){NewH -= NewH + offy -pH;}
	  //otherwise do it
	  for(int y = NewY; y < NewH; y++) 
	  {
		  for(int x = NewX; x < NewW; x++) {	  
			  SetPixel(x + offx,y + offy, image.getP()[x+y*image.getW()]);
		  }
	  }
  }
  
  public void drawText(String Text, int offx, int offy, int color) {
	  Text = Text.toUpperCase();
	  Image FontImage = font.getFontImage();
	  int offset = 0;
	  for(int i = 0; i < Text.length(); i++) {
		  
		  
		  int unicode = Text.codePointAt(i) -32;
		  
		  for(int y = 0; y<FontImage.getH(); y++) 
		  {
			  for(int x = 0; x < font.getWidths()[unicode]; x++) {
				  if(FontImage.getP()[(x+font.getOffsets()[unicode])+(y)*FontImage.getW()]==0xffffffff) 
				  {
					  SetPixel(x+offx+offset,y+offy,color);
				  }
				  
			  }
		  }
		  offset += font.getWidths()[unicode];
	  }
  }
  
  public void drawTiledImage (TiledImage tiledImage, int offx,int offy, int TileX,int TileY) 
  {
	//don't render if it is not on Screen
	  if(offx < -tiledImage.getTileW()) return;
	  if(offy < -tiledImage.getTileH()) return;
	  if(offx >= pW) return;
	  if(offy >= pH) return;
	  
	  int NewX=0,NewY=0,NewW=tiledImage.getTileW(),NewH=tiledImage.getTileH();
	 
	  //clipping code
	  if(NewX + offx < 0){NewX =-offx;}
	  if(NewY + offy < 0){NewY =-offy;}
	  if(NewW + offx >= pW){NewW -= NewW + offx -pW;}
	  if(NewH + offy >= pH){NewH -= NewH + offy -pH;}
	  //otherwise do it
	  for(int y = NewY; y < NewH; y++) 
	  {
		  for(int x = NewX; x < NewW; x++) {	  
			  SetPixel(x + offx,y + offy, tiledImage.getP()[(x+TileX*tiledImage.getTileW())+(y+TileY*tiledImage.getTileH())*tiledImage.getW()]);
		  }
	  }
	  
  }

public int[] getP() {
	return p;
}

public void setP(int[] p) {
	this.p = p;
}

public Font getFont() {
	return font;
}

public void setFont(Font font) {
	this.font = font;
}
  
  
  
  
  
  
}



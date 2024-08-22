package com.bloodiey.GGL;
import java.awt.event.KeyEvent;
import java.io.IOException;



public class GameLoop implements Runnable {
  private GenericRender Bx_generic;
  private Input inp;
  public Input getInp() {
	return inp;
}

private Thread thread;
  private Abstract game;
  private FormClass window;
  public SoundClip StartChime = new SoundClip("/sounds/snd_launch.wav");
  public boolean running = false;
  
  public final double FRAMERATE = 64;
  
  public final double UPDATE_CAP = 1.0/FRAMERATE;
  
  private int fps;
  
  public int width = 320;
  
  public int height = 240;
  
  public float scale = 2F;
  
  public String title = "Generic Game Library";
  
  public String iconDir= "assets/icon/icon.png"; // default Icon for program
  
  public GameLoop(Abstract game)
  {
	  StartChime = new SoundClip("/sounds/snd_launch.wav");
	  this.game = game;
	  
  }
  
  
  public void start() {
	StartChime.play();
    this.window = new FormClass(this);
    this.thread = new Thread(this);
    this.Bx_generic = new GenericRender(this);
    this.inp = new Input(this);
    this.thread.run();
  }
  
  public void stop() {thread.stop();}
  
  public void run() {
	this.window.SetImage(iconDir);
    this.running = true;
    boolean render = false;
    double firstTime = 0.0D;
    double lastTime = System.nanoTime() / 1.0E9D;
    double passedTime = 0.0D;
    double unprocessedTime = 0.0D;
    double frameTime = 0.0D;
    int frames = 0;
    fps = 0;
    while (this.running) {
    	
      render = false;
      firstTime = System.nanoTime() / 1.0E9D;
      passedTime = firstTime - lastTime;
      lastTime = firstTime;
      unprocessedTime += passedTime;
      frameTime += passedTime;
      while (unprocessedTime >= UPDATE_CAP) {
        unprocessedTime -= UPDATE_CAP;
        render = true;
       
        game.update(this, (float)UPDATE_CAP);
        inp.update();
        
        if (frameTime >= 1.0D) {
          frameTime = 0.0D;
          fps = frames;
          frames = 0;
          //System.out.println("FPS :" + fps);
          
        } 
      } 
      if (render) {
        //this.Bx_generic.clear();
        game.render(this, Bx_generic);
        //this.Bx_generic.drawText("FPS: " + fps, 0, 0, 0xffffffff);
        this.window.update();
        frames++;
        continue;
      } 
      try {
        Thread.sleep(1L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } 
    } 
    dispose();
  }
  
  private void dispose() {}
  
  
  public int getWidth() {
    return this.width;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public void setHeight(int height) {
    this.height = height;
  }
  
  public float getScale() {
    return this.scale;
  }
  
  public void setScale(float scale) {
    this.scale = scale;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String title) {
    this.title = title;
    window.SetTitle(title);
    window.UpdateForm();
  }
  
  public FormClass getWindow() {
    return this.window;
  }


  public int getFps() {
	return fps;
  }


public SoundClip getStartChime() {
	return StartChime;
}


public void setStartChime(SoundClip startChime) {
	StartChime = startChime;
}


public String getIconDir() {
	return iconDir;
}


public void setIconDir(String iconDir) {
	this.iconDir = iconDir;
}
  
  
}


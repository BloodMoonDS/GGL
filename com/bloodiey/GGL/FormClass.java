package com.bloodiey.GGL;
import javax.imageio.ImageIO;
import javax.naming.SizeLimitExceededException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
public class FormClass extends JFrame {
    /**
	 * 
	 */
	public BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	public Cursor blankCursor = this.getToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
	private static final long serialVersionUID = 1L;
	public JFrame frame;
    public int SizeX=320;
    public int SizeY=240;
    public String Title = "Window";
    public void Load(){
        frame.setSize(SizeX,SizeY);
        frame.setTitle(Title);
    }
    public void SetImage(String ImageDir) throws IOException{
        File sourceimage = new File(ImageDir);
        Image image = ImageIO.read(sourceimage);
        frame.setIconImage(image);
    }

    public void SetTitle(String Title)
    {
        frame.setTitle(Title);
    }
    public void setWebIcon(String Url) throws Exception{
        // WARNING MALFUNCTIONING
        String destinationFile = "assets/icon/icon.jpg";
        URL Cururl = new URL(destinationFile);
        saveImage(Url, destinationFile);
        BufferedImage image = null;
        image = ImageIO.read(Cururl);
        frame.setIconImage(image);
        
    }

    public void Show(){
        frame.setVisible(true);

    }

    public static void saveImage(String imageUrl, String destinationFile) throws Exception {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
    
        byte[] b = new byte[2048];
        int length;
    
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
    
        is.close();
        os.close();
    }    
    public void ChangeTitleValue(String TextTitle){
        Title = TextTitle;

    }
    public void UpdateForm(){
        frame.setSize(SizeX,SizeY);
        frame.setTitle(Title);
    }
    public void SetSizeXValue(int x){
        SizeX = x;
    }
    public void SetSizeYValue(int y){
        SizeY = y;
    }
    
  
  private BufferedImage image;
  
  private Canvas canvas;
  
  private BufferStrategy bs;
  
  private Graphics g;
  
  public FormClass(GameLoop gc) {
	this.setCursor(blankCursor);
    this.image = new BufferedImage(gc.getWidth(), gc.getHeight(), 1);
    this.canvas = new Canvas();
    Dimension s = new Dimension((int)(gc.getWidth() * gc.getScale()), (int)(gc.getHeight() * gc.getScale()));
    this.canvas.setPreferredSize(s);
    this.canvas.setMaximumSize(s);
    this.canvas.setMinimumSize(s);
    this.frame = new JFrame(gc.getTitle());
    this.frame.setDefaultCloseOperation(3);
    this.frame.setLayout(new BorderLayout());
    this.frame.add(this.canvas, "Center");
    this.frame.pack();
    this.frame.setLocationRelativeTo((Component)null);
    this.frame.setResizable(false);
    this.frame.setVisible(true);
    this.canvas.createBufferStrategy(4);
    this.bs = this.canvas.getBufferStrategy();
    this.g = this.bs.getDrawGraphics();
  }
  
  public void update() {
    this.g.drawImage(this.image, 0, 0, this.canvas.getWidth(), this.canvas.getHeight(), null);
    this.bs.show();
  }
  
  public BufferedImage getImage() {
    return this.image;
  }
  
  public Canvas getCanvas() {
    return this.canvas;
  }
  public void HideCursor() {
	  this.setCursor(blankCursor);
	 
  }
  public void ShowCursor() {
	  this.setCursor(Cursor.getDefaultCursor());
  }
}



  
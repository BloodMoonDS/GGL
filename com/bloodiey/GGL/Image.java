package com.bloodiey.GGL;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Image {
	private int W,h;
	private int[] p;
	public Image(String Path) {
		
		BufferedImage image = null;
		
		
		try {
		if(Image.class.getResourceAsStream(Path)==null) {
			JOptionPane.showMessageDialog(null,Path + " Leads To a Null image \n");
		}	
		else {
			image = ImageIO.read(Image.class.getResourceAsStream(Path));
		}
		} catch (IOException e) {
			SoundClip errsnd = new SoundClip("/sounds/snd_crash.wav");
			JOptionPane.showMessageDialog(null,Path + " Caused an error Advanced Details: \n" + e);
			System.out.println("Error While getting your Image");
			FileSaver sav = new FileSaver();
			sav.Writefile("Image Error", "Exception: " + e);
			e.printStackTrace();
		}
		
		W = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, W, h, null, 0, W);
		
		image.flush();
	}
	public int getW() {
		return W;
	}
	public void setW(int w) {
		W = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int[] getP() {
		return p;
	}
	public void setP(int[] p) {
		this.p = p;
	}
	
	
}

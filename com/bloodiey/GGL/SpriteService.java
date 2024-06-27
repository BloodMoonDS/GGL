package com.bloodiey.GGL;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteService {
	
	public void Drawimage(BufferedImage fc, BufferedImage img) {
		Graphics2D ap = fc.createGraphics();
		ap.drawImage(img, 0, 0, 0, 0, 0, 0, 0, 0, null);
		ap.dispose();
		
	}
	public BufferedImage Getimage(String ImageDir) throws IOException {
		 File sourceimage = new File(ImageDir);
	     Image image = ImageIO.read(sourceimage);
		
		return (BufferedImage) image;
	}
	
}

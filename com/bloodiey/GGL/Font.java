package com.bloodiey.GGL;

public class Font {
	
	public static final Font STANDARD = new Font("/fonts/font.png");
	
	private Image FontImage;
	private int[] offsets;
	private int[] widths;
	
	public Font(String Path) {
		FontImage = new Image(Path);
		
		offsets = new int[149186];
		widths = new int[149186];
		
		int unicode = 0;
		
		for(int i = 0; i < FontImage.getW(); i++) {
			
			if(FontImage.getP()[i]== 0xff0000ff) {
				
				offsets[unicode] = i;
				
			}
			if(FontImage.getP()[i]== 0xffffff00) {
				
				widths[unicode] = i - offsets[unicode];
				unicode++;
			}
			
		}
	}

	public Image getFontImage() {
		return FontImage;
	}

	public void setFontImage(Image fontImage) {
		FontImage = fontImage;
	}

	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int[] getWidths() {
		return widths;
	}

	public void setWidths(int[] widths) {
		this.widths = widths;
	}
}

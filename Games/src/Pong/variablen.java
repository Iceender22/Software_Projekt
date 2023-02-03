package Pong;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class variablen {

	static int screenwidth = 800, screenheight = 600;
	
	static boolean moveup = false, movedown = false;
	static boolean moveup2 = false, movedown2 = false;
	
	static int p1x = 20, p1y = 185;
	static int p2x = 755, p2y = 185;
	
	static int balldirx = 1, balldiry = -1;
	
	static Font font;
	
	public variablen() {
	
		try {
			
			font = Font.createFont(Font.TRUETYPE_FONT, new File("res/PixelTandysoft-0rJG.ttf")).deriveFont(100f);
			//font = Font.createFont(Font.TRUETYPE_FONT, new File("res/coders_crux.ttf")).deriveFont(125f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/PixelTandysoft-0rJG.ttf")));
			//ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/coders_crux.ttf")));
		} catch (FontFormatException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
}

package jvmlegend.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public double worldX, worldY;
	public double screenX, screenY;
	public double speed, vy;
	public double g = 0.8;
	
	public BufferedImage left, right;
	
	public Rectangle solidArea;
	
	public String direction = "right";
}

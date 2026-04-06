package jvmlegend.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import jvmlegend.main.GamePanel;
import jvmlegend.main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValue();
		getPlayerImage();
	}
	private void setDefaultValue() {
		solidArea = new Rectangle(13*2, 11*2, 22*2, 32*2);
		
		worldX = gp.tileSize;
		worldY = gp.ground - solidArea.y - solidArea.height;
		screenX = gp.tileSize;
		screenY = gp.ground - gp.playerSize;
		speed = 3;
	}
	private void getPlayerImage() {
		try {
			left = ImageIO.read(getClass().getResourceAsStream("/player/jvm_left.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/player/jvm_right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		//move
		if (keyH.leftPressed) {
			worldX -= speed;
			screenX -= speed;
			direction = "left";
		}
		else if (keyH.rightPressed) {
			worldX += speed;
			screenX += speed;
			direction = "right";
		}
		
		//jump
		if (keyH.startJumping) {
			keyH.startJumping = false;
			keyH.isJumping = true;
			vy = -15;
		}
		if (keyH.isJumping) {
			worldY += vy;
			screenY += vy;
			vy += g;
			if (gp.ground - (worldY + solidArea.y) < solidArea.height) {
				worldY = gp.ground - solidArea.y - solidArea.height;
				vy = 0;
				keyH.isJumping = false;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch (direction) {
		case "left":
			image = left;
			break;
		case "right":
			image = right;
			break;
		}
		
		g2.drawImage(image, (int)worldX, (int)worldY, gp.playerSize, gp.playerSize, null);
	}
}

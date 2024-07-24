package realms.node;

import realms.data.Texture;

import java.awt.*;

public class SpriteNode extends Node
{
	public Texture texture;

	public SpriteNode(double x, double y, double width, double height, Texture texture)
	{
		super(x, y, width, height);
		this.texture = texture;
	}

	@Override
	public void draw(Graphics2D g)
	{
		super.draw(g);
		g.drawImage(texture.bufferedImage, (int)getX(), (int)getY(), (int)width, (int)height, null);
	}
}

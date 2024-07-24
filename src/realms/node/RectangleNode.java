package realms.node;

import realms.data.Colour;

import java.awt.*;

public class RectangleNode extends Node
{
	public Colour colour;

	public RectangleNode(double x, double y, double width, double height, Colour colour)
	{
		super(x, y, width, height);
		this.colour = colour;
	}

	@Override
	public void draw(Graphics2D g)
	{
		super.draw(g);
		g.setColor(colour.toAwt());
		g.fillRect((int)getX(), (int)getY(), (int)width, (int)height);
	}
}

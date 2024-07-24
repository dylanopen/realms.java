package realms.node;

import realms.data.Colour;
import realms.data.Font;

import java.awt.*;

public class TextNode extends Node
{
	public Font font;
	public String text;
	public Colour colour;

	public TextNode(double x, double y, Font font, Colour colour, String text)
	{
		super(x, y, 0, 0);
		this.font = font;
		this.text = text;
		this.colour = colour;
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setFont(font.getAwt());
		g.setColor(colour.toAwt());
		g.drawString(text, (int)getX(), (int)getY());
	}
}

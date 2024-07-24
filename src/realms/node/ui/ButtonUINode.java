package realms.node.ui;

import jdk.jfr.Experimental;
import realms.data.Colour;
import realms.node.RectangleNode;
import realms.node.RectangleOutlineNode;

@Experimental
public class ButtonUINode extends UINode
{
	public Colour outlineColour;
	public Colour fillColour;

	private RectangleNode fillNode;
	private RectangleOutlineNode outlineNode;

	public ButtonUINode(double x, double y, double width, double height, Colour fillColour, Colour outlineColour)
	{
		super(x, y, width, height);
		this.fillColour = fillColour;
		fillNode = new RectangleNode(0, 0, width, height, fillColour);
		outlineNode = new RectangleOutlineNode(0, 0, width, height, outlineColour);
		addChild(fillNode);
		addChild(outlineNode);
	}

	public void update()
	{
		super.update();

		Colour fill = new Colour(fillColour.r, fillColour.g, fillColour.b, fillColour.a);

		if (pressed())
		{
			fill.r = (int) Math.min(fill.r * 1.2 + 18, 255);
			fill.g = (int) Math.min(fill.g * 1.2 + 18, 255);
			fill.b = (int) Math.min(fill.b * 1.2 + 18, 255);
		}
		else if (hovered())
		{
			fill.r = (int) Math.min(fill.r * 1.1 + 12, 255);
			fill.g = (int) Math.min(fill.g * 1.1 + 12, 255);
			fill.b = (int) Math.min(fill.b * 1.1 + 12, 255);
		}
		else
		{
			fill = fillColour;
		}

		fillNode.colour = fill;
	}
}

package realms.node;

import realms.data.Colour;
import realms.window.Realm;

import java.awt.*;

public class FillNode extends Node
{
	public Colour colour;
	public RectangleNode rectangle;

	public FillNode(Colour colour)
	{
		rectangle = new RectangleNode(
			0, 0,
			Realm.realm.getWindow().getWidth(),
			Realm.realm.getWindow().getHeight(),
			colour
		);
		this.addChild(rectangle);
	}
}

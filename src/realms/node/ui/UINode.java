package realms.node.ui;

import jdk.jfr.Experimental;
import realms.input.Mouse;
import realms.node.Node;

@Experimental
public class UINode extends Node
{
	private boolean isHovered = false;
	private boolean isPressed = false;
	private boolean justClicked = false;

	public UINode(double x, double y, double width, double height)
	{
		super(x, y, width, height);
		moveWithCamera = false;
	}

	public void click()
	{
		justClicked = true;
	}

	public void unclick()
	{
		justClicked = false;
	}

	public boolean clicked()
	{
		boolean result = justClicked;
		unclick();
		return result;
	}

	public void press()
	{
		isPressed = true;
	}

	public void unpress()
	{
		isPressed = false;
	}

	public boolean pressed()
	{
		return isPressed;
	}

	public void hover()
	{
		isHovered = true;
	}

	public void unhover()
	{
		isHovered = false;
	}

	public boolean hovered()
	{
		boolean result = isHovered;
		unhover();
		return result;
	}

	public void update()
	{
		super.update();

		Node mousePosNode = new Node(Mouse.x, Mouse.y, 1, 1, false);
		mousePosNode.moveWithCamera = false;

		unhover(); // reset and check again
		unpress();

		if (mousePosNode.isTouching(this))
		{
			hover();

			if (Mouse.justClicked)
				click();

			if (Mouse.isDown)
				press();
		}
	}
}

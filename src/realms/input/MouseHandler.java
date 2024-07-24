package realms.input;

import realms.window.Realm;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener
{
	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{
		Mouse.justClicked = true;
		Mouse.clickX = mouseEvent.getX();
		Mouse.clickY = mouseEvent.getY();
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{
		Mouse.isDown = true;
		Mouse.pressX = mouseEvent.getX();
		Mouse.pressY = mouseEvent.getY();
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{
		Mouse.isDown = false;
		Mouse.releaseX = mouseEvent.getX();
		Mouse.releaseY = mouseEvent.getY();
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent)
	{	}

	@Override
	public void mouseExited(MouseEvent mouseEvent)
	{	}

	public void updatePosition()
	{
		Mouse.justClicked = false;

		Point mousePos = Realm.realm.getWindow().getPanel().getMousePosition();
		if (mousePos != null)
		{
			Mouse.x = mousePos.x;
			Mouse.y = mousePos.y;
		}
	}
}

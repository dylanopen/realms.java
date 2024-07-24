package realms.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent keyEvent)
	{

	}

	@Override
	public void keyPressed(KeyEvent keyEvent)
	{
		int keyCode = keyEvent.getKeyCode();
		Keyboard.setKeyState(keyCode, true);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent)
	{
		int keyCode = keyEvent.getKeyCode();
		Keyboard.setKeyState(keyCode, false);
	}
}

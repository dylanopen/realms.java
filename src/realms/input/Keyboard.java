package realms.input;

public class Keyboard
{
	private static boolean[] keyStates = new boolean[65536];

	public static void setKeyState(int keyCode, boolean isPressed)
	{
		if (keyCode >= keyStates.length)
		{
			System.out.println("Realms Error: Key code '" + keyCode + "' is too large (max is '" + keyStates.length + "').");
			System.exit(128);
		}
		keyStates[keyCode] = isPressed;
	}

	public static boolean isDown(int keyCode)
	{
		return keyStates[keyCode];
	}
}

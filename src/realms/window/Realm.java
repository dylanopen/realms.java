package realms.window;

public class Realm
{
	public static Realm realm;

	private Window window;
	public boolean isRunning = false;
	public double targetFPS = 60.0;

	public double cameraX, cameraY = 0.0;

	public int iterations = 0;

	public Realm(String title, int width, int height)
	{
		Realm.realm = this;
		this.window = new Window(title, width, height);
	}

	public Window getWindow()
	{
		return window;
	}

	public void run(Loop loop)
	{
		isRunning = true;
		loop.start();
	}
}

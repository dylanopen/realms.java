package realms.data;

public class Time
{
	public static double delta;
	public static double fps;
	public static double lastFrame = (double)System.nanoTime() * 1e-9;
	public static double spareFrameTime = 0.0;

	public static long elapsedFrames = 0;

	public static void newFrame(double targetFPS)
	{
		elapsedFrames++;
		double newTime = (double)System.nanoTime() * 1e-9;
		delta = newTime - lastFrame;
		lastFrame = newTime;
		fps = 1.0 / delta;
		spareFrameTime = 1.0 / targetFPS - delta;
	}
}

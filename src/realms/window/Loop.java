package realms.window;

import realms.data.Time;
import realms.node.Node;

public class Loop implements Runnable
{
	private final Thread thread;

	public Loop()
	{
		thread = new Thread(this);
	}

	public void start()
	{
		thread.start();
	}

	protected void update()
	{
		Realm.realm.iterations++;
		Time.newFrame(Realm.realm.targetFPS);
		Node.updateAll();

		Panel panel = Realm.realm.getWindow().getPanel();
		panel.mouseHandler.updatePosition();
	}

	private void draw()
	{
		Realm.realm.getWindow().getPanel().repaint();
	}

	@Override
	public void run()
	{
		double nanoDrawInterval = 1e9 / Realm.realm.targetFPS;
		double frameDelta = 0.0;
		long lastNanoTime = System.nanoTime();
		long currentNanoTime;

		while (Realm.realm.isRunning)
		{
			currentNanoTime = System.nanoTime();
			frameDelta += (currentNanoTime - lastNanoTime) / nanoDrawInterval;
			lastNanoTime = currentNanoTime;
			if (frameDelta < 1) continue;
			Node.pushQueuedNodes();
			update();
			draw();
			frameDelta--;
		}

	}
}

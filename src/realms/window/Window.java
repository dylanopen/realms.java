package realms.window;

import realms.input.KeyboardHandler;
import realms.input.MouseHandler;

import javax.swing.*;

public class Window
{
	private String title;
	private int width, height;
	private JFrame frame;
	private Panel panel;

	public Window(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		createJFrame();
	}

	private void createJFrame()
	{
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(title);

		panel = new Panel(width, height);
		frame.add(panel);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public JFrame getFrame()
	{
		return frame;
	}

	public Panel getPanel()
	{
		return panel;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}

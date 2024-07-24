package realms.window;

import realms.data.Colour;
import realms.input.KeyboardHandler;
import realms.input.MouseHandler;
import realms.node.Node;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel
{
	private KeyboardHandler keyboardHandler = new KeyboardHandler();
	MouseHandler mouseHandler = new MouseHandler();

	public Panel(int width, int height)
	{
		super.setPreferredSize(new Dimension(width, height));
		super.setBackground(new Colour(14, 18, 22).toAwt());
		super.setDoubleBuffered(true);
		super.addKeyListener(keyboardHandler);
		super.addMouseListener(mouseHandler);
		super.setFocusable(true);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		Node.drawAll(g2);
		g2.dispose();
	}
}

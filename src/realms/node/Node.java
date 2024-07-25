package realms.node;

import realms.window.Realm;

import java.awt.*;
import java.util.ArrayList;

public class Node
{
	private static ArrayList<Node> allNodes = new ArrayList<>();

	public static void updateAll()
	{
		for (Node node : allNodes)
		{
			node.update();
		}
	}

	public static void drawAll(Graphics2D g)
	{
		for (Node node : allNodes)
		{
			// Basic frustum culling (off-screen images are not drawn)
			if (node.getX() + node.width <= 0.0 || node.getY() + node.height <= 0.0) continue;
			if (node.getX() >= Realm.realm.getWindow().getWidth() || node.getY() >= Realm.realm.getWindow().getHeight()) continue;
			if (!node.isVisible()) continue;

			node.draw(g);
		}
	}

	public Node parent = null;
	public ArrayList<Node> children = new ArrayList<>();
	public double x, y;
	public double width, height;
	public boolean moveWithCamera = true;
	public boolean visible = true;

	public Node(double x, double y, double width, double height, boolean addToList)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if (addToList)
			allNodes.add(this);
	}

	public Node(double x, double y, double width, double height)
	{
		this(x, y, width, height, true);
	}

	public Node()
	{
		this(0, 0, 0, 0);
	}

	public void update()
	{

	}

	public void draw(Graphics2D g)
	{

	}

	public boolean isTouching(Node otherNode)
	{
		double x1 = this.getX();
		double y1 = this.getY();
		double x2 = otherNode.getX();
		double y2 = otherNode.getY();
		double w1 = this.width;
		double h1 = this.height;
		double w2 = otherNode.width;
		double h2 = otherNode.height;

		return (x1 < x2 + w2) &&
		       (x1 + w1 > x2) &&
		       (y1 < y2 + h2) &&
		       (y1 + h1 > y2);
	}

	public void addChild(Node childNode)
	{
		this.children.add(childNode);
		childNode.parent = this;
	}

	public ArrayList<Node> getChildrenRecursive()
	{
		ArrayList<Node> childNodes = new ArrayList<>();
		for (Node childNode : children)
		{
			childNodes.addAll(childNode.getChildrenRecursive());
			childNodes.add(childNode);
		}
		return childNodes;
	}

	public boolean isVisible()
	{
		if (parent == null)
			return this.visible;
		return this.visible && parent.isVisible();
	}

	public double getX()
	{
		if (parent == null)
			if (moveWithCamera)
				return this.x - Realm.realm.cameraX;
			else
				return this.x;
		return parent.getX() + this.x;
	}

	public double getY()
	{
		if (parent == null)
			if (moveWithCamera)
				return this.y - Realm.realm.cameraY;
			else
				return this.y;
		return parent.getY() + this.y;
	}

	public void delete()
	{
		for (Node childNode : getChildrenRecursive())
		{
			Node.allNodes.remove(childNode);
		}
		Node.allNodes.remove(this);
	}

}

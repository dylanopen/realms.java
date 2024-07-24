package realms.data;

import java.awt.Color;

public class Colour
{
	public int r, g, b, a;

	public Colour(int r, int g, int b, int a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public Colour(int r, int g, int b)
	{
		this(r, g, b, 255);
	}

	public Color toAwt()
	{
		return new Color(r, g, b, a);
	}
}

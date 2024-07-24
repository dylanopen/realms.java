package realms.data;

public class Font
{
	public static final int REGULAR = 0;
	public static final int BOLD = 1;
	public static final int ITALIC = 2;

	private java.awt.Font awtFont;

	private String name;
	private int mods;
	private int size;

	public Font(String name, int mods, int size)
	{
		this.name = name;
		this.mods = mods;
		this.size = size;
		awtFont = new java.awt.Font(name, mods, size);
	}

	public java.awt.Font getAwt()
	{
		return awtFont;
	}
}

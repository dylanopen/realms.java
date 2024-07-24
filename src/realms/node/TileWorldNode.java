package realms.node;

import realms.data.Texture;
import realms.data.TextureSet;

import java.util.ArrayList;
import java.util.List;

public class TileWorldNode extends Node
{
	private int columns, rows;
	private double tileWidth, tileHeight;
	private List<Integer> tiles;
	private TextureSet tileSet;
	private List<SpriteNode> tileSprites;

	public TileWorldNode(
		double x, double y,
		int columns, int rows,
		double tileWidth, double tileHeight,
		TextureSet tileSet,
		List<Integer> tiles
	)
	{
		super(x, y, columns*tileWidth, rows*tileHeight);
		this.columns = columns;
		this.rows = rows;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.tileSet = tileSet;
		this.tiles = tiles;
		createTileSprites();
	}

	public int getColumns()
	{
		return columns;
	}

	public int getRows()
	{
		return rows;
	}

	public int get(int index)
	{
		return tiles.get(index);
	}

	public int get(int x, int y)
	{
		return tiles.get(y * columns + x);
	}

	public int getAtPixel(double xPixel, double yPixel)
	{
		double xPos = xPixel - getX();
		double yPos = yPixel - getY();
		int tileX = (int) (xPos / tileWidth);
		int tileY = (int) (yPos / tileHeight);
		if (tileX < 0 || tileY < 0 || tileX >= columns || tileY >= rows) return -1;
		return tileY * columns + tileX;
	}

	private void createTileSprites()
	{
		tileSprites = new ArrayList<>();
		for (int y = 0; y < rows; y++)
		{
			for (int x = 0; x < columns; x++)
			{
				Texture texture = tileSet.get(tiles.get(y*columns + x));
				SpriteNode spriteNode = new SpriteNode(x*tileWidth, y*tileHeight, tileWidth, tileHeight, texture);
				this.addChild(spriteNode);
				tileSprites.add(spriteNode);
			}
		}
	}
}

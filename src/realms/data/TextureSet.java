package realms.data;

import java.util.List;
import java.util.Arrays;

public class TextureSet
{
	private List<Texture> textures;

	public TextureSet(List<Texture> textures)
	{
		this.textures = textures;
	}

	public TextureSet(Texture[] textures)
	{
		this(Arrays.asList(textures));
	}

	public Texture get(int index)
	{
		return textures.get(index);
	}

	public void update(int index, Texture newTexture)
	{
		textures.set(index, newTexture);
	}

	public void add(Texture texture)
	{
		textures.add(texture);
	}
}

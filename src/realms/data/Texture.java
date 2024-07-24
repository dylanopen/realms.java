package realms.data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Texture
{
	public BufferedImage bufferedImage;

	public Texture(String filepath) throws IOException
	{
		InputStream stream = Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(filepath));
		bufferedImage = ImageIO.read(stream);
	}
}

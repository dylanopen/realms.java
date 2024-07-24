package realms.data;

import realms.node.Node;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Sound extends Node
{
	private Clip clip;
	private URL url;
	private AudioInputStream inputStream;

	public Sound(String filepath) throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		super();
		url = Objects.requireNonNull(getClass().getClassLoader().getResource(filepath));
	}

	public void reload() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		inputStream = AudioSystem.getAudioInputStream(url);
		clip = AudioSystem.getClip();
		clip.open(inputStream);
	}

	public void start() throws LineUnavailableException, IOException, UnsupportedAudioFileException
	{
		reload();
		clip.start();
	}

	public void loop()
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop()
	{
		clip.stop();
	}
}

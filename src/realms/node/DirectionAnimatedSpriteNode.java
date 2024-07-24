package realms.node;

import realms.data.Direction;
import realms.data.Texture;

public class DirectionAnimatedSpriteNode extends SpriteNode
{
	private Texture[] upAnimationFrames;
	private Texture[] downAnimationFrames;
	private Texture[] leftAnimationFrames;
	private Texture[] rightAnimationFrames;
	public double frameDuration;
	public Direction direction = Direction.Down;

	public DirectionAnimatedSpriteNode(
		double x, double y, double width, double height,
		Texture[] upAnimationFrames, Texture[] downAnimationFrames,
		Texture[] leftAnimationFrames, Texture[] rightAnimationFrames,
		double frameDuration
	)
	{
		super(x, y, width, height, downAnimationFrames[0]);
		this.upAnimationFrames = upAnimationFrames;
		this.downAnimationFrames = downAnimationFrames;
		this.leftAnimationFrames = leftAnimationFrames;
		this.rightAnimationFrames = rightAnimationFrames;
		this.frameDuration = frameDuration;
	}

	@Override
	public void update()
	{
		super.update();

		int animationStage;

		switch (direction)
		{
			case Up:
				animationStage = ((int)Math.max(0, y) % ((int)frameDuration*upAnimationFrames.length)) / (int)frameDuration;
				texture = upAnimationFrames[animationStage];
				break;
			case Down:
				animationStage = ((int)Math.max(0, y) % ((int)frameDuration*downAnimationFrames.length)) / (int)frameDuration;
				texture = downAnimationFrames[animationStage];
				break;
			case Left:
				animationStage = ((int)Math.max(0, x) % ((int)frameDuration*leftAnimationFrames.length)) / (int)frameDuration;
				texture = leftAnimationFrames[animationStage];
				break;
			case Right:
				animationStage = ((int)Math.max(0, x) % ((int)frameDuration*rightAnimationFrames.length)) / (int)frameDuration;
				texture = rightAnimationFrames[animationStage];
				break;

		}
	}
}

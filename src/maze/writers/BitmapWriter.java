/*
 * @copyright	Copyright (c) 2012 Jonas Amrich
 */
package maze.writers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Deque;
import javax.imageio.ImageIO;
import maze.utils.Coordinate;

/**
 *
 * @author jonasamrich
 */
public class BitmapWriter implements Writer {

	public static final int PATH_COLOR = 0x00ff00;

	@Override
	public void writePath(Deque<Coordinate> path, String original, String output) throws IOException {
		BufferedImage image = ImageIO.read(new File(original));

		int width = image.getWidth();
		int height = image.getHeight();

		BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				out.setRGB(x, y, image.getRGB(x, y));
			}
		}

		for (Coordinate coordinate : path) {
			out.setRGB(coordinate.x, coordinate.y, PATH_COLOR);
		}

		File outputfile = new File(output + ".png");
		ImageIO.write(out, "png", outputfile);
	}
}

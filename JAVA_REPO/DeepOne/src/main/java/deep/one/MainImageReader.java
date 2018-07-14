package deep.one;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainImageReader {

	static class MyWindow extends JFrame{
		final JPanel panel;
		final ImageIcon ii;
		final JLabel label;
		public MyWindow(){
			panel = new JPanel();
			 ii = new ImageIcon();
			label = new JLabel(ii);
			panel.add(label);
			add(panel);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(500, 500);
					setVisible(true);
				}
	}

	public static void main(String[] args) throws AWTException {

		final Robot robot = new Robot();
		final MyWindow myWindow = new MyWindow();
		final Rectangle rectangle = new Rectangle(1600, 200, 300,300);
		myWindow.panel.repaint();
		final ScheduledFuture<?> beeperHandle =
				Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(() -> {
					BufferedImage sc = robot.createScreenCapture(rectangle);






					myWindow.ii.setImage(sc);
					myWindow.panel.repaint();
					System.out.println(MouseInfo.getPointerInfo().getLocation().x);
					robot.mousePress(MouseEvent.BUTTON1_MASK);
					robot.mouseMove( MouseInfo.getPointerInfo().getLocation().x + 30, 		MouseInfo.getPointerInfo().getLocation().y + 30);
				//	robot.keyPress(KeyEvent.VK_LEFT);
				//	robot.keyRelease(KeyEvent.VK_LEFT);
					sc.flush();

				}, 2, 2, TimeUnit.SECONDS);

		beeperHandle.isDone();

	}
}

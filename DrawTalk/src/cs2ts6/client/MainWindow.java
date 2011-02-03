package cs2ts6.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//TODO 640x480 + 150 chat?
public class MainWindow extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 983051938169997622L;
	//TODO Drawing elements within JPanel
	private DrawingPanel drawingPanel;
	private ChatPanel chatPanel;
	
	private void createAndShowGUI(){
		JFrame frame = new JFrame("Draw & Talk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawingPanel = new DrawingPanel();
		chatPanel = new ChatPanel();
		frame.setPreferredSize(new Dimension(1000, 480));
		frame.add("West", drawingPanel);
		frame.add(chatPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final MainWindow mainWindow = new MainWindow();
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				mainWindow.createAndShowGUI();
			}
		});
	}

}

package gui_swing;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class RicochetStartPanel extends JPanel {
	
	
	RicochetStartPanel() throws IOException {
		setBackground(new Color(8,7,13));
		
		ImageIcon image = new ImageIcon(this.getClass().getResource("/images/frame_bg.jpg"));
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 5);
		flow.setAlignOnBaseline(true);
		
		setLayout(flow);
		
		JButton playButton = new JButton("Play");
		playButton.setBackground(Color.WHITE);
		playButton.setVerticalAlignment(SwingConstants.TOP);
		add(playButton);
		JLabel imageLabel = new JLabel(image);
		add(imageLabel);
		
		this.setVisible(true);
		
		this.validate();
		this.repaint();
	}
	
}

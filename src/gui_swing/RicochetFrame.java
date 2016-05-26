package gui_swing;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class RicochetFrame extends JFrame {
	RicochetStartPanel startPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RicochetFrame window = new RicochetFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RicochetFrame() throws IOException{
		startPanel = new RicochetStartPanel();
		
		//this.getContentPane().setLayout(null);
		
		this.getContentPane().add(startPanel, BorderLayout.CENTER);
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 5);
		startPanel.setLayout(flow);
		
		this.setBounds(50,50,496,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		//this.pack();
		this.setVisible(true);
	}

}

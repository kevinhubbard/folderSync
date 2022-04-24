import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FolderSync {
	JLabel iLabel = new JLabel("");
	JLabel fLabel = new JLabel("");

	public void createGui() {
		JFrame frame = new JFrame("Folder Sync");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		JPanel topPane = new JPanel();
		topPane.setBackground(Color.RED);
		JPanel midPane = new JPanel();
		midPane.setLayout(new BoxLayout(midPane, BoxLayout.PAGE_AXIS));
		
		JPanel botPane = new JPanel();
		botPane.setBackground(Color.BLUE);
		JButton iBtn = new JButton("Initial Folder");
		iBtn.addActionListener(new InitialListener());
		
		JButton fBtn = new JButton("Synced Folder");
		fBtn.addActionListener(new SyncListener());
		
		JLabel infoLabel = new JLabel("Choose an initial folder to syncronize with another.");
		JButton syncBtn = new JButton("Sync");
		JButton resetBtn = new JButton("Reset");

		JPanel ipane = new JPanel();
		JPanel fpane = new JPanel();
		ipane.setBackground(Color.GREEN);
		fpane.setBackground(Color.PINK);
		topPane.add(infoLabel);
		ipane.add(iBtn);
		ipane.add(iLabel);
		fpane.add(fBtn);
		fpane.add(fLabel);
		midPane.add(ipane);
		midPane.add(fpane);
		botPane.add(resetBtn);
		botPane.add(syncBtn);
		panel.add(topPane);
		panel.add(midPane);
		panel.add(botPane);
		frame.add(panel);
		frame.setSize(new Dimension(750,500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void selectedFolder(String o) {
		JFileChooser jfc = new JFileChooser();
		//jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String pathloc = jfc.getSelectedFile().getAbsolutePath();
			if (o.equals("i")) {
				iLabel.setText(pathloc);
			} else if (o.equals("f")) {
				fLabel.setText(pathloc);
			}
		}
		
	}
	
	public static void main(String[] args) {
		FolderSync fs = new FolderSync();
		fs.createGui();
	}

	private class InitialListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedFolder("i");
		}
	}

	private class SyncListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedFolder("f");
		}
	}
}
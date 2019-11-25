import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Font;

public class PrimesProject extends JFrame {

	private JPanel contentPane;
	private JTextField primeFileText;
	private JTextField crossFileText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimesProject frame = new PrimesProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimesProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel crossPanel = new JPanel();
		crossPanel.setBounds(1, 126, 999, 124);
		contentPane.add(crossPanel);
		crossPanel.setLayout(null);
		
		crossFileText = new JTextField();
		crossFileText.setText("crosses.txt");
		crossFileText.setBounds(new Rectangle(6, 5, 886, 58));
		crossPanel.add(crossFileText);
		crossFileText.setColumns(10);
		
		JLabel crossCountText = new JLabel("10000");
		crossCountText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		crossCountText.setBounds(900, 5, 93, 58);
		crossPanel.add(crossCountText);
		
		JLabel crossFileLabel = new JLabel("Hexagon Cross File");
		crossFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		crossFileLabel.setBounds(6, 64, 790, 66);
		crossPanel.add(crossFileLabel);
		
		JButton btnCrossLoad = new JButton("Load");
		btnCrossLoad.setBounds(799, 64, 93, 60);
		crossPanel.add(btnCrossLoad);
		
		JButton btnCrossSave = new JButton("Save");
		btnCrossSave.setBounds(900, 64, 93, 60);
		crossPanel.add(btnCrossSave);
		
		
		//PRIMES PANEL **************************
		JPanel primesPanel = new JPanel();
		primesPanel.setBounds(1, 1, 999, 124);
		contentPane.add(primesPanel);
		primesPanel.setLayout(null);
		
		primeFileText = new JTextField();
		primeFileText.setText("primes.txt");
		primeFileText.setBounds(new Rectangle(6, 5, 886, 58));
		primesPanel.add(primeFileText);
		primeFileText.setColumns(10);
		
		JLabel primeCountText = new JLabel("1000");
		primeCountText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		primeCountText.setBounds(900, 10, 93, 58);
		primesPanel.add(primeCountText);
		
		JLabel primesFileLabel = new JLabel("Primes File");
		primesFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		primesFileLabel.setBounds(6, 64, 790, 66);
		primesPanel.add(primesFileLabel);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(799, 64, 93, 60);
		primesPanel.add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(900, 64, 93, 60);
		primesPanel.add(btnSave);
		
		JPanel generatePanel = new JPanel();
		generatePanel.setBounds(1, 252, 999, 95);
		contentPane.add(generatePanel);
		generatePanel.setLayout(null);
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeneratePrimes.setBounds(50, 10, 300, 70);
		generatePanel.add(btnGeneratePrimes);
		
		JButton btnGenerateCrosses = new JButton("Generate Crosses");
		btnGenerateCrosses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGenerateCrosses.setBounds(693, 10, 300, 70);
		generatePanel.add(btnGenerateCrosses);
		
		JLabel largestPrime = new JLabel("The largest prime has 0 digits.");
		largestPrime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		largestPrime.setBounds(400, 10, 300, 30);
		generatePanel.add(largestPrime);
		
		JLabel largestCross = new JLabel("The largest cross has 0 and 0 digits.");
		largestCross.setFont(new Font("Tahoma", Font.PLAIN, 15));
		largestCross.setBounds(385, 43, 300, 30);
		generatePanel.add(largestCross);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 349, 999, 29);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Status: Bored.");
		lblNewLabel.setBounds(6, 6, 900, 16);
		panel.add(lblNewLabel);
	}
}

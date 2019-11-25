import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigInteger;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount;
	private JLabel lblCrossCount;
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	
	MainWindow(String name, Primes p)
	{
		m_Primes = p;
		setTitle(name);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		//==================Primes Panel==================
		JPanel primesPanel = new JPanel();
		primesPanel.setBounds(1, 1, 999, 122);
		contentPane.add(primesPanel);
		primesPanel.setLayout(null);

		tfPrimeFileName = new JTextField();
		tfPrimeFileName.setText("primes.txt");
		tfPrimeFileName.setBounds(new Rectangle(6, 5, 886, 58));
		primesPanel.add(tfPrimeFileName);
		tfPrimeFileName.setColumns(10);

		lblCrossCount = new JLabel("1000");
		lblCrossCount.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCrossCount.setBounds(900, 10, 93, 58);
		primesPanel.add(lblCrossCount);

		JLabel primesFileLabel = new JLabel("Primes File");
		primesFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		primesFileLabel.setBounds(6, 66, 790, 66);
		primesPanel.add(primesFileLabel);

		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(800, 66, 85, 55);
		primesPanel.add(btnLoad);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(890, 66, 85, 55);
		primesPanel.add(btnSave);
		//=======================================================

		//==================Hexagon Cross Panel==================
		JPanel crossPanel = new JPanel();
		crossPanel.setBounds(1, 126, 999, 122);
		contentPane.add(crossPanel);
		crossPanel.setLayout(null);

		tfCrossFileName = new JTextField();
		tfCrossFileName.setText("crosses.txt");
		tfCrossFileName.setBounds(new Rectangle(6, 5, 886, 58));
		crossPanel.add(tfCrossFileName);
		tfCrossFileName.setColumns(10);

		lblPrimeCount = new JLabel("10000");
		lblPrimeCount.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPrimeCount.setBounds(900, 10, 93, 58);
		crossPanel.add(lblPrimeCount);

		JLabel crossFileLabel = new JLabel("Hexagon Cross File");
		crossFileLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		crossFileLabel.setBounds(6, 66, 790, 66);
		crossPanel.add(crossFileLabel);

		JButton btnCrossLoad = new JButton("Load");
		btnCrossLoad.setBounds(800, 66, 85, 55);
		crossPanel.add(btnCrossLoad);

		JButton btnCrossSave = new JButton("Save");
		btnCrossSave.setBounds(890, 66, 85, 55);
		crossPanel.add(btnCrossSave);
		////=======================================================


		//==================Generate button Panel==================
		JPanel generatePanel = new JPanel();
		generatePanel.setBounds(1, 252, 999, 80);
		contentPane.add(generatePanel);
		generatePanel.setLayout(null);

		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGeneratePrimes.setBounds(30, 10, 300, 65);
		generatePanel.add(btnGeneratePrimes);

		JButton btnGenerateCrosses = new JButton("Generate Crosses");
		btnGenerateCrosses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGenerateCrosses.setBounds(660, 10, 300, 65);
		generatePanel.add(btnGenerateCrosses);

		lblLargestPrime = new JLabel("The largest prime has 0 digits.");
		lblLargestPrime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLargestPrime.setBounds(400, 10, 300, 30);
		generatePanel.add(lblLargestPrime);

		lblLargestCross = new JLabel("The largest cross has 0 and 0 digits.");
		lblLargestCross.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLargestCross.setBounds(385, 43, 300, 30);
		generatePanel.add(lblLargestCross);
		//=======================================================

		//==================Status Panel==================
		JPanel statusPanel = new JPanel();
		statusPanel.setBounds(1, 335, 999, 29);
		contentPane.add(statusPanel);
		statusPanel.setLayout(null);

		lblStatus = new JLabel("Status: Bored.");
		lblStatus.setBounds(6, 6, 900, 16);
		statusPanel.add(lblStatus);
		//=======================================================

		setVisible(true);
	}

	protected void popupGeneratePrimes()
	{
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout();
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try
      	{
      		BigInteger start = new BigInteger(tfStart.getText());
      		int count = Integer.parseInt(tfCount.getText());
       		m_Primes.generatePrimes(start, count);
       		lblStatus.setText("Status: Excited. Primes have been generated.");
       		updateStats();
       		m_Primes.printPrimes();
      		dPrimes.dispose();
      	}
      	catch(NumberFormatException ex)
      	{
      		lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
      		dPrimes.dispose();
      	}
      	
      }
    });
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	dPrimes.dispose();
      }
    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}

	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
 	}

}

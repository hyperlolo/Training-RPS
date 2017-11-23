package trainingRPSGames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField txtWouldYouLike;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setTitle("Rock Paper Scissors!");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWouldYouLike = new JTextField();
		txtWouldYouLike.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtWouldYouLike.setBounds(11, 11, 418, 38);
		txtWouldYouLike.setForeground(Color.BLACK);
		txtWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		txtWouldYouLike.setText("Would you like to play normal or random?");
		contentPane.add(txtWouldYouLike);
		txtWouldYouLike.setColumns(10);
		
		JButton btnNewButton = new JButton("Normal RPS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(11, 60, 130, 40);
		contentPane.add(btnNewButton);
		
		JButton btnRandomRps = new JButton("Random RPS");
		btnRandomRps.setBounds(294, 60, 130, 40);
		contentPane.add(btnRandomRps);
	}
}

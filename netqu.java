package netqu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class netqu {

	private JFrame frame;
	private JTextField dian1;
	private JTextField dian2;
	private JTextField dian3;
	private JTextField dian4;
	private JTextField quanzhi;
	private paintpanel panel_2 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					netqu window = new netqu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public netqu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7F51\u7EDC\u6700\u77ED\u8DEF\u5F84\u6F14\u793A");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnshengchengtu = new JButton("\u751F\u6210\u56FE");
		btnshengchengtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.shengchengtu();
			}
		});
		panel.add(btnshengchengtu);
		
		JButton btnxianshilu = new JButton("\u663E\u793A\u6700\u77ED\u8DEF\u5F84");
		btnxianshilu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p1,p2;
				p1=Integer.parseInt(dian1.getText());
				p2=Integer.parseInt(dian2.getText());
				panel_2.showpath( p1, p2);
			}
		});
		panel.add(btnxianshilu);
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u70B9");
		lblNewLabel.setBounds(10, 10, 27, 15);
		panel_1.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(101, 25, -50, -12);
		panel_1.add(textArea);
		
		dian1 = new JTextField();
		dian1.setBounds(44, 7, 30, 18);
		panel_1.add(dian1);
		dian1.setColumns(10);
		
		JLabel label = new JLabel("\u5230\u70B9");
		label.setBounds(84, 10, 54, 15);
		panel_1.add(label);
		
		dian2 = new JTextField();
		dian2.setColumns(10);
		dian2.setBounds(108, 7, 30, 18);
		panel_1.add(dian2);
		
		JLabel label_1 = new JLabel("\u7684\u6700\u77ED\u8DDD\u79BB");
		label_1.setBounds(148, 10, 101, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u8FB9\u7684\u4FE1\u606F");
		label_2.setBounds(626, 10, 54, 15);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("\u70B9");
		label_3.setBounds(636, 35, 34, 15);
		panel_1.add(label_3);
		
		dian3 = new JTextField();
		dian3.setColumns(10);
		dian3.setBounds(650, 35, 30, 18);
		panel_1.add(dian3);
		
		JLabel label_4 = new JLabel("\u5230\u70B9");
		label_4.setBounds(680, 35, 54, 15);
		panel_1.add(label_4);
		
		dian4 = new JTextField();
		dian4.setColumns(10);
		dian4.setBounds(708, 33, 30, 18);
		panel_1.add(dian4);
		
		JLabel label_5 = new JLabel("\u7684\u8FB9\uFF1A");
		label_5.setBounds(744, 35, 54, 15);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("\u6743\u503C");
		label_6.setBounds(646, 63, 54, 15);
		panel_1.add(label_6);
		
		quanzhi = new JTextField();
		quanzhi.setColumns(10);
		quanzhi.setBounds(680, 61, 54, 18);
		panel_1.add(quanzhi);
		
		panel_2 = new paintpanel();
		panel_2.setBounds(20, 37, 606, 482);
		panel_1.add(panel_2);
		
		JButton btnxianshibian = new JButton("\u663E\u793A");
		btnxianshibian.setBounds(681, 6, 93, 23);
		panel_1.add(btnxianshibian);
		btnxianshibian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int p3,p4;
				p3=Integer.parseInt(dian3.getText());
				p4=Integer.parseInt(dian4.getText());
				quanzhi.setText(panel_2.getquanzhi(p3,p4));
					
			}
		});
		
	}

}

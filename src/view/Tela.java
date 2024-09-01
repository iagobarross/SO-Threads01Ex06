/*6) (Desafio) Utilizando o Java SWING, criar uma tela, semelhante à tela abaixo, para criar
uma corrida de carros, tipo drag race. A aplicação deve ter a distância que os carros devem correr
e a velocidade máxima dos carros. Os carros (Jlabel) devem, a cada 100 mS, dar uma
arrancada de velocidade que pode estar entre 0 e a velocidade máxima (definida
aleatoriamente). Assim que o primeiro carro chegar, o JTextField Vencedor deve receber o
nome deste e o JTextField Perdedor receberá o nome do outro carro. Assim que a corrida se
inicia, o botão Correr deve sumir.
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.CarroThread;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldVencedor;
	private JTextField textFieldPerdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldVencedor = new JTextField();
		textFieldVencedor.setBounds(274, 202, 93, 20);
		contentPane.add(textFieldVencedor);
		textFieldVencedor.setColumns(10);
		
		textFieldPerdedor = new JTextField();
		textFieldPerdedor.setBounds(274, 233, 93, 20);
		contentPane.add(textFieldPerdedor);
		textFieldPerdedor.setColumns(10);
		
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setForeground(new Color(0, 0, 255));
		lblCarro1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCarro1.setBounds(10, 44, 47, 20);
		contentPane.add(lblCarro1);
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(new Color(255, 0, 0));
		lblCarro2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCarro2.setBounds(10, 101, 47, 20);
		contentPane.add(lblCarro2);
	
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCorrer.setBounds(10, 312, 89, 23);
		contentPane.add(btnCorrer);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 76, 585, 14);
		contentPane.add(progressBar);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVencedor.setBounds(211, 204, 53, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPerdedor.setBounds(211, 236, 53, 14);
		contentPane.add(lblPerdedor);
		
		ActionListener corrida = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread tCarro1 = new CarroThread(lblCarro1, btnCorrer, textFieldVencedor, textFieldPerdedor);
				Thread tCarro2 = new CarroThread(lblCarro2, btnCorrer, textFieldVencedor, textFieldPerdedor);
				tCarro1.start();
				tCarro2.start();
			}
			
		};
		
		btnCorrer.addActionListener(corrida);
	}
}

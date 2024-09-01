package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarroThread extends Thread {

	private JLabel carro;
	private JButton botao;
	private static int vencedor = 0;
	private JTextField textVencedor;
	private JTextField textPerdedor;

	public CarroThread(JLabel carro, JButton botao, JTextField textVencedor, JTextField textPerdedor) {
		this.carro = carro;
		this.botao = botao;
		this.textVencedor = textVencedor;
		this.textPerdedor = textPerdedor;
	}

	@Override
	public void run() {
		if (vencedor == 0) {
			textVencedor.setText("");
			textPerdedor.setText("");
			moveCarro();
		}
	}

	public void moveCarro() {
		botao.setVisible(false);

		Rectangle posicao = carro.getBounds();
		posicao.x = 10;
		carro.setBounds(posicao);

		int distanciaPercorrida = 0;
		int distanciaTotal = 525;
		int arrancada = 0;

		while (distanciaPercorrida < distanciaTotal) {
			arrancada = (int) ((Math.random() * 20) + 1);
			distanciaPercorrida += arrancada;
			posicao.x += arrancada;
			carro.setBounds(posicao);

			if (distanciaPercorrida >= distanciaTotal) {
				if (vencedor == 0) {
					textVencedor.setText(carro.getText());
					vencedor++;
				} else if (vencedor == 1) {
					textPerdedor.setText(carro.getText());
					vencedor++;
				}
			}

			try {
				Thread.sleep(120);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (vencedor == 2) {
			vencedor = 0;
			botao.setVisible(true);
		}
	}
}

package view.orders;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Prodotto;

public class OrderProductCard extends ProductCard {
	
	private JTextField textFieldQuantita;

	public OrderProductCard() {
		super();
		JLabel lblQuantita = new JLabel("Quantita");
		GridBagConstraints gbc_lblQuantita = new GridBagConstraints();
		gbc_lblQuantita.anchor = GridBagConstraints.EAST;
		gbc_lblQuantita.insets = new Insets(5, 5, 5, 5);
		gbc_lblQuantita.gridx = 1;
		gbc_lblQuantita.gridy = 4;
		add(lblQuantita, gbc_lblQuantita);
		
		textFieldQuantita = new JTextField();
		textFieldQuantita.setColumns(10);
		GridBagConstraints gbc_textFieldQuantita = new GridBagConstraints();
		gbc_textFieldQuantita.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldQuantita.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuantita.gridx = 3;
		gbc_textFieldQuantita.gridy = 4;
		add(textFieldQuantita, gbc_textFieldQuantita);
	}
	
	@Override
	public void loadData(Prodotto product) {
		super.loadData(product);
		this.textFieldQuantita.setText(String.valueOf(product.getQuantita()));
	}
	
	@Override
	public void clear() {
		super.clear();
		this.textFieldQuantita.setText("");
	}

}

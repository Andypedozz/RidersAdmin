package view.orders;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Prodotto;

import javax.swing.JTextArea;

public class ProductCard extends JPanel {
	private JTextField textFieldCodice;
	private JTextField textFieldProdotto;
	private JTextField textFieldPrezzo;
	
	public ProductCard() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodice.gridx = 3;
		gbc_textFieldCodice.gridy = 1;
		add(textFieldCodice, gbc_textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblProdotto = new JLabel("Prodotto");
		GridBagConstraints gbc_lblProdotto = new GridBagConstraints();
		gbc_lblProdotto.anchor = GridBagConstraints.EAST;
		gbc_lblProdotto.insets = new Insets(5, 5, 5, 5);
		gbc_lblProdotto.gridx = 1;
		gbc_lblProdotto.gridy = 2;
		add(lblProdotto, gbc_lblProdotto);
		
		textFieldProdotto = new JTextField();
		GridBagConstraints gbc_textFieldProdotto = new GridBagConstraints();
		gbc_textFieldProdotto.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldProdotto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProdotto.gridx = 3;
		gbc_textFieldProdotto.gridy = 2;
		add(textFieldProdotto, gbc_textFieldProdotto);
		textFieldProdotto.setColumns(10);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.EAST;
		gbc_lblPrezzo.insets = new Insets(5, 5, 5, 5);
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 3;
		add(lblPrezzo, gbc_lblPrezzo);
		
		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setColumns(10);
		GridBagConstraints gbc_textFieldPrezzo = new GridBagConstraints();
		gbc_textFieldPrezzo.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldPrezzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrezzo.gridx = 3;
		gbc_textFieldPrezzo.gridy = 3;
		add(textFieldPrezzo, gbc_textFieldPrezzo);
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.textFieldCodice.setEditable(false);
		this.textFieldProdotto.setEditable(false);
		this.textFieldPrezzo.setEditable(false);
	}
	
	public void loadData(Prodotto prodotto) {
		this.textFieldProdotto.setText(prodotto.getName());
		this.textFieldPrezzo.setText(String.valueOf(prodotto.getPrezzo()));
	}
	
	public void clear() {
		this.textFieldProdotto.setText("");
		this.textFieldPrezzo.setText("");
	}

}

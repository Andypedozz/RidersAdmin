package view.orders;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Prodotto;

import javax.swing.JTextArea;

public class ProductCard extends JPanel {
	private JTextField textFieldProdotto;
	private JTextField textFieldQuantita;
	private JTextField textFieldPrezzo;
	
	public ProductCard() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblProdotto = new JLabel("Prodotto");
		GridBagConstraints gbc_lblProdotto = new GridBagConstraints();
		gbc_lblProdotto.anchor = GridBagConstraints.EAST;
		gbc_lblProdotto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdotto.gridx = 1;
		gbc_lblProdotto.gridy = 1;
		add(lblProdotto, gbc_lblProdotto);
		
		textFieldProdotto = new JTextField();
		GridBagConstraints gbc_textFieldProdotto = new GridBagConstraints();
		gbc_textFieldProdotto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProdotto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProdotto.gridx = 2;
		gbc_textFieldProdotto.gridy = 1;
		add(textFieldProdotto, gbc_textFieldProdotto);
		textFieldProdotto.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 4;
		gbc_lblNote.gridy = 1;
		add(lblNote, gbc_lblNote);
		
		JTextArea textAreaNote = new JTextArea();
		GridBagConstraints gbc_textAreaNote = new GridBagConstraints();
		gbc_textAreaNote.gridwidth = 5;
		gbc_textAreaNote.gridheight = 3;
		gbc_textAreaNote.fill = GridBagConstraints.BOTH;
		gbc_textAreaNote.gridx = 5;
		gbc_textAreaNote.gridy = 1;
		add(textAreaNote, gbc_textAreaNote);
		
		JLabel lblQuantita = new JLabel("Quantita");
		GridBagConstraints gbc_lblQuantita = new GridBagConstraints();
		gbc_lblQuantita.anchor = GridBagConstraints.EAST;
		gbc_lblQuantita.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantita.gridx = 1;
		gbc_lblQuantita.gridy = 2;
		add(lblQuantita, gbc_lblQuantita);
		
		textFieldQuantita = new JTextField();
		textFieldQuantita.setColumns(10);
		GridBagConstraints gbc_textFieldQuantita = new GridBagConstraints();
		gbc_textFieldQuantita.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldQuantita.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuantita.gridx = 2;
		gbc_textFieldQuantita.gridy = 2;
		add(textFieldQuantita, gbc_textFieldQuantita);
		
		JLabel lblPrezzo = new JLabel("Prezzo");
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.EAST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrezzo.gridx = 1;
		gbc_lblPrezzo.gridy = 3;
		add(lblPrezzo, gbc_lblPrezzo);
		
		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setColumns(10);
		GridBagConstraints gbc_textFieldPrezzo = new GridBagConstraints();
		gbc_textFieldPrezzo.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPrezzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrezzo.gridx = 2;
		gbc_textFieldPrezzo.gridy = 3;
		add(textFieldPrezzo, gbc_textFieldPrezzo);
		
	}
	
	public void loadData(Prodotto prodotto) {
		this.textFieldProdotto.setText(prodotto.getName());
		this.textFieldQuantita.setText(String.valueOf(prodotto.getQuantita()));
		this.textFieldPrezzo.setText(String.valueOf(prodotto.getPrezzo()));
	}
	
	public void clear() {
		this.textFieldProdotto.setText("");
		this.textFieldQuantita.setText("");
		this.textFieldPrezzo.setText("");
	}

}

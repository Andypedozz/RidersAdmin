package view.restaurants;

import model.Restaurant;
import view.MyPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class PanelRestaurantsDettGeneral extends MyPanel {
	private JTextField textFieldCodice;
	private JTextField textFieldRistorante;
	private JTextField textFieldIndirizzo;
	
	public PanelRestaurantsDettGeneral() {
		this.setTitle("Dettagli Ristorante");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.insets = new Insets(0, 5, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		getContentPane().add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.ipady = 10;
		gbc_textFieldCodice.insets = new Insets(0, 5, 5, 15);
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodice.gridx = 2;
		gbc_textFieldCodice.gridy = 1;
		getContentPane().add(textFieldCodice, gbc_textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblRistorante = new JLabel("Ristorante");
		GridBagConstraints gbc_lblRistorante = new GridBagConstraints();
		gbc_lblRistorante.insets = new Insets(0, 5, 5, 5);
		gbc_lblRistorante.gridx = 1;
		gbc_lblRistorante.gridy = 2;
		getContentPane().add(lblRistorante, gbc_lblRistorante);
		
		textFieldRistorante = new JTextField();
		GridBagConstraints gbc_textFieldRistorante = new GridBagConstraints();
		gbc_textFieldRistorante.ipady = 10;
		gbc_textFieldRistorante.insets = new Insets(0, 5, 5, 15);
		gbc_textFieldRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRistorante.gridx = 2;
		gbc_textFieldRistorante.gridy = 2;
		getContentPane().add(textFieldRistorante, gbc_textFieldRistorante);
		textFieldRistorante.setColumns(10);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo");
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.insets = new Insets(0, 5, 5, 5);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 3;
		getContentPane().add(lblIndirizzo, gbc_lblIndirizzo);
		
		textFieldIndirizzo = new JTextField();
		textFieldIndirizzo.setColumns(10);
		GridBagConstraints gbc_textFieldIndirizzo = new GridBagConstraints();
		gbc_textFieldIndirizzo.ipady = 10;
		gbc_textFieldIndirizzo.insets = new Insets(0, 5, 5, 15);
		gbc_textFieldIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIndirizzo.gridx = 2;
		gbc_textFieldIndirizzo.gridy = 3;
		getContentPane().add(textFieldIndirizzo, gbc_textFieldIndirizzo);
		
		this.textFieldCodice.setEditable(false);
		this.textFieldRistorante.setEditable(false);
		this.textFieldIndirizzo.setEditable(false);
	}

	@Override
	public void updateFields() {
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		this.textFieldCodice.setText("");
		this.textFieldRistorante.setText("");
		this.textFieldIndirizzo.setText("");
	}
	
	public void loadData(Restaurant restaurant) {
		this.textFieldCodice.setText(String.valueOf(restaurant.getId()));
		this.textFieldRistorante.setText(restaurant.getName());
		this.textFieldIndirizzo.setText(restaurant.getIndirizzo());
	}

}

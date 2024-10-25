package view.riders;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controller.Controller;
import model.Rider;
import view.MyPanel;

public class PanelRiderDett extends MyPanel {
	
	private Controller controller;
	private JTextField textFieldCodice;
	private JTextField textFieldNome;
	private JTextField textFieldMezzo;
	private JCheckBox checkBoxLibero;
	
	public PanelRiderDett() {
		this.controller = Controller.getInstance();
		this.setTitle("Dettagli Rider");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 171, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.ipady = 10;
		gbc_lblCodice.ipadx = 10;
		gbc_lblCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCodice.insets = new Insets(5, 5, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		getContentPane().add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.ipady = 10;
		gbc_textFieldCodice.ipadx = 10;
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodice.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldCodice.gridx = 2;
		gbc_textFieldCodice.gridy = 1;
		getContentPane().add(textFieldCodice, gbc_textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.ipady = 10;
		gbc_lblNome.ipadx = 10;
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.insets = new Insets(5, 5, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 2;
		getContentPane().add(lblNome, gbc_lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
		gbc_textFieldNome.ipady = 10;
		gbc_textFieldNome.ipadx = 10;
		gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldNome.gridx = 2;
		gbc_textFieldNome.gridy = 2;
		getContentPane().add(textFieldNome, gbc_textFieldNome);
		
		JLabel lblMezzo = new JLabel("Mezzo");
		lblMezzo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMezzo = new GridBagConstraints();
		gbc_lblMezzo.ipady = 10;
		gbc_lblMezzo.ipadx = 10;
		gbc_lblMezzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMezzo.insets = new Insets(5, 5, 5, 5);
		gbc_lblMezzo.gridx = 1;
		gbc_lblMezzo.gridy = 3;
		getContentPane().add(lblMezzo, gbc_lblMezzo);
		
		textFieldMezzo = new JTextField();
		textFieldMezzo.setColumns(10);
		GridBagConstraints gbc_textFieldMezzo = new GridBagConstraints();
		gbc_textFieldMezzo.ipady = 10;
		gbc_textFieldMezzo.ipadx = 10;
		gbc_textFieldMezzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMezzo.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldMezzo.gridx = 2;
		gbc_textFieldMezzo.gridy = 3;
		getContentPane().add(textFieldMezzo, gbc_textFieldMezzo);
		
		JLabel lblLibero = new JLabel("Libero");
		lblLibero.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblLibero = new GridBagConstraints();
		gbc_lblLibero.ipady = 10;
		gbc_lblLibero.ipadx = 10;
		gbc_lblLibero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLibero.insets = new Insets(5, 5, 5, 5);
		gbc_lblLibero.gridx = 1;
		gbc_lblLibero.gridy = 4;
		getContentPane().add(lblLibero, gbc_lblLibero);
		
		checkBoxLibero = new JCheckBox();
		GridBagConstraints gbc_checkBoxLibero = new GridBagConstraints();
		gbc_checkBoxLibero.ipady = 10;
		gbc_checkBoxLibero.ipadx = 10;
		gbc_checkBoxLibero.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxLibero.insets = new Insets(5, 5, 5, 15);
		gbc_checkBoxLibero.gridx = 2;
		gbc_checkBoxLibero.gridy = 4;
		getContentPane().add(checkBoxLibero, gbc_checkBoxLibero);
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		this.textFieldCodice.setEditable(false);
		this.textFieldNome.setEditable(false);
		this.textFieldMezzo.setEditable(false);
		this.checkBoxLibero.setEnabled(false);
	}
	
	@Override
	public void updateFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		
	}

	public void loadData(Rider rider) {
		this.textFieldCodice.setText(String.valueOf(rider.getId()));
		this.textFieldNome.setText(rider.getName());
		this.textFieldMezzo.setText(rider.getMezzo());
		this.checkBoxLibero.setSelected(rider.isLibero());
	}

}

package view.orders;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import view.MyPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import controller.Controller;

public class PanelOrderDettGeneral extends MyPanel {
	private Controller controller;
	private JTextField textFieldCodice;
	private JTextField textFieldRistorante;
	private JTextField textFieldOrarioRitiro;
	private JTextField textFieldOrarioConsegna;
	private JTextField textFieldIndirizzoConsegna;
	private JCheckBox checkBoxCompletato;
	
	public PanelOrderDettGeneral() {
		this.controller = Controller.getInstance();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 171, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.ipady = 10;
		gbc_lblCodice.ipadx = 10;
		gbc_lblCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCodice.insets = new Insets(5, 5, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.ipady = 10;
		gbc_textFieldCodice.ipadx = 10;
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodice.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldCodice.gridx = 2;
		gbc_textFieldCodice.gridy = 1;
		add(textFieldCodice, gbc_textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblRistorante = new JLabel("Ristorante");
		lblRistorante.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRistorante = new GridBagConstraints();
		gbc_lblRistorante.ipady = 10;
		gbc_lblRistorante.ipadx = 10;
		gbc_lblRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRistorante.insets = new Insets(5, 5, 5, 5);
		gbc_lblRistorante.gridx = 1;
		gbc_lblRistorante.gridy = 2;
		add(lblRistorante, gbc_lblRistorante);
		
		textFieldRistorante = new JTextField();
		textFieldRistorante.setColumns(10);
		GridBagConstraints gbc_textFieldRistorante = new GridBagConstraints();
		gbc_textFieldRistorante.ipady = 10;
		gbc_textFieldRistorante.ipadx = 10;
		gbc_textFieldRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRistorante.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldRistorante.gridx = 2;
		gbc_textFieldRistorante.gridy = 2;
		add(textFieldRistorante, gbc_textFieldRistorante);
		
		JLabel lblOrarioRitiro = new JLabel("Orario ritiro");
		lblOrarioRitiro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioRitiro = new GridBagConstraints();
		gbc_lblOrarioRitiro.ipady = 10;
		gbc_lblOrarioRitiro.ipadx = 10;
		gbc_lblOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioRitiro.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioRitiro.gridx = 1;
		gbc_lblOrarioRitiro.gridy = 3;
		add(lblOrarioRitiro, gbc_lblOrarioRitiro);
		
		textFieldOrarioRitiro = new JTextField();
		textFieldOrarioRitiro.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioRitiro = new GridBagConstraints();
		gbc_textFieldOrarioRitiro.ipady = 10;
		gbc_textFieldOrarioRitiro.ipadx = 10;
		gbc_textFieldOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioRitiro.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldOrarioRitiro.gridx = 2;
		gbc_textFieldOrarioRitiro.gridy = 3;
		add(textFieldOrarioRitiro, gbc_textFieldOrarioRitiro);
		
		JLabel lblOrarioConsegna = new JLabel("Orario consegna");
		lblOrarioConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioConsegna = new GridBagConstraints();
		gbc_lblOrarioConsegna.ipady = 10;
		gbc_lblOrarioConsegna.ipadx = 10;
		gbc_lblOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioConsegna.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioConsegna.gridx = 1;
		gbc_lblOrarioConsegna.gridy = 4;
		add(lblOrarioConsegna, gbc_lblOrarioConsegna);
		
		textFieldOrarioConsegna = new JTextField();
		textFieldOrarioConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioConsegna = new GridBagConstraints();
		gbc_textFieldOrarioConsegna.ipady = 10;
		gbc_textFieldOrarioConsegna.ipadx = 10;
		gbc_textFieldOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioConsegna.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldOrarioConsegna.gridx = 2;
		gbc_textFieldOrarioConsegna.gridy = 4;
		add(textFieldOrarioConsegna, gbc_textFieldOrarioConsegna);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo consegna");
		lblIndirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.ipady = 10;
		gbc_lblIndirizzo.ipadx = 10;
		gbc_lblIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIndirizzo.insets = new Insets(5, 5, 5, 5);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 5;
		add(lblIndirizzo, gbc_lblIndirizzo);
		
		textFieldIndirizzoConsegna = new JTextField();
		textFieldIndirizzoConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldIndirizzo = new GridBagConstraints();
		gbc_textFieldIndirizzo.ipady = 10;
		gbc_textFieldIndirizzo.ipadx = 10;
		gbc_textFieldIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIndirizzo.insets = new Insets(5, 5, 5, 15);
		gbc_textFieldIndirizzo.gridx = 2;
		gbc_textFieldIndirizzo.gridy = 5;
		add(textFieldIndirizzoConsegna, gbc_textFieldIndirizzo);
		
		checkBoxCompletato = new JCheckBox("Completato");
		checkBoxCompletato.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_checkBoxCompletato = new GridBagConstraints();
		gbc_checkBoxCompletato.ipady = 10;
		gbc_checkBoxCompletato.ipadx = 10;
		gbc_checkBoxCompletato.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxCompletato.insets = new Insets(5, 5, 5, 5);
		gbc_checkBoxCompletato.gridx = 1;
		gbc_checkBoxCompletato.gridy = 6;
		add(checkBoxCompletato, gbc_checkBoxCompletato);
		
		this.textFieldCodice.setEditable(false);
		this.textFieldRistorante.setEditable(false);
		this.textFieldOrarioRitiro.setEditable(false);
		this.textFieldOrarioConsegna.setEditable(false);
		this.textFieldIndirizzoConsegna.setEditable(false);
		this.checkBoxCompletato.setEnabled(false);
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
		// TODO Auto-generated method stub
		
	}

}

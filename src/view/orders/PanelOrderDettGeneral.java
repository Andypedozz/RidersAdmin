package view.orders;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import view.MyPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controller.Controller;
import controller.StringUtils;
import model.Order;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PanelOrderDettGeneral extends MyPanel {
	private Controller controller;
	private JTextField textFieldCodice;
	private JTextField textFieldRistorante;
	private JTextField textFieldOrarioRitiro;
	private JTextField textFieldOrarioConsegna;
	private JTextField textFieldIndirizzoConsegna;
	private JCheckBox checkBoxCompletato;
	private JTextArea textAreaNote;
	private JButton btnMaps;
	
	public PanelOrderDettGeneral() {
		this.setTitle("Dettagli Ordine");
		this.controller = Controller.getInstance();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 223, 63, 0, 212, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.ipady = 10;
		gbc_lblCodice.ipadx = 10;
		gbc_lblCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCodice.insets = new Insets(5, 5, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		this.getContentPane().add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.ipady = 10;
		gbc_textFieldCodice.ipadx = 10;
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodice.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldCodice.gridx = 2;
		gbc_textFieldCodice.gridy = 1;
		this.getContentPane().add(textFieldCodice, gbc_textFieldCodice);
		textFieldCodice.setColumns(10);
		
		JLabel lblNote = new JLabel("Note");
		GridBagConstraints gbc_lblNote = new GridBagConstraints();
		gbc_lblNote.insets = new Insets(0, 0, 5, 5);
		gbc_lblNote.gridx = 4;
		gbc_lblNote.gridy = 1;
		this.getContentPane().add(lblNote, gbc_lblNote);
		
		textAreaNote = new JTextArea();
		GridBagConstraints gbc_textAreaNote = new GridBagConstraints();
		gbc_textAreaNote.gridheight = 5;
		gbc_textAreaNote.insets = new Insets(10, 0, 5, 15);
		gbc_textAreaNote.fill = GridBagConstraints.BOTH;
		gbc_textAreaNote.gridx = 5;
		gbc_textAreaNote.gridy = 1;
		this.getContentPane().add(textAreaNote, gbc_textAreaNote);
		
		JLabel lblRistorante = new JLabel("Ristorante");
		lblRistorante.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRistorante = new GridBagConstraints();
		gbc_lblRistorante.ipady = 10;
		gbc_lblRistorante.ipadx = 10;
		gbc_lblRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRistorante.insets = new Insets(5, 5, 5, 5);
		gbc_lblRistorante.gridx = 1;
		gbc_lblRistorante.gridy = 2;
		this.getContentPane().add(lblRistorante, gbc_lblRistorante);
		
		textFieldRistorante = new JTextField();
		textFieldRistorante.setColumns(10);
		GridBagConstraints gbc_textFieldRistorante = new GridBagConstraints();
		gbc_textFieldRistorante.ipady = 10;
		gbc_textFieldRistorante.ipadx = 10;
		gbc_textFieldRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRistorante.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldRistorante.gridx = 2;
		gbc_textFieldRistorante.gridy = 2;
		this.getContentPane().add(textFieldRistorante, gbc_textFieldRistorante);
		
		JLabel lblOrarioRitiro = new JLabel("Orario ritiro");
		lblOrarioRitiro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioRitiro = new GridBagConstraints();
		gbc_lblOrarioRitiro.ipady = 10;
		gbc_lblOrarioRitiro.ipadx = 10;
		gbc_lblOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioRitiro.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioRitiro.gridx = 1;
		gbc_lblOrarioRitiro.gridy = 3;
		this.getContentPane().add(lblOrarioRitiro, gbc_lblOrarioRitiro);
		
		textFieldOrarioRitiro = new JTextField();
		textFieldOrarioRitiro.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioRitiro = new GridBagConstraints();
		gbc_textFieldOrarioRitiro.ipady = 10;
		gbc_textFieldOrarioRitiro.ipadx = 10;
		gbc_textFieldOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioRitiro.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldOrarioRitiro.gridx = 2;
		gbc_textFieldOrarioRitiro.gridy = 3;
		this.getContentPane().add(textFieldOrarioRitiro, gbc_textFieldOrarioRitiro);
		
		JLabel lblOrarioConsegna = new JLabel("Orario consegna");
		lblOrarioConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioConsegna = new GridBagConstraints();
		gbc_lblOrarioConsegna.ipady = 10;
		gbc_lblOrarioConsegna.ipadx = 10;
		gbc_lblOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioConsegna.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioConsegna.gridx = 1;
		gbc_lblOrarioConsegna.gridy = 4;
		this.getContentPane().add(lblOrarioConsegna, gbc_lblOrarioConsegna);
		
		textFieldOrarioConsegna = new JTextField();
		textFieldOrarioConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioConsegna = new GridBagConstraints();
		gbc_textFieldOrarioConsegna.ipady = 10;
		gbc_textFieldOrarioConsegna.ipadx = 10;
		gbc_textFieldOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioConsegna.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldOrarioConsegna.gridx = 2;
		gbc_textFieldOrarioConsegna.gridy = 4;
		this.getContentPane().add(textFieldOrarioConsegna, gbc_textFieldOrarioConsegna);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo consegna");
		lblIndirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.ipady = 10;
		gbc_lblIndirizzo.ipadx = 10;
		gbc_lblIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIndirizzo.insets = new Insets(5, 5, 5, 5);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 5;
		this.getContentPane().add(lblIndirizzo, gbc_lblIndirizzo);
		
		textFieldIndirizzoConsegna = new JTextField();
		textFieldIndirizzoConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldIndirizzo = new GridBagConstraints();
		gbc_textFieldIndirizzo.ipady = 10;
		gbc_textFieldIndirizzo.ipadx = 10;
		gbc_textFieldIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIndirizzo.insets = new Insets(5, 5, 5, 5);
		gbc_textFieldIndirizzo.gridx = 2;
		gbc_textFieldIndirizzo.gridy = 5;
		this.getContentPane().add(textFieldIndirizzoConsegna, gbc_textFieldIndirizzo);
		
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		checkBoxCompletato = new JCheckBox("Completato");
		checkBoxCompletato.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_checkBoxCompletato = new GridBagConstraints();
		gbc_checkBoxCompletato.ipady = 10;
		gbc_checkBoxCompletato.ipadx = 10;
		gbc_checkBoxCompletato.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxCompletato.insets = new Insets(5, 5, 5, 5);
		gbc_checkBoxCompletato.gridx = 1;
		gbc_checkBoxCompletato.gridy = 6;
		this.getContentPane().add(checkBoxCompletato, gbc_checkBoxCompletato);
		this.checkBoxCompletato.setEnabled(false);
		
		btnMaps = new JButton("Apri in Maps");
		GridBagConstraints gbc_btnMaps = new GridBagConstraints();
		gbc_btnMaps.insets = new Insets(0, 0, 5, 5);
		gbc_btnMaps.gridx = 2;
		gbc_btnMaps.gridy = 6;
//		getContentPane().add(btnMaps, gbc_btnMaps);
		
		this.textFieldCodice.setEditable(false);
		this.textFieldRistorante.setEditable(false);
		this.textFieldOrarioRitiro.setEditable(false);
		this.textFieldOrarioConsegna.setEditable(false);
		this.textFieldIndirizzoConsegna.setEditable(false);
		this.textAreaNote.setEditable(false);
		this.textAreaNote.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.btnMaps.setEnabled(false);
		initListeners();
		
	}
	
	private void initListeners() {
		this.btnMaps.addActionListener(e -> {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			    try {
					Desktop.getDesktop().browse(new URI("https://www.google.it/maps/place/"+StringUtils.formatQueryString(this.textFieldIndirizzoConsegna.getText())));
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
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
		this.textFieldOrarioRitiro.setText("");
		this.textFieldOrarioConsegna.setText("");
		this.textFieldIndirizzoConsegna.setText("");
		this.checkBoxCompletato.setSelected(false);
		this.textAreaNote.setText("");
		this.btnMaps.setEnabled(false);
	}

	public void loadData(Order order) {
		this.textFieldCodice.setText(String.valueOf(order.getId()));
		this.textFieldRistorante.setText(order.getRistorante());
		this.textFieldOrarioRitiro.setText(order.getRitiro());
		this.textFieldOrarioConsegna.setText(order.getConsegna());
		this.textFieldIndirizzoConsegna.setText(order.getIndirizzo());
		this.checkBoxCompletato.setSelected(order.isCompleted());
		this.textAreaNote.setText(order.getNote());
		this.btnMaps.setEnabled(true);
	}

}

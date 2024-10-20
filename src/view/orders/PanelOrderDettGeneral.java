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
	private JLabel lblCap;
	private JTextField textFieldCap;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JLabel lblNomeCognome;
	private JTextField textFieldNomeCognome;
	
	public PanelOrderDettGeneral() {
		this.setTitle("Dettagli Ordine");
		this.controller = Controller.getInstance();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 223, 63, 0, 212, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCodice = new GridBagConstraints();
		gbc_lblCodice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCodice.insets = new Insets(5, 5, 5, 5);
		gbc_lblCodice.gridx = 1;
		gbc_lblCodice.gridy = 1;
		this.getContentPane().add(lblCodice, gbc_lblCodice);
		
		textFieldCodice = new JTextField();
		GridBagConstraints gbc_textFieldCodice = new GridBagConstraints();
		gbc_textFieldCodice.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodice.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_textAreaNote.gridheight = 10;
		gbc_textAreaNote.insets = new Insets(10, 0, 5, 15);
		gbc_textAreaNote.fill = GridBagConstraints.BOTH;
		gbc_textAreaNote.gridx = 5;
		gbc_textAreaNote.gridy = 1;
		this.getContentPane().add(textAreaNote, gbc_textAreaNote);
		
		lblNomeCognome = new JLabel("Nome e Cognome");
		GridBagConstraints gbc_lblNomeCognome = new GridBagConstraints();
		gbc_lblNomeCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCognome.gridx = 1;
		gbc_lblNomeCognome.gridy = 2;
		getContentPane().add(lblNomeCognome, gbc_lblNomeCognome);
		
		textFieldNomeCognome = new JTextField();
		textFieldNomeCognome.setEditable(false);
		textFieldNomeCognome.setColumns(10);
		GridBagConstraints gbc_textFieldNomeCognome = new GridBagConstraints();
		gbc_textFieldNomeCognome.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomeCognome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeCognome.gridx = 2;
		gbc_textFieldNomeCognome.gridy = 2;
		getContentPane().add(textFieldNomeCognome, gbc_textFieldNomeCognome);
		
		JLabel lblRistorante = new JLabel("Ristorante");
		lblRistorante.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblRistorante = new GridBagConstraints();
		gbc_lblRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRistorante.insets = new Insets(5, 5, 5, 5);
		gbc_lblRistorante.gridx = 1;
		gbc_lblRistorante.gridy = 3;
		this.getContentPane().add(lblRistorante, gbc_lblRistorante);
		
		textFieldRistorante = new JTextField();
		textFieldRistorante.setColumns(10);
		GridBagConstraints gbc_textFieldRistorante = new GridBagConstraints();
		gbc_textFieldRistorante.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRistorante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRistorante.gridx = 2;
		gbc_textFieldRistorante.gridy = 3;
		this.getContentPane().add(textFieldRistorante, gbc_textFieldRistorante);
		
		JLabel lblOrarioRitiro = new JLabel("Orario ritiro");
		lblOrarioRitiro.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioRitiro = new GridBagConstraints();
		gbc_lblOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioRitiro.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioRitiro.gridx = 1;
		gbc_lblOrarioRitiro.gridy = 4;
		this.getContentPane().add(lblOrarioRitiro, gbc_lblOrarioRitiro);
		
		textFieldOrarioRitiro = new JTextField();
		textFieldOrarioRitiro.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioRitiro = new GridBagConstraints();
		gbc_textFieldOrarioRitiro.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOrarioRitiro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioRitiro.gridx = 2;
		gbc_textFieldOrarioRitiro.gridy = 4;
		this.getContentPane().add(textFieldOrarioRitiro, gbc_textFieldOrarioRitiro);
		
		JLabel lblOrarioConsegna = new JLabel("Orario consegna");
		lblOrarioConsegna.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOrarioConsegna = new GridBagConstraints();
		gbc_lblOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOrarioConsegna.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrarioConsegna.gridx = 1;
		gbc_lblOrarioConsegna.gridy = 5;
		this.getContentPane().add(lblOrarioConsegna, gbc_lblOrarioConsegna);
		
		textFieldOrarioConsegna = new JTextField();
		textFieldOrarioConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldOrarioConsegna = new GridBagConstraints();
		gbc_textFieldOrarioConsegna.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOrarioConsegna.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOrarioConsegna.gridx = 2;
		gbc_textFieldOrarioConsegna.gridy = 5;
		this.getContentPane().add(textFieldOrarioConsegna, gbc_textFieldOrarioConsegna);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo consegna");
		lblIndirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblIndirizzo = new GridBagConstraints();
		gbc_lblIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIndirizzo.insets = new Insets(5, 5, 5, 5);
		gbc_lblIndirizzo.gridx = 1;
		gbc_lblIndirizzo.gridy = 6;
		this.getContentPane().add(lblIndirizzo, gbc_lblIndirizzo);
		
		textFieldIndirizzoConsegna = new JTextField();
		textFieldIndirizzoConsegna.setColumns(10);
		GridBagConstraints gbc_textFieldIndirizzo = new GridBagConstraints();
		gbc_textFieldIndirizzo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIndirizzo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIndirizzo.gridx = 2;
		gbc_textFieldIndirizzo.gridy = 6;
		this.getContentPane().add(textFieldIndirizzoConsegna, gbc_textFieldIndirizzo);
		
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		lblCap = new JLabel("Cap");
		lblCap.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCap = new GridBagConstraints();
		gbc_lblCap.insets = new Insets(0, 0, 5, 5);
		gbc_lblCap.gridx = 1;
		gbc_lblCap.gridy = 7;
		getContentPane().add(lblCap, gbc_lblCap);
		
		textFieldCap = new JTextField();
		textFieldCap.setEditable(false);
		textFieldCap.setColumns(10);
		GridBagConstraints gbc_textFieldCap = new GridBagConstraints();
		gbc_textFieldCap.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCap.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCap.gridx = 2;
		gbc_textFieldCap.gridy = 7;
		getContentPane().add(textFieldCap, gbc_textFieldCap);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 8;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 8;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 9;
		getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setEditable(false);
		textFieldTelefono.setColumns(10);
		GridBagConstraints gbc_textFieldTelefono = new GridBagConstraints();
		gbc_textFieldTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTelefono.gridx = 2;
		gbc_textFieldTelefono.gridy = 9;
		getContentPane().add(textFieldTelefono, gbc_textFieldTelefono);
		
		checkBoxCompletato = new JCheckBox("Completato");
		checkBoxCompletato.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_checkBoxCompletato = new GridBagConstraints();
		gbc_checkBoxCompletato.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxCompletato.insets = new Insets(5, 5, 5, 5);
		gbc_checkBoxCompletato.gridx = 1;
		gbc_checkBoxCompletato.gridy = 10;
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
		this.textFieldNomeCognome.setText("");
		this.textFieldRistorante.setText("");
		this.textFieldOrarioRitiro.setText("");
		this.textFieldOrarioConsegna.setText("");
		this.textFieldIndirizzoConsegna.setText("");
		this.textFieldCap.setText("");
		this.textFieldEmail.setText("");
		this.textFieldTelefono.setText("");
		this.checkBoxCompletato.setSelected(false);
		this.textAreaNote.setText("");
		this.btnMaps.setEnabled(false);
	}

	public void loadData(Order order) {
		this.textFieldCodice.setText(String.valueOf(order.getId()));
		this.textFieldNomeCognome.setText(order.getNomeCognome());
		this.textFieldRistorante.setText(order.getRistorante());
		this.textFieldOrarioRitiro.setText(order.getRitiro());
		this.textFieldOrarioConsegna.setText(order.getConsegna());
		this.textFieldIndirizzoConsegna.setText(order.getIndirizzo());
		this.textFieldCap.setText(String.valueOf(order.getCap()));
		this.textFieldEmail.setText(order.getEmail());
		this.textFieldTelefono.setText(order.getTel());
		this.textAreaNote.setText(order.getNote());
		this.checkBoxCompletato.setSelected(order.isCompleted());
		this.btnMaps.setEnabled(true);
	}

}

package view.orders;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

import controller.Controller;
import model.Order;
import view.NonEditableTableModel;

public class OrdersTable extends JTable {
	private Controller controller;
	private static final int CODICE = 0;
	private static final int NOMECOGNOME = 1;
	private static final int RISTORANTE = 2;
	private static final int RITIRO = 3;
	private static final int CONSEGNA = 4;
	private static final int INDIRIZZO = 5;
	
	private NonEditableTableModel tableModel;
	
	public OrdersTable() {
		tableModel = new NonEditableTableModel();
		init();
		this.setModel(tableModel);
	}
	
	private void init() {
		controller = Controller.getInstance();
		tableModel.addColumn("Codice");
		tableModel.addColumn("Nome e Cognome");
		tableModel.addColumn("Ristorante");
		tableModel.addColumn("Ritiro");
		tableModel.addColumn("Consegna");
		tableModel.addColumn("Indirizzo");
		tableModel.addColumn("Completato");
		
    	this.getTableHeader().setReorderingAllowed(false);
    	this.setColumnSelectionAllowed(false);
    	this.setCellSelectionEnabled(false);
    	this.setRowSelectionAllowed(true);
    	
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumnModel columnModel = this.getColumnModel();
		for(int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setResizable(false);
		}
	}
	
	public void loadRows(List<Order> orders) {
		clear();
		for(Order order : orders) {
			Object[] obj = {order.getId(), order.getNomeCognome(), order.getRistorante(), order.getRitiro(), order.getConsegna(), order.getIndirizzo(), (order.isCompleted())? "Completato" : "Non completato"};
			tableModel.addRow(obj);
		}
	}
	
	public Order getSelected() {
		Order order = null;
		int selectedRow = super.getSelectedRow();
		if(selectedRow != -1) {
			order = getOrderAt(selectedRow);
		}
		return order;
	}

	private Order getOrderAt(int selectedRow) {
		int id = (int)this.getValueAt(selectedRow, CODICE);
		String nome = (String) this.getValueAt(selectedRow, NOMECOGNOME);
		String ristorante = (String) this.getValueAt(selectedRow, RISTORANTE);
		String ritiro = (String) this.getValueAt(selectedRow, RITIRO);
		String consegna = (String) this.getValueAt(selectedRow, CONSEGNA);
		String indirizzo = (String) this.getValueAt(selectedRow, INDIRIZZO);
		Order order = new Order(id, nome, ristorante, ritiro, consegna, indirizzo, -1, null, null, null, null, false);
		return order;
	}
	
	public void clear() {
		this.tableModel = new NonEditableTableModel();
		this.setModel(tableModel);
		init();
	}
	
}

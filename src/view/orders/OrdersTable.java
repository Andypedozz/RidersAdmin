package view.orders;

import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import model.Order;
import view.NonEditableTableModel;

public class OrdersTable extends JTable {
	private static final int CODICE = 0;
	private static final int RISTORANTE = 1;
	private static final int RITIRO = 2;
	private static final int CONSEGNA = 3;
	private static final int INDIRIZZO = 4;
	
	private NonEditableTableModel tableModel;
	
	public OrdersTable() {
		tableModel = new NonEditableTableModel();
		init();
		this.setModel(tableModel);
	}
	
	public OrdersTable(List<Order> orders) {
		tableModel = new NonEditableTableModel();
		init();
		loadRows(orders);
		this.setModel(tableModel);
	}
	
	private void init() {
		tableModel.addColumn("Codice");
		tableModel.addColumn("Ristorante");
		tableModel.addColumn("Ritiro");
		tableModel.addColumn("Consegna");
		tableModel.addColumn("Indirizzo");
		tableModel.addColumn("Completato");
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumnModel columnModel = this.getColumnModel();
		for(int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setResizable(false);
		}
	}
	
	public void loadRows(List<Order> orders) {
		for(Order order : orders) {
			Object[] obj = {order.getId(), order.getRistorante(), order.getRitiro(), order.getConsegna(), order.getIndirizzo(), (order.isCompleted())? "Completato" : "Non completato"};
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
		String ristorante = (String) this.getValueAt(selectedRow, RISTORANTE);
		String ritiro = (String) this.getValueAt(selectedRow, RITIRO);
		String consegna = (String) this.getValueAt(selectedRow, CONSEGNA);
		String indirizzo = (String) this.getValueAt(selectedRow, INDIRIZZO);
		Order order = new Order(id, ristorante, ritiro, consegna, indirizzo);
		return order;
	}
	
	public void clear() {
		this.tableModel = new NonEditableTableModel();
		this.setModel(tableModel);
		init();
	}
	
}

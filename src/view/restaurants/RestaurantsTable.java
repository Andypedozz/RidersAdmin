package view.restaurants;

import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import model.Restaurant;
import view.NonEditableTableModel;

public class RestaurantsTable extends JTable {
	private static final int CODICE = 0;
	private static final int NOME = 1;
	private static final int INDIRIZZO = 2;
	
	private NonEditableTableModel tableModel;
	
	public RestaurantsTable() {
		tableModel = new NonEditableTableModel();
		init();
		this.setModel(tableModel);
	}
	
	public RestaurantsTable(List<Restaurant> restaurants) {
		tableModel = new NonEditableTableModel();
		init();
		loadRows(restaurants);
		this.setModel(tableModel);
	}
	
	private void init() {
		tableModel.addColumn("Codice");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Indirizzo");
		
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
	
	public void loadRows(List<Restaurant> restaurants) {
		for(Restaurant restaurant : restaurants) {
			Object[] obj = {restaurant.getId(), restaurant.getName(), restaurant.getIndirizzo()};
			tableModel.addRow(obj);
		}
	}
	
	public Restaurant getSelected() {
		Restaurant restaurant = null;
		int selectedRow = super.getSelectedRow();
		if(selectedRow != -1) {
			restaurant = getOrderAt(selectedRow);
		}
		return restaurant;
	}

	private Restaurant getOrderAt(int selectedRow) {
		int id = (int)this.getValueAt(selectedRow, CODICE);
		String nome = (String) this.getValueAt(selectedRow, NOME);
		String indirizzo = (String) this.getValueAt(selectedRow, INDIRIZZO);
		Restaurant restaurant = new Restaurant(id, nome, indirizzo);
		return restaurant;
	}
	
	public void clear() {
		this.tableModel = new NonEditableTableModel();
		this.setModel(tableModel);
		init();
	}
}

package view.riders;

import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;

import model.Order;
import model.Rider;
import view.NonEditableTableModel;

public class RidersTable extends JTable {
	private static final int CODICE = 0;
	private static final int NOME = 1;
	private static final int MEZZO = 2;
	private static final int LIBERO = 3;
	
	private NonEditableTableModel tableModel;
	
	public RidersTable() {
		tableModel = new NonEditableTableModel();
		init();
		this.setModel(tableModel);
	}
	
	public RidersTable(List<Rider> riders) {
		tableModel = new NonEditableTableModel();
		init();
		loadRows(riders);
		this.setModel(tableModel);
	}
	
	private void init() {
		tableModel.addColumn("ID");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Mezzo");
		tableModel.addColumn("Libero");
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		TableColumnModel columnModel = this.getColumnModel();
		for(int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setResizable(false);
		}
		
	}
	
	public void loadRows(List<Rider> riders) {
		
		for(Rider rider : riders) {
			Object[] obj = {rider.getId(), rider.getName(), rider.getMezzo(), (rider.isLibero())? "Libero" : "Occupato"};
			tableModel.addRow(obj);
		}
	}
	
	public Rider getSelected() {
		Rider rider = null;
		int selectedRow = super.getSelectedRow();
		if(selectedRow != -1) {
			rider = getRiderAt(selectedRow);
		}
		return rider;
	}
	
	private Rider getRiderAt(int selectedRow) {
		int id = (int) this.getValueAt(selectedRow, CODICE);
		String nome = (String) this.getValueAt(selectedRow, NOME);
		String mezzo = (String) this.getValueAt(selectedRow, MEZZO);
		boolean libero = Boolean.valueOf((String) this.getValueAt(selectedRow, LIBERO));
		Rider rider = new Rider(id, nome, mezzo, libero);
		return rider;
	}
}

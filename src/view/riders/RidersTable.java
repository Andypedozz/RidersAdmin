package view.riders;

import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import model.Rider;
import view.NonEditableTableModel;

public class RidersTable extends JTable {
	
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
}

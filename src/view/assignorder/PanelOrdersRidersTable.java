package view.assignorder;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

import model.Order;
import model.Rider;
import view.MyPanel;
import view.orders.OrdersTable;

public class PanelOrdersRidersTable extends MyPanel {

	private OrdersTable table;
	private JButton removeOrder;
	
	public PanelOrdersRidersTable() {
		this.setTitle("Ordini assegnati");
		this.getContentPane().setLayout(new BorderLayout());
		table = new OrdersTable();
		
		removeOrder = new JButton("Rimuovi ordine da Rider");
		removeOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(removeOrder);
    	JScrollPane scrollPane = new JScrollPane(table);
    	
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
	}
	
	@Override
	public void updateFields() {
		
	}
	
	public JButton getRemoveOrder() {
		return removeOrder;
	}

	public OrdersTable getTable() {
		return this.table;
	}
	
	public void loadData(Rider rider) {
		this.table.loadRows(rider.getOrders());
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		this.table.clear();
	}
}

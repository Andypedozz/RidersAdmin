package view.orders;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import controller.Controller;
import model.Order;
import view.MyPanel;

public class PanelOrdersTable extends MyPanel {
	private Controller controller;
	private OrdersTable table;
	private JButton assignOrder;
	private JButton updateOrders;
	
	public PanelOrdersTable() {
		this.controller = Controller.getInstance();
		this.setTitle("Ordini");
		this.getContentPane().setLayout(new BorderLayout());
		table = new OrdersTable();
		
    	JScrollPane scrollPane = new JScrollPane(table);
    	
		JToolBar toolBar = new JToolBar();
		
		assignOrder = new JButton("Assegna");
		assignOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		updateOrders = new JButton("Aggiorna");
		updateOrders.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		toolBar.add(assignOrder);
		toolBar.add(updateOrders);
    	
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		updateFields();
	}
	
		
	@Override
	public void updateFields() {
		this.table.clear();
		HashMap<Integer, Order> orders = this.controller.getOrders();
		List<Order> list = new LinkedList<Order>();
		orders.forEach((id,order) -> {
			list.add(order);
		});
		loadData(list);
	}
	
	
	
	public JButton getAssignOrderBtn() {
		return assignOrder;
	}


	public JButton getUpdateOrdersBtn() {
		return updateOrders;
	}


	public OrdersTable getTable() {
		return this.table;
	}
	
	private void loadData(List<Order> orders) {
		this.table.loadRows(orders);
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

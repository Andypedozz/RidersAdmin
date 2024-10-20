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
	private JButton viewInfo;
	private JButton addToRider;
	private JButton completed;
	private JButton removeOrder;
	private JButton updateOrders;
	
	public PanelOrdersTable() {
		this.controller = Controller.getInstance();
		this.setTitle("Ordini");
		this.getContentPane().setLayout(new BorderLayout());
		table = new OrdersTable();
		
    	JScrollPane scrollPane = new JScrollPane(table);
    	
		JToolBar toolBar = new JToolBar();
		
		viewInfo = new JButton("Info");
		viewInfo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		addToRider = new JButton("Assegna");
		addToRider.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		completed = new JButton("Completa");
		completed.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		removeOrder = new JButton("Rimuovi");
		removeOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		updateOrders = new JButton("Aggiorna");
		updateOrders.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		toolBar.add(addToRider);
		toolBar.add(completed);
		toolBar.add(removeOrder);
		toolBar.add(updateOrders);
    	
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		initListeners();
		updateFields();
	}
	
	private void initListeners() {
		this.removeOrder.addActionListener(e -> {
			Order order = this.table.getSelected();
			if(order != null) {
				controller.removeOrder(order);
				updateFields();				
			}
		});
		
		this.completed.addActionListener(e -> {
			Order order = this.table.getSelected();
			if(order != null) {
				controller.setCompleted(order);
				updateFields();
			}
		});
		
		this.updateOrders.addActionListener(e -> {
			controller.loadOrders();
			updateFields();
		});
	}

	@Override
	public void updateFields() {
		this.table.clear();
		HashMap<Integer, Order> orders = this.controller.getOrders();
		List<Order> list = new LinkedList<Order>();
		orders.forEach((id,order) -> {
			list.add(order);
		});
		loadOrders(list);
	}
	
	public OrdersTable getTable() {
		return this.table;
	}
	
	private void loadOrders(List<Order> orders) {
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

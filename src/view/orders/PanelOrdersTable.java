package view.orders;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

import controller.Controller;
import model.Order;
import view.MyPanel;

public class PanelOrdersTable extends MyPanel {
	private Controller controller;
	private OrdersTable table;
	private JButton assignOrder;
	private JButton updateOrders;
	private JButton clearBtn;
	private JButton deleteOrder;
	
	public PanelOrdersTable() {
		this.controller = Controller.getInstance();
		this.setTitle("Ordini");
		this.getContentPane().setLayout(new BorderLayout());
		table = new OrdersTable();
		
    	JScrollPane scrollPane = new JScrollPane(table);
    	
		JToolBar toolBar = new JToolBar();
		
		assignOrder = new JButton("Assegna");
		assignOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		deleteOrder = new JButton("Rimuovi");
		deleteOrder.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		updateOrders = new JButton("Aggiorna");
		updateOrders.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		clearBtn = new JButton("Pulisci");
		clearBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		toolBar.add(assignOrder);
		toolBar.add(updateOrders);
		toolBar.add(deleteOrder);
    	
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		updateFields();
		initListeners();
	}
	
	private void initListeners() {
		
		this.deleteOrder.addActionListener(e -> {
			deleteOrder();
		});
		
		this.table.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DELETE) {
					deleteOrder();
				}
			}
			
		});
		
		this.updateOrders.addActionListener(e -> {
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
		loadData(list);
	}
	
	private void deleteOrder() {
		Order order = this.table.getSelected();
		if(order != null) {
			order = controller.getOrders().get(order.getId());
			controller.removeOrder(order);
			updateFields();
		}
	}
	
	public JButton getAssignOrderBtn() {
		return assignOrder;
	}


	public JButton getUpdateOrdersBtn() {
		return updateOrders;
	}

	public JButton getClearBtn() {
		return this.clearBtn;
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

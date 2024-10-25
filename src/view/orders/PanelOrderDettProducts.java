package view.orders;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import controller.Controller;
import model.Order;
import model.Prodotto;
import view.MyPanel;

public class PanelOrderDettProducts extends MyPanel {
	private JScrollPane scrollPane;
	private JPanel dataPanel;
	
	public PanelOrderDettProducts() {
		this.setTitle("Prodotti");
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		this.getContentPane().setLayout(new GridLayout());
	}

	@Override
	public void updateFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		this.getContentPane().removeAll();
		this.revalidate();
	}

	public void loadData(Order order) {
		clear();
		this.dataPanel = new JPanel();
		this.dataPanel.setLayout(new GridLayout(order.getListaProdotti().size(),1));
		for(Prodotto prodotto : order.getListaProdotti()) {
			OrderProductCard card = new OrderProductCard();
			card.loadData(prodotto);
			this.dataPanel.add(card);
		}
		this.scrollPane = new JScrollPane(dataPanel);
		this.scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

}

package view.orders;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.Controller;
import model.Order;
import model.Prodotto;
import view.MyPanel;

public class PanelOrderDettProducts extends MyPanel {
	private Controller controller;
	private JScrollPane scrollPane;
	private JPanel contentPanel;
	
	public PanelOrderDettProducts() {
		this.contentPanel = new JPanel();
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
		this.removeAll();
	}

	public void loadData(Order order) {
		clear();
		this.contentPanel.setLayout(new GridLayout(order.getListaProdotti().size(),1));
		for(Prodotto prodotto : order.getListaProdotti()) {
			ProductCard card = new ProductCard();
			card.loadData(prodotto);
			this.contentPanel.add(card);
		}
		this.scrollPane = new JScrollPane(contentPanel);
		this.add(scrollPane);
	}

}

package view.restaurants;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import controller.Controller;
import model.Prodotto;
import model.Restaurant;
import view.MyPanel;
import view.orders.OrderProductCard;
import view.orders.ProductCard;

public class PanelRestaurantsDettProducts extends MyPanel {
	private JScrollPane scrollPane;
	private JPanel dataPanel;
	
	public PanelRestaurantsDettProducts() {
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
		// TODO Auto-generated method stub
		this.getContentPane().removeAll();
	}

	public void loadData(Restaurant restaurant) {
		clear();
		this.dataPanel = new JPanel();
		this.dataPanel.setLayout(new GridLayout(restaurant.getProdotti().size(),1));
		for(Prodotto prodotto : restaurant.getProdotti()) {
			ProductCard card = new ProductCard();
			card.loadData(prodotto);
			this.dataPanel.add(card);
		}
		this.scrollPane = new JScrollPane(dataPanel);
		this.scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.revalidate();
	}

}

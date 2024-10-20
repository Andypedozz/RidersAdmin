package view.restaurants;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;
import model.Restaurant;
import view.MyPanel;

public class PanelRestaurants extends MyPanel {
	private Controller controller;
	private PanelRestaurantsTable panelTable;
	private PanelRestaurantDett panelDett;
	
	public PanelRestaurants() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.panelDett = new PanelRestaurantDett();
		this.panelTable = new PanelRestaurantsTable();
		this.getContentPane().add(panelDett);
		this.getContentPane().add(panelTable);
		initListeners();
	}
	
	private void initListeners() {
		
		this.panelTable.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Restaurant restaurant = panelTable.getTable().getSelected();
				if(restaurant != null) {
					restaurant = controller.getRestaurants().get(restaurant.getId());
					panelDett.loadData(restaurant);
				}
			}
		});
	}
	
	@Override
	public void updateFields() {
		this.panelTable.updateFields();
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

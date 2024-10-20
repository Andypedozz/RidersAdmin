package view.restaurants;

import java.awt.GridLayout;

import controller.Controller;
import model.Restaurant;
import view.MyPanel;

public class PanelRestaurantDett extends MyPanel {
	private PanelRestaurantsDettGeneral panelRestaurant;
	private PanelRestaurantsDettProducts panelProducts;
	
	public PanelRestaurantDett() {
		this.getContentPane().setLayout(new GridLayout(1,2));
		this.panelRestaurant = new PanelRestaurantsDettGeneral();
		this.panelProducts = new PanelRestaurantsDettProducts();
		getContentPane().add(panelRestaurant);
		getContentPane().add(panelProducts);
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
		this.panelRestaurant.clear();
		this.panelProducts.clear();
	}

	public void loadData(Restaurant restaurant) {
		this.panelRestaurant.loadData(restaurant);
		this.panelProducts.loadData(restaurant);
	}

}

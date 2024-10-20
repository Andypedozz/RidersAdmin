package view.restaurants;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import controller.Controller;
import model.Restaurant;
import view.MyPanel;

public class PanelRestaurantsTable extends MyPanel {

	private Controller controller;
	private RestaurantsTable table;
	private JButton removeRestaurant;
	private JButton updateRestaurants;
	
	public PanelRestaurantsTable() {
		this.controller = Controller.getInstance();
		this.setTitle("Ordini");
		this.getContentPane().setLayout(new BorderLayout());
		table = new RestaurantsTable();
		
    	JScrollPane scrollPane = new JScrollPane(table);
    	
		JToolBar toolBar = new JToolBar();
		
		removeRestaurant = new JButton("Rimuovi");
		removeRestaurant.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		updateRestaurants = new JButton("Aggiorna");
		updateRestaurants.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		toolBar.add(removeRestaurant);
		toolBar.add(updateRestaurants);
    	
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		initListeners();
		updateFields();
	}
	
	private void initListeners() {
		this.updateRestaurants.addActionListener(e -> {
			Restaurant restaurant = this.table.getSelected();
			if(restaurant != null) {
				controller.getRestaurants().remove(restaurant.getId());
				updateFields();
			}
		});
	}
	
	@Override
	public void updateFields() {
		this.table.clear();
		HashMap<Integer, Restaurant> restaurants = this.controller.getRestaurants();
		List<Restaurant> list = new LinkedList<Restaurant>();
		restaurants.forEach((id,restaurant) -> {
			list.add(restaurant);
		});
		loadRestaurants(list);
	}

	private void loadRestaurants(List<Restaurant> list) {
		this.table.loadRows(list);
	}
	
	public RestaurantsTable getTable() {
		return this.table;
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

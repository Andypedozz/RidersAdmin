package view.orders;

import view.MyPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import controller.Controller;

public class PanelOrderDett extends MyPanel {
	private Controller controller;
	private PanelOrderDettGeneral panelOrder;
	private PanelOrderDettProducts panelProducts;
	
	public PanelOrderDett() {
		this.controller = Controller.getInstance();
		this.setLayout(new GridLayout(1,2));
		this.panelOrder = new PanelOrderDettGeneral();
		this.panelProducts = new PanelOrderDettProducts();
		add(panelOrder);
		add(panelProducts);
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
		
	}

}

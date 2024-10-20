package view.riders;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.Controller;
import model.Rider;
import view.MyPanel;

public class PanelRiders extends MyPanel {
	private Controller controller;
	private PanelRidersTable tablePanel;
	private PanelRiderDett panelDett;
	
	public PanelRiders() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.tablePanel = new PanelRidersTable();
		this.panelDett = new PanelRiderDett();
		this.getContentPane().add(panelDett);
		this.getContentPane().add(tablePanel);
		updateFields();
		initListeners();
	}
	
	private void initListeners() {
		this.tablePanel.getTable().addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				Rider rider = tablePanel.getTable().getSelected();
				rider = controller.getRiders().get(rider.getId());
				if(rider != null) {
					panelDett.loadData(rider);
				}
			}
			
		});
	}
	
	@Override
	public void updateFields() {
		this.tablePanel.updateFields();
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

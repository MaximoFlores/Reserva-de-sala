package controller;

import views.Dashboard;

public class Principal {

	public static void main(String[] args) {
		Dashboard dashboard = new Dashboard(new Controller());
		dashboard.getFrame().setVisible(true);
	}

}

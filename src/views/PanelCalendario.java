package views;

import javax.swing.JPanel;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class PanelCalendario extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controller controlador;
	private ArrayList<JLabel> horas;
	
	public PanelCalendario() {
		this.setBounds(0, 0, 732, 603);
		setLayout(null);
		this.horas = new ArrayList<JLabel>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 10, 534, 494);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.rowHeights = new int[]{80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(99, 528, 240, 50);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(393, 527, 240, 52);
		add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 514, 534, 9);
		add(separator);
		
		int columna = 0;
		int fila = 0;
		while(horas.size()<24) {
			JLabel lblNewLabel = new JLabel();
			lblNewLabel.setBackground(Color.green);
			lblNewLabel.setBorder(null);
			lblNewLabel.setOpaque(true);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(1, 1, 1, 1);
			gbc_lblNewLabel.gridx = columna;
			gbc_lblNewLabel.gridy = fila;
			
			panel.add(lblNewLabel, gbc_lblNewLabel);
			horas.add(lblNewLabel);
			
			columna = columna == 0?1:0;
			fila = columna == 0?(fila+1):fila;
						
		}
	}
}

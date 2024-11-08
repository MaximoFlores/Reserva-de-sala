package views;

import javax.swing.JPanel;

import controller.Controller;
import model.Oferta;
import model.Solucion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCalendario extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controller controlador;
	private ArrayList<JTextArea> horas;
	private JPanel panelHoras;
	//Parametro
	private final int cantHoras = 24;

	public PanelCalendario(Controller controlador) {
		this.controlador = controlador;
		setFont(new Font("Segoe UI", Font.BOLD, 15));
		setOpaque(false);
		this.setBounds(0, 0, 732, 603);
		setLayout(null);
		this.horas = new ArrayList<JTextArea>();

		cargarPanelHoras();
		cargarBotones();
	}

	private void cargarPanelHoras() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 10, 534, 494);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		add(scrollPane);

		panelHoras = new JPanel();
		scrollPane.setViewportView(panelHoras);
		GridBagLayout gbl_panelHoras = new GridBagLayout();
		gbl_panelHoras.columnWidths = new int[] {0, 0};
		gbl_panelHoras.rowHeights = new int[]{90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90};
		gbl_panelHoras.columnWeights = new double[]{1.0, 1.0};
		gbl_panelHoras.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panelHoras.setLayout(gbl_panelHoras);

		int columna = 0;
		int fila = 0;
		int index = 1;
		while(horas.size()<cantHoras) {
			JTextArea txtAreaNew = new JTextArea();
			txtAreaNew.setBorder(new MatteBorder(0, 5, 0, 0, new Color(230,230,230)));
			txtAreaNew.setForeground(Color.BLACK);
			txtAreaNew.setFocusable(false);
			txtAreaNew.setBackground(new Color(230,230,230));
			txtAreaNew.setText(index++ + ")");
			txtAreaNew.setFont(new Font("Segoe UI", Font.BOLD,13));
			txtAreaNew.setLineWrap(true); 
			txtAreaNew.setWrapStyleWord(true); 
			txtAreaNew.setEditable(false); 
			txtAreaNew.setOpaque(true);	
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
			gbc_lblNewLabel.insets = new Insets(1, 1, 1, 1);
			gbc_lblNewLabel.gridx = columna;
			gbc_lblNewLabel.gridy = fila;

			panelHoras.add(txtAreaNew, gbc_lblNewLabel);
			horas.add(txtAreaNew);

			columna = columna == 0?1:0;
			fila = columna == 0?(fila+1):fila;			
		}
	}

	private void cargarBotones() {
		JButton btnAGMGoloso = new JButton("Generar por A. Goloso");
		btnAGMGoloso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controlador.existeOfertas()) {
					limpiarCalendario();
					Solucion mejorSol = controlador.getSolAG();
					Oferta[] oferta = controlador.getSolAG().getHorario();
					for (int i = 0; i < horas.size(); i++) {
						if(oferta[i] != null)
							horas.get(i).setText((i+1) + ")\nNombre: " + oferta[i].getNombreOferente() + "\nID: "+
									oferta[i].getID() + " - Telefono: " + oferta[i].getTelefono() +
									"\nCant.Integrantes: " + oferta[i].getCantIntegrantes() + " - monto: " +oferta[i].getMonto()) ;	
					}
					JOptionPane.showMessageDialog(getParent(), "El monto total de la reserva es:  " + mejorSol.getMonto() + ".","Monto total por A. goloso",JOptionPane.DEFAULT_OPTION);
				}else {
					JOptionPane.showMessageDialog(getParent(), "No hay ofertas para generar un calendario", "ERROR!!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAGMGoloso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAGMGoloso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAGMGoloso.setBounds(99, 528, 240, 50);
		add(btnAGMGoloso);

		JButton btnAGMPolinomial = new JButton("Generar por A. Polinomial");
		btnAGMPolinomial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAGMPolinomial.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAGMPolinomial.setBounds(393, 527, 240, 52);
		add(btnAGMPolinomial);

		JSeparator separator = new JSeparator();
		separator.setBounds(99, 514, 534, 9);
		add(separator);
	}

	protected void limpiarCalendario() {
		for (int i = 0; i < horas.size(); i++) {
			horas.get(i).setText((i+1) + ")");
		}
		
	}
}

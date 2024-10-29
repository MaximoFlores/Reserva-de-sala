package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import defaultSala.Oferta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfMonto;
	private DefaultTableModel modelTable;
	private JSpinner spCantInt;
	private JSpinner spHasta;
	private JSpinner spDesde;

	@SuppressWarnings("serial")
	public PanelRegistro() {
		this.setBounds(0, 0, 732, 603);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 0, 644, 397);
		add(scrollPane);
		
		modelTable = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre", "Telefono", "Monto", "Desde", "Hasta", "Integrantes"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
		table = new JTable(modelTable);
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNombre.setBounds(44, 419, 95, 13);
		
		tfNombre = new JTextField();
		tfNombre.setBackground(new Color(255, 255, 255));
		tfNombre.setBounds(44, 442, 150, 30);
		tfNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTelefono.setBounds(44, 477, 95, 13);
		
		tfTelefono = new JTextField();
		tfTelefono.setBackground(new Color(255, 255, 255));
		tfTelefono.setBounds(44, 500, 150, 30);
		tfTelefono.setColumns(10);
		
		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHorario.setBounds(44, 535, 95, 13);
		
		spDesde = new JSpinner();
		spDesde.setBackground(new Color(255, 255, 255));
		spDesde.setBounds(44, 558, 55, 30);
				
		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(109, 556, 20, 30);
				
		spHasta = new JSpinner();
		spHasta.setBackground(new Color(255, 255, 255));
		spHasta.setBounds(139, 558, 55, 30);
				
		JLabel lblHS = new JLabel("hs");
		lblHS.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHS.setBounds(204, 556, 31, 30);
				
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMonto.setBounds(217, 421, 73, 13);
				
		tfMonto = new JTextField();
		tfMonto.setBackground(new Color(255, 255, 255));
		tfMonto.setBounds(217, 442, 150, 30);		
		tfMonto.setColumns(10);
		
		JLabel lblIntegrantes = new JLabel("Cant. Integrantes");
		lblIntegrantes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblIntegrantes.setBounds(217, 473, 118, 20);
				
		spCantInt = new JSpinner();
		spCantInt.setBackground(new Color(255, 255, 255));
		spCantInt.setBounds(217, 500, 150, 30);
				
		JButton btnAñadirOferta = new JButton("Añadir Oferta");
		btnAñadirOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int monto = Integer.valueOf(tfMonto.getText());
				int horaDesde = (int) spDesde.getValue();
				int horaHasta = (int) spHasta.getValue();
				int cantIntegrantes = (int) spCantInt.getValue();
				
				try {
					new Oferta(tfNombre.getText(), tfTelefono.getText(), monto, horaDesde, horaHasta, cantIntegrantes);
				} catch (Exception e) {
//					JOptionPane aviso = new JOp;
				}
				
				modelTable.addRow(new Object[] {tfNombre.getText(),tfTelefono.getText(),monto,
						horaDesde,horaHasta,cantIntegrantes});
				
				limpiarCampos();
			}


		});
		btnAñadirOferta.setForeground(new Color(0, 0, 0));
		btnAñadirOferta.setBackground(new Color(255, 255, 255));
		btnAñadirOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAñadirOferta.setBounds(387, 440, 130, 40);
				
		JButton btnEliminarOferta = new JButton("Eliminar Oferta");
		btnEliminarOferta.setForeground(new Color(0, 0, 0));
		btnEliminarOferta.setBackground(new Color(255, 255, 255));
		btnEliminarOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnEliminarOferta.setBounds(387, 490, 130, 40);
				
		JButton btnCargarArchivo = new JButton("Cargar Archivo");
		btnCargarArchivo.setForeground(new Color(0, 0, 0));
		btnCargarArchivo.setBackground(new Color(255, 255, 255));
		btnCargarArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCargarArchivo.setBounds(387, 540, 130, 40);	

		add(lblNombre);
		add(tfNombre);
		add(lblTelefono);
		add(tfTelefono);
		add(lblHorario);
		add(spDesde);
		add(lblA);
		add(spHasta);
		add(lblHS);
		add(lblMonto);
		add(tfMonto);
		add(lblIntegrantes);
		add(spCantInt);
		add(btnAñadirOferta);
		add(btnEliminarOferta);
		add(btnCargarArchivo);
	}

	private void limpiarCampos() {
		tfNombre.setText("");
		tfTelefono.setText("");
		tfMonto.setText("");
		spCantInt.setValue(0);
	}

}

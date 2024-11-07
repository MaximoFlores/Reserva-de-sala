package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;

import controller.Controller;
import model.Oferta;
import model.Sala;
import utilidades.CustomAlignmentRenderer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.List;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class PanelRegistro extends JPanel implements Observador{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfMonto;
	private DefaultTableModel modelTable;
	private JSpinner spCantInt;
	private JSpinner spHasta;
	private JSpinner spDesde;
	private JLabel lblErrorTelefono;
	private JButton btnAñadirOferta;
	private Controller _controlador;
	private JTextArea lblMensageBotones;

	public PanelRegistro(Controller controlador) {
		setOpaque(false);
		UIManager.put("Table.showHorizontalLines", true);
		UIManager.put("Table.showVerticalLines", true);
		_controlador = controlador;
		this.setBounds(0, 0, 732, 603);
		setLayout(null);

		cargarTabla();
		cargarBotones();
		cargarEstilos();
	}

	private void cargarBotones() {
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNombre.setBounds(44, 419, 95, 20);

		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char l = Character.toLowerCase(e.getKeyChar());
				if(!(l>='a' && l<='z' || l == ' '))
					e.consume();
			}
		});
		tfNombre.setBackground(new Color(255, 255, 255));
		tfNombre.setBounds(44, 442, 150, 30);
		tfNombre.setColumns(10);		

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTelefono.setBounds(44, 477, 95, 20);

		lblErrorTelefono = new JLabel("");
		lblErrorTelefono.setBounds(94, 482, 100, 13);

		tfTelefono = new JTextField();
		tfTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char l = e.getKeyChar();
				if(!(l >= '0' && l <= '9') || tfTelefono.getText().length()>=10)
					e.consume();
			}
		});
		tfTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(tfTelefono.getText().length()<10)
					tfTelefono.putClientProperty("JComponent.outline", "error");
			}
		});
		tfTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		tfTelefono.setBackground(new Color(255, 255, 255));
		tfTelefono.setBounds(44, 500, 150, 30);
		tfTelefono.setColumns(10);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHorario.setBounds(44, 535, 95, 13);

		spDesde = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		spDesde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int hDesde = (int)spDesde.getValue();
				int hHasta = (int) spHasta.getValue();
				int nuevoValor = hHasta < hDesde ? hDesde:hHasta;
				spHasta.setModel(new SpinnerNumberModel(nuevoValor, hDesde, 24, 1));
			}
		});
		spDesde.setBackground(new Color(255, 255, 255));
		spDesde.setBounds(44, 558, 55, 30);

		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(109, 556, 20, 30);

		spHasta = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		spHasta.setBackground(new Color(255, 255, 255));
		spHasta.setBounds(139, 558, 55, 30);

		JLabel lblHS = new JLabel("hs");
		lblHS.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHS.setBounds(204, 556, 31, 30);

		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMonto.setBounds(217, 421, 73, 18);

		tfMonto = new JTextField();
		tfMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char l = Character.toLowerCase(e.getKeyChar());
				if(!(l >= '0' && l <= '9'))
					e.consume();
			}
		});
		tfMonto.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMonto.setText("0");
		tfMonto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(tfMonto.getText().length() == 0)
					tfMonto.setText("0");
			}
		});
		tfMonto.setBackground(new Color(255, 255, 255));
		tfMonto.setBounds(217, 442, 150, 30);		
		tfMonto.setColumns(10);

		JLabel lblIntegrantes = new JLabel("Cant. Integrantes");
		lblIntegrantes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblIntegrantes.setBounds(217, 473, 118, 24);

		spCantInt = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
		spCantInt.setBackground(new Color(255, 255, 255));
		spCantInt.setBounds(217, 500, 150, 30);

		btnAñadirOferta = new JButton("Añadir Oferta");
		btnAñadirOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadirOferta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMensageBotones.setText("Registra la oferta \n "
						+ "pasada con los valores elegidos");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMensageBotones.setText("");
			}
		});
		btnAñadirOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(tfNombre.getText().isEmpty() || tfTelefono.getText().isEmpty()) {
					JOptionPane.showMessageDialog(getParent(), "Algun dato ingresado es invalido!!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					int monto = Integer.parseInt(tfMonto.getText());
					int horaDesde = (int) spDesde.getValue();
					int horaHasta = (int) spHasta.getValue();
					int cantIntegrantes = (int) spCantInt.getValue();

					Oferta oferta = new Oferta(tfNombre.getText(), tfTelefono.getText(), monto, horaDesde, horaHasta, cantIntegrantes);
					_controlador.agregarOferta(oferta);
					limpiarCampos();		
				}	
			}
		});
		btnAñadirOferta.setForeground(new Color(0, 0, 0));
		btnAñadirOferta.setBackground(new Color(255, 255, 255));
		btnAñadirOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAñadirOferta.setBounds(387, 440, 130, 40);

		JButton btnEliminarOferta = new JButton("Eliminar Oferta");
		btnEliminarOferta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarOferta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMensageBotones.setText("");
			}
		});
		btnEliminarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				if(!(fila == -1)) {
					int id = (int) (modelTable.getValueAt(fila, 0));
					_controlador.eliminarOferta(id);
				}
			}
		});
		btnEliminarOferta.setForeground(new Color(0, 0, 0));
		btnEliminarOferta.setBackground(new Color(255, 255, 255));
		btnEliminarOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnEliminarOferta.setBounds(387, 490, 130, 40);

		JButton btnCargarArchivo = new JButton("Cargar Archivo");
		btnCargarArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCargarArchivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblMensageBotones.setText("");
			}
		});
		btnCargarArchivo.setForeground(new Color(0, 0, 0));
		btnCargarArchivo.setBackground(new Color(255, 255, 255));
		btnCargarArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCargarArchivo.setBounds(387, 540, 130, 40);	

		add(lblNombre);
		add(tfNombre);
		add(lblErrorTelefono);
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
		
		lblMensageBotones = new JTextArea("");
		lblMensageBotones.setBounds(558, 419, 130, 165);
		lblMensageBotones.setLineWrap(true); 
		lblMensageBotones.setWrapStyleWord(true); 
		lblMensageBotones.setEditable(false); 
		lblMensageBotones.setOpaque(false); 
		add(lblMensageBotones);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(182, 182, 182));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(537, 420, 5, 165);
		add(separator);
	}

	private void cargarTabla() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 0, 644, 397);
		add(scrollPane);
		modelTable = new DefaultTableModel(new Object[][] {}, new String[] {"ID","Nombre",
				"Telefono", "Monto", "Horario", "Integrantes"}) {
			private static final long serialVersionUID = 1327456263074663053L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelTable);
		table.setDefaultRenderer(Object.class, new CustomAlignmentRenderer());
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		scrollPane.setViewportView(table);
	}

	private void limpiarCampos() {
		tfNombre.setText("");
		tfTelefono.setText("");
		tfMonto.setText("0");
		spCantInt.setValue(((SpinnerNumberModel) spCantInt.getModel()).getMinimum());
	}

	private void cargarEstilos() {
		tfNombre.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduce un nombre");
		tfTelefono.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Introduce un telefono");
	}

	@Override
	public void notificar(Sala sala) {
		List<Oferta> ofertas = sala.getOfertas();
		modelTable.setRowCount(0);
		for (Oferta oferta : ofertas) {
			String horario = oferta.getHoraDesde() + " a " + oferta.getHoraHasta();
			modelTable.addRow(new Object[] {oferta.getID(), oferta.getNombreOferente(), 
					oferta.getTelefono(), oferta.getMonto(), horario, oferta.getCantIntegrantes()});
		}
	}	
}	


package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import utilidades.CustomAlignmentRenderer;

import javax.swing.AbstractSpinnerModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Color;

public class View {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel modelTable;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfMonto;
	private JPanel _panelRegistro;
	private JPanel _panelPrincipal;
	private JPanel _panelCalendario;
	private JSpinner _spHasta;

	public View() {
		FlatLightLaf.setup();
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1020, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		cargarPanelPrincipal();	
	}

	private void cargarPanelPrincipal() {
		_panelPrincipal = new JPanel();
		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[]{256, 384};
		gbl_panelPrincipal.rowHeights = new int[]{603, 0};
		gbl_panelPrincipal.columnWeights = new double[]{1.0, 1.0};
		gbl_panelPrincipal.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		_panelPrincipal.setLayout(gbl_panelPrincipal);

		cargarPanelCalendario();		
		cargarPanelRegistro();
		frame.getContentPane().add(_panelPrincipal, BorderLayout.CENTER);
	}

	private void cargarPanelCalendario() {
		_panelCalendario = new JPanel();
		_panelCalendario.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelCalendario = new GridBagConstraints();
		gbc_panelCalendario.fill = GridBagConstraints.BOTH;
		gbc_panelCalendario.gridx = 0;
		gbc_panelCalendario.gridy = 0;
		GridBagLayout gbl_panelCalendario = new GridBagLayout();
		gbl_panelCalendario.columnWidths = new int[]{0};
		gbl_panelCalendario.rowHeights = new int[] {0, 350, 100};
		gbl_panelCalendario.columnWeights = new double[]{1.0};
		gbl_panelCalendario.rowWeights = new double[]{0.0, 1.0, 1.0};
		_panelCalendario.setLayout(gbl_panelCalendario);

		cargarTituloCalendario();		
		cargarContainerVisualCalendario();
		cargarBotonesCalendario();

		_panelPrincipal.add(_panelCalendario, gbc_panelCalendario);
	}

	private void cargarTituloCalendario() {
		JLabel lblTituloCalendario = new JLabel("Calendario");
		lblTituloCalendario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblTituloCalendario = new GridBagConstraints();
		gbc_lblTituloCalendario.insets = new Insets(5, 0, 5, 0);
		gbc_lblTituloCalendario.gridx = 0;
		gbc_lblTituloCalendario.gridy = 0;
		_panelCalendario.add(lblTituloCalendario, gbc_lblTituloCalendario);
	}

	private void cargarContainerVisualCalendario() {
		JScrollPane JScrollContenedorCalendario = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 10, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;

		JPanel panelCalendarioVisual = new JPanel();
		panelCalendarioVisual.setPreferredSize(new Dimension(200, 600));
		panelCalendarioVisual.setLayout(new GridLayout(12, 2, 0, 0));

		for (int i = 0; i < 24; i++) {
			JButton button = new JButton((i+1) + " : ");
			button.setHorizontalAlignment(SwingConstants.LEFT);
			panelCalendarioVisual.add(button);
		}

		JScrollContenedorCalendario.setViewportView(panelCalendarioVisual);
		_panelCalendario.add(JScrollContenedorCalendario, gbc_scrollPane_1);
	}

	private void cargarBotonesCalendario() {
		JPanel panelCalendarioBotones = new JPanel();
		panelCalendarioBotones.setOpaque(false);
		GridBagConstraints gbc_panelCalendarioBotones = new GridBagConstraints();
		gbc_panelCalendarioBotones.fill = GridBagConstraints.BOTH;
		gbc_panelCalendarioBotones.gridx = 0;
		gbc_panelCalendarioBotones.gridy = 2;
		_panelCalendario.add(panelCalendarioBotones, gbc_panelCalendarioBotones);
	}

	private void cargarPanelRegistro() {
		_panelRegistro = new JPanel();
		_panelRegistro.setBackground(new Color(21, 101, 192));
		GridBagConstraints gbc_panelRegistro = new GridBagConstraints();
		gbc_panelRegistro.fill = GridBagConstraints.BOTH;
		gbc_panelRegistro.gridx = 1;
		gbc_panelRegistro.gridy = 0;
		GridBagLayout gbl_panelRegistro = new GridBagLayout();
		gbl_panelRegistro.columnWidths = new int[]{0};
		gbl_panelRegistro.rowHeights = new int[]{0,380, 210};
		gbl_panelRegistro.columnWeights = new double[]{1.0};
		gbl_panelRegistro.rowWeights = new double[]{0.0, 1.0, 1.0};
		_panelRegistro.setLayout(gbl_panelRegistro);

		cargarTituloRegistro();
		cargarTablaRegistro();
		cargarBotonesRegistro();

		_panelPrincipal.add(_panelRegistro, gbc_panelRegistro);
	}

	private void cargarTituloRegistro() {
		JLabel lblTituloRegistro = new JLabel("Registro de Ofertas");
		lblTituloRegistro.setForeground(new Color(255, 255, 255));
		lblTituloRegistro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblTituloRegistro = new GridBagConstraints();
		gbc_lblTituloRegistro.insets = new Insets(5, 0, 5, 0);
		gbc_lblTituloRegistro.gridx = 0;
		gbc_lblTituloRegistro.gridy = 0;

		_panelRegistro.add(lblTituloRegistro, gbc_lblTituloRegistro);
	}

	private void cargarTablaRegistro() {
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 5, 5, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;

		String[] nombreColumnas = {"ID","Nombre","Telefono","Monto","Horario","Cant. Integrantes"};
		modelTable = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modelTable.setColumnIdentifiers(nombreColumnas);
		table = new JTable(modelTable);	
		table.setDefaultRenderer(Object.class, new CustomAlignmentRenderer());	
		scrollPane.setViewportView(table);
		_panelRegistro.add(scrollPane, gbc_scrollPane);
	} 

	private void cargarBotonesRegistro() {
		JPanel panelRegistroBotones = new JPanel();
		panelRegistroBotones.setOpaque(false);
		GridBagConstraints gbc_panelRegistroBotones = new GridBagConstraints();
		gbc_panelRegistroBotones.insets = new Insets(0, 5, 10, 10);
		gbc_panelRegistroBotones.fill = GridBagConstraints.BOTH;
		gbc_panelRegistroBotones.gridx = 0;
		gbc_panelRegistroBotones.gridy = 2;

		GridBagLayout gbl_panelRegistroBotones = new GridBagLayout();
		gbl_panelRegistroBotones.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRegistroBotones.rowHeights = new int[]{0, 0, 0, 0, 0, 0, };
		gbl_panelRegistroBotones.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRegistroBotones.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		panelRegistroBotones.setLayout(gbl_panelRegistroBotones);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 3;
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char letra = Character.toLowerCase(e.getKeyChar());
				if(!(letra >= 'a' && letra <= 'z' || letra == ' '))
					e.consume();
			}
		});
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.gridwidth = 3;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.BOTH;
		gbc_tfNombre.gridx = 0;
		gbc_tfNombre.gridy = 1;
		tfNombre.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.gridwidth = 3;
		gbc_lblTelefono.fill = GridBagConstraints.BOTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 2;

		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_tfTelefono = new GridBagConstraints();
		gbc_tfTelefono.gridwidth = 3;
		gbc_tfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_tfTelefono.fill = GridBagConstraints.BOTH;
		gbc_tfTelefono.gridx = 0;
		gbc_tfTelefono.gridy = 3;		
		tfTelefono.setColumns(10);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setForeground(new Color(255, 255, 255));
		lblHorario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.gridwidth = 3;
		gbc_lblHorario.fill = GridBagConstraints.BOTH;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 0;
		gbc_lblHorario.gridy = 4;

		JSpinner spDesde = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		spDesde.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		spDesde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valorDesde = (int) spDesde.getValue();
				int valorHasta = (int) _spHasta.getValue();
				int valor = valorDesde < valorHasta? valorHasta:valorDesde;
				_spHasta.setModel(new SpinnerNumberModel(valor,valorDesde,24,1));
			}
		});
		GridBagConstraints gbc_spDesde = new GridBagConstraints();
		gbc_spDesde.fill = GridBagConstraints.BOTH;
		gbc_spDesde.insets = new Insets(0, 0, 0, 5);
		gbc_spDesde.gridx = 0;
		gbc_spDesde.gridy = 5;

		JLabel lblA = new JLabel("a");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setHorizontalTextPosition(SwingConstants.LEFT);
		lblA.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.fill = GridBagConstraints.BOTH;
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 5;

		_spHasta = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
		_spHasta.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_spHasta = new GridBagConstraints();
		gbc_spHasta.fill = GridBagConstraints.BOTH;
		gbc_spHasta.insets = new Insets(0, 0, 0, 5);
		gbc_spHasta.gridx = 2;
		gbc_spHasta.gridy = 5;

		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setForeground(new Color(255, 255, 255));
		lblMonto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblMonto = new GridBagConstraints();
		gbc_lblMonto.gridwidth = 3;
		gbc_lblMonto.fill = GridBagConstraints.BOTH;
		gbc_lblMonto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonto.gridx = 4;
		gbc_lblMonto.gridy = 0;

		tfMonto = new JTextField();
		tfMonto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_tfMonto = new GridBagConstraints();
		gbc_tfMonto.gridwidth = 3;
		gbc_tfMonto.insets = new Insets(0, 0, 5, 5);
		gbc_tfMonto.fill = GridBagConstraints.BOTH;
		gbc_tfMonto.gridx = 4;
		gbc_tfMonto.gridy = 1;
		tfMonto.setColumns(10);

		JButton btnRegistrarOferta = new JButton("Registrar Oferta");
		btnRegistrarOferta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_btnRegistrarOferta = new GridBagConstraints();
		gbc_btnRegistrarOferta.fill = GridBagConstraints.BOTH;
		gbc_btnRegistrarOferta.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarOferta.gridx = 8;
		gbc_btnRegistrarOferta.gridy = 1;

		JLabel lblCantInteg = new JLabel("Cant. Integrantes");
		lblCantInteg.setForeground(new Color(255, 255, 255));
		lblCantInteg.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_lblCantInteg = new GridBagConstraints();
		gbc_lblCantInteg.gridwidth = 3;
		gbc_lblCantInteg.fill = GridBagConstraints.BOTH;
		gbc_lblCantInteg.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantInteg.gridx = 4;
		gbc_lblCantInteg.gridy = 2;

		JSpinner spCantInteg = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
		spCantInteg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_spCantInteg = new GridBagConstraints();
		gbc_spCantInteg.fill = GridBagConstraints.BOTH;
		gbc_spCantInteg.gridwidth = 3;
		gbc_spCantInteg.insets = new Insets(0, 0, 5, 5);
		gbc_spCantInteg.gridx = 4;
		gbc_spCantInteg.gridy = 3;	

		JButton btnEliminarOferta = new JButton("Eliminar Oferta");
		btnEliminarOferta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_btnEliminarOferta = new GridBagConstraints();
		gbc_btnEliminarOferta.fill = GridBagConstraints.BOTH;
		gbc_btnEliminarOferta.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminarOferta.gridx = 8;
		gbc_btnEliminarOferta.gridy = 3;

		JButton btnCargarOferta = new JButton("Cargar Oferta");
		btnCargarOferta.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GridBagConstraints gbc_btnCargarOferta = new GridBagConstraints();
		gbc_btnCargarOferta.fill = GridBagConstraints.BOTH;
		gbc_btnCargarOferta.gridx = 8;
		gbc_btnCargarOferta.gridy = 5;
		panelRegistroBotones.add(lblNombre, gbc_lblNombre);
		panelRegistroBotones.add(tfNombre, gbc_tfNombre);
		panelRegistroBotones.add(lblTelefono, gbc_lblTelefono);
		panelRegistroBotones.add(tfTelefono, gbc_tfTelefono);
		panelRegistroBotones.add(lblHorario, gbc_lblHorario);
		panelRegistroBotones.add(spDesde, gbc_spDesde);
		panelRegistroBotones.add(lblA, gbc_lblA);
		panelRegistroBotones.add(_spHasta, gbc_spHasta);
		panelRegistroBotones.add(lblMonto, gbc_lblMonto);
		panelRegistroBotones.add(tfMonto, gbc_tfMonto);
		panelRegistroBotones.add(btnRegistrarOferta, gbc_btnRegistrarOferta);
		panelRegistroBotones.add(lblCantInteg, gbc_lblCantInteg);
		panelRegistroBotones.add(spCantInteg, gbc_spCantInteg);
		panelRegistroBotones.add(btnEliminarOferta, gbc_btnEliminarOferta);
		panelRegistroBotones.add(btnCargarOferta, gbc_btnCargarOferta);
		_panelRegistro.add(panelRegistroBotones, gbc_panelRegistroBotones);
	}
}
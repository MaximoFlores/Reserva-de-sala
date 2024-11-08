package views;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;

import controller.Controller;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dashboard {

	private JFrame frame;
	private Controller _controlador;
	private JPanel _panelPrincipal;
	private JPanel panelContenedor;
	private JPanel _panelMenu;
	private PanelRegistro _panelRegistro;
	private PanelCalendario _panelCalendario; //cambiar la clase

	private JLabel lblTitulo;

	public Dashboard(Controller controller) {	
		FlatLightLaf.setup();
		_controlador = controller;
		_panelRegistro = new PanelRegistro(controller);
		_panelCalendario = new PanelCalendario(controller);
		_controlador.agregarObs(_panelRegistro);
		initializeStyles();
		initialize();	
	}

	public JFrame getFrame() {
		return frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrar();			
			}
		});
		frame.setResizable(false);
		frame.setBounds(0, 0, 1020, 640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		_panelPrincipal = new JPanel();
		_panelPrincipal.setBackground(new Color(255, 255, 255));
		_panelPrincipal.setLayout(null);
		frame.getContentPane().add(_panelPrincipal, BorderLayout.CENTER);

		cargarMenu();
		cargarContenedor();	
		stylesComponentsPersonalized();	
	}

	private void cargarContenedor() {
		panelContenedor = new JPanel();
		panelContenedor.setOpaque(false);
		panelContenedor.setBounds(274, 0, 732, 603);
		panelContenedor.setLayout(null);
		showPanel(_panelRegistro);

		_panelPrincipal.add(panelContenedor);
	}

	private void cargarMenu() {
		_panelMenu = new JPanel();
		_panelMenu.setBackground(new Color(13, 71, 161));
		_panelMenu.setBounds(0, 0, 270, 603);
		_panelMenu.setLayout(null);		

		cargarBotonesMenu();

		_panelPrincipal.add(_panelMenu);
	}

	private void cargarBotonesMenu() {

		lblTitulo = new JLabel("Reservas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(31, 45, 201, 48);

		JSeparator jseparator = new JSeparator();
		jseparator.setBounds(31, 103, 201, 11);

		JButton btnOfertas = new JButton("Ofertas");
		cargarConfigBotonesMenu(btnOfertas, _panelRegistro, "/recursos/Bookmark.png");
		btnOfertas.setBounds(0, 161, 270, 60);

		JButton btnCalendario = new JButton("Calendario");
		cargarConfigBotonesMenu(btnCalendario, _panelCalendario, "/recursos/calendar-plus.png");
		btnCalendario.setBounds(0, 221, 270, 60);

		_panelMenu.add(lblTitulo);
		_panelMenu.add(jseparator);
		_panelMenu.add(btnOfertas);
		_panelMenu.add(btnCalendario);
	}

	public void showPanel(JPanel panel) {
		panelContenedor.removeAll();
		panelContenedor.add(panel);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}

	private void initializeStyles() {
		UIManager.put( "Separator.stripeWidth", 3 );
	}

	private void stylesComponentsPersonalized() {
		lblTitulo.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
		lblTitulo.setForeground(Color.WHITE);
	}

	private void cargarConfigBotonesMenu(JButton boton,JPanel panelAMostrar, String icon) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel(panelAMostrar);
			}
		});
		boton.setIconTextGap(10);
		boton.setIcon(new ImageIcon(Dashboard.class.getResource(icon)));
		boton.setForeground(new Color(255, 255, 255));
		boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		boton.setHorizontalAlignment(SwingConstants.LEFT);
		boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boton.setBorderPainted(false);
		boton.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		boton.setBackground(new Color(21, 101, 192));	
	}

	private void cerrar() { 
		if(_controlador.hayCambios()) {
			int option = JOptionPane.showOptionDialog(frame, "Quieres guardar las ofertas antes de cerrar?", "Guardar?", 0, 0, null, null, frame);
			if(option == JOptionPane.YES_OPTION)
				_controlador.guardarInstancia();
		}
		System.exit(0);
	}
}

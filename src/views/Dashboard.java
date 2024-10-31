package views;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class Dashboard {

	private JFrame frame;
	private JLabel lblTitulo;
	private JPanel panelContenedor;
	private JSeparator jseparator;
	private JButton btnCalendario;
	private JButton btnOfertas;
	private JButton btnArchivo;
	private JButton btnConfig;
	private JPanel _panelPrincipal;
	private JPanel _panelMenu;

	public Dashboard() {		
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		initializeStyles();
		initialize();
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1020, 640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		_panelPrincipal = new JPanel();
		_panelPrincipal.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(_panelPrincipal, BorderLayout.CENTER);
		_panelPrincipal.setLayout(null);

		_panelMenu = new JPanel();
		_panelMenu.setBackground(new Color(13, 71, 161));
		_panelMenu.setBounds(0, 0, 270, 603);
		_panelMenu.setLayout(null);
		
		lblTitulo = new JLabel("Reservas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(31, 45, 201, 48);

		jseparator = new JSeparator();
		jseparator.setBounds(31, 103, 201, 11);

		btnOfertas = new JButton("Ofertas");
		btnOfertas.setIconTextGap(10);
		btnOfertas.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/Bookmark.png")));
		btnOfertas.setForeground(new Color(255, 255, 255));
		btnOfertas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnOfertas.setHorizontalAlignment(SwingConstants.LEFT);
		btnOfertas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOfertas.setBorderPainted(false);
		btnOfertas.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		btnOfertas.setBackground(new Color(21, 101, 192));
		btnOfertas.setBounds(0, 161, 270, 60);

		btnCalendario = new JButton("Calendario");
		btnCalendario.setIconTextGap(10);
		btnCalendario.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/calendar-plus.png")));
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCalendario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalendario.setBorderPainted(false);
		btnCalendario.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		btnCalendario.setBackground(new Color(21, 101, 192));
		btnCalendario.setBounds(0, 221, 270, 60);

		btnArchivo = new JButton("Archivo");
		btnArchivo.setIconTextGap(10);
		btnArchivo.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/file-chart.png")));
		btnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnArchivo.setForeground(new Color(255, 255, 255));
		btnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnArchivo.setHorizontalAlignment(SwingConstants.LEFT);
		btnArchivo.setBorderPainted(false);
		btnArchivo.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		btnArchivo.setBackground(new Color(21, 101, 192));
		btnArchivo.setBounds(0, 281, 270, 60);

		btnConfig = new JButton("Configuracion");
		btnConfig.setIconTextGap(10);
		btnConfig.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/Settings.png")));
		btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfig.setForeground(new Color(255, 255, 255));
		btnConfig.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConfig.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfig.setBorderPainted(false);
		btnConfig.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		btnConfig.setBackground(new Color(21, 101, 192));
		btnConfig.setBounds(0, 341, 270, 60);

		panelContenedor = new JPanel();
		panelContenedor.setOpaque(false);
		panelContenedor.setBounds(274, 0, 732, 603);
		panelContenedor.setLayout(null);
		panelContenedor.add(new PanelRegistro());

		_panelPrincipal.add(_panelMenu);
		_panelMenu.add(lblTitulo);
		_panelMenu.add(jseparator);
		_panelMenu.add(btnOfertas);
		_panelMenu.add(btnCalendario);
		_panelMenu.add(btnArchivo);
		_panelMenu.add(btnConfig);

		_panelPrincipal.add(panelContenedor);
		
		stylesComponentsPersonalized();
		
	}


	public void addPanelToContainer(JPanel panel) {
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
		btnArchivo.putClientProperty("FlatLaf.style", "font: bold $h1.font");
		btnArchivo.putClientProperty("JButton.background", Color.RED);
//		jseparator.putClientProperty("JSeparator.foreground", Color.RED);
//		jseparator.putClientProperty("Separator.background", Color.RED);
//		Separator.background
	}
	
	
}

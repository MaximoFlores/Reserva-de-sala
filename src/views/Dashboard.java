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
	private JSeparator separator;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
//		FlatLightLaf.setup();
		initialize();
		initializeStyles();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1020, 640);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(null);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(13, 71, 161));
		panelMenu.setBounds(0, 0, 270, 603);
		panelPrincipal.add(panelMenu);
		panelMenu.setLayout(null);

		JButton btnOfertas = new JButton("Ofertas");
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
		panelMenu.add(btnOfertas);

		JButton btnCalendario = new JButton("Calendario");
		btnCalendario.setIconTextGap(10);
		btnCalendario.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/calendar-plus.png")));
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCalendario.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalendario.setBorderPainted(false);
		btnCalendario.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		btnCalendario.setBackground(new Color(21, 101, 192));
		btnCalendario.setBounds(0, 221, 270, 60);
		panelMenu.add(btnCalendario);

		JButton btnArchivo = new JButton("Archivo");
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
		panelMenu.add(btnArchivo);

		JButton Configuracion = new JButton("Configuracion");
		Configuracion.setIconTextGap(10);
		Configuracion.setIcon(new ImageIcon(Dashboard.class.getResource("/recursos/Settings.png")));
		Configuracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Configuracion.setForeground(new Color(255, 255, 255));
		Configuracion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Configuracion.setHorizontalAlignment(SwingConstants.LEFT);
		Configuracion.setBorderPainted(false);
		Configuracion.setBorder(new MatteBorder(1, 10, 1, 1, (Color) new Color(0, 0, 0)));
		Configuracion.setBackground(new Color(21, 101, 192));
		Configuracion.setBounds(0, 341, 270, 60);
		panelMenu.add(Configuracion);

		separator = new JSeparator();
		separator.setBounds(31, 103, 201, 11);
		
		panelMenu.add(separator);

		lblTitulo = new JLabel("Reservas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(31, 45, 201, 48);
		panelMenu.add(lblTitulo);

		panelContenedor = new JPanel();
		panelContenedor.setOpaque(false);
		panelContenedor.setBounds(274, 0, 732, 603);
		panelPrincipal.add(panelContenedor);
		panelContenedor.setLayout(null);

		addPanel(new PanelRegistro());

	}

	public void addPanel(JPanel panel) {
		panelContenedor.add(panel);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}

	private void initializeStyles() {
		lblTitulo.putClientProperty( "FlatLaf.style", "font: bold $h1.font" );
		lblTitulo.setForeground(Color.WHITE);
		
	}
}

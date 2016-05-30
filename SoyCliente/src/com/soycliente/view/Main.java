package com.soycliente.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.soycliente.enumeration.CalendarDay;
import com.soycliente.enumeration.CalendarMonth;
import com.soycliente.enumeration.City;
import com.soycliente.enumeration.OperationType;
import com.soycliente.enumeration.ProductType;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String[] CALENDAR_YEARS = {"2016", "2017", "2018", "2019", "2020"};
	
	/**
	 * 
	 */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel solicitudPanel = new JPanel();
		solicitudPanel.setBackground(Color.WHITE);
		contentPane.add(solicitudPanel);
		GridBagLayout gbl_solicitudPanel = new GridBagLayout();
		gbl_solicitudPanel.columnWidths = new int[]{0, 0, 30, 0, 0, 0, 4, 0, 0, 0};
		gbl_solicitudPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 35, 0, 0, 0};
		gbl_solicitudPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_solicitudPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		solicitudPanel.setLayout(gbl_solicitudPanel);
		
		JLabel titleLabel = new JLabel("Ingrese su nueva solicitud");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.WEST;
		gbc_titleLabel.gridwidth = 6;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel.gridx = 1;
		gbc_titleLabel.gridy = 1;
		solicitudPanel.add(titleLabel, gbc_titleLabel);
		
		JLabel operationLabel = new JLabel("\u00BFQu\u00E9 desea hacer?");
		operationLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		operationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_operationLabel = new GridBagConstraints();
		gbc_operationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_operationLabel.anchor = GridBagConstraints.WEST;
		gbc_operationLabel.gridx = 1;
		gbc_operationLabel.gridy = 2;
		solicitudPanel.add(operationLabel, gbc_operationLabel);
			
		JComboBox operationComboBox = new JComboBox();
		operationComboBox.setModel(new DefaultComboBoxModel(OperationType.values()));
		GridBagConstraints gbc_operationComboBox = new GridBagConstraints();
		gbc_operationComboBox.gridwidth = 3;
		gbc_operationComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_operationComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_operationComboBox.gridx = 2;
		gbc_operationComboBox.gridy = 2;
		solicitudPanel.add(operationComboBox, gbc_operationComboBox);
		
		JLabel productLabel = new JLabel("Seleccione el producto:");
		GridBagConstraints gbc_productLabel = new GridBagConstraints();
		gbc_productLabel.insets = new Insets(0, 0, 5, 5);
		gbc_productLabel.anchor = GridBagConstraints.WEST;
		gbc_productLabel.gridx = 1;
		gbc_productLabel.gridy = 3;
		solicitudPanel.add(productLabel, gbc_productLabel);
		
		JComboBox productComboBox = new JComboBox();
		productComboBox.setModel(new DefaultComboBoxModel(ProductType.values()));
		GridBagConstraints gbc_productComboBox = new GridBagConstraints();
		gbc_productComboBox.gridwidth = 3;
		gbc_productComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_productComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_productComboBox.gridx = 2;
		gbc_productComboBox.gridy = 3;
		solicitudPanel.add(productComboBox, gbc_productComboBox);
		
		JLabel fromCityLabel = new JLabel("Ciudad Origen:");
		GridBagConstraints gbc_fromCityLabel = new GridBagConstraints();
		gbc_fromCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fromCityLabel.anchor = GridBagConstraints.WEST;
		gbc_fromCityLabel.gridx = 1;
		gbc_fromCityLabel.gridy = 4;
		solicitudPanel.add(fromCityLabel, gbc_fromCityLabel);
		
		JLabel bogotaCityLabel = new JLabel("Bogot\u00E1 D.C.");
		GridBagConstraints gbc_bogotaCityLabel = new GridBagConstraints();
		gbc_bogotaCityLabel.gridwidth = 2;
		gbc_bogotaCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bogotaCityLabel.anchor = GridBagConstraints.WEST;
		gbc_bogotaCityLabel.gridx = 2;
		gbc_bogotaCityLabel.gridy = 4;
		solicitudPanel.add(bogotaCityLabel, gbc_bogotaCityLabel);
		
		JLabel destinationCityLabel = new JLabel("Ciudad Destino:");
		GridBagConstraints gbc_destinationCityLabel = new GridBagConstraints();
		gbc_destinationCityLabel.anchor = GridBagConstraints.EAST;
		gbc_destinationCityLabel.gridwidth = 2;
		gbc_destinationCityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_destinationCityLabel.gridx = 4;
		gbc_destinationCityLabel.gridy = 4;
		solicitudPanel.add(destinationCityLabel, gbc_destinationCityLabel);
		
		JComboBox destinationComboBox = new JComboBox();
		destinationComboBox.setModel(new DefaultComboBoxModel(City.values()));
		GridBagConstraints gbc_destinationComboBox = new GridBagConstraints();
		gbc_destinationComboBox.gridwidth = 2;
		gbc_destinationComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_destinationComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_destinationComboBox.gridx = 6;
		gbc_destinationComboBox.gridy = 4;
		solicitudPanel.add(destinationComboBox, gbc_destinationComboBox);
		
		JLabel departingLabel = new JLabel("Fecha Inicio:");
		GridBagConstraints gbc_departingLabel = new GridBagConstraints();
		gbc_departingLabel.anchor = GridBagConstraints.WEST;
		gbc_departingLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departingLabel.gridx = 1;
		gbc_departingLabel.gridy = 5;
		solicitudPanel.add(departingLabel, gbc_departingLabel);
		
		JLabel departingDayLabel = new JLabel("D\u00EDa:");
		GridBagConstraints gbc_departingDayLabel = new GridBagConstraints();
		gbc_departingDayLabel.anchor = GridBagConstraints.WEST;
		gbc_departingDayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departingDayLabel.gridx = 2;
		gbc_departingDayLabel.gridy = 5;
		solicitudPanel.add(departingDayLabel, gbc_departingDayLabel);
		
		JComboBox dayDepartingDateComboBox = new JComboBox();
		dayDepartingDateComboBox.setModel(new DefaultComboBoxModel<>(CalendarDay.values()));
		GridBagConstraints gbc_dayDepartingDateComboBox = new GridBagConstraints();
		gbc_dayDepartingDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_dayDepartingDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayDepartingDateComboBox.gridx = 3;
		gbc_dayDepartingDateComboBox.gridy = 5;
		solicitudPanel.add(dayDepartingDateComboBox, gbc_dayDepartingDateComboBox);
		
		JLabel departingMonthLabel = new JLabel("Mes:");
		GridBagConstraints gbc_departingMonthLabel = new GridBagConstraints();
		gbc_departingMonthLabel.anchor = GridBagConstraints.EAST;
		gbc_departingMonthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departingMonthLabel.gridx = 4;
		gbc_departingMonthLabel.gridy = 5;
		solicitudPanel.add(departingMonthLabel, gbc_departingMonthLabel);
		
		JComboBox monthDepartingDateComboBox = new JComboBox();
		monthDepartingDateComboBox.setModel(new DefaultComboBoxModel<>(CalendarMonth.values()));
		GridBagConstraints gbc_monthDepartingDateComboBox = new GridBagConstraints();
		gbc_monthDepartingDateComboBox.anchor = GridBagConstraints.NORTH;
		gbc_monthDepartingDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_monthDepartingDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthDepartingDateComboBox.gridx = 5;
		gbc_monthDepartingDateComboBox.gridy = 5;
		solicitudPanel.add(monthDepartingDateComboBox, gbc_monthDepartingDateComboBox);
		
		JLabel departingYearLabel = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_departingYearLabel = new GridBagConstraints();
		gbc_departingYearLabel.anchor = GridBagConstraints.EAST;
		gbc_departingYearLabel.insets = new Insets(0, 0, 5, 5);
		gbc_departingYearLabel.gridx = 6;
		gbc_departingYearLabel.gridy = 5;
		solicitudPanel.add(departingYearLabel, gbc_departingYearLabel);
		
		JComboBox yearDepartingDateComboBox = new JComboBox();
		yearDepartingDateComboBox.setModel(new DefaultComboBoxModel(CALENDAR_YEARS));
		GridBagConstraints gbc_yearDepartingDateComboBox = new GridBagConstraints();
		gbc_yearDepartingDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_yearDepartingDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearDepartingDateComboBox.gridx = 7;
		gbc_yearDepartingDateComboBox.gridy = 5;
		solicitudPanel.add(yearDepartingDateComboBox, gbc_yearDepartingDateComboBox);
		
		JLabel returningLabel = new JLabel("Fecha Fin:");
		GridBagConstraints gbc_returningLabel = new GridBagConstraints();
		gbc_returningLabel.insets = new Insets(0, 0, 5, 5);
		gbc_returningLabel.anchor = GridBagConstraints.WEST;
		gbc_returningLabel.gridx = 1;
		gbc_returningLabel.gridy = 6;
		solicitudPanel.add(returningLabel, gbc_returningLabel);
		
		JLabel returningDayLabel = new JLabel("D\u00EDa:");
		GridBagConstraints gbc_returningDayLabel = new GridBagConstraints();
		gbc_returningDayLabel.anchor = GridBagConstraints.WEST;
		gbc_returningDayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_returningDayLabel.gridx = 2;
		gbc_returningDayLabel.gridy = 6;
		solicitudPanel.add(returningDayLabel, gbc_returningDayLabel);
		
		JComboBox dayReturningDateComboBox = new JComboBox();
		dayReturningDateComboBox.setModel(new DefaultComboBoxModel<>(CalendarDay.values()));
		GridBagConstraints gbc_dayReturningDateComboBox = new GridBagConstraints();
		gbc_dayReturningDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_dayReturningDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_dayReturningDateComboBox.gridx = 3;
		gbc_dayReturningDateComboBox.gridy = 6;
		solicitudPanel.add(dayReturningDateComboBox, gbc_dayReturningDateComboBox);
		
		JLabel returningMonthLabel = new JLabel("Mes:");
		GridBagConstraints gbc_returningMonthLabel = new GridBagConstraints();
		gbc_returningMonthLabel.anchor = GridBagConstraints.EAST;
		gbc_returningMonthLabel.insets = new Insets(0, 0, 5, 5);
		gbc_returningMonthLabel.gridx = 4;
		gbc_returningMonthLabel.gridy = 6;
		solicitudPanel.add(returningMonthLabel, gbc_returningMonthLabel);
		
		JComboBox monthReturningDateComboBox = new JComboBox();
		monthReturningDateComboBox.setModel(new DefaultComboBoxModel<>(CalendarMonth.values()));
		GridBagConstraints gbc_monthReturningDateComboBox = new GridBagConstraints();
		gbc_monthReturningDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_monthReturningDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_monthReturningDateComboBox.gridx = 5;
		gbc_monthReturningDateComboBox.gridy = 6;
		solicitudPanel.add(monthReturningDateComboBox, gbc_monthReturningDateComboBox);
		
		JLabel returningYearLabel = new JLabel("A\u00F1o:");
		GridBagConstraints gbc_returningYearLabel = new GridBagConstraints();
		gbc_returningYearLabel.anchor = GridBagConstraints.EAST;
		gbc_returningYearLabel.insets = new Insets(0, 0, 5, 5);
		gbc_returningYearLabel.gridx = 6;
		gbc_returningYearLabel.gridy = 6;
		solicitudPanel.add(returningYearLabel, gbc_returningYearLabel);
		
		JComboBox yearReturningDateComboBox = new JComboBox();
		yearReturningDateComboBox.setModel(new DefaultComboBoxModel(CALENDAR_YEARS));
		GridBagConstraints gbc_yearReturningDateComboBox = new GridBagConstraints();
		gbc_yearReturningDateComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_yearReturningDateComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearReturningDateComboBox.gridx = 7;
		gbc_yearReturningDateComboBox.gridy = 6;
		solicitudPanel.add(yearReturningDateComboBox, gbc_yearReturningDateComboBox);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblInput.setForeground(Color.GRAY);
		GridBagConstraints gbc_lblInput = new GridBagConstraints();
		gbc_lblInput.anchor = GridBagConstraints.WEST;
		gbc_lblInput.gridwidth = 7;
		gbc_lblInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblInput.gridx = 1;
		gbc_lblInput.gridy = 7;
		solicitudPanel.add(lblInput, gbc_lblInput);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 9;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		solicitudPanel.add(panel, gbc_panel);
		
		JButton processButton = new JButton("Procesar");
		processButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(processButton);
		
		JPanel resultadoPanel = new JPanel();
		resultadoPanel.setBackground(Color.WHITE);
		contentPane.add(resultadoPanel);
	}

}

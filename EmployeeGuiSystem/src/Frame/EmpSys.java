package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import javax.swing.border.MatteBorder;

public class EmpSys extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAdrs;
	private JTextField txtEml;
	private JTextField txtPhn;
	private JTable table;
	private Color foregroundColor = new Color(255, 255, 255);
	private Color backgroundColor = new Color(0, 0, 128);

	public EmpSys() {
		setTitle("Employee_Managment_System");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1183, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBorder(
				new TitledBorder(null, "Emplyee_Information", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 74, 490, 435);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 50, 99, 39);
		panel.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		txtName.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtName.setToolTipText("your full name");
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(124, 54, 320, 30);
		panel.add(txtName);
		txtName.setColumns(10);

		JLabel lblAdress = new JLabel("ADRESS:");
		lblAdress.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblAdress.setBounds(22, 123, 99, 39);
		panel.add(lblAdress);

		txtAdrs = new JTextField();
		txtAdrs.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		txtAdrs.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdrs.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtAdrs.setColumns(10);
		txtAdrs.setBounds(124, 127, 320, 30);
		panel.add(txtAdrs);

		JLabel lblPhone = new JLabel("EMAIL:");
		lblPhone.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblPhone.setBounds(22, 196, 99, 39);
		panel.add(lblPhone);

		txtEml = new JTextField();
		txtEml.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		txtEml.setHorizontalAlignment(SwingConstants.CENTER);
		txtEml.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtEml.setColumns(10);
		txtEml.setBounds(124, 200, 320, 30);
		panel.add(txtEml);

		JLabel lblPhone_1 = new JLabel("PHONE:");
		lblPhone_1.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblPhone_1.setBounds(22, 270, 99, 39);
		panel.add(lblPhone_1);

		txtPhn = new JTextField();
		txtPhn.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		txtPhn.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhn.setFont(new Font("Sitka Text", Font.BOLD, 15));
		txtPhn.setColumns(10);
		txtPhn.setBounds(124, 274, 320, 30);
		panel.add(txtPhn);

		JLabel lblSave = new JLabel("SAVE");

		lblSave.setName("btnSave");
		lblSave.setForeground(new Color(255, 255, 255));
		lblSave.setOpaque(true);
		lblSave.setBackground(new Color(0, 0, 128));
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblSave.setBounds(57, 369, 99, 39);
		panel.add(lblSave);

		JLabel lblEdit = new JLabel("EDIT");
		lblEdit.setName("btnEdit");
		lblEdit.setBackground(backgroundColor);
		lblEdit.setForeground(foregroundColor);
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setOpaque(true);
		lblEdit.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblEdit.setBounds(181, 369, 99, 39);
		panel.add(lblEdit);

		JLabel lblDelete = new JLabel("DELETE");

		lblDelete.setName("btnDelete");
		lblDelete.setOpaque(true);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(foregroundColor);
		lblDelete.setBackground(backgroundColor);
		lblDelete.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblDelete.setBounds(305, 369, 99, 39);
		panel.add(lblDelete);

		JLabel lblNewLabel_1 = new JLabel("Empolyee Registeration");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 38));
		lblNewLabel_1.setForeground(new Color(75, 0, 130));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(111, 10, 608, 48);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(517, 74, 630, 543);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setUpdateSelectionOnSort(false);
		table.setRowMargin(5);
		table.setRowHeight(20);
		table.setBackground(new Color(220, 220, 220));
		table.setForeground(new Color(105, 105, 105));
		table.setFont(new Font("Sitka Text", Font.BOLD, 14));
		table.setModel(
				new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "NAME", "ADDRESS", "EMAIL", "PHONE"
			}
		));
		
		scrollPane.setViewportView(table);
		// actions
		showData();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					DefaultTableModel mdl = (DefaultTableModel) table.getModel();
					txtName.setText(mdl.getValueAt(index, 1).toString());
					txtAdrs.setText(mdl.getValueAt(index, 2).toString());
					txtEml.setText(mdl.getValueAt(index, 3).toString());
					txtPhn.setText(mdl.getValueAt(index, 4).toString());
				}
			}

		});

		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkEmptyField()) {
					JOptionPane.showConfirmDialog(scrollPane, "Field is empty ...try again !!", "System",
							JOptionPane.WARNING_MESSAGE);
					} 
				else {
					try {
						int result = Tools.save(txtName.getText(), txtAdrs.getText(), txtEml.getText(), txtPhn.getText());
						if (result != -1) {
							cleanRow();
							showData();
							cleanField();
							JOptionPane.showMessageDialog(scrollPane, "Added ", "System", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch (SQLException a){
						JOptionPane.showMessageDialog(scrollPane, a.getMessage(), "System",
								JOptionPane.ERROR_MESSAGE);
															}
						
				}	
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setForeground(backgroundColor);
				lblSave.setBackground(foregroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSave.setForeground(foregroundColor);
				lblSave.setBackground(backgroundColor);
			}
		});
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					try {
						DefaultTableModel mdl = (DefaultTableModel) table.getModel();
						int id = Integer.parseInt(mdl.getValueAt(index, 0).toString());
						int result = Tools.deleteRow(id);
						if (result != -1) {
							mdl.removeRow(index);
							cleanField();
							//showData();
							} 
						}catch(SQLException a) {
						JOptionPane.showMessageDialog(scrollPane, a.getMessage());
						}
				} else
					JOptionPane.showMessageDialog(scrollPane, "no row selected ", "System ",
							JOptionPane.WARNING_MESSAGE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblDelete.setForeground(backgroundColor);
				lblDelete.setBackground(foregroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDelete.setForeground(foregroundColor);
				lblDelete.setBackground(backgroundColor);
			}
		});
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					DefaultTableModel mdl = (DefaultTableModel) table.getModel();
					int id = Integer.parseInt(mdl.getValueAt(index, 0).toString());
					String name = txtName.getText();
					String adrs = txtEml.getText();
					String eml = txtEml.getText();
					String phn = txtPhn.getText();
					try {
						int result = Tools.edit(id, name, adrs, eml, phn);
						if (result != -1) {
							cleanRow();
							showData();
							cleanField();
							JOptionPane.showMessageDialog(scrollPane, "update successfully");
						} 
					}catch(SQLException a) {
						
							JOptionPane.showMessageDialog(scrollPane, a.getMessage());
					}
				} else
					JOptionPane.showMessageDialog(scrollPane, "no row selected ", "System ",
							JOptionPane.WARNING_MESSAGE);
				
				//updateField(table.getSelectedRow());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblEdit.setForeground(backgroundColor);
				lblEdit.setBackground(foregroundColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblEdit.setForeground(foregroundColor);
				lblEdit.setBackground(backgroundColor);
			}
		});

	}

	private boolean checkEmptyField() {
		return (txtName.getText().equals("") || txtAdrs.getText().equals("") || txtEml.getText().equals("")
				|| txtPhn.getText().equals("")) ? true : false;
	}

	private void cleanField() {
		txtName.setText("");
		txtPhn.setText("");
		txtEml.setText("");
		txtAdrs.setText("");
	}

	private void showData() {
		try {
			ArrayList<Employee> employees = Tools.getEmployees();
			if (employees != null) {
				DefaultTableModel mdl = (DefaultTableModel) table.getModel();
				for (Employee e : employees) {
					mdl.addRow(new Object[] { e.getId(), e.getName(), e.getAddress(), e.getEmail(), e.getPhone() });
				}
				}
		}catch(SQLException a) {
			JOptionPane.showMessageDialog(null, a.getMessage());
		}
	}

	

	private void cleanRow() {
		DefaultTableModel mdl = (DefaultTableModel) table.getModel();
		mdl.setRowCount(0);
		
	}

	

}

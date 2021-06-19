package view.menuView.Dialog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class five {

	///// Border////////////////
	SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
	SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	//////////////////////

	//// 다이어로그 생성/////////////
	JDialog p2_5 = new JDialog();
	///////////////////////////////

	////// 메밀함 구성 기능////////////
	int count = 0;
	int count2 = 0;
	String[] str = { "제목", "받기", "삭제" };
	String str2[][] = { { "임시 데이", "b", "" }, { "임시데이", "2", "" } };
	Object[] objColNms = new Object[] { "Col1", "Col2", "Del" };
	DefaultTableModel model = new DefaultTableModel(str2, str);
	JTable table = new JTable(model);
	JScrollPane scroll = new JScrollPane(table);

	JButton btn1 = new JButton("나가기");
	JButton btn2 = new JButton("메일함");
	JButton btn3 = new JButton("친구목록");

	//////////////////////////////

	public five() {

		p2_5.setSize(600, 400);
		p2_5.setUndecorated(true);
		p2_5.setLayout(null);
		p2_5.setLocationRelativeTo(null);
		p2_5.setVisible(true);

		// 배치 설정///////////////
		scroll.setBounds(10, 10, 430, 300);
		btn1.setBounds(470, 315, 120, 80);
		btn2.setBounds(470, 10, 120, 80);
		btn3.setBounds(470, 100, 120, 80);

		////// 메일함 설정/////////////////
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCell2());
		table.getColumnModel().getColumn(1).setCellEditor(new TableCell2());
		table.getColumnModel().getColumn(2).setCellRenderer(new TableCell());
		table.getColumnModel().getColumn(2).setCellEditor(new TableCell());

		/// BORDER/////
		btn2.setBorder(b2);
		btn3.setBorder(b2);

		///////

		// 기능 설정 ///////////////////////

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2_5.dispose();
			}

		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count == 0) {
					btn2.setBorder(b1);
					btn3.setBorder(b2);
					count += 1;
				} else if (count == 1) {
					btn2.setBorder(b2);
					count -= 1;
				}
			}

		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count2 == 0) {
					btn2.setBorder(b2);
					btn3.setBorder(b1);
					count2 += 1;
				} else if (count2 == 1) {
					btn3.setBorder(b2);
					count2 -= 1;
				}
			}

		});

		//// 기능 삽입/////////////////////
		p2_5.add(scroll);
		p2_5.add(btn1);
		p2_5.add(btn2);
		p2_5.add(btn3);

	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public TableCell() {
			jb = new JButton("Del");
			jb.setVisible(true);

		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return jb;
		}
	} // end class Tab

	class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
		JButton jb;

		public TableCell2() {
			jb = new JButton("Add");
			jb.setVisible(true);

		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jb;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return jb;
		}
	} // end class Tab
}

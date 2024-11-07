package utilidades;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomAlignmentRenderer extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if(value instanceof Integer) {
			setHorizontalAlignment(SwingConstants.CENTER);
		}
		else if(value instanceof String && column != 4)
			setHorizontalAlignment(SwingConstants.LEFT);
		else
			setHorizontalAlignment(SwingConstants.CENTER);
		return component;
	}

}

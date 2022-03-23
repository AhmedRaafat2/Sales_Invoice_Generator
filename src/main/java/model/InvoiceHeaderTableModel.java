package model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceHeaderTableModel extends AbstractTableModel {

    private List<InvoiceHeader> invoicesArray;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyy");

    public InvoiceHeaderTableModel(List<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    public List<InvoiceHeader> getInvoicesArray() {
        return invoicesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesArray.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "No.";
            case 1:
                return "Date";
            case 2:
                return "Customer";
            case 3:
                return "Total";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = invoicesArray.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return header.getInvNumber();
            case 1:
                return df.format(header.getInvDate());
            case 2:
                return header.getCustomerName();
            case 3:
                return header.getInvoiceTotal();
            default:
                return "";
        }
    }
}

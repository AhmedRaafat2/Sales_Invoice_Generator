package model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceLinesTableModel extends AbstractTableModel {

    private List<InvoiceLine> invoicesLinesArray;
    private List<InvoiceHeader> invoicesHeaderArray;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyy");

    public InvoiceLinesTableModel(List<InvoiceLine> invoicesLinesArray, List<InvoiceHeader> invoicesHeaderArray) {
        this.invoicesLinesArray = invoicesLinesArray;
        this.invoicesHeaderArray = invoicesHeaderArray;
    }

    public List<InvoiceLine> getInvoicesLinesArray() {
        return invoicesLinesArray;
    }

    @Override
    public int getRowCount() {
        return invoicesLinesArray.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "No.";
            case 1:
                return "Item Name";
            case 2:
                return "Item Price";
            case 3:
                return "Count";
            case 4:
                return "Item Total";
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
                return Double.class;
            case 3:
                return Integer.class;
            case 4:
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
        InvoiceLine line = invoicesLinesArray.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return invoicesHeaderArray.get(rowIndex).getInvNumber();
            case 1:
                return line.getItemName();
            case 2:
                return line.getItemPrice();
            case 3:
                return line.getItemCount();
            case 4:
                return line.getLineTotal();
            default:
                return "";
        }
    }
}

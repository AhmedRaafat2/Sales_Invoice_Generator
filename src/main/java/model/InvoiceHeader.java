package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    private int invNumber;
    private String customerName;
    private Date invDate;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int invNumber, Date invDate, String customerName) {
        this.invNumber = invNumber;
        this.customerName = customerName;
        this.invDate = invDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(int invNumber) {
        this.invNumber = invNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invNumber=" + invNumber + ", customerName=" + customerName + ", invDate=" + invDate + '}';
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceLine line : getLines()) {
            total += line.getLineTotal();
        }
        return total;
    }

    public void addInvoiceLine(InvoiceLine line) {
        getLines().add(line);
    }
}

package gui;

import javax.swing.*;
import java.awt.*;

public class InvoiceAddNewHeaderDialog extends JDialog {

    private JLabel customerNameLabel;
    private JTextField customerNameTF;
    private JLabel invoiceDateLabel;
    private JTextField invoiceDateTF;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceAddNewHeaderDialog(InvoiceFrame invoiceFrame) {
        customerNameLabel = new JLabel("Custome Name : ");
        customerNameTF = new JTextField();
        invoiceDateLabel = new JLabel("Invoice Date : ");
        invoiceDateTF = new JTextField();
        okButton = new JButton("ok");
        cancelButton = new JButton("cancel");
        okButton.setActionCommand("createNewHeaderOkBtn");
        okButton.addActionListener(invoiceFrame);
        cancelButton.setActionCommand("cancelNewHeaderBtn");
        cancelButton.addActionListener(invoiceFrame);

        setLayout(new GridLayout(3,2));
        add(invoiceDateLabel);
        add(invoiceDateTF);
        add(customerNameLabel);
        add(customerNameTF);
        add(okButton);
        add(cancelButton);
        pack();
        setLocation(600, 400);
    }

    public JTextField getCustomerNameTF() {
        return customerNameTF;
    }

    public JTextField getInvoiceDateTF() {
        return invoiceDateTF;
    }
}

package gui;

import javax.swing.*;
import java.awt.*;

public class InvoiceAddLineDialog extends JDialog {

    private JLabel itemNameLabel;
    private JTextField itemNameTF;
    private JLabel itemPriceLabel;
    private JTextField itemPriceTF;
    private JLabel itemCountLabel;
    private JTextField itemCountTF;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceAddLineDialog(InvoiceFrame frame) {
        itemNameLabel = new JLabel("Item Name");
        itemNameTF = new JTextField();
        itemPriceLabel = new JLabel("Item Price");
        itemPriceTF = new JTextField();
        itemCountLabel = new JLabel("Item Count");
        itemCountTF = new JTextField();
        okButton = new JButton("ok");
        cancelButton = new JButton("cancel");
        okButton.addActionListener(frame);
        okButton.setActionCommand("okAddLineDialog");
        cancelButton.addActionListener(frame);
        cancelButton.setActionCommand("cancelAddLineDialog");

        setLayout(new GridLayout(4,2));
        add(itemNameLabel);
        add(itemNameTF);
        add(itemCountLabel);
        add(itemCountTF);
        add(itemPriceLabel);
        add(itemPriceTF);
        add(okButton);
        add(cancelButton);
        pack();
        setLocation(1000, 500);
    }

    public JLabel getItemNameLabel() {
        return itemNameLabel;
    }

    public JTextField getItemNameTF() {
        return itemNameTF;
    }

    public JTextField getItemPriceTF() {
        return itemPriceTF;
    }

    public JTextField getItemCountTF() {
        return itemCountTF;
    }
}

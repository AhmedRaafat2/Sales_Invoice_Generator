package gui;

import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLine;
import model.InvoiceLinesTableModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceFrame extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    private String headerFilePath;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyy");
    private List<InvoiceHeader> invoicesArray = new ArrayList<>();
    private List<InvoiceLine> invoiceLinessArray = new ArrayList<>();
    private InvoiceHeaderTableModel headerModel;
    private InvoiceLinesTableModel linesModel;
    private JButton deleteInvoiceLine;
    private JButton createNewInvoiceBtn;
    private JTextField customerNameTextField;
    private JButton deleteInvoiceBtn;
    private JMenu fileMenu;
    private JTextField invoiceDateTextField;
    private JLabel invoiceNumberShowLbl;
    private JLabel invoiceTotalShowLbl;
    private JTable invoicesTable;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel8;
    private JMenuBar jMenuBar1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable linesTable;
    private JMenuItem loadFileMenu;
    private JMenuItem saveFileMenu;
    private JButton createNewLineBtn;
    private InvoiceAddNewHeaderDialog addNewHeaderDialog;
    private InvoiceAddLineDialog addNewLineDialog;

    public InvoiceFrame() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        invoicesTable = new JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        createNewInvoiceBtn = new JButton();
        createNewInvoiceBtn.setEnabled(false);
        createNewInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn = new JButton();
        deleteInvoiceBtn.setEnabled(false);
        deleteInvoiceBtn.addActionListener(this);
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        customerNameTextField = new JTextField();
        invoiceDateTextField = new JTextField();
        invoiceNumberShowLbl = new JLabel();
        invoiceTotalShowLbl = new JLabel();
        jScrollPane2 = new JScrollPane();
        linesTable = new JTable();
        createNewLineBtn = new JButton();
        createNewLineBtn.setEnabled(false);
        createNewLineBtn.addActionListener(this);
        deleteInvoiceLine = new JButton();
        deleteInvoiceLine.setEnabled(false);
        deleteInvoiceLine.addActionListener(this);
        jLabel8 = new JLabel();
        jMenuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        loadFileMenu = new JMenuItem();
        loadFileMenu.addActionListener(this);
        saveFileMenu = new JMenuItem();
        saveFileMenu.addActionListener(this);

        setLocation(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoices Table");

        jScrollPane1.setViewportView(invoicesTable);
        createNewInvoiceBtn.setText("Create New Invoice");
        createNewInvoiceBtn.setActionCommand("CreateNewInvoice");
        deleteInvoiceBtn.setText("Delete Invoice");
        deleteInvoiceBtn.setToolTipText("");
        deleteInvoiceBtn.setActionCommand("DeleteInvoice");
        jLabel2.setText("Invoice Number");
        jLabel3.setText("Invoice Date");
        jLabel4.setText("Custumer Name");
        jLabel5.setText("Invoice Total");

        jLabel8.setText("Invoice Items");
        jScrollPane2.setViewportView(linesTable);

        createNewLineBtn.setText("Create New Line");
        createNewLineBtn.setActionCommand("createNewLine");
        deleteInvoiceLine.setText("Delete Line");
        deleteInvoiceLine.setActionCommand("deleteInvoiceLine");

        fileMenu.setText("File");
        loadFileMenu.setText("Load File");
        loadFileMenu.setActionCommand("LoadFile");
        fileMenu.add(loadFileMenu);
        saveFileMenu.setText("Save File");
        saveFileMenu.setEnabled(false);
        saveFileMenu.setActionCommand("SaveFile");
        fileMenu.add(saveFileMenu);
        jMenuBar1.add(fileMenu);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(createNewInvoiceBtn)
                                                .addGap(60, 60, 60)
                                                .addComponent(deleteInvoiceBtn)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(createNewLineBtn)
                                                .addGap(78, 78, 78)
                                                .addComponent(deleteInvoiceLine))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(invoiceTotalShowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel8)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(invoiceNumberShowLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(invoiceNumberShowLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(invoiceTotalShowLbl))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createNewInvoiceBtn)
                                        .addComponent(deleteInvoiceBtn)
                                        .addComponent(createNewLineBtn)
                                        .addComponent(deleteInvoiceLine))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LoadFile":
                loadFile();
                break;
            case "SaveFile":
                saveFiles();
                break;
            case "CreateNewInvoice":
                showAddInvoiceHeaderDialog();
                break;
            case "DeleteInvoice":
                deleteInvoice();
                break;
            case "createNewLine":
                showAddInvoiceLineDialog();
                break;
            case "deleteInvoiceLine":
                deleteLine();
                break;
            case "createNewHeaderOkBtn":
                createInvoiceDialogOk();
                break;
            case "cancelNewHeaderBtn":
                createInvoiceDialogcancel();
                break;
            case "okAddLineDialog":
                okInvoiceLineDialog();
                break;
            case "cancelAddLineDialog":
                cancelInvoiceLineDialog();
                break;
        }
    }

    private void saveFiles() {
        String headerString = "";
        String linesString = "";
        for (int i = 0; i < invoicesArray.size(); i++) {
            headerString += "" + invoicesArray.get(i).getInvNumber();
            headerString += ",";
            headerString += "" + df.format(invoicesArray.get(i).getInvDate());
            headerString += ",";
            headerString += invoicesArray.get(i).getCustomerName();
            headerString += "\n";
        }

        for (int i = 0; i < invoicesArray.size(); i++) {
            for (int y = 0; y < invoicesArray.get(i).getLines().size(); y++) {
                linesString += "" + invoicesArray.get(i).getInvNumber();
                linesString += ",";
                linesString += invoicesArray.get(i).getLines().get(y).getItemName();
                linesString += ",";
                linesString += "" + invoicesArray.get(i).getLines().get(y).getItemPrice();
                linesString += ",";
                linesString += "" + invoicesArray.get(i).getLines().get(y).getItemCount();
                linesString += "\n";
            }
        }
        JOptionPane.showMessageDialog(this, "Select File to Save Header", "Important Note", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter headerWriter = new FileWriter(headerFile);
                headerWriter.write(headerString);
                headerWriter.flush();
                headerWriter.close();

                JOptionPane.showMessageDialog(this, "Select File to Save Lines", "Important Note", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter linesWriter = new FileWriter(linesFile);
                    linesWriter.write(linesString);
                    linesWriter.flush();
                    linesWriter.close();
                    JOptionPane.showMessageDialog(this, "Your data written succesfully", "Important Note", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(headerString);
        System.out.println("*******************");
        System.out.println(linesString);
    }

    private void deleteInvoice() {
        if (invoicesTable.getSelectedRow() >= 0) {
            int selectedHeaderRow = invoicesTable.getSelectedRow();

            invoicesArray.remove(selectedHeaderRow);
            linesTable.setModel(new InvoiceLinesTableModel(new ArrayList<InvoiceLine>(), invoicesArray));
            headerModel.fireTableDataChanged();
            linesModel.fireTableDataChanged();

            customerNameTextField.setText("");
            invoiceDateTextField.setText("");
            invoiceNumberShowLbl.setText("");
            invoiceTotalShowLbl.setText("");
        }
    }

    private void deleteLine() {
        if (linesTable.getSelectedRow() >= 0) {
            int selectedLineRow = linesTable.getSelectedRow();
            int selectedHeaderRow = invoicesTable.getSelectedRow();
            invoicesArray.get(selectedHeaderRow).getLines().remove(selectedLineRow);
            invoiceTotalShowLbl.setText("" + headerModel.getInvoicesArray().get(invoicesTable.getSelectedRow()).getInvoiceTotal());
            headerModel.fireTableDataChanged();
            linesModel.fireTableDataChanged();
        }
    }

    private void okInvoiceLineDialog() {
        String itemName = addNewLineDialog.getItemNameTF().getText();
        String itemCountString = addNewLineDialog.getItemCountTF().getText();
        String itemPriceString = addNewLineDialog.getItemPriceTF().getText();

        addNewLineDialog.setVisible(false);
        addNewLineDialog.dispose();
        addNewLineDialog = null;

        int itemCount = Integer.parseInt(itemCountString);
        double itemPrice = Double.parseDouble(itemPriceString);
        int headerIndex = invoicesTable.getSelectedRow();
        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoicesArray.get(headerIndex));
        invoicesArray.get(headerIndex).getLines().add(invoiceLine);
        invoiceTotalShowLbl.setText("" + headerModel.getInvoicesArray().get(invoicesTable.getSelectedRow()).getInvoiceTotal());
        headerModel.fireTableDataChanged();
        linesModel.fireTableDataChanged();
    }

    private void cancelInvoiceLineDialog() {
        addNewLineDialog.setVisible(false);
        addNewLineDialog.dispose();
        addNewLineDialog = null;
    }

    private void showAddInvoiceLineDialog() {
        addNewLineDialog = new InvoiceAddLineDialog(this);
        addNewLineDialog.setVisible(true);
    }

    private void createInvoiceDialogOk() {
        String invoiceDateString = addNewHeaderDialog.getInvoiceDateTF().getText();
        String customerName = addNewHeaderDialog.getCustomerNameTF().getText();
        addNewHeaderDialog.setVisible(false);
        addNewHeaderDialog.dispose();
        addNewHeaderDialog = null;
        try {
            Date invoiceDate = df.parse(invoiceDateString);
            int invoiceNumber = getNextInvoiceNumber();
            InvoiceHeader header = new InvoiceHeader(invoiceNumber, invoiceDate, customerName);
            invoicesArray.add(header);
            headerModel.fireTableDataChanged();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private int getNextInvoiceNumber() {
        int max = 0;
        for (InvoiceHeader header : invoicesArray) {
            if (header.getInvNumber() > max) {
                max = header.getInvNumber();
            }
        }
        return max + 1;
    }

    private void createInvoiceDialogcancel() {
        addNewHeaderDialog.setVisible(false);
        addNewHeaderDialog.dispose();
        addNewHeaderDialog = null;
    }

    private void showAddInvoiceHeaderDialog() {
        addNewHeaderDialog = new InvoiceAddNewHeaderDialog(this);
        addNewHeaderDialog.setVisible(true);
    }

    private void loadFile() {
        JOptionPane.showMessageDialog(this, "Select Header File First", "Important Note", JOptionPane.WARNING_MESSAGE);
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
        fc.setFileFilter(filter);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            headerFilePath = fc.getSelectedFile().getPath();
            try {
                File headerFile = new File(headerFilePath);
                FileReader headerReader = new FileReader(headerFile);
                BufferedReader br = new BufferedReader(headerReader);
                String line = "";
                String[] headerSplittedArrayString;
                while ((line = br.readLine()) != null) {
                    headerSplittedArrayString = line.split(",");

                    String invoiceNumberString = headerSplittedArrayString[0];
                    String invoiceDateString = headerSplittedArrayString[1];
                    String invoiceCustomerNameString = headerSplittedArrayString[2];

                    int invoiceNumber = Integer.parseInt(invoiceNumberString);
                    Date invoiceDate = df.parse(invoiceDateString);

                    InvoiceHeader invoice = new InvoiceHeader(invoiceNumber, invoiceDate, invoiceCustomerNameString);
                    invoicesArray.add(invoice);
                }
                //Alert for lines + file chooser for lines file
                JOptionPane.showMessageDialog(this, "Select Lines File", "Important Note", JOptionPane.WARNING_MESSAGE);
                result = fc.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fc.getSelectedFile();
                    FileReader linesReader = new FileReader(linesFile);

                    BufferedReader linesBuffer = new BufferedReader(linesReader);
                    String linesOfLine = "";
                    String[] lineSplittedArrayString;
                    while ((linesOfLine = linesBuffer.readLine()) != null) {

                        lineSplittedArrayString = linesOfLine.split(",");

                        String invoiceNumberString = lineSplittedArrayString[0];
                        String invoiceItemNameString = lineSplittedArrayString[1];
                        String invoiceItemPriceString = lineSplittedArrayString[2];
                        String invoiceItemCountString = lineSplittedArrayString[3];

                        int invoiceNumber = Integer.parseInt(invoiceNumberString);
                        double invoiceItemPrice = Double.parseDouble(invoiceItemPriceString);
                        int invoiceItemCount = Integer.parseInt(invoiceItemCountString);

                        InvoiceHeader header = returnInvoiceById(invoiceNumber);
                        InvoiceLine invoiceLine = new InvoiceLine(invoiceItemNameString, invoiceItemPrice, invoiceItemCount, header);
                        header.getLines().add(invoiceLine);
                    }
                    headerModel = new InvoiceHeaderTableModel(invoicesArray);
                    invoicesTable.setModel(headerModel);
                    invoicesTable.validate();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        createNewInvoiceBtn.setEnabled(true);
        deleteInvoiceBtn.setEnabled(true);
        saveFileMenu.setEnabled(true);
    }

    public InvoiceHeader returnInvoiceById(int invoiceNumber) {
        InvoiceHeader header = null;
        for (InvoiceHeader invoiceHeader : invoicesArray) {
            if (invoiceNumber == invoiceHeader.getInvNumber()) {
                header = invoiceHeader;
                break;
            }
        }
        return header;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRowIndex = invoicesTable.getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader header = headerModel.getInvoicesArray().get(selectedRowIndex);
            customerNameTextField.setText(header.getCustomerName());
            invoiceDateTextField.setText(df.format(header.getInvDate()));
            invoiceNumberShowLbl.setText("" + header.getInvNumber());
            invoiceTotalShowLbl.setText("" + header.getInvoiceTotal());

            ArrayList<InvoiceLine> linesOfSelectedRow = header.getLines();

            linesModel = new InvoiceLinesTableModel(linesOfSelectedRow, invoicesArray);
            linesTable.setModel(linesModel);
            linesModel.fireTableDataChanged();

            createNewLineBtn.setEnabled(true);
            deleteInvoiceLine.setEnabled(true);
        }
    }
}

package gui;

import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLine;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceFrame extends javax.swing.JFrame implements ActionListener, MouseListener {

    private DateFormat df = new SimpleDateFormat("dd-MM-yyy");
    private List<InvoiceHeader> invoicesArray = new ArrayList<>();
    private InvoiceHeaderTableModel headerModel;
    private JButton cancelInvoiceBtn;
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
    private JTable jTable1;
    private JMenuItem loadFileMenu;
    private JMenuItem saveFileMenu;
    private JButton saveInvoiceBtn;


    public InvoiceFrame() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        invoicesTable = new JTable();
        createNewInvoiceBtn = new JButton();
        createNewInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn = new JButton();
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
        jTable1 = new JTable();
        saveInvoiceBtn = new JButton();
        saveInvoiceBtn.addActionListener(this);
        cancelInvoiceBtn = new JButton();
        cancelInvoiceBtn.addActionListener(this);
        jLabel8 = new JLabel();
        jMenuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        loadFileMenu = new JMenuItem();
        loadFileMenu.addActionListener(this);
        saveFileMenu = new JMenuItem();
        saveFileMenu.addActionListener(this);

        setLocation(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Invoices Table");

//        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//
//                },
//                new String [] {
//
//                }
//        ));

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

//        customerNameTextField.setText("");
//        invoiceDateTextField.setText("");
//        invoiceNumberShowLbl.setText("1.0");
//        invoiceTotalShowLbl.setText("jLabel7");

//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//
//                },
//                new String [] {
//
//                }
//        ));
        jScrollPane2.setViewportView(jTable1);

        saveInvoiceBtn.setText("Save");
        saveInvoiceBtn.setActionCommand("save");

        cancelInvoiceBtn.setText("Cancel");
        cancelInvoiceBtn.setActionCommand("cancel");

        jLabel8.setText("Invoice Items");

        fileMenu.setText("File");
        loadFileMenu.setText("Load File");
        loadFileMenu.setActionCommand("LoadFile");
        fileMenu.add(loadFileMenu);
        saveFileMenu.setText("Save File");
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
                                                .addGap(108, 108, 108)
                                                .addComponent(saveInvoiceBtn)
                                                .addGap(78, 78, 78)
                                                .addComponent(cancelInvoiceBtn))
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
                                        .addComponent(saveInvoiceBtn)
                                        .addComponent(cancelInvoiceBtn))
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "LoadFile":
                openFile();
                break;
            case "SaveFile":
                break;
            case "CreateNewInvoice":
                break;
            case "DeleteInvoice":
                break;
            case "save":
                break;
            case "cancel":
                break;
        }

    }

    private void openFile() {
        JOptionPane.showMessageDialog(this, "Select Header File First", "Important Note", JOptionPane.WARNING_MESSAGE);
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
        fc.setFileFilter(filter);

        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            //FileInputStream fis = null;
            try {
                File headerFile = new File(path);
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
                    File linesFile =fc.getSelectedFile();
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

//                        InvoiceHeader invoice = new InvoiceHeader(invoiceNumber, invoiceCustomerNameString, invoiceDate);
//                        invoicesArray.add(invoice);
                        InvoiceHeader header = returnInvoiceById(invoiceNumber);
                        InvoiceLine invoiceLine = new InvoiceLine(invoiceItemNameString, invoiceItemPrice, invoiceItemCount, header);
                        header.getLines().add(invoiceLine);
                        //System.out.println("");
                    }
                    headerModel = new InvoiceHeaderTableModel(invoicesArray);
                    invoicesTable.setModel(headerModel);
                    invoicesTable.validate();
                    invoicesTable.addMouseListener(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public InvoiceHeader returnInvoiceById(int invoiceNumber){
        InvoiceHeader header = null;
        for(InvoiceHeader invoiceHeader :invoicesArray){
            if(invoiceNumber == invoiceHeader.getInvNumber()){
                header = invoiceHeader;
                break;
            }
        }
        return header;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = invoicesTable.getSelectedRow();
        System.out.println("selected row is    : "+x);
        InvoiceHeader header = invoicesArray.get(invoicesTable.getSelectedRow());
        System.out.println(header.getInvNumber());
        System.out.println(header.getCustomerName());
        System.out.println(header.getInvDate());
        System.out.println(header.getInvoiceTotal());
        System.out.println(header.getLines());

        customerNameTextField.setText(header.getCustomerName());
        invoiceDateTextField.setText(df.format(header.getInvDate()));
        invoiceNumberShowLbl.setText(""+header.getInvNumber());
        invoiceTotalShowLbl.setText(""+header.getInvoiceTotal());

        System.out.println(header.getLines().get(0).getLineTotal());



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

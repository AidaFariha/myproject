import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ISO8583Table2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ISO8583Table2 frame = new ISO8583Table2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ISO8583Table2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		jTable.setRowSorter(rowSorter);
		
//		Filter Function
	       JPanel panel = new JPanel(new BorderLayout());
	       panel.add(new JLabel("Specify a word to match:"),
	               BorderLayout.WEST);
	       panel.add(jtfFilter, BorderLayout.CENTER);

	       getContentPane().setLayout(new BorderLayout());
	       getContentPane().add(panel, BorderLayout.SOUTH);
	       getContentPane().add(new JScrollPane(jTable), BorderLayout.CENTER);

	       jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

	           @Override
	           public void insertUpdate(DocumentEvent e) {
	               String text = jtfFilter.getText();

	               if (text.trim().length() == 0) {
	                   rowSorter.setRowFilter(null);
	               } else {
	                   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	               }
	           }

	           @Override
	           public void removeUpdate(DocumentEvent e) {
	               String text = jtfFilter.getText();

	               if (text.trim().length() == 0) {
	                   rowSorter.setRowFilter(null);
	               } else {
	                   rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	               }
	           }

	           @Override
	           public void changedUpdate(DocumentEvent e) {
	               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	           }

	       });
	
	}
//		End of Filter Function

		    String[] columnNames
           = {"ID", "Name", "Message Length", "Class Description"};

    Object[][] data = {
    	   {0, "Message Type Indicator", 25, "Request from a point-of-sale terminal for authorization a purchase." },
           {1, "Bitmap", 16, "Enter description here. Any description." },
           {2, "Primary Account Number", 19, "Enter description here. Any description." },
           {3, "Processing Code", 6, "Enter description here. Any description." },
           {4, "Amount, Transaction", 12, "Enter description here. Any description." },
           {5, "Amount, Reconciliation", 12, "Enter description here. Any description." },
           {6, "Amount, Cardholder billing", 12, "Enter description here. Any description." },
           {7, "Date and time, transmission", 10, "Enter description here. Any description." },
           {8, "Amount, Cardholder billing fee", 8, "Enter description here. Any description." },
           {9, "Conversion rate, Reconciliation", 8, "Enter description here. Any description." },
           {10, "Conversion rate, Cardholder billing", 8, "Enter description here. Any description." },
           {11, "Systems trace audit number", 6, "Enter description here. Any description." },
           {12, "Date and time, Local transaction", 6, "Enter description here. Any description." },
           {13, "Date, Effective", 4, "Enter description here. Any description." },
           {14, "Date, Expiration", 4, "Enter description here. Any description." },
           {15, "Date, Settlement", 4, "Enter description here. Any description." },
           {16, "Date, Conversion", 4, "Enter description here. Any description." },
           {17, "Date, Capture", 4, "Enter description here. Any description." },
           {18, "Merchant type", 4, "Enter description here. Any description." },
           {19, "Country code, Acquiring institution", 4, "Enter description here. Any description." },
           {20, "Country code, Primary account number", 4, "Enter description here. Any description." },
           {21, "Country code, Forwarding institution", 4, "Enter description here. Any description." },
           {22, "Point of service data code", 3, "Enter description here. Any description." },
           {23, "Card sequence number", 3, "Enter description here. Any description." },
           {24, "Function code", 3, "Enter description here. Any description." },
           {25, "Message reason code", 2, "Enter description here. Any description." },
           {26, "Card acceptor business code", 4, "Enter description here. Any description." },
           {27, "Approval code length", 1, "Enter description here. Any description." },
           {28, "Date, Reconciliation", 9, "Enter description here. Any description." },
           {29, "Reconciliation indicator", 3, "Enter description here. Any description." },
           {30, "Amounts, original", 24, "Enter description here. Any description." },
           {31, "Acquirer reference data", 99, "Enter description here. Any description." },
           {32, "Acquirer institution identification code", 11, "Enter description here. Any description." },
           {33, "Forwarding institution identification code", 11, "Enter description here. Any description." },
           {34, "Primary account number, extended", 28, "Enter description here. Any description." },
           {35, "Track 2 data", 37, "Enter description here. Any description." },
           {36, "Track 3 data", 104, "Enter description here. Any description." },
           {37, "Retrieval reference number", 12, "Enter description here. Any description." },
           {38, "Approval code", 6, "Enter description here. Any description." },
           {39, "Action code (3N) - ESWX V2 only", 3, "Enter description here. Any description." },
           {39, "Action code (2N) - ESWX V3 and External Hosts", 2, "Enter description here. Any description." },
           {40, "Service code", 3, "Enter description here. Any description." },
           {41, "Card acceptor terminal identification", 8, "Enter description here. Any description." },
           {42, "Card acceptor identification code", 15, "Enter description here. Any description." },
           {43, "Card acceptor name/location", 40, "Enter description here. Any description." },
           {43, "Card acceptor name/location", 40, "Enter description here. Any description." },
           {44, "Additional response data", 99, "Enter description here. Any description." },
           {45, "Track 1 data", 76, "Enter description here. Any description." },
           {46, "Amounts, Fees", 204, "Enter description here. Any description." },
           {47, "Additional data - nationa", 999, "Enter description here. Any description." },
           {48, "Additional data - private", 999, "Enter description here. Any description." },
           {48, "Additional data - private", 999, "Enter description here. Any description." },
           {49, "Currency code, Transaction", 3, "Enter description here. Any description." },
           {50, "Currency code, Reconciliation", 3, "Enter description here. Any description." },
           {51, "Currency code, Cardholder billing", 3, "Enter description here. Any description." },
           {52, "Personal identification number [PIN] data", 16, "Enter description here. Any description." },
           {53, "Security related control information", 48, "Enter description here. Any description." },
           {54, "Amounts, additional", 120, "Enter description here. Any description." },
           {55, "Amounts, additional", 255, "Enter description here. Any description." },
           {56, "Original data elements", 35, "Enter description here. Any description." },
           {57, "Authorization life cycle code", 3, "Enter description here. Any description." },
           {58, "Authorizing agent institution Id Code", 11, "Enter description here. Any description." },
           {59, "Transport data", 999, "Enter description here. Any description." },
           {60, "Reserved for national use", 28, "Enter description here. Any description." },
           {61, "Reserved for national use", 999, "Enter description here. Any description." },
           {62, "Reserved for private use", 84, "Enter description here. Any description." },
           {62, "Reserved for private use", 999, "Enter description here. Any description." },
           {63, "Reserved for private use", 999, "Enter description here. Any description." },
           {64, "Message authentication code field", 8, "Enter description here. Any description." },
           {65, "Reserved for ISO use", 8, "Enter description here. Any description." },
           {66, "Amounts, original fees", 204, "Enter description here. Any description." },
           {66, "Amounts, original fees", 1, "Enter description here. Any description." },
           {67, "Extended payment data", 2, "Enter description here. Any description." },
           {68, "Country code, receiving institution", 3, "Enter description here. Any description." },
           {69, "Country code, settlement institution", 3, "Enter description here. Any description." },
           {70, "Country code, authorizing agent Inst.", 3, "Enter description here. Any description." },
           {71, "Message number", 8, "Enter description here. Any description." },
           {72, "Data record", 999, "Enter description here. Any description." },
           {73, "Date, action", 6, "Enter description here. Any description." },
           {74, "Credits, number", 10, "Enter description here. Any description." },
           {75, "Credits, reversal number", 10, "Enter description here. Any description." },
           {76, "Debits, number", 10, "Enter description here. Any description." },
           {77, "Debits, reversal number", 10, "Enter description here. Any description." },
           {78, "Transfer, number", 10, "Enter description here. Any description." },
           {79, "Transfer, reversal number", 10, "Enter description here. Any description." },
           {80, "Inquiries, number", 10, "Enter description here. Any description." },
           {81, "Authorizations, number", 10, "Enter description here. Any description." },
           {82, "Inquiries, reversal number", 10, "Enter description here. Any description." },
           {82, "Inquiries, reversal number", 12, "Enter description here. Any description." },
           {83, "Payments, number", 10, "Enter description here. Any description." },
           {83, "Payments, number", 12, "Enter description here. Any description." },
           {84, "Payments, reversal number", 10, "Enter description here. Any description." },
           {84, "Payments, reversal number", 12, "Enter description here. Any description." },
           {85, "Fee collections, number", 12, "Enter description here. Any description." },
           {86, "Credits, amount", 16, "Enter description here. Any description." },
           {87, "Credits, reversal amount", 16, "Enter description here. Any description." },
           {88, "Debits, amount", 16, "Enter description here. Any description." },
           {89, "Debits, reversal amount", 16, "Enter description here. Any description." },
           {90, "Authorizations, reversal number", 42, "Enter description here. Any description." },
           {91, "Country code, transaction Dest. Inst.", 3, "Enter description here. Any description." },
           {92, "Country code, transaction Orig. Inst.", 3, "Enter description here. Any description." },
           {93, "Transaction Dest. Inst. Id code", 11, "Enter description here. Any description." },
           {94, "Transaction Orig. Inst. Id code", 11, "Enter description here. Any description." },
           {95, "Card issuer reference data", 99, "Enter description here. Any description." },
           {95, "Card issuer reference data", 42, "Enter description here. Any description." },
           {96, "Message authentication code field", 8, "Enter description here. Any description." },
           {96, "Message authentication code field", 16, "Enter description here. Any description." },
           {96, "Key management data", 999, "Enter description here. Any description." },
           {97, "Amount, Net reconciliation", 17, "Enter description here. Any description." },
           {97, "Amount, Net reconciliation", 17, "Enter description here. Any description." },
           {98, "Payee", 25, "Enter description here. Any description." },
           {99, "Settlement institution Id code", 11, "Enter description here. Any description." },
           {99, "Settlement institution Id code", 11, "Enter description here. Any description." },
           {100, "Receiving institution Id code", 11, "Enter description here. Any description." },
           {101, "File name", 17, "Enter description here. Any description." },
           {102, "Account identification 1", 28, "Enter description here. Any description." },
           {103, "Account identification 2", 28, "Enter description here. Any description." },
           {104, "Transaction description", 100, "Enter description here. Any description." },
           {105, "Credits, Chargeback amount", 16, "Enter description here. Any description." },
           {106, "Debits, Chargeback amount", 16, "Enter description here. Any description." },
           {107, "Credits, Chargeback number", 10, "Enter description here. Any description." },
           {108, "Debits, Chargeback number", 10, "Enter description here. Any description." },
           {109, "Credits, Fee amounts", 84, "Enter description here. Any description." },
           {110, "Debits, Fee amounts", 84, "Enter description here. Any description." },
           {111, "Reserved for ISO use", 999, "Enter description here. Any description." },
           {112, "Reserved for ISO use", 999, "Enter description here. Any description." },
           {113, "Reserved for ISO use", 999, "Enter description here. Any description." },
           {114, "Reserved for ISO use", 999, "Enter description here. Any description." },
           {115, "Reserved for ISO use", 999, "Enter description here. Any description." },
           {116, "Reserved for national use", 999, "Enter description here. Any description." },
           {117, "Reserved for national use", 999, "Enter description here. Any description." },
           {118, "Reserved for national use", 999, "Enter description here. Any description." },
           {119, "Reserved for national use", 999, "Enter description here. Any description." },
           {120, "Reserved for national use", 999, "Enter description here. Any description." },
           {121, "Reserved for national use", 999, "Enter description here. Any description." },
           {122, "Reserved for national use", 999, "Enter description here. Any description." },
           {123, "Reserved for private use", 999, "Enter description here. Any description." },
           {124, "Reserved for private use", 999, "Enter description here. Any description." },
           {125, "Reserved for private use", 999, "Enter description here. Any description." },
           {126, "Reserved for private use", 999, "Enter description here. Any description." },
           {127, "Reserved for private use", 999, "Enter description here. Any description." },
           {128, "Message authentication code field", 8, "Enter description here. Any description." },
   
   };
 
    //create table with data
    JTable table = new JTable(data, columnNames);{
     
//    add the table to the frame
    this.add(new JScrollPane(table));
     
    this.setTitle("ISO8583 Table");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    this.pack();  
    this.setVisible(true);
 
} 

   public DefaultTableModel model = new DefaultTableModel(data, columnNames);
   public JTable jTable = new JTable(model);

   public TableRowSorter<TableModel> rowSorter
           = new TableRowSorter<>(jTable.getModel());

   public JTextField jtfFilter = new JTextField();
   public JButton jbtFilter = new JButton("Filter");


}

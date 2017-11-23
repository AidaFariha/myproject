import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EditISO extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditISO frame = new EditISO();
					frame.setVisible(true);
					frame.setTitle("Edit Field");
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public EditISO() {
		setBounds(100, 100, 450, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String isoid = JOptionPane.showInputDialog(null, "Enter ISO id : ", "Edit Field", JOptionPane.INFORMATION_MESSAGE);
		if (isoid.equals(JOptionPane.NO_OPTION)) {
			
		}
		
		textField = new JTextField();
		textField.setText(isoid);
		textField.setEditable(false); 
		textField.setBounds(157, 52, 253, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 83, 253, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 114, 253, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 147, 253, 23);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("ISO id :");
		lblNewLabel.setBounds(32, 56, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMessageLength = new JLabel("Message length :");
		lblMessageLength.setBounds(32, 87, 115, 14);
		contentPane.add(lblMessageLength);
		
		JLabel lblMessageName = new JLabel("Message name :");
		lblMessageName.setBounds(32, 118, 115, 14);
		contentPane.add(lblMessageName);
		
		JLabel lblMessageClass = new JLabel("Message Class :");
		lblMessageClass.setBounds(32, 151, 115, 14);
		contentPane.add(lblMessageClass);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText(null);
				textField_2.setText(null);
			    textField_3.setText(null);
			}
		});
		btnReset.setBounds(227, 206, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
				try {
					String filepath = "iso87gfci.xml";
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
					Document doc = docBuilder.parse(filepath);
					doc.getDocumentElement().normalize();
					
					NodeList nodelist = doc.getElementsByTagName("isofield");
					
					for(int i=0; i<nodelist.getLength(); i++) { 
						
					Element element = (Element)nodelist.item(i); 
					String id = element.getAttribute("id"); 
					String input = textField.getText();
					
					if(id.equalsIgnoreCase(input)) { 
						element.setAttribute("length", textField_1.getText());
						element.setAttribute("name", textField_2.getText());
						element.setAttribute("class", textField_3.getText());
					} 
					} 
		
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File(filepath));
					transformer.transform(source, result);

					System.out.println("Done");

				   } catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				   } catch (TransformerException tfe) {
					tfe.printStackTrace();
				   } catch (IOException ioe) {
					ioe.printStackTrace();
				   } catch (SAXException sae) {
					sae.printStackTrace();
				   }
				setVisible(false);
			}
		});
		btnUpdate.setBounds(321, 206, 89, 23);
		contentPane.add(btnUpdate);
	}
	
}

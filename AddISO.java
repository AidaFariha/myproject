
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
import org.xml.sax.SAXException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddISO extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTest;
	private JTextField txtTest_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					AddISO frame = new AddISO();
					frame.setTitle("Add Field");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public AddISO() {
		
		setBounds(100, 100, 450, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdate = new JButton("Add");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String filename = "iso87gfci.xml";
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
					Document doc = docBuilder.parse(filename);
					doc.getDocumentElement().normalize();
					
					doc.getDocumentElement().normalize();
					
					Element element = doc.getDocumentElement();
					Element newisofield = doc.createElement("isofield");
					newisofield.setAttribute("id", txtTest.getText());
					newisofield.setAttribute("length", txtTest_1.getText());
					newisofield.setAttribute("name", textField_2.getText());
					newisofield.setAttribute("class", textField_3.getText());
					
					element.appendChild(newisofield);
				        
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);
					StreamResult result = new StreamResult(new File(filename));
					transformer.transform(source, result);
					
				}
				catch (ParserConfigurationException pce) {
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
		btnUpdate.setBounds(324, 221, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTest.setText(null);
				txtTest_1.setText(null);
				textField_2.setText(null);
			    textField_3.setText(null);
			}
		});
		btnReset.setBounds(228, 221, 89, 23);
		contentPane.add(btnReset);

		txtTest = new JTextField();
		txtTest.setBounds(135, 53, 278, 28);
		contentPane.add(txtTest);
		txtTest.setColumns(10);
		
		txtTest_1 = new JTextField();
		txtTest_1.setColumns(10);
		txtTest_1.setBounds(135, 92, 278, 28);
		contentPane.add(txtTest_1);
		
		JLabel lblNewLabel = new JLabel("ISO Id :");
		lblNewLabel.setBounds(31, 60, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Message Length :");
		lblNewLabel_1.setBounds(31, 99, 110, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Message Name :");
		lblNewLabel_2.setBounds(31, 138, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 131, 278, 28);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Message Class :");
		lblNewLabel_3.setBounds(31, 177, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 170, 278, 28);
		contentPane.add(textField_3);
	}

}

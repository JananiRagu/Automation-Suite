package com.test.regression.cub.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UpdateXML {
	
	public void updateTestData() {

		   try {
		      File inputFile = new File("temp.xml"); 	    	
		      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      Node testData = doc.getFirstChild();
		      Node user = doc.getElementsByTagName("user").item(0);
		      // update supercar attribute
		      //NamedNodeMap attr = user.getAttributes();
		      //Node nodeAttr = attr.getNamedItem("company");
		      //nodeAttr.setTextContent("Lamborigini");

		      // loop the supercar child node
		      NodeList list = user.getChildNodes();
		      for (int temp = 0; temp < list.getLength(); temp++) {
		         Node node = list.item(temp);
		         if (node.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) node;
		            
		           
		            if ("UserName".equals(eElement.getNodeName())){
		            	
		            	String username = eElement.getTextContent();
		            	System.out.println("Username before Update : "+ username);
		            	
		            	List<String> splitUserName = Arrays.asList(username.split("@"));
		            	
		            	String temp1 = splitUserName.get(0);
		            	List<String> wantedUserName = Arrays.asList(temp1.split("_"));
		            	
		            	String numInUserName = wantedUserName.get(1);
		            	int updatedNumInUserName = Integer.parseInt(numInUserName);
		            	updatedNumInUserName++;
		            	
		            	String numInUserNameUpdated = String.valueOf(updatedNumInUserName);
		            	String updateUN = wantedUserName.get(0)+"_"+numInUserNameUpdated+"@"+splitUserName.get(1);
		            	
		            	System.out.println("Updated Username : " + updateUN);
		            	
		            	//setValue("UserName", eElement , updateUN);
		            	//node.setNodeValue(updateUN);
		            	eElement.setTextContent(updateUN);
		            
		            	//System.out.println("Updated Successfully..");
		            }
		         }
		      }
		     
		      
		      Transformer xformer = TransformerFactory.newInstance().newTransformer();
		      xformer.transform(new DOMSource(doc), new StreamResult(inputFile));

		    //For console Output. 
		      StreamResult consoleResult = new StreamResult(System.out); 
		      xformer.transform(new DOMSource(doc), consoleResult); 

		}catch(SAXException | TransformerException | IOException | ParserConfigurationException ex) {
		    ex.printStackTrace();
		}
		   
	}
	
}

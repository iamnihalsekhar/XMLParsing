import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyEmp {
    public static void addNewUser(Scanner userInput) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        boolean addUser = true;
        while(addUser){
            System.out.println("Do you want to add a new employee ? (Yes/No)");
            String decision;
            String nameToWrite;
            String ageToWrite;
            String designationToWrite;
    
            decision = userInput.nextLine();
                switch(decision){
                    case "Yes" :
                    case "YES" :
                    case "yes" :
                    case "y" :
                    case "Y" : 
                    System.out.println("Enter the Name of the Employee");
                    nameToWrite = userInput.nextLine();
                    System.out.println("Enter the Age of the Employee");
                    ageToWrite = userInput.nextLine();
                    System.out.println("Enter the Designation of the Employee");
                    designationToWrite = userInput.nextLine();
                    if(nameToWrite.isEmpty()){
                        nameToWrite = "N/A";
                    }
                    if(ageToWrite.isEmpty()){
                        ageToWrite = "N/A";
                    }
                    if(designationToWrite.isEmpty()){
                        designationToWrite = "N/A";
                    }
                    //Do your workings here.    
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
                    Document doc = docBuilder.parse("D:\\SampleXml.xml");
                    Element employeesTag = doc.getDocumentElement();
                    Element employee = doc.createElement("employee");
                    Element name = doc.createElement("name");
                    name.setTextContent(nameToWrite);
                    employee.appendChild(name);
                    Element age = doc.createElement("age");
                    age.setTextContent(ageToWrite);
                    employee.appendChild(age);
                    Element designation = doc.createElement("designation");
                    designation.setTextContent(designationToWrite);
                    employee.appendChild(designation);
                    employeesTag.appendChild(employee);
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("D:\\SampleXml.xml"));
                    transformer.transform(source, result);
                    break;
                    case "No":
                    case "NO":
                    case "no":
                    case "n" : 
                    case "N" :
                    addUser = false;
                    break;
                    default:
                    System.out.println("You have entered incorrect input");
                    boolean repeat = true;
                    while (repeat){
                        System.out.println("Do you want to continue ? (Yes/No)");
                        decision = userInput.nextLine();
                        switch(decision){
                            case "No":
                            case "NO":
                            case "no":
                            case "n" : 
                            case "N" :
                            repeat = false;
                            addUser = false;
                            break;
                            case "Yes" :
                            case "YES" :
                            case "yes" :
                            case "y" :
                            case "Y" : 
                            addUser = true;
                            repeat = false;
                            break;
                            default :
                            repeat = true;
                        }
                    }
                break;
            }
        }
    }
    public static void deleteEmployee(Scanner userInput) throws ParserConfigurationException, SAXException, IOException, TransformerException{
        boolean addUser = true;
        while(addUser){
            System.out.println("Do you want to delete an existing employee ? (Yes/No)");
            String decision;
            String nameToWrite;
            decision = userInput.nextLine();
                switch(decision){
                    case "Yes" :
                    case "YES" :
                    case "yes" :
                    case "y" :
                    case "Y" : 
                    System.out.println("Enter the Name of the Employee");
                    nameToWrite = userInput.nextLine();
    
                    if(nameToWrite.isEmpty()){
                        nameToWrite = "N/A";
                    }
                    
                    //Do your workings here.    
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
                    Document doc = docBuilder.parse("D:\\SampleXml.xml");
                    NodeList employee = doc.getElementsByTagName("employee");
                    boolean empDeleted = false;
                    for(int node = 0; employee.getLength()> node; node++){
                        Node details = employee.item(node);
                        if(details.getTextContent().contains(nameToWrite)){
                          Node parent = details.getParentNode();
                          parent.removeChild(details);
                          empDeleted = true;
                        }
                    }
                    if(!empDeleted){
                        System.err.println("No Employee found matching the given name");
                    }
                    System.out.println("Remaining Records :- " + employee.getLength());
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("D:\\SampleXml.xml"));
                    transformer.transform(source, result);
                    break;
                    case "No":
                    case "NO":
                    case "no":
                    case "n" : 
                    case "N" :
                    addUser = false;
                    break;
                    default:
                    System.out.println("You have entered incorrect input");
                    boolean repeat = true;
                    while (repeat){
                        System.out.println("Do you want to continue ? (Yes/No)");
                        decision = userInput.nextLine();
                        switch(decision){
                            case "No":
                            case "NO":
                            case "no":
                            case "n" : 
                            case "N" :
                            repeat = false;
                            addUser = false;
                            break;
                            case "Yes" :
                            case "YES" :
                            case "yes" :
                            case "y" :
                            case "Y" : 
                            addUser = true;
                            repeat = false;
                            break;
                            default :
                            repeat = true;
                        }
                    }
                break;
            }
        }
    }
}

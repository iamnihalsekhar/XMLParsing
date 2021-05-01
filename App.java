
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();	
		SAXParser parser = parserFactor.newSAXParser();
	    ParseXML parseXML = new ParseXML();	  
	    Path path = Paths.get("D:\\SampleXml.xml");

	    parser.parse(path.toFile(),parseXML);

	    Employees employees = parseXML.getEmployees();

        List emps = employees.getEmp();
        for(int i = 0;emps.size()>i;i++){
        	System.out.println(emps.get(i));
        }
        Scanner newScan = new Scanner(System.in);
        System.out.println("First you will be navigated to add an employee and then deleting an existing employee");

            //To add a new employee and update the existing xml file
            ModifyEmp.addNewUser(newScan);
            //To delete an existing employee and update the existing xml file
            ModifyEmp.deleteEmployee(newScan);
            
        newScan.close();
	}
}

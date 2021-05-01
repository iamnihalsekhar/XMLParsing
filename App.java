
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

        List movies = employees.getEmp();
        for(int i = 0;movies.size()>i;i++){
        	System.out.println(movies.get(i));
        }
        Scanner newScan = new Scanner(System.in);
        //To add a new employee
        ModifyEmp.addNewUser(newScan);
        ModifyEmp.deleteEmployee(newScan);
        
        newScan.close();
	}
}

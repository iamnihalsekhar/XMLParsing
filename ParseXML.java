import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class ParseXML extends DefaultHandler {
    
    Employees employees = new Employees();
	List empList = new ArrayList();
	Emp emp=null;
	String content =null;	

	public void startElement(String namespaceURI,String localName,String qname,Attributes attributes){				
		if(qname.equals("employee")){
			emp=new Emp();
		}
	}

	public void endElement(String namespaceURI,String localName,String qname){

		switch(qname){
		   case "employee":         empList.add(emp);
		    break;
		   case "name" :            emp.setName(content);
		    break;
		   case "age" :             emp.setAge(content);
		    break;
		   case "designation"  :    emp.setDesig(content);   
		    break;
		   case "employees" :       employees.setEmp(empList);
		    break;
		}

	}	
	public void characters(char []ch,int start,int length){		
		content=new String(ch, start, length);
	}
	public Employees getEmployees(){
		return employees;
	}	

}

 
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class st {
	private String name;
	private int age;
	private double gpa;
	
    public st(String name, int age, double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
    

	public st() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	


	@Override
	public String toString() {
		return "st [name=" + name + ", age=" + age + ", gpa=" + gpa + "]";
	}


	public static void main(String argv[]) {
		List<st> students = new ArrayList<>();
		st student4 = new st("Huong", 18, 3.6);
		st student5 = new st("Hien", 18, 3.5);
		st student6 = new st("Nhi", 18, 3.7);
		students.add(student4);
		students.add(student6);
		students.add(student5);
        try {
            DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // tạo phần tử gốc có tên class
            Element rootElement = doc.createElement("class");
            // thêm thuộc tính totalStudents vào thẻ class
            doc.appendChild(rootElement);
            System.out.println();
            Attr totalStudentAttr = doc.createAttribute("totalStudents");
            totalStudentAttr.setValue(students.size()+ "");
            rootElement.setAttributeNode(totalStudentAttr);
            int i = 1;
            for (st st : students) {
            Element s1 =  doc.createElement("student");
            rootElement.appendChild(s1);
            Attr attr1 = doc.createAttribute("rollno");
            
            attr1.setValue(i + "");
            s1.setAttributeNode(attr1);
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(st.name + ""));
            s1.appendChild(name);
           
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode(st.age + ""));
            s1.appendChild(age);
           
            Element gpa = doc.createElement("gpa");
            gpa.appendChild(doc.createTextNode(st.gpa + ""));
            s1.appendChild(gpa);
           
            i = i + 1;
			}

 
            // ghi nội dung vào file XML
            TransformerFactory transformerFactory = 
                    TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(
                    new File("D:\\html\\h2\\students.xml"));
            transformer.transform(source, result);
 
            // ghi kết quả ra console để kiểm tra
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

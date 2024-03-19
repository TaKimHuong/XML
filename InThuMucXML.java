import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InThuMucXML {
	public File file;
	public InThuMucXML(String tenFile) {
		this.file = new File(tenFile);

	}
	public  void InThuMuc(){
		this.InChiTietCayThuMuc(this.file, 1);
	}
	public  void InChiTietCayThuMuc(File file , int bac)  {
		for (int i = 0; i < bac; i++) {
			System.out.print("\t");
		}
		
		if (file.canRead() && file.isDirectory()) {
			File[] mangCon = file.listFiles();
			System.out.println("<" + file.getName() + ">");
			for (File fx : mangCon) {
				InChiTietCayThuMuc(fx, bac + 1);
			}
			for (int i = 0; i < bac; i++) {
				System.out.print("\t");
			}
			System.out.println("</" + file.getName() + ">");
		}else {
			System.out.println("<file>" + file.getName() + "</file>" );
		}
		
	}
	
	public static void main(String[] args) {
		File f = new File("D:\\html");
		InThuMucXML in = new InThuMucXML("D:\\HTML_b3");
		in.InThuMuc();
	
	}

}

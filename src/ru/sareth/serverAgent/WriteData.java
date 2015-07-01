package ru.sareth.serverAgent;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteData {
	public static void writeInFile(String message, String fileName){
		File file = new File(fileName);
		 
	    try {
	        //���������, ��� ���� ���� �� ���������� �� ������� ���
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        //PrintWriter ��������� ����������� ������ � ����
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            //���������� ����� � ����
	        	out.print("<main>\n");
	            out.print(message);
	            out.print("\n</main>");
	        } finally {
	            //����� ���� �� ������ ������� ����
	            //����� ���� �� ���������
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
}

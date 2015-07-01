package ru.sareth.serverAgent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Main {
	public static void main(String[] args) throws IOException {
		String message="";
		if (args.length == 2) {
			message+=Space.getSpace(args[0]);
			WriteData.writeInFile(message, args[2]);
		}else if(args.length == 3){
			message+=Space.getSpace(args[0]);
			message+=Space.getSpace(args[1]);
			WriteData.writeInFile(message, args[2]);
		}
		else if(args.length == 4){
			message+=Space.getSpace(args[0]);
			message+=Space.getSpace(args[1]);
			message+=Space.getSpace(args[2]);
			WriteData.writeInFile(message, args[3]);
		}else if(args.length == 5){
			message+=Space.getSpace(args[0]);
			message+=Space.getSpace(args[1]);
			message+=Space.getSpace(args[2]);
			message+=Space.getSpace(args[3]);
			WriteData.writeInFile(message, args[4]);
		}else{
			showErrorMessage();
		}
		printUsage();
		
		Runtime r=Runtime.getRuntime();
		String f,temp,res="";
		int i=0,j=0;
		f="sensors";
		Process p=r.exec(f);
		BufferedReader pin=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((temp=pin.readLine())!=null)
		{
		System.out.println(temp);
		}
		
	}

	private static void showErrorMessage() {
		System.out.print("Parameters of service is incorrect\n"
					+ "Syntax\n agent.jar [volumes] [pathToResult]\n" 
					+ "________________\n"
					+ " [volumes]\n On windows c: d: e: etc. but not more three"
					+ "\n On unix / /dev/sda1 etc.\n"
					+ " [pathToResult] - path to file with result\n"
					+ "________________\n"
					+"(c) Sareth.ru 2015 serverAgent freespace version 0.1.0");
	}
	
	private static void printUsage() {
		  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		    method.setAccessible(true);
		    if (method.getName().startsWith("get") 
		        && Modifier.isPublic(method.getModifiers())) {
		            Object value;
		        try {
		            value = method.invoke(operatingSystemMXBean);
		        } catch (Exception e) {
		            value = e;
		        } // try
		        System.out.println(method.getName() + " = " + value);
		    } // if
		  } // for
		}

}

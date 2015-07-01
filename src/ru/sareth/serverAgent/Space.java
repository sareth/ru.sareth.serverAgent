package ru.sareth.serverAgent;

import java.io.File;

public class Space {
	public static String getSpace(String VOLUME){
		final File file = new File(VOLUME);
        
		long totalSpace = file.getTotalSpace();
		long freeSpace = file.getFreeSpace();
		long usableSpace = file.getUsableSpace();
		String message="";         
		message+=("<volume v=\"" + VOLUME + "\">\n");
		message+=("<total>" + totalSpace / 1024 / 1024 + "</total>\n");
		message+=("<free>" + freeSpace / 1024 / 1024 + "</free>\n");
		message+=("<usable>" + usableSpace / 1024 / 1024 + "</usable>\n");
		if ((usableSpace / 1024 / 1024)<15000){
			message+=("<lowerspace>Usable space are lower than 15 GB!!!</lowerspace>\n");
		}
		message+="</volume>\n";
		return message;
		
	}
}

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void ip(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha!= null) {
				if(linha.contains("Adaptador")) {
					System.out.println(linha);
				}else if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ping(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha!= null) {	
				if(linha.contains("ms")) {
					if(linha.contains("Resposta") == false) {
					System.out.println(linha);
					}	
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
} //fim

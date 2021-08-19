package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		int opc = 0;
		
		RedesController redeC = new RedesController();
		String os = redeC.os();
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu "
					+ "\nEscolha o n�mero que corresponde as op��es abaixo \n1- M�todo IP \n2- M�todo PING"
					+ "\n3- Finalizar"));
			
			switch(opc) {
			case 1:
				if(os.contains("W") == true) {
					String process = "ipconfig";
					redeC.ip(process);
				}else {
					String process = "ifconfig";
					redeC.ip(process);
				}
				break;
			case 2:
				if(os.contains("W") == true) {
					String process = "PING -4 -n 10 www.google.com.br";
					redeC.ping(process);
				}else {
					String process = "PING -4 -c 10 www.google.com.br";
					redeC.ping(process);
				}
				break;
				
			case 3:
				JOptionPane.showMessageDialog(null, "Finalizando...");
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "N�mero inv�lido. Tente novamente!");
			}
			
		}while(opc != 3);
		
	}

}

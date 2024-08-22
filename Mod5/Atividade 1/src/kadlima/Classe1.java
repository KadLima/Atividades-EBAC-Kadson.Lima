package kadlima;

public class Classe1 {

	public static void main(String[] args) {
		System.out.print("Olá! Boa noite, " + args[0] + " " + args[1] + ". " + "Como você está?");	 
			String resposta = args[2];
			if(resposta.equalsIgnoreCase("Bem")) {
				System.out.print(" Que bom," + " " + args[0] + "! Estou bem também. Obrigado por perguntar."); 
			}	else if(resposta.equalsIgnoreCase("Não estou tão bem hoje.")) {
				System.out.print("Puxa. Posso te ajudar em algo?");
			}	else 
				System.out.print(" Ah, já vi que você não é de falar muito...");							
	}
}
package frontiere;

import java.util.InputMismatchException;
import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé "+nomVendeur+" il faut être un habitant du village pour commercer ici");
		} else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouvez un étal");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé "+nomVendeur+" je n'ai plus d'étals qui ne soit pas déjà occupé");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements:");
		String produit = entreString("Quel produit souhaitez-vous vendre ?");
		int nbProduit= Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numEtal= controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal numéro "+(numEtal+1));
		}
		}
	
	
	private String entreString(String question) {
		boolean entreecorrecte=false;
		String produit = null;
		do {
			try {
				System.out.println(question);
				produit=scan.next();
				entreecorrecte=true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez entrer du texte !");
				entreecorrecte=false;
			}
		} while(!entreecorrecte);
		return produit;
	}
	
	
}
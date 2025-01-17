package frontiere;

import java.util.Scanner;
import personnages.Gaulois;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)){
			
			System.out.println("Quel produit voulez-vous achetez?");
			String produit=scan.next();
			String[] vendeurs=controlAcheterProduit.listeVendeur(nomAcheteur, produit);
			System.out.println("Chez quel commercant voulez-vous acheter "+produit);
			for(int i=0;i<vendeurs.length;i++) {
				System.out.println((i+1)+" - "+ vendeurs[i]);
			}
			int numVendeur=scan.nextInt();

			System.out.println("Panoramix se deplace jusqu a l'etal du vendeur " +vendeurs[numVendeur-1]);
			System.out.println("Combien de fleurs souhaitez-vous achetez?");
			int nbAchat=scan.nextInt();
			
			controlAcheterProduit.acheterProduit(produit, nbAchat,vendeurs[numVendeur-1]);
			System.out.println(nomAcheteur+" a acheter "+nbAchat+ " de "+produit+ " a "+vendeurs[numVendeur-1]);
		} else {
			System.out.println("Vous n'etes pas un habitant du village");
		}
		
	}
	
}

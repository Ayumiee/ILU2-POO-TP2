package controleur;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);	
	}
	
	
	public String[] listeVendeur(String nomAcheteur, String produit) {
		Gaulois[] gaulois=village.rechercherVendeursProduit(produit);
		String[] nomVendeurs=new String[gaulois.length];
		for (int i=0;i<gaulois.length;i++) {
			nomVendeurs[i]=gaulois[i].getNom();
		}
		return nomVendeurs;
	}


	public void acheterProduit(String produit, int nbAchat, String vendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		etal.acheterProduit(nbAchat);
	}
}

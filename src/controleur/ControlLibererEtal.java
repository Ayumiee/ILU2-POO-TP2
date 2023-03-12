package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal= new String[5];
		donneesEtal[1]=""+controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).isEtalOccupe();
		donneesEtal[2]=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getProduit();
		donneesEtal[3]=""+controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantiteDebut();
		donneesEtal[4]=""+(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantiteDebut()-controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).getQuantite());
		return donneesEtal;
	}

	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}

}

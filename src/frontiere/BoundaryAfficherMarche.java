package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] donnees=controlAfficherMarche.donnerInfosMarche();
		if (donnees.length==0) {
			System.out.println("Le marché est vide, revenez plus tard");
		} else {
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			for (int i=0;i<donnees.length;i++) {
				String vendeur = donnees[i];
				i++;
				String quantitee = donnees[i];
				i++;
				String produit = donnees[i];
				i++;

				System.out.println("- "+ vendeur+" qui vend "+ quantitee+ " "+ produit);
			}
		}
	}
}

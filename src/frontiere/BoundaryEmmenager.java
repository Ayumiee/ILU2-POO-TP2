package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerGaulois(String nomVisiteur) {
		int force=-1;
		System.out.println("Bienvenu villageois "+nomVisiteur);
		force=Clavier.entrerEntier("Quelle est votre force?");
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force = -1;
		int potionMin =-1;
		int potionMax=-1;
		System.out.println("Bienvenue druide " + nomVisiteur);
		force = Clavier.entrerEntier("Quelle est votre force ?");
		potionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
		do {
			potionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			if (potionMax<potionMin) {
				System.out.println("Votre force de potion la plus forte ne peut pas �tre plus petite que votre force de potion la plus faible");
			}
		} while(potionMax<potionMin);

	controlEmmenager.ajouterDuide(nomVisiteur,force,potionMin,potionMax);
	}
	
}

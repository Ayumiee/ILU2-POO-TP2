package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu;
		vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui !");
		} else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu "+donneesEtal[4]+" sur "+donneesEtal[3]+" produit");
			System.out.println("En revoir "+nomVendeur+" , passez une bonne journ�e");
		}
	}

}

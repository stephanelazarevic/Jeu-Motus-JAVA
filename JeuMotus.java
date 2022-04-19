package MonPackage;

public class JeuMotus {

	public static void main(String[] args) {

		// Déclaration des variables
		
		String J1, J2, Mot, Prop;
		int TailleMot, TailleProp, NbEss, Cpt, LConnu; 
		
		// Déclaration des variables indicées
		
		String MotAtrouver[];
		String MotRep[];
		
		// initialisation des variables
		
		J1 = Saisie.lire_String("Joueur 1, saisissez votre nom");
		J2 = Saisie.lire_String("Joueur 2, saisissez votre nom");
		LConnu = 0;
		
		// Saisie du Mot mystère
		
		Mot = Saisie.lire_String(J1 + " veuillez saisir un mot secret de plus de 2 lettres");
		Mot = Mot.toLowerCase(); 
		TailleMot = Mot.length();
		while (Mot.length() < 3) {
			Mot = Saisie.lire_String("Le mot doit contenir 3 caractères au minimum, veuillez recommencez !");
			Mot = Mot.toLowerCase(); 
			TailleMot = Mot.length();
		}
		
		// Instanciation des variables indicées
		
		MotAtrouver = new String[TailleMot];
		MotRep = new String[TailleMot];
		
		// Traitement
				
		NbEss = TailleMot - 2;
		
		for (Cpt = 0; Cpt < TailleMot; Cpt++) {
			MotAtrouver[Cpt] = Mot.substring(Cpt, Cpt+1);
		}
		
		System.out.println(J2 + " le mot à trouver contient " + TailleMot + " lettres, et vous disposez de " + NbEss + " essais. Veuillez saisir une proposition ou tapez 'SOL' pour obtenir la réponse et arrêter.");
		for (NbEss = 0; NbEss < TailleMot-2; NbEss++ ) {
			Prop = Saisie.lire_String(J2 + " veuillez saisir une proposition");
			Prop = Prop.toLowerCase(); 
			TailleProp = Prop.length();
			
			// Suite du traitement
				
			if (Prop.equals("sol")) {
				System.out.println("Le mot secret à trouver était : " + Mot);
				break;
			}
			else 
				while (TailleProp != TailleMot && Prop != "sol") {
					Prop = Saisie.lire_String("Erreur, veuillez saisir un mot de " + TailleMot + " caractères");
					TailleProp  = Prop.length();
				} 
			
				if (TailleProp == TailleMot && Prop != "SOL") {
			
				for (Cpt = 0; Cpt < TailleProp; Cpt++) {
					MotRep[Cpt] = Prop.substring(Cpt, Cpt+1);
					}
				for (Cpt = 0; Cpt < TailleProp; Cpt++) {
					if (MotRep[Cpt].contentEquals(MotAtrouver[Cpt])) {
						LConnu = LConnu+1;
					}
				}
				
				}
				
				System.out.println("Vous avez " + LConnu + " lettre(s) bien placée(s)");
				System.out.println("Vous avez utilisé " + (NbEss+1) + " essais sur " + (TailleMot - 2));
				LConnu = 0;
				
				if (Prop.equals(Mot)) {
					System.out.println("Bravo, vous avez trouvé le mot secret !");
					break;
				}
		}
		
		System.out.println("C'est terminé !");
	}

}
	

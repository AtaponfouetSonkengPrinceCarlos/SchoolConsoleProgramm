import java.util.ArrayList;
import java.util.List;

public class Application {
public static void main(String[] args) {
	
	//on cree un une liste de ContratService
	List<ContratService> listeContrat = new  ArrayList<>();
	
	//Creation d'un objet Bande passante 
	ContratBandePassante cbp = new ContratBandePassante(1, "Client A", "Or", (double) 50);
	//Creation d'un objet taux de disponibilite
	ContratDisponilite ctd = new ContratDisponilite(1, "Client A", "Or", (double) 99.5);
	
	//Ajout des contrats services dans la la liste de contrat
	listeContrat.add(cbp);
	
	listeContrat.add(ctd);
	
	//Utilisation du polymorphisme pour evaluer les conformite de chaque contrat
	//service contenue dans la liste de contrat Service
	
	for(ContratService cs: listeContrat) {
		cs.evaluerConformite();
	}
	
	//On genere les rapport de chaque contrat service
	cbp.genererRapport();
	ctd.genererRapport();
	
	
	
}
}


public abstract class ContratService {

	protected int identifiant;
	protected String nomClient;
	protected String niveauService;
	
	public ContratService(int identifiant, String nomClient, String niveauService) {
		this.identifiant = identifiant;
		this.nomClient = nomClient;
		this.niveauService = niveauService;
	}

	
	protected boolean evaluerConformite() {
		if(this.identifiant != 0 && this.nomClient != null && this.niveauService != null) { // Nous verifions si aucun champ n'est vide
			System.out.println("Le contrat est conforme");
			return true;
		}
		return false;
	}
	
	protected void afficheDetails() {
		System.out.println("Affichage des details de l'appel !");
		System.out.println("Identifiant"+this.identifiant+"\n"+"Nom du client:"+
		this.nomClient+"\n"+"Niveau de service"+this.niveauService);
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNiveauService() {
		return niveauService;
	}

	public void setNiveauService(String niveauService) {
		this.niveauService = niveauService;
	}
}

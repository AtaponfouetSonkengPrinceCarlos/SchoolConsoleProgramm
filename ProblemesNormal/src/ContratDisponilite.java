
public class ContratDisponilite extends ContratService implements Auditable {

	public ContratDisponilite(int identifiant, String nomClient, 
			String niveauService, Double tauxDisponibilite) {
		super(identifiant, nomClient, niveauService);
		this.tauxDisponibilite = tauxDisponibilite;
	}

	private Double tauxDisponibilite;
	
	@Override
	public void genererRapport() {
		// TODO Auto-generated method stub
		if(this.evaluerConformite() && this.tauxDisponibilite != 0) {
			System.out.println("L'accord est conforme voici sa description");
			this.evaluerConformite();
			System.out.println("La bande passante minimun de cette accord est:"+
			this.tauxDisponibilite);
		}else {
			System.out.println("L'accord est non conforme voici sa description");
			this.evaluerConformite();
			System.out.println("La bande passante minimun de cette accord est:"+
					this.tauxDisponibilite);
		}
	}

	public Double getTauxDisponibilite() {
		return tauxDisponibilite;
	}

	public void setTauxDisponibilite(Double tauxDisponibilite) {
		this.tauxDisponibilite = tauxDisponibilite;
	}

}

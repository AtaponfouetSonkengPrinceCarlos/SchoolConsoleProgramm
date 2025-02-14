
public class ContratBandePassante extends ContratService implements Auditable {
	
	public ContratBandePassante(int identifiant, String nomClient, String niveauService,
			Double bandePassanteMinimun) {
		super(identifiant, nomClient, niveauService);
		this.BandePassanteMinimun = bandePassanteMinimun;
	}


	private Double BandePassanteMinimun;

	
	@Override
	public void genererRapport() {
		// TODO Auto-generated method stub
		if(this.evaluerConformite() && this.BandePassanteMinimun > 0) {
			System.out.println("L'accord est conforme voici sa description");
			this.evaluerConformite();
			System.out.println("La bande passante minimun de cette accord est:"+
			this.BandePassanteMinimun);
		}else {
			System.out.println("L'accord est non conforme voici sa description");
			this.evaluerConformite();
			System.out.println("La bande passante minimun de cette accord est:"+
			this.BandePassanteMinimun);
		}

	}


	public Double getBandePassanteMinimun() {
		return BandePassanteMinimun;
	}


	public void setBandePassanteMinimun(Double bandePassanteMinimun) {
		BandePassanteMinimun = bandePassanteMinimun;
	}

}

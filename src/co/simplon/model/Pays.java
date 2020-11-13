package co.simplon.model;

public class Pays
{
	private int id;
	private String nom;
	
	
	public Pays() {}	
	
	public Pays(int unId,String unNom) 
	{
		this.id=unId;
		this.nom = unNom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return this.id;
	}
	
	public String toString() 
	{
		return this.getId()+" "+this.getNom();
	}
	
}

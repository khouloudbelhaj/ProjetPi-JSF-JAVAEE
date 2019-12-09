package ManagedBean;

public class Ent {
	
		public String Nom;
		public String Prenom;
		public String Departement;
		public Ent()
		{
			this.Nom="undef";
			this.Prenom="udef";
			this.Departement="undef";
		}
		@Override
		public String toString() {
			return "ent [Nom=" + Nom + ", Prenom=" + Prenom + ", Departement=" + Departement + "]";
		}
		
		
	
}

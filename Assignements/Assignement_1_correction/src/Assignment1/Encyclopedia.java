package Assignment1;

public class Encyclopedia extends Book{
	private int  nbVolumes;
	public Encyclopedia(String t, String a, int pa, String g, int c, float p, int v) {
		super(t, a, pa, g, c, p);
		setNbVolumes(v);
	}
	public int getNbVolumes() {
		return nbVolumes;
	}
	public void setNbVolumes(int v) {
		nbVolumes = v;
	}
	public String toString(){
		return "E "+super.toString()+" Number of Volumes: "+nbVolumes;
	}
	public boolean equals(Encyclopedia b){
		if(super.equals(b) && nbVolumes==b.getNbVolumes()){
			return true;
		}
		return false;
	}
	
	
}

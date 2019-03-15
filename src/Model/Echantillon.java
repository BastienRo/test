package Model;

import java.util.ArrayList;

public class Echantillon{
	
	
	//liste des complexe formant le signal
	private ArrayList<Complex> signal;
	private int echantillonage; // la puissance de 2 entrée
	private int nbpoints; // nombre de points demandé
	private int nombrefen;
	private FFT nb;
	private ArrayList<ArrayList<Complex>> matrice;
	
	//constructeur
	public Echantillon(int echantillonage, int nbpoints,ArrayList<Complex> input){
		this.echantillonage = echantillonage;
		this.nbpoints=nbpoints;
		this.signal = input;
		//this.nb=new FFT();
	}
	
	public ArrayList<ArrayList<Complex>> diviseTab(){ //méthode qui divise le tableau en nombre de fenetre ce nombre correspond au nombre de valeur à calculer divisé par la puissance de 2
		
		int fe = this.echantillonage; // fe = nombre de fenetre
		int j;
		ArrayList<ArrayList<Complex>> matrice = new ArrayList<ArrayList<Complex>>();
		ArrayList<Complex> temp = new ArrayList<Complex>();
		
		for(j = 0; j<nbpoints; j++){
			if(temp.size() == fe){ // si le tableau temp à la même taille que le nombre de fenetre 
				matrice.add(new FFT().fft(temp));// on ajoute dans le tableau matrice la FFT du tableau temp
				temp = new ArrayList<Complex>();// on réinitialise le tableau temp
			}
			temp.add(signal.get(j)); // on ajoute dans le tableau temp le complexe à l'index j du signal
		}
			if(temp.size() != fe){ // si le tableau temp n'a pas la même taille que le nombre de fenetre
				for(j=temp.size();j<fe;j++){ //on parcours donc le tableau
				
				temp.add(new Complex(0,0)); // et on ajoute des complexe nul jusqu'à que l'on atteigne l'index fe
				
				
			}
			matrice.add(new FFT().fft(temp)); // on ajoute dans le tableau matrice la FFT du tableau temp
		}
		return matrice; // on retourne le tableau 2D avec une taille égale à fe et qui comporte les FFT de temp
			
	}
	
	
	public ArrayList<ArrayList<Complex>> modulefen(ArrayList<ArrayList<Complex>> x){ //méthode qui va calculer les modules du tableau x en entré
		int taille = x.size(); // on déclare et on définie la taille du tableau x
		int taille2; //délaration de la taille du tableau temp
		ArrayList<Complex> temp = new ArrayList<Complex>(); // création d'un tableau de temp
		for(int i = 0; i<taille;i++){ //on parcours le tableau en entré
			temp.addAll(x.get(i)); //on va ajouter à chaque index le complex du tableau en entré
			taille2= temp.size();//on recupere la taille du tableau temp
			for(int j=0;j<taille2;j++){// on parcours le second tableau temp
				temp.set(j,temp.get(j).module()); // on remplace le complex du tableau temp à l'index j par le module du complexe de ce tableau ce même index
			}
			x.set(i, temp); //on remplace le complexe du tableau à l'index i par le module qui est dans le tableau temp
			temp = new ArrayList<Complex>();// on reinitialise le tableau temp
		}
		return x; // on retourne le tableau x qui comporte maintenant tout les modules
		
	}

	public ArrayList<Complex> getSignal() {
		return signal;
	}

	public void setSignal(ArrayList<Complex> signal) {
		this.signal = signal;
	}

	public int getEchantillonage() {
		return echantillonage;
	}

	public void setEchantillonage(int echantillonage) {
		this.echantillonage = echantillonage;
	}

	public int getNbpoints() {
		return nbpoints;
	}

	public void setNbpoints(int nbpoints) {
		this.nbpoints = nbpoints;
	}

	public int getNombrefen() {
		return nombrefen;
	}

	public void setNombrefen(int nombrefen) {
		this.nombrefen = nombrefen;
	}

	public FFT getNb() {
		return nb;
	}

	public void setNb(FFT nb) {
		this.nb = nb;
	}

	public ArrayList<ArrayList<Complex>> getMatrice() {
		return matrice;
	}

	public void setMatrice(ArrayList<ArrayList<Complex>> matrice) {
		this.matrice = matrice;
	}
	
	
}
	
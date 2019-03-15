

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class lanceur{
	
	 private static final Logger log = LoggerFactory.getLogger(Main.class);
		
		public static ArrayList<ArrayList<Complex>> Create(int n, int echantillonage){
		
		//int n = 34; // L
		//int echantillonage = 4; // 2^N
		double bornemoins = -3.14;
		double borneplus = -1*bornemoins;			// intervalle de -PI à PI
		
		double pas = (6.28)/(n-1);

        ArrayList<Complex> x = new ArrayList<Complex>(); 

        // original data
        
       for (double i = bornemoins; i < borneplus; i=i+pas) {
        //x.add(new Complex(i+1, 0));
        x.add(new Complex(Math.sin(i),0));
        //System.out.println(i);

        
       }
       x.add(new Complex(Math.sin(borneplus),0));
       
       
       System.out.println("--------------------------------------------------------------------------------");
       System.out.println("					x");
       System.out.println("--------------------------------------------------------------------------------");
       
       
       for (int i = 0; i < n; i++) { 
    	   
    	   log.info(x.get(i).toString()+"		 i= "+i);
       }
       
       System.out.println("--------------------------------------------------------------------------------");
       System.out.println("					Affichage des échantillons apres la FFT");
       System.out.println("--------------------------------------------------------------------------------");
       
       Echantillon test = new Echantillon(echantillonage,n,x); // création d'un objet test qui est un tableau à deux dimensions
       ArrayList<ArrayList<Complex>> fftaj = test.diviseTab(); //initialisation d'un tableau fftaj qui est la division du tableau test grâce à la méthode diviseTab de la classe Echantillon
       
       int size = fftaj.size(); // on récupère la taille du tableau fftaj
       	  for(int i= 0; i < size; i++){ //on parcours ce tableau
       		 log.info(fftaj.get(i).toString()); // on affiche en console les complexe de ce tableau
       		 System.out.println("--------------------------------------------------------------------------------");
       	  }
       	  
       	 System.out.println("--------------------------------------------------------------------------------");
       	 System.out.println("					Affichage des modules");
       	 System.out.println("--------------------------------------------------------------------------------");
       	 
       	 fftaj = test.modulefen(fftaj); //on applique la méthode modulefen de la classe Echantillon qui va faire le module de chaque complexe du tableau test
       	 for(int i = 0; i<size; i++){ // on parcours ce tableau
       		 
       		 log.info(fftaj.get(i).toString()); //on affiche les modules de chaque complexes à l'indixe i
       		System.out.println("");
       		 System.out.println("----------------------------------------	[FENETRE "+(i+1)+"]	----------------------------------------");
       		System.out.println("");
       	 }
       	 
       	return fftaj; //on retourne le tableau 2D comportants tous les modules
       	
       	
       	 
		
       	 
       	 
	}
}
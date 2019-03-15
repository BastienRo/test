package Model;



//import java.util.logging.Logger;

public class Complex {
	
	
	double re;
	double im;
	
	//constructeur d'un complexe
	public Complex(double reel,double imag){
		
		re=reel;
		im=imag;
		
	}
	
	//constructeur d'un complexe avec un partie imaginaire nulle donc un réel
	public Complex(double reel){
		
		re=reel;
		im=0;
	}
	
	public String toString() {
        if (im == 0) return re + ""; //partie imaginaire = 0
        if (re == 0) return im + "i"; //partie réel = 0
        
        if((im < 0)&&(im > -0.0001)) return re +"";
        else if (im < 0) return re + " - " + (-im) + "i";
        if((im > 0)&&(im < 0.0001)) return re +"";
        
        return re + " + " + im + "i";
	}
	
	// module
	 public Complex module(){
		 double ree = Math.sqrt(re*re+im*im);
		 Complex modulo =new Complex(ree,0);  //on met le module sous forme complexe avec une partie imaginaire nulle puis lorque nous en aurons besoin nous prendrons seulement la partie réele
	        return modulo;
	    }
	 
	 public double phase() {
	        return Math.atan2(im, re);
	    }

	
	// return un nouveau complexe de l'addition de deux complexes
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double reel = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(reel, imag);
    }

    // return un nouveau Complexe de la soustraction de deux complexes
    public Complex moins(Complex b) {
        Complex a = this;
        double reel = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(reel, imag);
    }
    //return un nouveau Complexe de la multiplication de deux complexes
    public Complex multiplie(Complex b) {
        Complex a = this;
        double reel = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(reel, imag);
    }
    
    // retourn la partie imaginaire ou réel d'un complexe
    public double re() { return re; }
    public double im() { return im; }
    
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }
    // retourne le conjugué d'un complexe
    public Complex conjugue() {
        return new Complex(re, -im);
    }

    
    public Complex echelle(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }
    
 // return un complexe par la division de deux complexes
    public Complex divise(Complex b) {
        Complex a = this;
        return a.multiplie(b.reciprocal());
    }
    
    /*public Complex Puissance(int pw) {

		double module = Math
				.sqrt(this.getRe() * this.getRe() + this.getIm() * this.getIm());
		double argument = Math.atan2(this.getIm(), this.getIm());
		// cos équivalent à la partie réelle du complexe
		double coseq = Math.cos(pw * argument);
		// sin équivalent à la partie imaginaire du complexe
		double sineq = Math.sin(pw * argument);
		// module à la puissance pw
		double moduleq = Math.pow(module, pw);
		// On arrondi sinus et cosinus
		if ((sineq < 0.00001) && (sineq > -0.00001)) {
			sineq = 0;
		}
		if ((coseq < 0.00001) && (coseq > -0.00001)) {
			coseq = 0;
		}
		Complex resultat = new Complex(moduleq * coseq, moduleq * sineq);
		return resultat;
	}*/

    public String Stringmodule() { return Math.sqrt(Math.pow(re,2)+Math.pow(im,2))+""; }
    	
     // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divise(cos());
    }

	public double getRe() {
		return re;
	}

	public void setRe(double re) {
		this.re = re;
	}

	public double getIm() {
		return im;
	}

	public void setIm(double im) {
		this.im = im;
	}
	
	
}
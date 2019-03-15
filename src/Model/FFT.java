package Model;

import java.util.ArrayList;

public class FFT {
	
	//constructeur
	public FFT(){
		
	}
	
    // compute the FFT of x, assuming its length is a power of 2
    public ArrayList<Complex> fft(ArrayList<Complex> uk) {
        int n = uk.size(); //length;

        // base case
        if (n == 1) {
        	ArrayList<Complex> back = new ArrayList<Complex>();
        	back.add(uk.get(0));
        	return back;
        	//return new ArrayList<Complex>();// { uk[0] };
        }

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) { throw new RuntimeException("n is not a power of 2"); }

        // fft des termes paires 
        ArrayList<Complex> paireTemp = new ArrayList<Complex>(); //[n\2];
        for (int k = 0; k < n/2; k++) {
        	paireTemp.add(uk.get(2*k)); //paireTemp[k] = uk[2*k];
        }
        ArrayList<Complex> q =new ArrayList<Complex>();
        q = fft(paireTemp);

        // fft des termes impaire
        ArrayList<Complex> ImpaireTemp = new ArrayList<Complex>();             //Complex[] ImpaireTemp  = new Complex[n/2];  // reuse the array
        
        for (int k = 0; k < n/2; k++) {
            ImpaireTemp.add(uk.get(2*k +1)); //ImpaireTemp[k] = uk[2*k + 1];
        }
        ArrayList<Complex> r = new ArrayList<Complex>();
        r = fft(ImpaireTemp);

        // combine
        ArrayList<Complex> y = new ArrayList<Complex>(); 					//Complex[] aj = new Complex[n];
        ArrayList<Complex> v = new ArrayList<Complex>();
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y.add(q.get(k).plus(wk.multiplie(r.get(k))));	//aj[k]       = q[k].plus(wk.multiplie(r[k]));
            v.add(q.get(k).moins(wk.multiplie(r.get(k))));
            //aj.add(q.get(k + n/2).moins(wk.multiplie(r.get(k)))); //aj[k + n/2] = q[k].moins(wk.multiplie(r[k]));
        }

        y.addAll(v);
        return y;
    }
    // compute the inverse FFT of x, assuming its length is a power of 2
    public ArrayList<Complex> ifft(ArrayList<Complex> x) {
        int n = x.size();
        ArrayList<Complex> uk = new ArrayList<Complex>();

        // prend le conjugué
        for (int i = 0; i < n; i++) {
        uk.add(x.get(i).conjugue());				//uk[i] = x[i].conjugue();
        }

        // compute forward FFT
        uk = fft(uk);

        // take conjugate again
        for (int i = 0; i < n; i++) {
        	uk.add(uk.get(i).conjugue());						//uk[i] = uk[i].conjugue();
        }
        
        ArrayList<Complex> z = new ArrayList<Complex>();
        // divide by n
        for (int i = 0; i < n; i++) {
        	z.add(uk.get(i).echelle(1.0/n));					//uk[i] = uk[i].echelle(1.0 / n);
        }

        return z;

    }

}
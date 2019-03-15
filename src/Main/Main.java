package Main;

import Controller.VolumeController;
import Model.VolumeModel;

import View.FieldVolumeView;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	VolumeModel model = new VolumeModel();
	VolumeController controller = new VolumeController(model);
	FieldVolumeView fView = new FieldVolumeView(model, controller);
	//XYLineChartExample FView = new XYLineChartExample();
	controller.init(fView);
	//controller.initCourbe(FView);
	  controller.displayViews();
	  
      
	    
	}
}
       
       
       
      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		int n = 32; // L
		double bornemoins = -3.14;
		double borneplus = -1*bornemoins;			// intervalle de -PI à PI
		
		double pas = (6.28)/(n-1);

        ArrayList<Complex> x = new ArrayList<Complex>(); 

        // original data
        
       for (double i = bornemoins; i < borneplus; i=i+pas) {
        //x.add(new Complex(i+1, 0));
        x.add(new Complex(Math.sin(i),0));
        System.out.println(i);

        
       }
       x.add(new Complex(Math.sin(borneplus),0));
       
       
       System.out.println("-----------");
       System.out.println("x");
       System.out.println("-----------");
       
       
       for (int i = 0; i < n; i++) { 
    	   
    	   log.info(x.get(i).toString()+"		 i= "+i);
       }
       
       
       //.show(x, "x");
        
        
       System.out.println("-----------");
       System.out.println("y=fft(x)");
       System.out.println("-----------");

        // FFT of original data
        ArrayList<Complex> y =  new FFT().fft(x);
        
        for (int i = 0; i < n; i++) { 
     	   
     	   log.info(y.get(i).toString()+"		 i= "+i);
        }
        
        
      //  FFT.show(y, "y = fft(x)");
        
        System.out.println("-----------");
        System.out.println("z=ifft(y)");
        System.out.println("-----------");

        // take inverse FFT
        ArrayList<Complex> z = new FFT().ifft(y);
        
        for (int i = 0; i < n; i++) { 
     	   
     	   log.info(z.get(i).toString()+"		 i= "+i);
        }
        
        
        //FFT.show(z, "z = ifft(y)");
         
         
	}
}
*/
	
		
		
		
		/*Complex a = new Complex(1,0);
		Complex b = new Complex(2,0);
		Complex c = new Complex(3,0);
		Complex d = new Complex(4,0);
		Complex e = new Complex(1,1);
		//ArrayList<Complex> tab = {new Complex(1,4),new Complex(2,3)};
		ArrayList<Complex> tab = new ArrayList<Complex>();
		
		ArrayList<Complex> resultat;
		
		tab.add(a);
		tab.add(b);
		tab.add(c);
		tab.add(d);
		
		FFT ff=new FFT();
		resultat=ff.fft(tab);
		
		int p;
		
		
		log.info(resultat.get(0).toString());
		log.info(resultat.get(1).toString());
		log.info(resultat.get(2).toString());
		log.info(resultat.get(3).toString());
		*/
		
		/*int n = 4;
        ArrayList<Complex> x = new ArrayList<Complex>(); 

        // original data
       for (int i = 0; i < n; i++) {
        x.add(new Complex(i+1, 0));
        
          //  x[i] = new Complexe(-2*Math.random() + 1, 4);
        }
       
       System.out.println("-----------");
       System.out.println("x");
       System.out.println("-----------");
       
       for (int i = 0; i < n; i++) { 
    	   
    	   log.info(x.get(i).toString());
       }
       
       
       //.show(x, "x");
        
        
       System.out.println("-----------");
       System.out.println("y=fft(x)");
       System.out.println("-----------");

        // FFT of original data
        ArrayList<Complex> y = FFT.fft(x);
        
        for (int i = 0; i < n; i++) { 
     	   
     	   log.info(y.get(i).toString());
        }
        
        
      //  FFT.show(y, "y = fft(x)");
        
        System.out.println("-----------");
        System.out.println("z=ifft(y)");
        System.out.println("-----------");

        // take inverse FFT
        ArrayList<Complex> z = FFT.ifft(y);
        
        for (int i = 0; i < n; i++) { 
     	   
     	   log.info(z.get(i).toString());
        }
        
        
        //FFT.show(z, "z = ifft(y)");
         
         */






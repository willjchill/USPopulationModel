import java.lang.Math;

class Main {
  public static void main(String[] args) {
    double[] yearsSince1790 = new double[17];
    for(int i = 0; i < 17; i++) {
      yearsSince1790[i] = 10 * i; 
    } 

    double[] popInMillions = {3.929,
 5.308,7.240,9.638,12.866,17.069,23.192,
 31.433,38.558,50.156,62.948,75.996,
 91.972,105.711,122.775,131.669,150.697};

    double[] prediction = new double[17];
    int index = 0;
    for(double t : yearsSince1790) {
      prediction[index] = (272.22) / ((272.22/3.929-1)* Math.exp(-0.0296*t) + 1); 
      index++; 
    }

    double[] error = new double[17]; 
    for(int i = 0; i < 17; i++) {
      error[i] = prediction[i] - popInMillions[i]; 
    } 

    double[] percentError = new double[17];
    for(int i = 0; i < 17; i++) {
      percentError[i] = error[i] / popInMillions[i] * 100;
    }

    // rounding values
    for(int j = 0; j < 17; j++) {
        prediction[j] = (double)Math.round(prediction[j] * 100000d) / 100000d;
        error[j] = (double)Math.round(error[j] * 100000d) / 100000d;
        percentError[j] = (double)Math.round(percentError[j] * 100000d) / 100000d;
    }

    System.out.format("%5s\t%-5s\t%-5s\t%-5s\t%-5s%n", "Year", "Pop.", "Model", 
    "Error", "% Error");
    for(int j = 0; j < 17; j++) {
      System.out.format("%5.0f\t%-5.3f\t%-5.3f\t%-5.3f\t%-5.2f%n",  
      yearsSince1790[j] + 1790, popInMillions[j], prediction[j], error[j], Math.abs(percentError[j]));
    }
    
  }
}

/*
1790 3.929
1800 5.308
1810 7.240
1820 9.638
1830 12.866
1840 17.069
1850 23.192
1860 31.433
1870 38.558
1880 50.156
1890 62.948
1900 75.996
1910 91.972
1920 105.711
1930 122.775
1940 131.669
1950 150.697
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MonthTemperatures {

	final static int MONTH_DAYS = 31;
	static ArrayList<Double> temps = new ArrayList<Double>();
	static Random tempMonthRand = new Random();
		
	public static void main(String[] args) {
		while(temps.size() <= MONTH_DAYS) {
			double temperature = (tempMonthRand.nextDouble() - 0.5) * 50;
			Double roundTemperature = new BigDecimal(temperature).setScale(1, RoundingMode.HALF_UP).doubleValue();
			temps.add(roundTemperature);
		}
		
		//System.out.println("      mo    tu    we    th    fi    sa    su");
		
		ArrayList<String> week = new ArrayList<String>();
		
		week.add("mo");
		week.add("tu");
		week.add("we");
		week.add("th");
		week.add("fi");
		week.add("sa");
		week.add("su");
		System.out.print("  ");
		week.forEach(w->System.out.print("    " + w));
		
		int i = 0, j = 0;
		for( Double t : temps ) {
			if(i == 0 || i % 7 == 0) {
				j++;
				System.out.printf("\n%d. ", j);
			}
			System.out.printf("%5.1f ", t);
			i++;
		}
		System.out.println("\n");
		  
		Double max = Collections.max(temps);
		Double min = Collections.min(temps);
		Double avg = 0.0;
		
		for( Double t: temps ) {
			avg += t;
		}
		
		avg = avg / temps.size();
		double roundAvg = new BigDecimal(avg).setScale(1, RoundingMode.HALF_UP).doubleValue();
				
		System.out.printf("Maximum temperature is %5.1f\n", max);
		System.out.printf("Minimum temperature is %5.1f\n", min);
		System.out.printf("Average temperature is %5.1f\n", roundAvg);

	}
}

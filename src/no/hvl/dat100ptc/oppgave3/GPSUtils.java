package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min; 
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] tabell = new double[gpspoints.length];
		
		for (int i = 0; i<gpspoints.length; i++) {
			tabell[i] = gpspoints[i].getLatitude();
		}
		
		return tabell;
		
		// TODO
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] tabell = new double[gpspoints.length];
		
		for (int i = 0; i<gpspoints.length; i++) {
			tabell[i] = gpspoints[i].getLongitude();
		}
		
		return tabell;
		
		// TODO 

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = Math.toRadians(gpspoint1.getLatitude());
		  double longitude1 = Math.toRadians(gpspoint1.getLongitude());
		  double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		  double longitude2 = Math.toRadians(gpspoint2.getLongitude());

		  double deltaphi = latitude2 - latitude1;
		  double deltadelta = longitude2 - longitude1;

		  double a = compute_a(latitude1, latitude2, deltaphi, deltadelta);
		  double c = compute_c(a);

		  double d = R * c;

		  return d;

		// TODO 
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		 return Math.pow(Math.sin(deltaphi / 2), 2) + Math.cos(phi1) * Math.cos(phi2) * Math.pow(Math.sin(deltadelta / 2), 2);
		
		// TODO 

	}

	private static double compute_c(double a) {
		
		return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		
		// TODO 

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		double distance = distance(gpspoint1, gpspoint2);
		
	    secs = gpspoint2.getTime() - gpspoint1.getTime();
	    speed = distance / secs;
	    
	    return speed;
		
		// TODO

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO 
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO
		
	}
}

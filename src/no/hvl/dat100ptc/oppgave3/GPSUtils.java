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
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] tabell = new double[gpspoints.length];
		
		for (int i = 0; i<gpspoints.length; i++) {
			tabell[i] = gpspoints[i].getLongitude();
		}
		
		return tabell;

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

	}
	

	private static double compute_c(double a) {

		
		return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));


	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		

		double distance = distance(gpspoint1, gpspoint2);
		
	    secs = gpspoint2.getTime() - gpspoint1.getTime();
	    speed = distance / secs;
	    
	    return speed;
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int hh = secs / 3600;
		int mm = (secs % 3600) / 60;
		int ss = secs % 60;
		
		String h = "  " + hh;
		String m = "" + mm;
		String s = "" + ss;
		
		if (hh<10) {
			h = "  0%s";
		} if (mm<10) {
			m = "0%s";
		} if (ss<=10) {
			s = "0%s";
		}
		
		String formatert = h + TIMESEP + m + TIMESEP + s;
		
		timestr = String.format(formatert, hh, mm, ss);
		
		return timestr;
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		double avrundet = ceil(d * 100) / 100;
		
		return "      " + avrundet;
		
	}
}

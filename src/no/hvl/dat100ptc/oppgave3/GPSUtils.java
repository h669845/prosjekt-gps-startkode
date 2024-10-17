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
		
		double[] arr = new double[gpspoints.length];
		
		for (int i = 0; i<gpspoints.length; i++) {
			arr[i] = gpspoints[i].getLatitude();
		}
		
		return arr;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] arr = new double[gpspoints.length];
		
		for (int i = 0; i<gpspoints.length; i++) {
			arr[i] = gpspoints[i].getLongitude();
		}
		
		return arr;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 	= toRadians(gpspoint1.getLatitude());
		longitude1 	= toRadians(gpspoint2.getLongitude());
		latitude2 	= toRadians(gpspoint2.getLatitude());
		longitude2 	= toRadians(gpspoint2.getLongitude());
		
		double dxPhi = toRadians(latitude2 - latitude1);
		double dxLambda = toRadians(longitude2 - longitude1);
		
		double a = compute_a(latitude1, latitude2, dxPhi, dxLambda);
		double c = compute_c(a);
		
		return R * c;
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		return pow(sin(deltaphi/2), 2) + cos(phi1) * cos(phi2) * pow(sin(deltadelta/2), 2);		

	}

	private static double compute_c(double a) {

		return 2 * atan2(sqrt(a), sqrt(1-a));

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		
		return speed = distance(gpspoint1, gpspoint2)/secs;

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

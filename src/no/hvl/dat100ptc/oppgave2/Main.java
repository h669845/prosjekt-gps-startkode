package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

		// TODO
		
		GPSPoint point1 = new GPSPoint(1, 3.2, 4.5, 6.2);
		GPSPoint point2 = new GPSPoint(1, 1.2, 6.5, 6.5);
		
		GPSData gpsData = new GPSData(2);
		
		gpsData.insertGPS(point1);
		gpsData.insertGPS(point2);
		
		gpsData.print();
		
	}
}

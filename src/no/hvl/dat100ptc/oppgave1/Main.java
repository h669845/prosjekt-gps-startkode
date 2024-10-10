package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		// TODO
		GPSPoint gpspoint = new GPSPoint(1, 2.0, 3.0, 4.0);
		
		System.out.println("Tid: " + gpspoint.getTime());
		
		gpspoint.setTime(2);
		
		System.out.println(gpspoint.toString());
		
	}

}

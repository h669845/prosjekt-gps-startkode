package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		
		this.gpspoints = new GPSPoint[n];
		this.antall = 0; 
		
		// TODO
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			antall++;
			return true;
			
		} else{
			return false;
		}
				
		// TODO 
	
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		
		GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		return insertGPS(gpspoint);
		
	}

	private int parseInt(String time) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void print() {
		
		System.out.println("====== GPS Data - START ======");
		
		for (int i = 0; i < gpspoints.length; i++){
			String text = gpspoints[i].toString();
			System.out.print(text);
		}
		
		System.out.println("====== GPS Data - SLUTT ======");

		

		// TODO 
	}
}

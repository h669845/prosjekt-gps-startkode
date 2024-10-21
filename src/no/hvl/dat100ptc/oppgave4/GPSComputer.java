package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	public double totalDistance() {

		double totalDistance = 0;
		for (int i = 0; i < gpspoints.length - 1; i++) {
			totalDistance += GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
		}

		return totalDistance;

		// TODO

	}

	public double totalElevation() {

		double elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double diff = gpspoints[i + 1].getElevation() - gpspoints[i].getElevation();
			if (diff > 0) {
				elevation += diff;
			}
		}

		return elevation;

		// TODO

	}

	public int totalTime() {

		int time = 0;

		time = gpspoints[gpspoints.length - 1].getTime() - gpspoints[0].getTime();

		return time;

		// TODO

	}

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < gpspoints.length - 1; i++) {
			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i + 1]);
			int timeDiff = gpspoints[i + 1].getTime() - gpspoints[i].getTime();
			speeds[i] = distance / timeDiff;
		}

		return speeds;

	}

	public double maxSpeed() {

		double[] speeds = speeds();
		double maxspeed = 0;

		for (double speed : speeds) {
			if (speed > maxspeed) {
				maxspeed = speed;
			}
		}

		return maxspeed;

	}

	public double averageSpeed() {

		double average = 0;
		// s = v * t
		double totalDistance = totalDistance();
		int totalTime = totalTime();
		average = totalDistance / totalTime;

		return average;

		// TODO

	}

	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;
		double speedmph = speed * MS;

		if (speedmph < 10) {
			met = 4.0;
		} else if (speedmph < 12) {
			met = 6.0;
		} else if (speedmph < 14) {
			met = 8.0;
		} else if (speedmph < 16) {
			met = 10.0;
		} else if (speedmph < 20) {
			met = 12.0;
		} else {
			met = 16.0;
		}
		
		double hours = secs / 3600.0;
		kcal = met * weight * hours;
		return kcal;
		// TODO
		

	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
			double speed = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
            int secs = gpspoints[i + 1].getTime() - gpspoints[i].getTime();
            totalkcal += kcal(weight, secs, speed);
        }
		
		return totalkcal;
		

		// TODO
		

	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {
		
		int totalTime = totalTime();
		double totalDistance = totalDistance();
		double totalElevation = totalElevation();
		double maxSpeed = maxSpeed();
		double averageSpeed = averageSpeed();
		double totalKcal = totalKcal(WEIGHT);
		
		int hours = totalTime / 3600;
		int minutes = (totalTime % 3600) / 60;
		int seconds = totalTime % 60;
		
		String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

		System.out.println("==============================================");
		System.out.println("Total Time     : " + timeString);
		System.out.println("Total distance : " + totalDistance + " km");
		System.out.println("Total elevation: " + totalElevation + " m");
		System.out.println("Max speed      : " + maxSpeed + " km/t");
		System.out.println("Average speed  : " + averageSpeed + " km/t");
		System.out.println("Energy         : " + totalKcal + " kcal");
		System.out.println("==============================================");
		
		

	}

}

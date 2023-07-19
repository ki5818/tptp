package com.tptp.dto;

public class Cluster {
	private String clusterId;
	private double centerLat;
	private double centerLng;
	private double avg;
	
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public String getClusterId() {
		return clusterId;
	}
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}
	public double getCenterLat() {
		return centerLat;
	}
	public void setCenterLat(double centerLat) {
		this.centerLat = centerLat;
	}
	public double getCenterLng() {
		return centerLng;
	}
	public void setCenterLng(double centerLng) {
		this.centerLng = centerLng;
	}
	@Override
	public String toString() {
		return "Cluster [clusterId=" + clusterId + ", centerLat=" + centerLat + ", centerLng=" + centerLng + ", avg="
				+ avg + "]";
	}
	
	
}

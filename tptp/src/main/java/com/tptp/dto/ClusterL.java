package com.tptp.dto;

public class ClusterL {
	private String clusterLId;
	private double latCenter;
	private double lngCenter;
	private double dist;
	private double avg;
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getClusterLId() {
		return clusterLId;
	}
	public void setClusterLId(String clusterLId) {
		this.clusterLId = clusterLId;
	}
	public double getLatCenter() {
		return latCenter;
	}
	public void setLatCenter(double latCenter) {
		this.latCenter = latCenter;
	}
	public double getLngCenter() {
		return lngCenter;
	}
	public void setLngCenter(double lngCenter) {
		this.lngCenter = lngCenter;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	@Override
	public String toString() {
		return "ClusterL [clusterLId=" + clusterLId + ", latCenter=" + latCenter + ", lngCenter=" + lngCenter
				+ ", dist=" + dist + ", avg=" + avg + "]";
	}
	
	
}

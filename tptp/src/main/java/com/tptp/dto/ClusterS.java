package com.tptp.dto;

public class ClusterS {
	private String clusterSId;
	private double latCenter;
	private double lngCenter;
	private double dist;
	private String clusterMId;
	private double avg;
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getClusterSId() {
		return clusterSId;
	}
	public void setClusterSId(String clusterSId) {
		this.clusterSId = clusterSId;
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
	public String getClusterMId() {
		return clusterMId;
	}
	public void setClusterMId(String clusterMId) {
		this.clusterMId = clusterMId;
	}
	
	
}

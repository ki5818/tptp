package com.tptp.dto;
import java.util.Map;

public class Tptp {
	private String id;
	private String categoryId;
	private String detail;
	private double lat;
	private double lng;
	private String place;
	private String region;
	private String address;
	private String clusterSId;
	private int count;
	private int count_by_region;
	private int total;
	private int distance;

	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount_by_region() {
		return count_by_region;
	}
	public void setCount_by_region(int count_by_region) {
		this.count_by_region = count_by_region;
	}

	private Map<String, Object> pageInfo;
	
	Category category;
	Review review;
	Cluster cluster;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClusterSId() {
		return clusterSId;
	}
	public void setClusterSId(String clusterSId) {
		this.clusterSId = clusterSId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Map<String, Object> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(Map<String, Object> pageInfo) {
		this.pageInfo = pageInfo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	@Override
	public String toString() {
		return "Tptp [id=" + id + ", categoryId=" + categoryId + ", detail=" + detail + ", lat=" + lat + ", lng=" + lng
				+ ", place=" + place + ", region=" + region + ", address=" + address + ", clusterSId=" + clusterSId
				+ ", count=" + count + ", count_by_region=" + count_by_region + ", total=" + total + ", pageInfo="
				+ pageInfo + ", category=" + category + ", review=" + review + ", cluster=" + cluster + "]";
	}
	
	
}

package com.tptp.dto;

public class Tptp {
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
	public int getCount_by_region() {
		return count_by_region;
	}
	public void setCount_by_region(int count_by_region) {
		this.count_by_region = count_by_region;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
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
	private double distance;
	private int CT1;
	private int CT2;
	private int CT3;
	private int CT4;
	private double avgLat;
	private double avgLng;
	
	
	public double getAvgLat() {
		return avgLat;
	}
	public void setAvgLat(double avgLat) {
		this.avgLat = avgLat;
	}
	public double getAvgLng() {
		return avgLng;
	}
	public void setAvgLng(double avgLng) {
		this.avgLng = avgLng;
	}
	public int getCT1() {
		return CT1;
	}
	public void setCT1(int cT1) {
		CT1 = cT1;
	}
	public int getCT2() {
		return CT2;
	}
	public void setCT2(int cT2) {
		CT2 = cT2;
	}
	public int getCT3() {
		return CT3;
	}
	public void setCT3(int cT3) {
		CT3 = cT3;
	}
	public int getCT4() {
		return CT4;
	}
	public void setCT4(int cT4) {
		CT4 = cT4;
	}
	Category category;
	Review review;
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
	

	
	
}
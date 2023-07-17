package com.tptp.dto;

import java.util.Date;

public class Review {
	private String reviewId;
	private String placeId;
	private String contents;
	private String photo;
	private String password;
	private String writeDate;
	
	Tptp tptp;
	
	public Tptp getTptp() {
		return tptp;
	}
	public void setTptp(Tptp tptp) {
		this.tptp = tptp;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", placeId=" + placeId + ", contents=" + contents + ", photo=" + photo
				+ ", password=" + password + ", writeDate=" + writeDate + "]";
	}
	
	
	
}

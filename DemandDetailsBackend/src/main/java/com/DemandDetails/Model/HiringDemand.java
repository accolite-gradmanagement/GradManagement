package com.DemandDetails.Model;

import java.util.Date;

public class HiringDemand {

	private int edId;
	private String edName;
	private int hmId;
	private String hmName;
	private int demandCount;
	private Date startTime;
	private int lId;
	private String status;
	private String comments;

	public HiringDemand(int edId, int hmId, int demandCount, int lId, Date startTime, String status, String comments) {
		super();
		this.edId = edId;
		this.hmId = hmId;
		this.demandCount = demandCount;
		this.startTime = startTime;
		this.lId = lId;
		this.status = status;
		this.comments = comments;
	}

	public HiringDemand() {

	}

	@Override
	public String toString() {
		return "HiringDemand [edId=" + edId + ", edName=" + edName + ", hmId=" + hmId + ", hmName=" + hmName
				+ ", demandCount=" + demandCount + ", startTime=" + startTime + ", lId=" + lId + ", status=" + status
				+ ", comments=" + comments + "]";
	}

	public int getEdId() {
		return edId;
	}

	public void setEdId(int edId) {
		this.edId = edId;
	}

	public String getEdName() {
		return edName;
	}

	public void setEdName(String edName) {
		this.edName = edName;
	}

	public int getHmId() {
		return hmId;
	}

	public void setHmId(int hmId) {
		this.hmId = hmId;
	}

	public String getHmName() {
		return hmName;
	}

	public void setHmName(String hmName) {
		this.hmName = hmName;
	}

	public int getDemandCount() {
		return demandCount;
	}

	public void setDemandCount(int demandCount) {
		this.demandCount = demandCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}

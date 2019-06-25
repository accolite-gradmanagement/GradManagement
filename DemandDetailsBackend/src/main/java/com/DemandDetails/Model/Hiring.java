package com.DemandDetails.Model;

import java.util.Date;
import java.util.List;

public class Hiring {

	private int serialNumber;
	private String edName;
	private List<Employee> hiringManagers;
	private int totalDemand;
	private int demandInBangalore;
	private Date expectedStartInBangalore;
	private int demandInMumbai;
	private Date expectedStartInMumbai;
	private String comments;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getEdName() {
		return edName;
	}

	public void setEdName(String edName) {
		this.edName = edName;
	}

	public List<Employee> getHiringManagers() {
		return hiringManagers;
	}

	public void setHiringManagers(List<Employee> hiringManagers) {
		this.hiringManagers = hiringManagers;
	}

	public int getTotalDemand() {
		return totalDemand;
	}

	public void setTotalDemand(int totalDemand) {
		this.totalDemand = totalDemand;
	}

	public int getDemandInBangalore() {
		return demandInBangalore;
	}

	public void setDemandInBangalore(int demandInBangalore) {
		this.demandInBangalore = demandInBangalore;
	}

	public Date getExpectedStartInBangalore() {
		return expectedStartInBangalore;
	}

	public void setExpectedStartInBangalore(Date expectedStartInBangalore) {
		this.expectedStartInBangalore = expectedStartInBangalore;
	}

	public int getDemandInMumbai() {
		return demandInMumbai;
	}

	public void setDemandInMumbai(int demandInMumbai) {
		this.demandInMumbai = demandInMumbai;
	}

	public Date getExpectedStartInMumbai() {
		return expectedStartInMumbai;
	}

	public void setExpectedStartInMumbai(Date expectedStartInMumbai) {
		this.expectedStartInMumbai = expectedStartInMumbai;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Hiring [edName=" + edName + ", hiringManager=" + hiringManagers + ", totalDemand=" + totalDemand
				+ ", demandInBangalore=" + demandInBangalore + ", expectedStartInBangalore=" + expectedStartInBangalore
				+ ", demandInMumbai=" + demandInMumbai + ", expectedStartInMumbai=" + expectedStartInMumbai
				+ ", comments=" + comments + "]";
	}

	public Hiring(int serialNumber, String edName, List<Employee> hiringManagers, int totalDemand,
			int demandInBangalore, Date expectedStartInBangalore, int demandInMumbai, Date expectedStartInMumbai,
			String comments) {
		super();
		this.serialNumber = serialNumber;
		this.edName = edName;
		this.hiringManagers = hiringManagers;
		this.totalDemand = totalDemand;
		this.demandInBangalore = demandInBangalore;
		this.expectedStartInBangalore = expectedStartInBangalore;
		this.demandInMumbai = demandInMumbai;
		this.expectedStartInMumbai = expectedStartInMumbai;
		this.comments = comments;
	}

	public Hiring() {
		super();
	}

}

package com.DemandDetails.Model;

import java.util.Date;

public class HiringDemand {

	private int ED_ID;
	private String ED_NAME;
	private int HM_ID;
	private String HM_NAME;
	private int DEMAND_COUNT;
	private Date START_TIME;
	private int L_ID;
	private String STATUS;
	private String COMMENTS;

	public int getED_ID() {
		return ED_ID;
	}

	public void setED_ID(int eD_ID) {
		ED_ID = eD_ID;
	}

	public int getHM_ID() {
		return HM_ID;
	}

	public void setHM_ID(int hM_ID) {
		HM_ID = hM_ID;
	}

	public String getED_NAME() {
		return ED_NAME;
	}

	public void setED_NAME(String eD_NAME) {
		ED_NAME = eD_NAME;
	}

	public String getHM_NAME() {
		return HM_NAME;
	}

	public void setHM_NAME(String hM_NAME) {
		HM_NAME = hM_NAME;
	}

	public int getDEMAND_COUNT() {
		return DEMAND_COUNT;
	}

	public void setDEMAND_COUNT(int dEMAND_COUNT) {
		DEMAND_COUNT = dEMAND_COUNT;
	}

	public Date getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(Date sTART_TIME) {
		START_TIME = sTART_TIME;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getCOMMENTS() {
		return COMMENTS;
	}

	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}

	public int getL_ID() {
		return L_ID;
	}

	public void setL_ID(int l_ID) {
		L_ID = l_ID;
	}

	public HiringDemand(int eD_ID, int hM_ID, int dEMAND_COUNT, int l_ID, Date sTART_TIME, String sTATUS,
			String cOMMENTS) {
		super();
		ED_ID = eD_ID;
		HM_ID = hM_ID;
		DEMAND_COUNT = dEMAND_COUNT;
		START_TIME = sTART_TIME;
		L_ID = l_ID;
		STATUS = sTATUS;
		COMMENTS = cOMMENTS;
	}

	public HiringDemand() {
		super();
	}

	@Override
	public String toString() {
		return "HiringDemand [ED_ID=" + ED_ID + ", ED_NAME=" + ED_NAME + ", HM_ID=" + HM_ID + ", HM_NAME=" + HM_NAME
				+ ", DEMAND_COUNT=" + DEMAND_COUNT + ", START_TIME=" + START_TIME + ", L_ID=" + L_ID + ", STATUS="
				+ STATUS + ", COMMENTS=" + COMMENTS + "]";
	}

}

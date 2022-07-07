package com.ncs.empconsole.model;

import java.io.Serializable;

public class Project implements Serializable,Comparable<Project> {
	private int projectNumber;
	private String projectName;
	private int cost;
	private String startdate;
	private String enddate;
	private String comments;
	private String projectHeadEmail;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectNumber, String projectName, int cost, String startdate, String enddate, String comments,
			String projectHeadEmail) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.cost = cost;
		this.startdate = startdate;
		this.enddate = enddate;
		this.comments = comments;
		this.projectHeadEmail = projectHeadEmail;
	}

	public Project(int projectNumber, String projectName) {
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
	}

	public int getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProjectHeadEmail() {
		return projectHeadEmail;
	}

	public void setProjectHeadEmail(String projectHeadEmail) {
		this.projectHeadEmail = projectHeadEmail;
	}

	@Override
	public String toString() {
		return "Project [projectNumber=" + projectNumber + ", projectName=" + projectName + ", cost=" + cost
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", comments=" + comments + ", projectHeadEmail="
				+ projectHeadEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + cost;
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + ((projectHeadEmail == null) ? 0 : projectHeadEmail.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + projectNumber;
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (cost != other.cost)
			return false;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (projectHeadEmail == null) {
			if (other.projectHeadEmail != null)
				return false;
		} else if (!projectHeadEmail.equals(other.projectHeadEmail))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (projectNumber != other.projectNumber)
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		return true;
	}

	@Override
	public int compareTo(Project p) {
		return this.projectNumber - p.getProjectNumber();
	}

	
	
	

}

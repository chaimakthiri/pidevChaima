package com.esprit.pidev.jpa;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {

	private String res;

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}
}

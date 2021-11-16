package com.exam;

import org.springframework.stereotype.Component;

@Component
public class Address {
	int aid;
	String roadno;
	String streetno;
	String pobox;

	public Address() {
		super();
	}

	
	public Address(int aid) {
		super();
		this.aid = aid;
	}


	public Address(String roadno, String streetno, String pobox) {
		super();
		this.roadno = roadno;
		this.streetno = streetno;
		this.pobox = pobox;
	}

	public Address(int aid, String roadno, String streetno, String pobox) {
		super();
		this.aid = aid;
		this.roadno = roadno;
		this.streetno = streetno;
		this.pobox = pobox;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getRoadno() {
		return roadno;
	}

	public void setRoadno(String roadno) {
		this.roadno = roadno;
	}

	public String getStreetno() {
		return streetno;
	}

	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}

	public String getPobox() {
		return pobox;
	}

	public void setPobox(String pobox) {
		this.pobox = pobox;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", roadno=" + roadno + ", streetno=" + streetno + ", pobox=" + pobox + "]";
	}

}

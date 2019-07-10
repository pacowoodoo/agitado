package com.lucainnocenti.agitado.enums;

public enum TadoZoneType {
	BASEFLOOR("Piano Terra",  "BF", 1),
	FIRSTFLOOR("Primo Piano", "FF", 2);

	private final String name;
	private final String abbr;
	private final int id;

	private TadoZoneType(String name, String abbr, int id ) {
		this.name = name;
		this.abbr = abbr;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviatedName() {
		return abbr;
	}

	public int getId(){
		return id;
	}

	public static TadoZoneType valueOfId(int id) {
		for (TadoZoneType e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}
}

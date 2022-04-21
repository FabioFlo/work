package com.project.dao;

import com.project.riferimenti.EnumPiattaforma;

public class DAOPiattaforma {

	public boolean controlloPiattaforma(int id) {
		boolean ris = false;
		int count = 0;
		for (EnumPiattaforma e : EnumPiattaforma.values()) {
			count++;
		}
		if (count == id) {
			ris = true;
		}else {
			for (EnumPiattaforma e : EnumPiattaforma.values()) {
				if (ris) {
					
				}
			}
		}

		return ris;
	}
}

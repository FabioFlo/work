package com.project.riferimenti;

public class main {

	public static void main(String[] args) {
		GiocoTest gioco = new GiocoTest();
		
		System.out.println(gioco.genere);
		
		for(Genere g : Genere.values())
			System.out.println(g);
		
		
		switch(gioco.genere) {
		case Action:
			break;
		case FPS:
			break;
		case GDR:
			break;
		case Platform:
			break;
		case Puzzle:
			break;
		case cazzi:
			break;
		default:
			break;
		}
	}

}

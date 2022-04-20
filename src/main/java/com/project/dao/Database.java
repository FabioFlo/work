package com.project.dao;
import java.sql.*;
import java.util.*;

public class Database {

	private String percorso;
	private String username = "root";
	private String password = "root";
	private Connection c;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public Database(String nomeDB)
	{
		try
		{
			Class.forName(DRIVER);
			setPercorso(nomeDB);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setPercorso(String nomeDB)
	{
		String timeZone = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&amp";
       	String mysqlConnection = "jdbc:mysql://localhost:3306/";
		this.percorso = mysqlConnection + nomeDB + "?" + timeZone;
	}


	//GetC
	public Connection getC() {
		return c;
	}

	//Apri connessione
	public void apriConnessione() {
		try {
			Class.forName(DRIVER);
			this.c = DriverManager.getConnection(percorso,username,password);
		} catch(Exception e) {
			System.out.println("Errore nell'aprire la connessione");
			e.printStackTrace();
		}
	}

	//Chiudi connessione
	public void chiudiConnessione() {
		try {
			c.close();
		} catch(Exception e) {
			System.out.println("Errore nella chiusura della connessione");
			e.printStackTrace();;
		}
	}

	//Read generico db
	public List<Map<String, String>> read(String query, String... params) {
		List<Map<String, String>> ris = new ArrayList<>();
		try {
			PreparedStatement ps = c.prepareStatement(query);
			if(params.length > 0) {
				for(int i = 0; i < params.length; i++) {
					ps.setString(i + 1, params[i]);
				}
			}
			ResultSet tabella = ps.executeQuery(query);
			int nColonne = tabella.getMetaData().getColumnCount();

			Map<String, String> mappa;
			String chiave;
			String valore;
			while(tabella.next()) {
				mappa = new HashMap<String, String>();
				for(int i = 1; i < nColonne; i++) {
					chiave = tabella.getMetaData().getColumnLabel(i);
					valore = tabella.getString(i);
					mappa.put(chiave, valore);
				}
				ris.add(mappa);
			}
			
		} catch(Exception e) {
			System.out.println("Errore read db");
			e.printStackTrace();
		}
		return ris;
	}
	
	//Update generico db
	public boolean update(String query, String... params) {
		boolean ris;
		try {
			PreparedStatement ps = c.prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			ps.executeUpdate();
			ris = true;
		} catch(Exception e) {
			System.out.println("Errore update db");
			e.printStackTrace();
			ris = false;
		}
		return ris;
	}
}
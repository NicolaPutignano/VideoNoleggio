package it.javaoggetti.jdbc;

import java.sql.*;//
import java.util.Scanner;

public class VideoNoleggio {

	public static void main(String[] args) {
		
		// 1. caricare il driver jdbc(try/catch)
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					// 2. collegarsi ad un database
					//    (oggetto Connection)
					
					try {
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_noleggio","root","root");

//						PreparedStatement ps = c.prepareStatement("INSERT INTO genere(tipo) VALUES (?)");
												
//						ps.setString(1, "fantasy");
//						// 4d3. eseguo la query
//						ps.execute();
//						
//						
//						ps.setString(1, "thriller");
//						// 4d3. eseguo la query
//						ps.execute();
//
//						
//						ps.setString(1, "horror");
//						// 4d3. eseguo la query
//						ps.execute();
//
//						
//						ps.setString(1, "comico");
//						// 4d3. eseguo la query
//						ps.execute();
//
//						ps.setString(1, "hard");
//						// 4d3. eseguo la query
//						ps.execute();
						
//						PreparedStatement ps = c.prepareStatement("INSERT INTO film (titolo, genere, data_uscita, regista, prezzo, quantita)  VALUES (?,?,?,?,?,?)");					
//						
//						ps.setString(1, "million dollar baby");
//						ps.setInt(2, 1);
//						ps.setDate(3, new Date(2017, 10, 11));
//						ps.setString(4, "clint eastwood");
//						ps.setDouble(5, 10.00 );
//						ps.setInt(6, 4);
//						// 4d3. eseguo la query
//						ps.execute();
//						
//						ps.setString(1, "pulp fiction");
//						ps.setInt(2, 1);
//						ps.setDate(3, new Date(1999, 0, 11));
//						ps.setString(4, "quentin tarantino");
//						ps.setDouble(5, 7.00 );
//						ps.setInt(6, 2);
//						// 4d3. eseguo la query
//						ps.execute();
//						
//						ps.setString(1, "Avatar");
//						ps.setInt(2, 5);
//						ps.setDate(3, new Date(2017, 10, 11));
//						ps.setString(4, "non lo so");
//						ps.setDouble(5, 9.00 );
//						ps.setInt(6, 2);
//						// 4d3. eseguo la query
//						ps.execute();
//						
//						ps.setString(1, "E.T.");
//						ps.setInt(2, 1);
//						ps.setDate(3, new Date(2017, 10, 11));
//						ps.setString(4, "spilberg");
//						ps.setDouble(5, 10.00 );
//						ps.setInt(6, 3);
//						// 4d3. eseguo la query
//						ps.execute();
//						
//						ps.setString(1, "biancaneve sotto i nani");
//						ps.setInt(2, 1);
//						ps.setDate(3, new Date(2000, 11, 03));
//						ps.setString(4, "non lo so");
//						ps.setDouble(5, 5.00 );
//						ps.setInt(6, 9);
//						// 4d3. eseguo la query
//						ps.execute();
						Statement s = c.createStatement();
						
						// 4. eseguire le query (e eventualmente ottenerne i risultati)
						Scanner sc = new Scanner (System.in);
						// TUTTO QUELLO CHE DOBBIAMO FAR FARE AL DB VIENE DOPO   statement s = c.createStatement();
						
						System.out.println("\t \t \t \t \t Benvenuti \n" + " \t \t \t \t Video Noleggio GNOGNO!!!  \n \n \n");
						System.out.println("Selezionare l'opzione desiderata: \n\n" + 
						"OPZIONE 1" + " - - - " + "Controllare lista film: \n" + 
						"OPZIONE 2" + " - - - " + "Controllare film noleggiati \n ");
						
						int scelta = sc.nextInt();
						
						System.out.println(scelta);
						
							if (scelta == 1) {
								ResultSet rs1 = s.executeQuery(
										"SELECT id, titolo FROM Film;"
										);
								while(rs1.next()) {									// fino a quando ho ancora cose da leggere
												// stampa la riga corrente
									for(int i = 1; i <= rs1.getMetaData().getColumnCount(); i++) {   // scandiscimi le colonne
										System.out.println(rs1.getMetaData().getColumnLabel(i)+": "	// stampa il nome della colonna i
													+rs1.getString(i) + " ");
									}// stampa il contenuto della cella i
								}
							} else if (scelta == 2) {
								ResultSet rs2 = s.executeQuery(
										"SELECT id, titolo FROM Film "
										+ "JOIN Noleggio ON Noleggio.film = Film.id "
										+ "GROUP BY id, titolo; "
										);
								while(rs2.next()) {									// fino a quando ho ancora cose da leggere
									// stampa la riga corrente
									for(int i = 1; i <= rs2.getMetaData().getColumnCount(); i++) {   // scandiscimi le colonne
										System.out.println(rs2.getMetaData().getColumnLabel(i)+": "	// stampa il nome della colonna i
										+rs2.getString(i) + " ");
									}
								}
							} else {
								System.out.println("NESSUNA SCELTA SELEZIONATA \n SI PREGA DI SCEGLIERE LA GIUSTA OPZIONE!!");
							}
						
						/*
						  while(rs.next()) {
						 
							System.out.println("Row "+rs.getRow());
							for(int i = 1; i < rs.getMetaData().getColumnCount()+1; i++) {
								System.out.println(rs.getMetaData().getColumnLabel(i)+": "	// stampa il nome della colonna i
											+rs.getString(i));								// stampa il contenuto della cella i
							}
						}
						*/
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Modifica stefano");
						
				
	}

		
}



package it.javaoggetti.jdbc;

import java.sql.*;

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

						ResultSet rs = s.executeQuery("SELECT titolo FROM video_noleggio.film join genere on film.genere=genere.id where genere.tipo='DRAMMATICO' GROUP BY titolo;");
						
						// 5. scorrere i risultati
						
						while(rs.next()) {
							System.out.println("Row "+rs.getRow());
							for(int i = 1; i < rs.getMetaData().getColumnCount()+1; i++) {
								System.out.println(rs.getMetaData().getColumnLabel(i)+": "	// stampa il nome della colonna i
											+rs.getString(i));								// stampa il contenuto della cella i
							}
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	}

		
}



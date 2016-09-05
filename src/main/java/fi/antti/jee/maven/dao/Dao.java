package fi.antti.jee.maven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fi.antti.jee.maven.bean.Kortti;

public class Dao {

	private Connection yhdista() throws SQLException, Exception {

		Connection yhteys = null;

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();
			// avataan yhteys
			yhteys = DriverManager.getConnection(DBConnectionProperties
					.getInstance().getProperty("url"), DBConnectionProperties
					.getInstance().getProperty("username"),
					DBConnectionProperties.getInstance()
							.getProperty("password"));

		} catch (SQLException sqlE) {
			System.err.println("Tietokantayhteyden avaaminen ei onnistunut. "
					+ DBConnectionProperties.getInstance().getProperty("url")
					+ "\n" + sqlE.getMessage() + " " + sqlE.toString() + "\n");
			sqlE.printStackTrace();
			throw (sqlE);
		} catch (Exception e) {
			System.err.println("TIETOKANTALIITTYN VIRHETILANNE: "
					+ "JDBC:n omaa tietokanta-ajuria ei loydy.\n\n"
					+ e.getMessage() + " " + e.toString() + "\n");
			e.printStackTrace();
			System.out.print("\n");
			throw (e);
		}

		return yhteys;

	}

	public ArrayList<Kortti> haeKaikkiTiedot() throws SQLException, Exception {
		ArrayList<Kortti> data = null;
		Kortti kortti = null;
		String sql = "SELECT * FROM kortit WHERE isDeleted = 0";
		PreparedStatement preparedStatement = null; // suoritettava SQL-lause
		ResultSet tulokset = null; // SQL-kyselyn tulokset
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				tulokset = preparedStatement.executeQuery();
				if (tulokset != null) {
					conn.close(); // sulje yhteys kantaan
					if (data == null) {
						data = new ArrayList<Kortti>();
					}
					while (tulokset.next()) {
						try {
							kortti = new Kortti();

							kortti.setId(tulokset.getInt("id"));
							kortti.setEtunimi(tulokset.getString("etunimi"));
							kortti.setSukunimi(tulokset.getString("sukunimi"));
							kortti.setOsoite(tulokset.getString("osoite"));
							kortti.setZip(tulokset.getString("zip"));
							kortti.setPostitoimipaikka(tulokset
									.getString("postitoimipaikka"));

							data.add(kortti);

						} catch (Exception e) {
							// TODO: handle exception
							System.out.print("hops" + e);

						}

					}
					tulokset.close();
				} else {
					conn.close();
					data = null;
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}
			}
		}
		return data;
	}

	public void lisaaKortti(Kortti kortti) throws SQLException, Exception {

		String sql = "INSERT INTO kortit(etunimi, sukunimi, osoite, zip, postitoimipaikka) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement;
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);

				preparedStatement.setString(1, kortti.getEtunimi());
				preparedStatement.setString(2, kortti.getSukunimi());
				preparedStatement.setString(3, kortti.getOsoite());
				preparedStatement.setString(4, kortti.getZip());
				preparedStatement.setString(5, kortti.getPostitoimipaikka());
				preparedStatement.execute(); // Ajetaan SQL lause

			}

		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}
			}
		}

	}

	public void editOsoite(Kortti kortti) throws SQLException, Exception {

		String sql = "UPDATE kortit SET etunimi = ?, sukunimi = ?, osoite = ?, zip = ?, postitoimipaikka = ? WHERE id = ?";
		PreparedStatement preparedStatement;
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setString(1, kortti.getEtunimi());
				preparedStatement.setString(2, kortti.getSukunimi());
				preparedStatement.setString(3, kortti.getOsoite());
				preparedStatement.setString(4, kortti.getZip());
				preparedStatement.setString(5, kortti.getPostitoimipaikka());
				preparedStatement.setInt(6, kortti.getId());
				preparedStatement.execute(); // Ajetaan SQL lause

			}

		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}
			}
		}

	}

	public Kortti haeRivi(int id) throws SQLException, Exception {

		Kortti data = null;
		String sql = "SELECT * FROM kortit WHERE id = ? ";
		PreparedStatement preparedStatement = null; // suoritettava SQL-lause
		ResultSet tulokset = null; // SQL-kyselyn tulokset
		Connection conn = null;
		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				tulokset = preparedStatement.executeQuery();
				if (tulokset != null) {
					conn.close(); // sulje yhteys kantaan

					while (tulokset.next()) {
						data = new Kortti();

						data.setId(tulokset.getInt("id"));
						data.setEtunimi(tulokset.getString("etunimi"));
						data.setSukunimi(tulokset.getString("sukunimi"));
						data.setOsoite(tulokset.getString("osoite"));
						data.setZip(tulokset.getString("zip"));
						data.setPostitoimipaikka(tulokset
								.getString("postitoimipaikka"));
					}
					tulokset.close();
				} else {
					conn.close();
					data = null;

				}
			}

		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}
			}
		}
		return data;
	}

	public void poistaOsoite(int id) throws SQLException, Exception {

		String sql = "UPDATE kortit SET isDeleted = ? WHERE id = ?";
		PreparedStatement preparedStatement;
		Connection conn = null;

		try {
			conn = yhdista();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setBoolean(1, true);
				preparedStatement.setInt(2, id);
				preparedStatement.execute(); // Ajetaan SQL lause

			}

		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		} finally {
			if (conn != null && conn.isClosed() == false) {
				try {
					conn.close(); // yhteys poikki
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}
			}
		}

	}

}
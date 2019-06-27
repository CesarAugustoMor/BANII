/**
 * 
 */
package interacaoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author César Agusto Moro Fürst
 *
 */
public class ExecutaQuery {
	
	public static boolean cadastra(StringBuilder esprecao,Connection conection) {
		if (conection==null||esprecao==null) {
			return false;
		}
		try {
			Statement st = conection.createStatement();
			ResultSet rs = st.executeQuery(esprecao.toString());
			while (rs.next()){
			    if (rs.getBoolean(1)) {
			    	System.out.println(rs.getBoolean(1));
					return true;
				}
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	public static ResultSet busca(StringBuilder esprecao, Connection conection) throws SQLException {
		Statement st = conection.createStatement();
		ResultSet rs = st.executeQuery(esprecao.toString());
		/*while (rs.next()){
			System.out.print(rs.getBoolean(1));
		    if (rs.getBoolean(1)) {
				
			}
		}*/
		//rs.close();
		//st.close();
		return rs;
	}
	
}
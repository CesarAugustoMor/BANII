/**
 * 
 */
package interacaoBanco;

import java.sql.*;

/**
 * @author C�sar Agusto Moro F�rst
 *
 */
public class ConectaBanco {
	
	public static Connection getConection(String servidor, String porta, String senha) throws SQLException{
		StringBuilder url = new StringBuilder();
		url.append("jdbc:postgresql://")
			.append(servidor)
			.append(':')
			.append(porta)
			.append('/')
			.append("TrabalhoFinal?user=postgres&password=")
			.append(senha);
		return DriverManager.getConnection(url.toString());
	}

}

package server.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Db {

	private static Connection con = getConnection();	
	
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/projetospt?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "JMV@xrms9";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		}catch(Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}	
    
    public static void executaDataManipulation(StringBuilder sql) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql.toString());
            st.executeUpdate();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na execução DataManipulation, verifique com seu DBA");
        }
    }

    public static ResultSet executaSelect(StringBuilder sql) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(sql.toString());
            rs = st.executeQuery();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na execução da consulta, verifique com seu DBA");
        }
        return rs;
    }
	
	
}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//    public class CreateDatabase {
//        public static void main(String[] args) {
//            String url = "jdbc:postgresql://localhost:5432/postgres"; // default DB
//            String user = "postgres"; // superuser
//            String password = "Wanjiru1806"; // update with your actual password
//
//            String dbName = "ucm";
//
//            try (Connection conn = DriverManager.getConnection(url, user, password);
//                 Statement stmt = conn.createStatement()) {
//
//                stmt.executeUpdate("CREATE DATABASE " + dbName);
//                System.out.println("Database '" + dbName + "' created successfully.");
//
//            } catch (Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//    }
//
//

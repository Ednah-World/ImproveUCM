import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

    public class connectingdb {
        public static void main(String[] args) {
            // Admin connection (default superuser in PostgreSQL)
            String url = "jdbc:postgresql://localhost:5432/postgres"; // connect to default "postgres" DB
            String user = "postgres"; // superuser
            String password = "Wanjiru1806"; // admin password

            // Name of the database to create
            String dbName = "ucm";
            // Shared user
            String sharedUser = "common_user";
            String sharedPassword = "common_pass";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {

                // 1. Create the database
                stmt.executeUpdate("CREATE DATABASE " + dbName );
                System.out.println("Database '" + dbName + "' created successfully.");

                // 2. Create a common user
                stmt.executeUpdate("CREATE USER " + sharedUser + " WITH ENCRYPTED PASSWORD '" + sharedPassword + "'");
                System.out.println("User '" + sharedUser + "' created successfully.");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            // 3. Grant privileges after switching to the new DB
            String newDbUrl = "jdbc:postgresql://localhost:5432/" + dbName;

            try (Connection dbConn = DriverManager.getConnection(newDbUrl, user, password);
                 Statement dbStmt = dbConn.createStatement()) {

                dbStmt.executeUpdate("GRANT ALL PRIVILEGES ON DATABASE " + dbName + " TO " + sharedUser);
                System.out.println("Granted privileges on '" + dbName + "' to '" + sharedUser + "'.");

            } catch (Exception e) {
                System.out.println("Error while granting privileges: " + e.getMessage());
            }
        }
    }



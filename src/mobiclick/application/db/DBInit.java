package mobiclick.application.db;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.stream.Collectors;
import static mobiclick.application.Application.DB_URL;
import static mobiclick.application.Application.LOGGER;

/**
 *
 * @author DennisMutethia
 */
public class DBInit {
    private final static String filePath = "/mobiclick/application/db/pos.sql";

    public void loadSqlFile() {
        try (InputStream inputStream = getClass().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String sql = reader.lines().collect(Collectors.joining("\n"));
            this.executeSql(sql);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        }
    }

    private void executeSql(String sql) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
                System.out.println("Creating base tables...");

                for (String query : sql.split(";")) {
                    if (!query.trim().isEmpty()) {
                        try (Statement stmt = conn.createStatement()) {
                            stmt.execute(query);
                            System.out.println("Statement executed.");
                        } catch (SQLException e) {
                            LOGGER.log(Level.SEVERE, "{0}", e);
                        }
                    }
                }
                
                System.out.println("Done creating base tables...");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "{0}", e);
        }
    }
}

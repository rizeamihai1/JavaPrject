package Models;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {
    private static final String FILE_NAME = "audit_log.csv";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String actiune) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            String time = LocalDateTime.now().format(formatter);
            writer.append(time).append(",").append(actiune).append("\n");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în audit_log.csv: " + e.getMessage());
        }
    }
}

package com.mobiclick.pos.utils;

import static com.mobiclick.pos.Init.APPLICATION_PROPERTIES;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/**
 * @author dennis
 */
public class Logging {
    public static final Logger LOGGER = Logger.getLogger("infoLogger");
    
    static {
        try {
            File logsDir = new File(APPLICATION_PROPERTIES.getProperty("log_path"));
            if (!logsDir.exists()) {
                logsDir.mkdir();
            }
            FileHandler fh = new FileHandler(logsDir + "/" + APPLICATION_PROPERTIES.getProperty("app_name") + ".log");

            //infologger.setUseParentHandlers(false); 
            fh.setFormatter(new MyFormatter());

            LOGGER.addHandler(fh);

        } catch (IOException ex) {
            Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, " (fail) initialize Loggers - fileLocation not found", ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Logging.class.getName()).log(Level.SEVERE, " (fail) initialize Loggers - permissions denied {0}", ex);
         }
    }

    private static class MyFormatter extends Formatter {
        //
        // Create a DateFormat to format the logger timestamp.

        @Override
        public String format(LogRecord record) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(record.getMillis());

            StringBuilder builder = new StringBuilder(1000);
            builder.append(new SimpleDateFormat("dd-MMM-yyyy HH:mm:s").format(cal.getTime()))
                    .append(" ")
                    .append(record.getLevel())
                    .append(": ");
            //builder.append(record.getSourceClassName()).append(".");
            //builder.append(record.getSourceMethodName()).append(" : ");
            builder.append(formatMessage(record));
            builder.append("\n");
            return builder.toString();
        }

        @Override
        public String getHead(Handler h) {
            return super.getHead(h);
        }

        @Override
        public String getTail(Handler h) {
            return super.getTail(h);
        }
    }
}

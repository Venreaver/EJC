package tasks.task_05;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of csv parser in multi threads with output report
 * <p>
 * <p> Parse information about users connections and summarize time each user spent on different urls
 */
class CSVDataHandler {
    /**
     * map with necessary data for report
     */
    private Map<String, Long> reportMap;
    private final String inputFolderPath;
    private File[] csvFilesArray;

    CSVDataHandler() {
        this(Config.INPUT_FOLDER_PATH);
    }

    CSVDataHandler(String inputFolderPath) {
        this.inputFolderPath = inputFolderPath;
        this.csvFilesArray = new File(inputFolderPath)
                .listFiles((dir, name) -> name.toLowerCase().endsWith(Config.FILE_EXTENSION));
        this.reportMap = new ConcurrentHashMap<>();
    }

    /**
     * Starts processing
     */
    void start() {
        parseData();
        createTimeReport();
    }

    /**
     * Parses csv data files in multi threads
     */
    private void parseData() {
        int threadCount = csvFilesArray.length < 10 ? csvFilesArray.length : Config.THREAD_COUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (File csvFile : csvFilesArray) {
            executorService.execute(new ParsingThread(csvFile));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.err.println(Config.ERROR + e.getMessage());
        }
    }

    /**
     * Creates output report with information about sum time each user spent on different urls
     */
    private void createTimeReport() {
        String outPutPath = inputFolderPath + Config.OUTPUT_FOLDER_NAME;
        if (new File(outPutPath).mkdir()) {
            File timeReportFile = new File(outPutPath, Config.OUTPUT_FILE_NAME + Config.FILE_EXTENSION);
            try (FileWriter writer = new FileWriter(timeReportFile, false)) {
                writer.write(Config.REPORT_ATTRIBUTES);
                Map<String, Long> sortedMap = new TreeMap<>(reportMap);
                for (Map.Entry<String, Long> pair : sortedMap.entrySet()) {
                    writer.write('\n' + pair.getKey() + ',' + pair.getValue());
                }
            } catch (IOException e) {
                System.err.println(Config.ERROR + e.getMessage());
            }
        }
    }

    /**
     * Inner class for reading data files
     */
    private class ParsingThread implements Runnable {
        private File fileToParse;

        private ParsingThread(File fileToParse) {
            this.fileToParse = fileToParse;
        }

        /**
         * Reads all data from file, analyzes data and puts into reportMap
         */
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileToParse))) {
                reader.readLine();
                String fileLine;
                while ((fileLine = reader.readLine()) != null) {
                    String[] values = fileLine.split(",");
                    long timeValue = values[2].matches("\\d*") ? Long.parseLong(values[2]) : 0;
                    reportMap.merge(values[3] + ',' + values[1], timeValue, (exTime, newTime) -> exTime + newTime);
                }
            } catch (IOException e) {
                System.err.println(Config.ERROR + e.getMessage());
            }
        }
    }
}

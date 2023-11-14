import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List <Integer> createIntegerList(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (String arg : args) {
            integerList.add(Integer.parseInt(arg));
        }
        return integerList;
    }

    public static ArrayList <Streamers> readFromFileStreamers(String filename, ArrayList<Streamers> streamers) {
        CSVReader fReader = null;
        try {
            fReader = new CSVReader(new FileReader
                    ("src/main/resources/" + filename));
            String[] line;
            fReader.readNext();
            while ((line = fReader.readNext()) != null) {
                streamers.add(new StreamersBuilder()
                        .withStreamerType(Integer.parseInt(line[0]))
                        .withId(Integer.parseInt(line[1]))
                        .withName(line[2])
                        .build());
            }
            return streamers;
        } catch (IOException e) {
            System.err.print("Error: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

        public static ArrayList <Streams> readFromFileStreams(String filename, ArrayList<Streams> streams) {
            CSVReader fReader = null;
            try {
                fReader = new CSVReader(new FileReader
                        ("src/main/resources/" + filename));
                String[] line;
                fReader.readNext();
                while ((line = fReader.readNext()) != null) {
                   streams.add(new StreamsBuilder()
                            .withStreamType(Integer.parseInt(line[0]))
                            .withId(Integer.parseInt(line[1]))
                            .withStreamGenre(Integer.parseInt(line[2]))
                            .withNoOfStreams(Integer.toUnsignedLong(Integer.parseInt(line[3])))
                            .withStreamerId(Integer.parseInt(line[4]))
                            .withLength(Integer.toUnsignedLong(Integer.parseInt(line[5])))
                            .withDate(Integer.toUnsignedLong(Integer.parseInt((line[6]))))
                            .withName(line[7])
                            .build());
                }
                return streams;
            } catch (IOException e) {
                System.err.print("Error: " + e.getMessage());
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        public static ArrayList <Users> readFromFileUsers(String filename, ArrayList<Users> users) {
            CSVReader fReader = null;
            try {
                fReader = new CSVReader(new FileReader
                        ("src/main/resources/" + filename));
                String[] line;
                fReader.readNext();
                while ((line = fReader.readNext()) != null) {
                    users.add(new UsersBuilder()
                            .withId(Integer.parseInt(line[0]))
                            .withName(line[1])
                            .withStreams(createIntegerList(line[2].split(" ")))
                            .build());
                }
                return users;
            } catch (IOException e) {
                System.err.print("Error: " + e.getMessage());
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        public static ArrayList <String> readFileFromCommands(String filename){
        try{
            FileReader fileReader = new FileReader("src/main/resources/" + filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            ArrayList<String> commands = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null){
                commands.add(line);
            }
            return commands;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

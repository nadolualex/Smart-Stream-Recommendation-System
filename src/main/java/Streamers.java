import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Streamers extends Template{
    private Integer streamerType;
    private Integer id;
    private String name;
    public Streamers() {}

    public Integer getStreamerType() {
        return streamerType;
    }
    public void setStreamerType(Integer streamerType) {
        this.streamerType = streamerType;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static String getStreamerName(int streamerId, ArrayList<Streamers> streamers) {
        for (int i = 0; i < streamers.size(); i++) {
            if (streamers.get(i).getId() == streamerId) {
                return streamers.get(i).getName();
            }
        }
        return null;
    }

    public static String hourMinutesSeconds(Long seconds) {
        Long hours = seconds / 3600;
        Long minutes = (seconds % 3600) / 60;
        Long remainingSeconds = seconds % 60;
        if(hours > 0)
            return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" +
                    String.format("%02d",remainingSeconds);
        else if(minutes > 0)
            return String.format("%02d", minutes) + ":" + String.format("%02d",remainingSeconds);
        return String.format("%02d",remainingSeconds);
    }

    //convert Date Unix time to GMT
    public static String convertDate(Long date) {
        date = date * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public void print(ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers, int k, int j) {
            System.out.print("{\"id\":" + "\"" + users.get(k).getStreams().get(j) +
                    "\"" + "," +
                    "\"name\":" + "\"" + Streams.getStreamName(users.get(k).getStreams().get(j), streams) +
                    "\"" + "," +
                    "\"streamerName\":" + "\"" + Streamers.getStreamerName
                    (streams.get(k).getStreamerId(users.get(k).getStreams().get(j), streams), streamers) +
                    "\"" + "," +
                    "\"noOfListenings\":" + "\"" + streams.get(k).getNoOfStreams(users.get(k).getStreams().get(j), streams) +
                    "\"" + "," +
                    "\"length\":" + "\"" + Streamers.hourMinutesSeconds
                    (streams.get(k).getLength(users.get(k).getStreams().get(j), streams)) +
                    "\"" + "," +
                    "\"dateAdded\":" + "\"" + Streamers.convertDate
                    (streams.get(k).getDateAdded(users.get(k).getStreams().get(j), streams)) + "\"" + "}");
        }

}

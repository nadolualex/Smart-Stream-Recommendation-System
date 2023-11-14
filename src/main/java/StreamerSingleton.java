import java.util.ArrayList;

public class StreamerSingleton {
    private static StreamerSingleton instance = null;
    private ArrayList<Streamers> streamers;
    private StreamerSingleton() {
        streamers = new ArrayList<>();
    }
    public static StreamerSingleton getInstance() {
        if (instance == null) {
            instance = new StreamerSingleton();
        }
        return instance;
    }

    public static void setInstance(StreamerSingleton instance) {
        StreamerSingleton.instance = instance;
    }

    public ArrayList<Streamers> getStreamers() {
        return streamers;
    }

    public void setStreamers(ArrayList<Streamers> streamers) {
        this.streamers = streamers;
    }
}

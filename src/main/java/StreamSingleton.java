import java.util.ArrayList;

public class StreamSingleton {
    private static StreamSingleton instance = null;
    private ArrayList<Streams> streams;
    private StreamSingleton() {
        streams = new ArrayList<>();
    }
    public static StreamSingleton getInstance() {
        if (instance == null) {
            instance = new StreamSingleton();
        }
        return instance;
    }

    public static void setInstance(StreamSingleton instance) {
        StreamSingleton.instance = instance;
    }

    public ArrayList<Streams> getStreams() {
        return streams;
    }

    public void setStreams(ArrayList<Streams> streams) {
        this.streams = streams;
    }
}

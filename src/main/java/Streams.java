import java.util.ArrayList;
import java.util.Objects;

public class Streams {
    private Integer id;
    private Long noOfStreams;
    private Long length;
    private Long dateAdded;
    private String name;
    private StreamCommon streamCommon;

    public Streams(Integer id, Long noOfStreams, Long length, Long dateAdded, String name, int streamType, int streamGenre, int streamerId) {
        this.id = id;
        this.noOfStreams = noOfStreams;
        this.length = length;
        this.dateAdded = dateAdded;
        this.name = name;
        this.streamCommon = StreamFactory.getStreamCommon(streamType, streamGenre, streamerId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StreamCommon getStreamCommon() {
        return streamCommon;
    }

    public void setStreamCommon(StreamCommon streamCommon) {
        this.streamCommon = streamCommon;
    }

    public Long getNoOfStreams() {
        return noOfStreams;
    }

    public void setNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static String getStreamName(int streamId, ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).getId() == streamId) {
                return streams.get(i).getName();
            }
        }
        return null;
    }
    public Integer getStreamerId(int streamerId, ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).getId() == streamerId) {
                return streams.get(i).getStreamCommon().getStreamerId();
            }
        }
        return null;
    }
    public Long getNoOfStreams(int streamId, ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).getId() == streamId) {
                return streams.get(i).getNoOfStreams();
            }
        }
        return null;
    }
    public Long getLength(int streamId, ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).getId() == streamId) {
                return streams.get(i).getLength();
            }
        }
        return null;
    }
    public Long getDateAdded(int streamId, ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            if (streams.get(i).getId() == streamId) {
                return streams.get(i).getDateAdded();
            }
        }
        return null;
    }

    public void OrderByListenings(ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            for (int j = 0; j < streams.size(); j++) {
                if (streams.get(i).getNoOfStreams() > streams.get(j).getNoOfStreams()) {
                    Streams temp = streams.get(i);
                    streams.set(i, streams.get(j));
                    streams.set(j, temp);
                }
            }
        }
    }

    public void sortStreamsByDate(ArrayList<Streams> streams){
        for (int i = 0; i < streams.size(); i++) {
            for (int j = 0; j < streams.size(); j++) {
                if (streams.get(i).getDateAdded() > streams.get(j).getDateAdded()) {
                    Streams temp = streams.get(i);
                    streams.set(i, streams.get(j));
                    streams.set(j, temp);
                }
                if(Objects.equals(streams.get(i).getDateAdded(), streams.get(j).getDateAdded())){
                    if (streams.get(i).getNoOfStreams() > streams.get(j).getNoOfStreams()) {
                        Streams temp = streams.get(i);
                        streams.set(i, streams.get(j));
                        streams.set(j, temp);
                    }
                }
            }
        }
    }

    public void AddStream(Integer streamerID, Integer StreamType, Integer id, Integer StreamGenre,
                                 Long length, String name, ArrayList<Streams> streams) {
        streams.add(new StreamsBuilder()
                .withStreamType(StreamType)
                .withId(id)
                .withStreamGenre(StreamGenre)
                .withNoOfStreams(0L)
                .withStreamerId(streamerID)
                .withLength(length)
                .withDate(1673560800L)
                .withName(name)
                .build());
    }

    public void DeleteStream(Integer streamerID, Integer id, ArrayList<Streams> streams) {
        for (int i = 0; i < streams.size(); i++) {
            if (Objects.equals(streams.get(i).getStreamCommon().getStreamerId(),
                    streamerID) && Objects.equals(streams.get(i).getId(), id)){
                streams.remove(i);
            }
        }
    }
}

public class StreamsBuilder {

    private Integer id;
    private Long noOfStreams;
    private Long length;
    private Long dateAdded;
    private String name;
    private int streamType;
    private int streamGenre;
    private int streamerId;

    public StreamsBuilder withStreamType(Integer streamType) {
        this.streamType = streamType;
        return this;
    }

    public StreamsBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public StreamsBuilder withStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
        return this;
    }

    public StreamsBuilder withDate(Long dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public StreamsBuilder withLength(Long length) {
        this.length = length;
        return this;
    }

    public StreamsBuilder withNoOfStreams(Long noOfStreams) {
        this.noOfStreams = noOfStreams;
        return this;
    }

    public StreamsBuilder withStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
        return this;
    }

    public StreamsBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Streams build() {
        return new Streams(id, noOfStreams, length, dateAdded, name, streamType, streamGenre, streamerId);
    }
}

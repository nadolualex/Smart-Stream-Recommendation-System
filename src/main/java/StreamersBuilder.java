public class StreamersBuilder {
    private final Streamers streamers = new Streamers();
    public StreamersBuilder withStreamerType(Integer streamerType) {
        streamers.setStreamerType(streamerType);
        return this;
    }
    public StreamersBuilder withId(Integer id) {
        streamers.setId(id);
        return this;
    }
    public StreamersBuilder withName(String name) {
        streamers.setName(name);
        return this;
    }
    public Streamers build() {
        return streamers;
    }
}

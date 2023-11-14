public class StreamCommon {

    private int streamType;
    private int streamGenre;
    private int streamerId;

    public StreamCommon() {}

    public Integer getStreamGenre() {
        return streamGenre;
    }

    public void setStreamGenre(Integer streamGenre) {
        this.streamGenre = streamGenre;
    }

    public Integer getStreamerId() {
        return streamerId;
    }

    public void setStreamerId(Integer streamerId) {
        this.streamerId = streamerId;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public StreamCommon(int streamType, int streamGenre, int streamerId) {
        this.streamType = streamType;
        this.streamGenre = streamGenre;
        this.streamerId = streamerId;
    }
}

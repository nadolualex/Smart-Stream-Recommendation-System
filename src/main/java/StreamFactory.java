import java.util.HashMap;
import java.util.Map;

public class StreamFactory {
    private static final Map<Integer, StreamCommon> streamsCommon = new HashMap<>();
    public static StreamCommon getStreamCommon(int streamType, int streamGenre, int streamerId){
        if(streamsCommon.get(streamerId) == null){
            streamsCommon.put(streamerId, new StreamCommon(streamType, streamGenre, streamerId));
        }
        return streamsCommon.get(streamerId);
    }

}

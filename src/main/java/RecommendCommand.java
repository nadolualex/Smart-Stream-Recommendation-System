import java.util.ArrayList;
import java.util.Objects;

public class RecommendCommand extends CommandPattern {
    void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers,
              ArrayList<String> commands, int a, int commandId){
        Integer userId = Integer.parseInt(commands.get(a).split(" ")[0]);

        for(int k = 0; k < users.size(); k ++) {
            if (Objects.equals(users.get(k).getId(), userId)) {
                ArrayList<Integer> StreamersListened = new ArrayList<>();
                StreamersListened.clear();
                for (int j = 0; j < users.get(k).getStreams().size(); j++) {
                    for (int l = 0; l < streams.size(); l++) {
                        if (Objects.equals(users.get(k).getStreams().get(j), streams.get(l).getId())) {
                            StreamersListened.add(streams.get(l).getStreamCommon().getStreamerId());
                        }
                    }
                }
                ArrayList<Streams> StreamsRecommended = new ArrayList<>();
                StreamsRecommended.clear();
                for (int j = 0; j < streams.size(); j++) {
                    if (!users.get(k).getStreams().contains(streams.get(j).getId()) &&
                            StreamersListened.contains(streams.get(j).getStreamCommon().getStreamerId()))
                        StreamsRecommended.add(streams.get(j));
                }
                streams.get(k).OrderByListenings(StreamsRecommended);
                for (int j = 0; j < StreamsRecommended.size(); j++) {
                    if (j > 0)
                        System.out.print(",");
                    else if (dummy == 0) {
                        System.out.print("[");
                    } else {
                        System.out.print("\n");
                        System.out.print("[");
                        dummy++;
                    }
                    System.out.print("{\"id\":" + "\"" + StreamsRecommended.get(j).getId() +
                            "\"" + "," +
                            "\"name\":" + "\"" + StreamsRecommended.get(j).getName() +
                            "\"" + "," +
                            "\"streamerName\":" + "\"" + Streamers.getStreamerName
                            (StreamsRecommended.get(j).getStreamCommon().getStreamerId(), streamers) +
                            "\"" + "," +
                            "\"noOfListenings\":" + "\"" + StreamsRecommended.get(j).getNoOfStreams() +
                            "\"" + "," +
                            "\"length\":" + "\"" + Streamers.hourMinutesSeconds(StreamsRecommended.get(j).getLength()) +
                            "\"" + "," +
                            "\"dateAdded\":" + "\"" + Streamers.convertDate(StreamsRecommended.get(j).getDateAdded()) +
                            "\"" + "}");
                }
                System.out.print("]");
            }
        }
    }
}

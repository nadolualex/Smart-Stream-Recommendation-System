import java.util.ArrayList;
import java.util.Objects;

public class SurpriseCommand extends CommandPattern {

    void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers,
              ArrayList<String> commands, int a, int commandId) {
        Integer userId = Integer.parseInt(commands.get(a).split(" ")[0]);
        int type;
        if(commands.get(a).split(" ")[2].equals("SONG")){
            type = 1;
        }
        else if(commands.get(a).split(" ")[2].equals("PODCAST"))
            type = 2;
        else
            type = 3;
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

                ArrayList <Streamers> StreamersNotListened = new ArrayList<>();
                StreamersNotListened.clear();
                for(int j = 0; j < streamers.size(); j ++){
                    if(!StreamersListened.contains(streamers.get(j).getId()))
                        StreamersNotListened.add(streamers.get(j));
                }

                ArrayList <Streams> StreamsSurprised = new ArrayList<>();
                StreamsSurprised.clear();

                for(int j = 0; j < StreamersNotListened.size(); j++){
                    for(int l = 0; l < streams.size(); l++){
                        if(Objects.equals(StreamersNotListened.get(j).getId(), streams.get(l).getStreamCommon().getStreamerId())
                                && streams.get(l).getStreamCommon().getStreamType() == type)
                            StreamsSurprised.add(streams.get(l));
                    }
                }

                streams.get(k).sortStreamsByDate(StreamsSurprised);

                for(int j = 0; j < StreamsSurprised.size(); j ++) {
                    if(j == 3){
                        break;
                    }
                    if(j > 0)
                        System.out.print(",");
                    else if(dummy == 0){
                        System.out.print("[");
                    }
                    else {
                        System.out.print("\n");
                        System.out.print("[");
                        dummy ++;
                    }
                    System.out.print("{\"id\":" + "\"" + StreamsSurprised.get(j).getId() + "\"" + "," +
                            "\"name\":" + "\"" + StreamsSurprised.get(j).getName() + "\"" + "," +
                            "\"streamerName\":" + "\"" + Streamers.getStreamerName(StreamsSurprised.get(j).getStreamCommon().getStreamerId(), streamers) + "\"" + "," +
                            "\"noOfListenings\":" + "\"" + StreamsSurprised.get(j).getNoOfStreams() + "\"" + "," +
                            "\"length\":" + "\"" + Streamers.hourMinutesSeconds(StreamsSurprised.get(j).getLength()) + "\"" + "," +
                            "\"dateAdded\":" + "\"" + Streamers.convertDate(StreamsSurprised.get(j).getDateAdded()) + "\"" + "}");
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }
}

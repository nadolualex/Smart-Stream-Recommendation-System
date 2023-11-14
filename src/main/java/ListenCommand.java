import java.util.ArrayList;

public class ListenCommand extends CommandPattern {
    void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers,
              ArrayList<String> commands, int a, int commandId){

        for (int k = 0; k < users.size(); k++) {
            if (users.get(k).getId() == commandId) {
                users.get(k).addStream(Integer.parseInt(commands.get(a).split(" ")[2]));
                for (int j = 0; j < streams.size(); j++) {
                    if (streams.get(j).getId() == Integer.parseInt(commands.get(a).split(" ")[2])) {
                        Long b = streams.get(j).getNoOfStreams(); // increase the number of streams
                        b++;
                        streams.get(j).setNoOfStreams(b);
                    }
                }
            }
        }

    }
}


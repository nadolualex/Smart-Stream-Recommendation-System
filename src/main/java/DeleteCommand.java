import java.util.ArrayList;

public class DeleteCommand extends CommandPattern {
    void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers,
              ArrayList<String> commands, int a, int commandId) {
        streams.get(a).DeleteStream(commandId, Integer.parseInt(commands.get(a).split(" ")[2]), streams);
    }
}


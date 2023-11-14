import java.util.ArrayList;

//Command pattern

public abstract class CommandPattern {
    abstract void exec(int dummy,
                       ArrayList<Users> users, ArrayList<Streams> streams,
                       ArrayList<Streamers> streamers, ArrayList<String> commands,
                       int a, int commandId);
}

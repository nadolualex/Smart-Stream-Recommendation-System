import java.util.ArrayList;

public abstract class Comanda {
    abstract void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams,
                       ArrayList<Streamers> streamers, ArrayList<String> commands, int a, int commandId);
}

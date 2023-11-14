import java.util.ArrayList;

public class ProiectPOO {

    public static void main(String[] args) {
        if(args == null) {
            System.out.println("Nothing to read here");
        }
        else {
            ArrayList<Streamers> streamers = new ArrayList<>();

            ArrayList<Streams> streams = new ArrayList<>();

            ArrayList<Users> users = new ArrayList<>();

            ArrayList<String> commands = new ArrayList<>();

            Commands.commandFunction(args,streamers,streams,users,commands);
        }
    }
}

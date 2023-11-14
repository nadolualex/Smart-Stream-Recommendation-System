import java.util.ArrayList;
public class AddCommand extends CommandPattern {
    void exec(int dummy, ArrayList<Users> users, ArrayList<Streams> streams, ArrayList<Streamers> streamers,
              ArrayList<String> commands, int a, int commandId){

        String songName = commands.get(a).split(" ")[6];

        if(commands.get(a).split(" ").length > 7){
            for(int f = 7; f < commands.get(a).split(" ").length; f++){
                songName +=  " " + commands.get(a).split(" ")[f];
            }
        }

        streams.get(a).AddStream(commandId,
                Integer.parseInt(commands.get(a).split(" ")[2]),
                Integer.parseInt(commands.get(a).split(" ")[3]),
                Integer.parseInt(commands.get(a).split(" ")[4]),
                Long.parseLong(commands.get(a).split(" ")[5]),
                songName,
                streams);
    }
}

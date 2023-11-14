import java.util.ArrayList;
import java.util.Collections;
public class Commands {
    public static String command;
    public static int commandId;
    public static void commandFunction(String[] args, ArrayList<Streamers> streamers, ArrayList<Streams> streams,
                                       ArrayList<Users> users, ArrayList<String> commands) {
        users.clear();
        streams.clear();
        streamers.clear();
        commands.clear();

        //Singletons for the classes
        UserSingleton userSingleton = UserSingleton.getInstance();
        StreamerSingleton streamerSingleton = StreamerSingleton.getInstance();
        StreamSingleton streamSingleton = StreamSingleton.getInstance();

        for (int i = 0; i < 4; i++) {
            if (i == 0)
                streamerSingleton.setStreamers(ReadFile.readFromFileStreamers(args[i], streamers));
            if (i == 1)
                streamSingleton.setStreams(ReadFile.readFromFileStreams(args[i], streams));
            if (i == 2)
                userSingleton.setUsers(ReadFile.readFromFileUsers(args[i], users));
            if (i == 3) {
                ArrayList <Streams> newStreams = streamSingleton.getStreams();
                Collections.reverse(newStreams);
                commands = ReadFile.readFileFromCommands(args[i]);
                //Variable to check if I shoult print a comma or not
                int dummy = 0;

                //List FOR USERS
                for (int a = 0; a < commands.size(); a++) {
                    commandId = Integer.parseInt(commands.get(a).split(" ")[0]);
                    command = commands.get(a).split(" ")[1];
                    ArrayList <String> text = new ArrayList<>();
                    text.clear();
                    if(command.equals("LIST")) {
                        if(dummy == 0) System.out.print("[");
                        int numberUsers = 0;
                        for (int k = 0; k < userSingleton.getUsers().size(); k++) {
                            if (userSingleton.getUsers().get(k).getId() == commandId) {
                                for (int j = 0; j < userSingleton.getUsers().get(k).getStreams().size(); j++) {
                                    if(numberUsers > 0) {
                                        System.out.print(",");
                                    }
                                    else if(dummy != 0){
                                        System.out.print("\n");
                                        System.out.print("[");
                                    }
                                    numberUsers++;
                                dummy ++;
                                streamerSingleton.getStreamers().get(k).print(userSingleton.getUsers(),
                                        streamSingleton.getStreams(),streamerSingleton.getStreamers(),k,j);
                                }
                            }
                        }

                        //List FOR STREAMERS
                        int numberStreams = 0;
                        text.clear();
                        for (Streams newStream : newStreams) {
                            if (newStream.getStreamCommon().getStreamerId() == commandId) {
                                if (numberStreams > 0) {
                                    text.add(",");
                                } else if (dummy != 0) {
                                    text.add("\n");
                                    text.add("[");
                                }
                                dummy++;
                                numberStreams++;
                                //putting the data in the text array for reversing the output
                                text.add("{\"id\":" + "\"" + newStream.getId() +
                                        "\"" + "," +
                                        "\"name\":" + "\"" + newStream.getName() +
                                        "\"" + "," +
                                        "\"streamerName\":" + "\"" + Streamers.getStreamerName(commandId,
                                        streamerSingleton.getStreamers()) +
                                        "\"" + "," +
                                        "\"noOfListenings\":" + "\"" + newStream.getNoOfStreams() +
                                        "\"" + "," +
                                        "\"length\":" + "\"" + Streamers.hourMinutesSeconds
                                        (newStream.getLength()) +
                                        "\"" + "," +
                                        "\"dateAdded\":" + "\"" + Streamers.convertDate
                                        (newStream.getDateAdded()) +
                                        "\"" + "}");
                            }
                        }
                        text.add("]");
                        for (String s : text) System.out.print(s);

                    }

                    if(command.equals("ADD")){
                        AddCommand addCommand = new AddCommand();
                        addCommand.exec(dummy, userSingleton.getUsers(),
                                streamSingleton.getStreams(), streamerSingleton.getStreamers(),
                                commands, a, commandId);
                    }

                    if(command.equals("DELETE")) {
                        DeleteCommand deleteCommand = new DeleteCommand();
                        deleteCommand.exec(dummy, userSingleton.getUsers(),
                                streamSingleton.getStreams(), streamerSingleton.getStreamers(),
                                commands, a, commandId);
                    }

                    if(command.equals("LISTEN")){
                        ListenCommand listenCommand = new ListenCommand();
                        listenCommand.exec(dummy, userSingleton.getUsers(),
                                streamSingleton.getStreams(), streamerSingleton.getStreamers(),
                                commands, a, commandId);
                    }

                    if (command.equals("RECOMMEND")){
                        RecommendCommand recommendCommand = new RecommendCommand();
                        recommendCommand.exec(dummy, userSingleton.getUsers(),
                                streamSingleton.getStreams(), streamerSingleton.getStreamers(),
                                commands, a, commandId);
                    }

                    else if (command.equals("SURPRISE")){
                        SurpriseCommand surpriseCommand = new SurpriseCommand();
                        surpriseCommand.exec(dummy, userSingleton.getUsers(),
                                streamSingleton.getStreams(), streamerSingleton.getStreamers(),
                                commands, a, commandId);
                    }
                }
            }
        }
    }
}

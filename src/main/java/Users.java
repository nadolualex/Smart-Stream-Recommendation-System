import java.util.ArrayList;
import java.util.List;

public class Users {
    private Integer id;
    private String name;
    private List<Integer> streams;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getStreams() {
        return streams;
    }

    public void setStreams(List<Integer> streams) {
        this.streams = streams;
    }

    public void addStream(int parseInt) {
        streams.add(parseInt);
    }

}

import java.util.List;

public class UsersBuilder {
    private final Users user = new Users();

    public UsersBuilder withId(Integer id) {
        user.setId(id);
        return this;
    }

    public UsersBuilder withName(String name) {
        user.setName(name);
        return this;
    }

    public UsersBuilder withStreams(List<Integer> streams) {
        user.setStreams(streams);
        return this;
    }

    public Users build() {
        return user;
    }

}

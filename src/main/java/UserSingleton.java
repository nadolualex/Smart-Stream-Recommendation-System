import java.util.ArrayList;

public class UserSingleton {
        private static UserSingleton instance = null;
        private ArrayList<Users> users;
        private UserSingleton() {
            users = new ArrayList<>();
        }
        public static UserSingleton getInstance() {
            if (instance == null) {
                instance = new UserSingleton();
            }
            return instance;
        }

    public static void setInstance(UserSingleton instance) {
        UserSingleton.instance = instance;
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }
}

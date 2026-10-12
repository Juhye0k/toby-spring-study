import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new DaoFactory().userDao();
        User user = new User();
        user.setId("test");
        user.setName("test");
        user.setPassword("");

        dao.add(user);
        System.out.println(user);

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
    }
}

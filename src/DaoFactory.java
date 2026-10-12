
public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }
    public UserDao accountDao() {
        return new UserDao(connectionMaker());
    }
    public UserDao messageDao() {
        return new UserDao(connectionMaker());
    }
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}

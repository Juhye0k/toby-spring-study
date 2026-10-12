import java.sql.*;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        connectionMaker = connectionMaker
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby", "root", "1234");

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        Class.forName("com.mysql.jdbc.Driver");
        // DB를 위한 커넥션 가져오기
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby", "root", "1234");

        // SQL을 담은 PreparedStatement
        PreparedStatement ps = c.prepareStatement("select * from users where id=?");
        ps.setString(1, id);

        // 쿼리 실행결과 ResultSet으로 받기
        ResultSet rs = ps.executeQuery();
        rs.next();

        // 저장할 오브젝트
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}

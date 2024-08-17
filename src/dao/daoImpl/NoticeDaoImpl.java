package dao.daoImpl;

import common.ErrorCode;
import config.ConnectionFactory;
import dao.NoticeDao;
import dto.request.NoticeRequestDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDaoImpl implements NoticeDao {

    private static Connection connection = null;
    private static ResultSet rs = null;

    @Override
    public void createNotice(NoticeRequestDto request) {
        connection = ConnectionFactory.getInstance().open();
        String query = new StringBuilder()
            .append("INSERT INTO Notice ")
            .append("(author, title, content, created_at)")
            .append("VALUES (?, ?, ?, ?)").toString();

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, request.getAuthor());
            pstmt.setString(2, request.getTitle());
            pstmt.setString(3, request.getContent());
            pstmt.setString(4, request.getCreated_at());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            ConnectionFactory.getInstance().close();
        }
    }
}

package dao.daoImpl;

import config.ConnectionFactory;
import dao.SectionDao;
import dto.SectionDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoImpl implements SectionDao {
    static ConnectionFactory factory = new ConnectionFactory().getInstance();
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection con = null;

    @Override
    public List<SectionDto> findAll() {
        List<SectionDto> sectionAll = new ArrayList<>();
        con = factory.open();

        String query = "SELECT * FROM section";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int warehouse_id = rs.getInt("warehouse_id");
                double size = rs.getDouble("size");

                SectionDto dto = new SectionDto(id, warehouse_id, size);
                sectionAll.add(dto);
            }

            pstmt.close();
            rs.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            System.err.println("커넥션 에러");
        }

        return sectionAll;
    }

    @Override
    public SectionDto findById(int id) {
        SectionDto findId = null;

        con = factory.open();

        String query = "SELECT * FROM cell WHERE id = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()){
                int cell_id = rs.getInt("id");
                int section_id = rs.getInt("warehouse_id");
                double size = rs.getDouble("size");

                findId = new SectionDto(
                        cell_id,
                        section_id,
                        size);
            }
            pstmt.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findId;
    }
}

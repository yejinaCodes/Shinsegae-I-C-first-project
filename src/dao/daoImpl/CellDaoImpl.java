package dao.daoImpl;

import config.ConnectionFactory;
import dao.CellDao;
import dto.CellDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CellDaoImpl implements CellDao {
    static ConnectionFactory factory = new ConnectionFactory().getInstance();
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection con = null;

    @Override
    public List<CellDto> findAll() {
        List<CellDto> CellAll = new ArrayList<>();
        con = factory.open();

        String query = "SELECT * FROM cell";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                int section_id = rs.getInt("section_id");
                double size = rs.getDouble("size");
                int total_capacity = rs.getInt("total_capacity");
                int available_capacity = rs.getInt("available_capacity");
                CellDto dto = new CellDto(id, section_id,total_capacity ,size , available_capacity);
                CellAll.add(dto);
            }

            pstmt.close();
            rs.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            System.err.println("커넥션 에러");
        }

        return CellAll;
    }

    @Override
    public CellDto findById(int id) {
        CellDto findId = null;

        con = factory.open();

        String query = "SELECT * FROM cell WHERE id = ?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();

            while (rs.next()){
                int cell_id = rs.getInt("id");
                int section_id = rs.getInt("section_id");
                int total_capacity = rs.getInt("total_capacity");
                int available_capacity = rs.getInt("available_capacity");
                double size = rs.getDouble("size");

                findId = new CellDto(
                        cell_id,
                        section_id,
                        total_capacity,
                        size,
                        available_capacity);
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

package dao.daoImpl;

import config.ConnectionFactory;
import dao.WarehouseDao;
import dto.WarehouseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao {
    static ConnectionFactory factory = new ConnectionFactory().getInstance();
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    static Connection con = null;

    @Override
    public List<WarehouseDto> findAll() {
        List<WarehouseDto> warehouseAll = new ArrayList<>();
        con = factory.open();

        String query = "SELECT * FROM warehouse";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String number = rs.getString("number");
                double size = rs.getDouble("size");

                WarehouseDto dto = new WarehouseDto(id, name, city, number, size);
                warehouseAll.add(dto);
            }

            pstmt.close();
            rs.close();
            con.close();
            factory.close();
        } catch (SQLException e) {
            System.err.println("커넥션 에러");
        }

        return warehouseAll;
    }
}

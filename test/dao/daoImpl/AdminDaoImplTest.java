package dao.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import config.ConnectionFactory;
import dto.AdminDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class AdminDaoImplTest {

    @Mock
    private Connection mockConn;

    @Mock
    private PreparedStatement mockPs;

    private AdminDaoImpl adminDao;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        adminDao = new AdminDaoImpl();

        ConnectionFactory mockCf = mock(ConnectionFactory.class);
        when(mockCf.open()).thenReturn(mockConn);

        when(mockConn.prepareStatement(anyStrubg())).thenReturn(mockPs);

        adminDao.setConnectionFactory(mockCf);
    }

    @Test
    void createAdmin() {
        AdminDto admin = new AdminDto("신짱구", "shinZZ", "shin123!^", "shin@gmail.com", "01012345678", "01284", "서울시 서초구 반포동");

        adminDao.createAdmin(admin);

        verify(mockConnection).prepareStatement(anyString());
        verify(mockPreparedStatement).setString(1, adminDto.getName());
        verify(mockPreparedStatement).setString(2, adminDto.getAdminId());
        verify(mockPreparedStatement).setString(3, adminDto.getPassword());
        verify(mockPreparedStatement).setString(4, adminDto.getEmail());
        verify(mockPreparedStatement).setString(5, adminDto.getCompanyEmail());
        verify(mockPreparedStatement).setInt(6, adminDto.getPhone());
        verify(mockPreparedStatement).setString(7, adminDto.getZipCode());
        verify(mockPreparedStatement).setString(8, adminDto.getAddress());
    }
}
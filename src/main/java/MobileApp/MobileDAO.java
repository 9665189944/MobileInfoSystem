package MobileApp;

import java.sql.*;
import java.util.ArrayList;

public class MobileDAO {
    static Connection con=null;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertMobileRecord(MobileDTO m1)
    {

            PreparedStatement pstmt=null;
            int count=0;
            String query="insert into Mobile_info values(?,?,?,?,?,?)";
            try {
                pstmt=con.prepareStatement(query);
                pstmt.setInt(1,m1.getMobileNo());
                pstmt.setString(2,m1.getModelName());
                pstmt.setString(3,m1.getCompany());
                pstmt.setInt(4,m1.getRam());
                pstmt.setInt(5,m1.getCamera());
                pstmt.setDouble(6,m1.getPrice());

                count=pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return count;
        }

       ArrayList<MobileDTO> data=new ArrayList<>();;
      public ArrayList<MobileDTO> diasplayModelName(MobileDTO cname)
      {


          PreparedStatement pstmt=null;
          ResultSet rs=null;
          String query="select Model_Name from Mobile_info where Compnay=? ";
          try {
              pstmt=con.prepareStatement(query);
              pstmt.setString(1,cname.getCompany());
              rs=pstmt.executeQuery();
              while (rs.next())
              {
                  MobileDTO m1=new MobileDTO();
                  m1.setModelName(rs.getString("Model_Name"));
                  data.add(m1);
              }

          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
          return data;
      }

    public ArrayList<MobileDTO> desplayDetailsByPrice(double price1,double price2)
    {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select * from Mobile_info where Price between ? and ? ";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setDouble(1,price1);
            pstmt.setDouble(2,price2);
            rs=pstmt.executeQuery();
            ArrayList<MobileDTO> da=record(rs);
                 data=da;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public  ArrayList<MobileDTO> displayDetailsByRam(int ram)
    {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select * from Mobile_info where RAM=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,ram);
            rs=pstmt.executeQuery();
            ArrayList<MobileDTO> data1=record(rs);
                     data=data1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
    public ArrayList<MobileDTO> desplayDetailsByCameraBet(int cam1,int cam2)
    {
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String query="select * from Mobile_info where Camera between ? and ? ";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,cam1);
            pstmt.setInt(2,cam2);
            rs=pstmt.executeQuery();
            ArrayList<MobileDTO> da=record(rs);
            data=da;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public int deleteMobileRecord(MobileDTO d1)
    {
        PreparedStatement pstmt=null;
        int count=0;
        String query="delete from Mobile_info where  Model_No=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,d1.getMobileNo());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public  ArrayList<MobileDTO>  record(ResultSet rs) throws SQLException {

        while (rs.next())
        {
            MobileDTO m1=new MobileDTO();
            m1.setMobileNo(rs.getInt("Model_No"));
            m1.setModelName(rs.getString("Model_Name"));
            m1.setCompany(rs.getString("Compnay"));
            m1.setRam(rs.getInt("Ram"));
            m1.setCamera(rs.getInt("Camera"));
            m1.setPrice(rs.getDouble("Price"));
            data.add(m1);
        }
        return data;
    }


}

import java.sql.*;
import java.util.ArrayList;
import java.lang.*;

/**
 * Created by staLker on 21-08-2018.
 */
public class NavalMgmtDAO {
    private static final String driver = "org.sqlite.JDBC";
    private static final String url = "jdbc:sqlite:C:/Users/staLker/Desktop/GitHubLocal/ProjectsDemo/demo/src\\database";
    private static final String username = "";
    private static final String password = "";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;



    public int addNavalOfficer(NavalOfficer navalOfficer){
        String query1 = "INSERT INTO NavalOfficer VALUES (?,?,?,?,?);";
        String query2 = "SELECT COUNT(officer_no) FROM NavalOfficer;";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1,navalOfficer.getOfficerNo());
            preparedStatement.setString(2,navalOfficer.getOfficerName());
            preparedStatement.setString(3,navalOfficer.getOfficerRank());
            preparedStatement.setDouble(4,navalOfficer.getOfficerSal());
            preparedStatement.setInt(5,navalOfficer.getBaseCampID());
            int count = preparedStatement.executeUpdate();
            if(count == 1){
                System.out.println("Officer Added Successfully");
            }
            else {
                System.out.println("Error!");
            }
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query2);
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return -1;
    }
    public int addBaseCamp(BaseCamp baseCamp){
        String query1 = "INSERT INTO BaseCamp VALUES (?,?,?);";
        String query2 = "SELECT COUNT(base_id) FROM BaseCamp;";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            preparedStatement = connection.prepareStatement(query1);
            preparedStatement.setInt(1,baseCamp.getBaseCampId());
            preparedStatement.setString(2,baseCamp.getBaseCampName());
            preparedStatement.setString(3,baseCamp.getBaseCampLoc());
            int count = preparedStatement.executeUpdate();
            if(count == 1){
                System.out.println("BaseCamp Added Successfully");
            }
            else {
                System.out.println("Error!");
            }
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query2);
            rs.next();
            return rs.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return -1;

    }
    public ArrayList<String> getOfficersNameSortedBySal(){
        ArrayList<String> officersName = new ArrayList<String>();
        String query = "SELECT officer_name FROM NavalOfficer ORDER BY officer_salary ASC";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                officersName.add(resultSet.getString(1));
            }
            return officersName;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public ArrayList<String> getOfficersNameForBaseCampLoc(String i){
        return null;
    }
    public double getOfficersTotalSalOnBaseCamp(int i){
        return 0.0;
    }


}

package com.dao;

import com.model.*;

import java.sql.*;
import java.util.ArrayList;

public class UsersDaoImpl implements UsersDao {
    //检查管理员登录信息是否正确
    public Teachers checkAdLogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM Lupy_Teachers15 WHERE lpy_Tauthoritylevel15='管理员' AND lpy_Tno15=? AND lpy_Tpassword15=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getLpy_Tno15());
            pstmt.setString(2,teachers.getLpy_Tpassword15());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teachers1.setLpy_Collegeno15(rst.getString("lpy_Collegeno15"));
                teachers1.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teachers1.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                teachers1.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                teachers1.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                teachers1.setLpy_Tpassword15(rst.getString("lpy_Tpassword15"));
                teachers1.setLpy_Tauthoritylevel15(rst.getString("lpy_Tauthoritylevel15"));
                teachers1.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teachers1;
    }
    //检查普通教师登录信息是否正确
    public Teachers checkTeaLogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM Lupy_Teachers15 WHERE (lpy_Tauthoritylevel15='普通教师' OR lpy_Tauthoritylevel15='管理员') AND lpy_Tno15=? AND lpy_Tpassword15=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getLpy_Tno15());
            pstmt.setString(2,teachers.getLpy_Tpassword15());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teachers1.setLpy_Collegeno15(rst.getString("lpy_Collegeno15"));
                teachers1.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teachers1.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                teachers1.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                teachers1.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                teachers1.setLpy_Tpassword15(rst.getString("lpy_Tpassword15"));
                teachers1.setLpy_Tauthoritylevel15(rst.getString("lpy_Tauthoritylevel15"));
                teachers1.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teachers1;
    }
    //检查学生登录方法
    public Students checkStuLogin(Students students) throws DaoException{
        String sql = "SELECT * FROM Lupy_Students15 WHERE lpy_Sno15=? AND lpy_Spassword15=?";
        Students students1 = new Students();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,students.getLpy_Sno15());
            pstmt.setString(2,students.getLpy_Spassword15());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                students1.setLpy_Sno15(rst.getString("lpy_Sno15"));
                students1.setLpy_Classno15(rst.getString("lpy_Classno15"));
                students1.setLpy_Mno15(rst.getString("lpy_Mno15"));
                students1.setLpy_Sname15(rst.getString("lpy_Sname15"));
                students1.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                students1.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                students1.setLpy_Spassword15(rst.getString("lpy_Spassword15"));
                students1.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                students1.setLpy_Scredit15(rst.getDouble("lpy_Scredit15"));
                students1.setLpy_Savggpa15(rst.getDouble("lpy_Savggpa15"));
                students1.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return students1;
    }
    //修改教师信息
    public boolean changeTeaInfo(Teachers teachers) throws DaoException{
        String sql="UPDATE Lupy_Teachers15 SET lpy_Tno15=?,lpy_Tname15=?,lpy_Tsex15=?,lpy_Tage15=?,lpy_Tprofess15=?,lpy_Tphone15=? WHERE lpy_Tno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,teachers.getLpy_Tno15());
            pstmt.setString(2,teachers.getLpy_Tname15());
            pstmt.setString(3,teachers.getLpy_Tsex15());
            pstmt.setInt(4,teachers.getLpy_Tage15());
            pstmt.setString(5,teachers.getLpy_Tprofess15());
            pstmt.setString(6,teachers.getLpy_Tphone15());
            pstmt.setString(7,teachers.getLpy_Tno15());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //修改学生信息
    public boolean changeStuInfo(Students students) throws DaoException{
        String sql="UPDATE Lupy_Students15 SET lpy_Sno15=?,lpy_Sname15=?,lpy_Ssex15=?,lpy_Sage15=?,lpy_Sphone15=?,lpy_Shometown15=? WHERE lpy_Sno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,students.getLpy_Sno15());
            pstmt.setString(2,students.getLpy_Sname15());
            pstmt.setString(3,students.getLpy_Ssex15());
            pstmt.setInt(4,students.getLpy_Sage15());
            pstmt.setString(5,students.getLpy_Sphone15());
            pstmt.setString(6,students.getLpy_Shometown15());
            pstmt.setString(7,students.getLpy_Sno15());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据工号查询教师
    public Teachers findTeaByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM Lupy_Teachers15 WHERE lpy_Tno15=?";
        Teachers teachers=new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    teachers.setLpy_Tno15(rst.getString("lpy_Tno15"));
                    teachers.setLpy_Collegeno15(rst.getString("lpy_Collegeno15"));
                    teachers.setLpy_Tname15(rst.getString("lpy_Tname15"));
                    teachers.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                    teachers.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                    teachers.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                    teachers.setLpy_Tpassword15(rst.getString("lpy_Tpassword15"));
                    teachers.setLpy_Tauthoritylevel15(rst.getString("lpy_Tauthoritylevel15"));
                    teachers.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return teachers;
    }
    //根据学号查询学生
    public Students findStuByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM Lupy_Students15 WHERE lpy_Sno15=?";
        Students students=new Students();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    students.setLpy_Sno15(rst.getString("lpy_Sno15"));
                    students.setLpy_Classno15(rst.getString("lpy_Classno15"));
                    students.setLpy_Mno15(rst.getString("lpy_Mno15"));
                    students.setLpy_Sname15(rst.getString("lpy_Sname15"));
                    students.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                    students.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                    students.setLpy_Spassword15(rst.getString("lpy_Spassword15"));
                    students.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                    students.setLpy_Scredit15(rst.getDouble("lpy_Scredit15"));
                    students.setLpy_Savggpa15(rst.getDouble("lpy_Savggpa15"));
                    students.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return students;
    }
    //修改教师密码
    public boolean changeTeaPassword(Teachers teachers) throws DaoException{
        String sql="UPDATE Lupy_Teachers15 SET lpy_Tpassword15=? WHERE lpy_Tno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,teachers.getLpy_Tpassword15());
            pstmt.setString(2,teachers.getLpy_Tno15());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //修改学生密码
    public boolean changeStuPassword(Students students) throws DaoException{
        String sql="UPDATE Lupy_Students15 SET lpy_Spassword15=? WHERE lpy_Sno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,students.getLpy_Spassword15());
            pstmt.setString(2,students.getLpy_Sno15());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //查询所有课平均成绩
    public ArrayList<AvgScore> allAvgScore() throws DaoException{
        ArrayList<AvgScore> scoreList = new ArrayList<AvgScore>();
        String sql = "SELECT * FROM lupy_avgscore_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                AvgScore avgScore = new AvgScore();
                avgScore.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                avgScore.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                avgScore.setLpy_Courseavgscore15(rst.getDouble("lpy_Courseavgscore15"));
                scoreList.add(avgScore);
            }
            return scoreList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询平均成绩
    public ArrayList<AvgScore> findByFuzzyAvgScore(String info) throws DaoException{
        ArrayList<AvgScore> scoreList = new ArrayList<AvgScore>();
        String sql="SELECT * FROM lupy_avgscore_view15 WHERE lpy_Courseno15 like ? OR lpy_Coursename15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                AvgScore avgScore = new AvgScore();
                avgScore.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                avgScore.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                avgScore.setLpy_Courseavgscore15(rst.getDouble("lpy_Courseavgscore15"));
                scoreList.add(avgScore);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return scoreList;
    }
    //查询所有学生信息
    public ArrayList<StuInfo> AllStuInfo() throws DaoException{
        ArrayList<StuInfo> stuList = new ArrayList<StuInfo>();
        String sql = "SELECT * FROM lupy_stuinfo_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                StuInfo stuInfo=new StuInfo();
                stuInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuInfo.setLpy_Sclass15(rst.getString("lpy_Sclass15"));
                stuInfo.setLpy_Smajor15(rst.getString("lpy_Smajor15"));
                stuInfo.setLpy_Scollege15(rst.getString("lpy_Scollege15"));
                stuInfo.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                stuInfo.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                stuInfo.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                stuInfo.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                stuList.add(stuInfo);
            }
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询所有教师信息
    public ArrayList<TeaInfo> AllTeaInfo() throws DaoException{
        ArrayList<TeaInfo> teaList = new ArrayList<TeaInfo>();
        String sql = "SELECT * FROM lupy_teainfo_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                TeaInfo teaInfo=new TeaInfo();
                teaInfo.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teaInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teaInfo.setLpy_Tcollege15(rst.getString("lpy_Tcollege15"));
                teaInfo.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                teaInfo.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                teaInfo.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                teaInfo.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
                teaList.add(teaInfo);
            }
            return teaList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //根据学号删除学生信息
    public boolean deleteStu(String no)throws DaoException{
        String sql="DELETE FROM Lupy_Students15 WHERE lpy_Sno15=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据教师工号删除教师信息
    public boolean deleteTea(String no)throws DaoException{
        String sql="DELETE FROM Lupy_Teachers15 WHERE lpy_Tno15=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //模糊查询学生信息
    public ArrayList<StuInfo> findByFuzzyStuInfo(String info)throws DaoException{
        ArrayList<StuInfo> stuList=new ArrayList<StuInfo>();
        String sql="SELECT * FROM lupy_stuinfo_view15 WHERE lpy_Sname15 like ? OR lpy_Sno15 like ? OR lpy_Sclass15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuInfo stuInfo=new StuInfo();
                stuInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuInfo.setLpy_Sclass15(rst.getString("lpy_Sclass15"));
                stuInfo.setLpy_Smajor15(rst.getString("lpy_Smajor15"));
                stuInfo.setLpy_Scollege15(rst.getString("lpy_Scollege15"));
                stuInfo.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                stuInfo.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                stuInfo.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                stuInfo.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                stuList.add(stuInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //模糊查询教师信息
    public ArrayList<TeaInfo> findByFuzzyTeaInfo(String info)throws DaoException{
        ArrayList<TeaInfo> teaList=new ArrayList<TeaInfo>();
        String sql="SELECT * FROM lupy_teainfo_view15 WHERE lpy_Tname15 like ? OR lpy_Tno15 like ? OR lpy_Tcollege15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaInfo teaInfo=new TeaInfo();
                teaInfo.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teaInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teaInfo.setLpy_Tcollege15(rst.getString("lpy_Tcollege15"));
                teaInfo.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                teaInfo.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                teaInfo.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                teaInfo.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
                teaList.add(teaInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //根据工号查询教师信息
    public TeaInfo findTeaInfoByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM lupy_teainfo_view15 WHERE lpy_Tno15=?";
        TeaInfo teaInfo=new TeaInfo();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    teaInfo.setLpy_Tno15(rst.getString("lpy_Tno15"));
                    teaInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                    teaInfo.setLpy_Tcollege15(rst.getString("lpy_Tcollege15"));
                    teaInfo.setLpy_Tsex15(rst.getString("lpy_Tsex15"));
                    teaInfo.setLpy_Tage15(rst.getInt("lpy_Tage15"));
                    teaInfo.setLpy_Tprofess15(rst.getString("lpy_Tprofess15"));
                    teaInfo.setLpy_Tphone15(rst.getString("lpy_Tphone15"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return teaInfo;
    }
    //根据学号查询学生信息
    public StuInfo findStuInfoByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM lupy_stuinfo_view15 WHERE lpy_Sno15=?";
        StuInfo stuInfo=new StuInfo();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    stuInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                    stuInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                    stuInfo.setLpy_Sclass15(rst.getString("lpy_Sclass15"));
                    stuInfo.setLpy_Smajor15(rst.getString("lpy_Smajor15"));
                    stuInfo.setLpy_Scollege15(rst.getString("lpy_Scollege15"));
                    stuInfo.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                    stuInfo.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                    stuInfo.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                    stuInfo.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return stuInfo;
    }
    //添加教师
    public boolean addTeacher (Teachers teachers) throws DaoException{
        String sql = "INSERT INTO Lupy_Teachers15 VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,teachers.getLpy_Tno15());
            pstmt.setString(2,teachers.getLpy_Collegeno15());
            pstmt.setString(3,teachers.getLpy_Tname15());
            pstmt.setString(4,teachers.getLpy_Tsex15());
            pstmt.setInt(5,teachers.getLpy_Tage15());
            pstmt.setString(6,teachers.getLpy_Tprofess15());
            pstmt.setString(7,"123456");
            pstmt.setString(8,teachers.getLpy_Tauthoritylevel15());
            pstmt.setString(9,teachers.getLpy_Tphone15());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //添加学生
    public boolean addStudent (Students students) throws DaoException{
        String sql = "INSERT INTO Lupy_Students15 VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,students.getLpy_Sno15());
            pstmt.setString(2,students.getLpy_Classno15());
            pstmt.setString(3,students.getLpy_Mno15());
            pstmt.setString(4,students.getLpy_Sname15());
            pstmt.setString(5,students.getLpy_Ssex15());
            pstmt.setInt(6,students.getLpy_Sage15());
            pstmt.setString(7,"123456");
            pstmt.setString(8,students.getLpy_Sphone15());
            pstmt.setDouble(9,0);
            pstmt.setDouble(10,0);
            pstmt.setString(11,students.getLpy_Shometown15());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //查询所有学生成绩信息
    public ArrayList<StuGradeInfo> allStuGradeInfo() throws DaoException{
        ArrayList<StuGradeInfo> stuList = new ArrayList<StuGradeInfo>();
        String sql = "SELECT * FROM lupy_grade_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyStuGradeInfo(String info) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE lpy_Sname15 like ? OR lpy_Sno15 like ? OR lpy_Coursename15 like ? OR lpy_Tname15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据教师模糊查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyTeaStuGradeInfo(String info,String tea) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE (lpy_Sname15 like ? OR lpy_Sno15 like ? OR lpy_Coursename15 like ? OR lpy_Classname15 like ?) AND lpy_Tname15 = ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            pstmt.setString(5,tea);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据学期查询成绩信息
    public ArrayList<StuGradeInfo> termStuGradeInfo(String term) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE lpy_Cterm15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,term);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据学年查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyYearGradeInfo(String info) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE lpy_Cterm15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据教师和学期查询成绩信息
    public ArrayList<StuGradeInfo> termTeaStuGradeInfo(String term,String tea) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE lpy_Cterm15=? AND lpy_Tname15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,term);
            pstmt.setString(2,tea);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据教师和学年查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyYearTeaGradeInfo(String info,String tea) throws DaoException{
        ArrayList<StuGradeInfo> stuList=new ArrayList<StuGradeInfo>();
        String sql="SELECT * FROM lupy_grade_view15 WHERE lpy_Cterm15 like ? AND lpy_Tname15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,tea);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuList.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据学号和课程名查询成绩信息
    public StuGradeInfo findTeaGradeInfoBySnoAndName(String no,String name) throws DaoException{
        String sql = "SELECT * FROM lupy_grade_view15 WHERE lpy_Sno15=? AND lpy_Coursename15=?";
        StuGradeInfo stuGradeInfo=new StuGradeInfo();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            pstmt.setString(2,name);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                    stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                    stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                    stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                    stuGradeInfo.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                    stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                    stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                    stuGradeInfo.setLpy_Tname15(rst.getString("lpy_Tname15"));
                    stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return stuGradeInfo;
    }
    //查询所有学生排名
    public ArrayList<StuRank> allStuRank() throws DaoException{
        ArrayList<StuRank> stuList = new ArrayList<StuRank>();
        String sql = "SELECT * FROM lupy_rank_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                StuRank stuRank=new StuRank();
                stuRank.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuRank.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuRank.setLpy_AvgGpa15(rst.getDouble("lpy_AvgGpa15"));
                stuRank.setLpy_Rank15(rst.getInt("lpy_Rank15"));
                stuList.add(stuRank);
            }
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询学生排名
    public ArrayList<StuRank> findByFuzzyStuRank(String info) throws DaoException{
        ArrayList<StuRank> stuList = new ArrayList<StuRank>();
        String sql="SELECT * FROM lupy_rank_view15 WHERE lpy_Sname15 like ? OR lpy_Sno15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuRank stuRank=new StuRank();
                stuRank.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuRank.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuRank.setLpy_AvgGpa15(rst.getDouble("lpy_AvgGpa15"));
                stuRank.setLpy_Rank15(rst.getInt("lpy_Rank15"));
                stuList.add(stuRank);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //查询所有学生
    public ArrayList<Students> allStu() throws DaoException{
        ArrayList<Students> stuList = new ArrayList<Students>();
        String sql = "SELECT * FROM Lupy_Students15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                Students students1=new Students();
                students1.setLpy_Sno15(rst.getString("lpy_Sno15"));
                students1.setLpy_Classno15(rst.getString("lpy_Classno15"));
                students1.setLpy_Mno15(rst.getString("lpy_Mno15"));
                students1.setLpy_Sname15(rst.getString("lpy_Sname15"));
                students1.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                students1.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                students1.setLpy_Spassword15(rst.getString("lpy_Spassword15"));
                students1.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                students1.setLpy_Scredit15(rst.getDouble("lpy_Scredit15"));
                students1.setLpy_Savggpa15(rst.getDouble("lpy_Savggpa15"));
                students1.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                stuList.add(students1);
            }
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询学生
    public ArrayList<Students> findByFuzzyStu(String info) throws DaoException{
        ArrayList<Students> stuList = new ArrayList<Students>();
        String sql="SELECT * FROM Lupy_Students15 WHERE lpy_Sname15 like ? OR lpy_Sno15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Students students1=new Students();
                students1.setLpy_Sno15(rst.getString("lpy_Sno15"));
                students1.setLpy_Classno15(rst.getString("lpy_Classno15"));
                students1.setLpy_Mno15(rst.getString("lpy_Mno15"));
                students1.setLpy_Sname15(rst.getString("lpy_Sname15"));
                students1.setLpy_Ssex15(rst.getString("lpy_Ssex15"));
                students1.setLpy_Sage15(rst.getInt("lpy_Sage15"));
                students1.setLpy_Spassword15(rst.getString("lpy_Spassword15"));
                students1.setLpy_Sphone15(rst.getString("lpy_Sphone15"));
                students1.setLpy_Scredit15(rst.getDouble("lpy_Scredit15"));
                students1.setLpy_Savggpa15(rst.getDouble("lpy_Savggpa15"));
                students1.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                stuList.add(students1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //查询所有教师任课
    public ArrayList<TeaCourse> allTeaCourse() throws DaoException{
        ArrayList<TeaCourse> teaList = new ArrayList<TeaCourse>();
        String sql = "SELECT * FROM lupy_teacourse_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                TeaCourse teaCourse=new TeaCourse();
                teaCourse.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teaCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teaCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                teaCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                teaCourse.setLpy_Classno15((rst.getString("lpy_Classno15")));
                teaCourse.setLpy_Classname15(rst.getString("lpy_Classname15"));
                teaList.add(teaCourse);
            }
            return teaList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询教师任课
    public ArrayList<TeaCourse> findByFuzzyTeaCourse(String info) throws DaoException{
        ArrayList<TeaCourse> teaList = new ArrayList<TeaCourse>();
        String sql="SELECT * FROM lupy_teacourse_view15 WHERE lpy_Tname15 like ? OR lpy_Tno15 like ? OR lpy_Courseno15 like ? OR lpy_Coursename15 like ? OR lpy_Classno15 like ? OR lpy_Classname15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            pstmt.setString(5,"%"+info+"%");
            pstmt.setString(6,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCourse teaCourse=new TeaCourse();
                teaCourse.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teaCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teaCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                teaCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                teaCourse.setLpy_Classno15((rst.getString("lpy_Classno15")));
                teaCourse.setLpy_Classname15(rst.getString("lpy_Classname15"));
                teaList.add(teaCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //查询所有班级课程开设情况
    public ArrayList<ClassCourse> allClassCourse() throws DaoException{
        ArrayList<ClassCourse> classCoursesList = new ArrayList<ClassCourse>();
        String sql = "SELECT * FROM lupy_classcourse_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                ClassCourse classCourse=new ClassCourse();
                classCourse.setLpy_Classno15(rst.getString("lpy_Classno15"));
                classCourse.setLpy_Classname15(rst.getString("lpy_Classname15"));
                classCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                classCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                classCourse.setLpy_Ccredit15(rst.getDouble("lpy_Ccredit15"));
                classCourse.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                classCourse.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                classCourse.setLpy_Assessmentmethod15(rst.getString("lpy_Assessmentmethod15"));
                classCoursesList.add(classCourse);
            }
            return classCoursesList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询班级课程开设情况
    public ArrayList<ClassCourse> findByFuzzyClassCourse(String info) throws DaoException{
        ArrayList<ClassCourse> classCoursesList = new ArrayList<ClassCourse>();
        String sql="SELECT * FROM lupy_classcourse_view15 WHERE lpy_Classno15 like ? OR lpy_Classname15 like ? OR lpy_Courseno15 like ? OR lpy_Coursename15 like ? OR lpy_Cterm15 like ? OR lpy_Assessmentmethod15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            pstmt.setString(5,"%"+info+"%");
            pstmt.setString(6,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ClassCourse classCourse=new ClassCourse();
                classCourse.setLpy_Classno15(rst.getString("lpy_Classno15"));
                classCourse.setLpy_Classname15(rst.getString("lpy_Classname15"));
                classCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                classCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                classCourse.setLpy_Ccredit15(rst.getDouble("lpy_Ccredit15"));
                classCourse.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                classCourse.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                classCourse.setLpy_Assessmentmethod15(rst.getString("lpy_Assessmentmethod15"));
                classCoursesList.add(classCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return classCoursesList;
    }
    //查询所有生源地
    public ArrayList<StuAddress> allStuAddress() throws DaoException{
        ArrayList<StuAddress> stuAddresses = new ArrayList<StuAddress>();
        String sql = "SELECT * FROM lupy_stuaddress_view15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                StuAddress stuAddress=new StuAddress();
                stuAddress.setLpy_Shometown15(rst.getString("lpy_Shometown15"));
                stuAddress.setLpy_Num15(rst.getString("lpy_Num15"));
                stuAddresses.add(stuAddress);
            }
            return stuAddresses;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //根据课程名查课程号
    public String queryCoursenoByName(String name) throws DaoException{
        String no=null;
        String sql = "SELECT lpy_Courseno15 FROM Lupy_Courses15 WHERE lpy_Coursename15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                no=rst.getString("lpy_Courseno15");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return no;
    }
    //添加成绩信息
    public boolean addStuGrade(String sno,String courseno,Double grade) throws DaoException{
        String sql = "INSERT INTO Lupy_Report15 VALUES(?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,sno);
            pstmt.setString(2,courseno);
            pstmt.setDouble(3,grade);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //更新绩点
    public boolean updateGPA() throws DaoException{
        String sql = "CALL Lupy_CalculateAllGpa15()";
        try {
            Connection conn = getConnection();
            CallableStatement pstmt = conn.prepareCall(sql);
            pstmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    //根据学号和课程号修改成绩
    public boolean updateGradeBySnoAndCourseno(String sno,String courseno,Double grade) throws DaoException{
        String sql="UPDATE Lupy_Report15 SET lpy_Grade15=? WHERE (lpy_Sno15=? AND lpy_Courseno15=?)";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setDouble(1,grade);
            pstmt.setString(2,sno);
            pstmt.setString(3,courseno);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据学号和课程编号删除成绩信息
    public boolean deleteGradeBySnoAndCourseno(String sno,String courseno) throws DaoException{
        String sql="DELETE FROM Lupy_Report15 WHERE lpy_Sno15=? AND lpy_Courseno15=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sno);
            pstmt.setString(2,courseno);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据教师编号模糊查询教师任课
    public ArrayList<TeaCourse> findByFuzzyTeaCourse(String info,String no) throws DaoException{
        ArrayList<TeaCourse> teaList = new ArrayList<TeaCourse>();
        String sql="SELECT * FROM lupy_teacourse_view15 WHERE (lpy_Tname15 like ? OR lpy_Tno15 like ? OR lpy_Courseno15 like ? OR lpy_Coursename15 like ? OR lpy_Classno15 like ? OR lpy_Classname15 like ?) AND lpy_Tno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            pstmt.setString(5,"%"+info+"%");
            pstmt.setString(6,"%"+info+"%");
            pstmt.setString(7,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCourse teaCourse=new TeaCourse();
                teaCourse.setLpy_Tno15(rst.getString("lpy_Tno15"));
                teaCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                teaCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                teaCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                teaCourse.setLpy_Classno15((rst.getString("lpy_Classno15")));
                teaCourse.setLpy_Classname15(rst.getString("lpy_Classname15"));
                teaList.add(teaCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //教师查询任教课平均成绩
    public ArrayList<AvgScore> allTeaAvgScore(String no) throws DaoException{
        ArrayList<AvgScore> scoreList = new ArrayList<AvgScore>();
        String sql = "SELECT lupy_avgscore_view15.lpy_Courseno15,lupy_avgscore_view15.lpy_Coursename15,lupy_avgscore_view15.lpy_Courseavgscore15 FROM lupy_avgscore_view15,Lupy_Courses15 WHERE lupy_avgscore_view15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND Lupy_Courses15.lpy_Tno15=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1,no);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                AvgScore avgScore = new AvgScore();
                avgScore.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                avgScore.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                avgScore.setLpy_Courseavgscore15(rst.getDouble("lpy_Courseavgscore15"));
                scoreList.add(avgScore);
            }
            return scoreList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //教师模糊查询任教课平均成绩
    public ArrayList<AvgScore> findByFuzzyTeaAvgScore(String info,String no) throws DaoException{
        ArrayList<AvgScore> scoreList = new ArrayList<AvgScore>();
        String sql = "SELECT lupy_avgscore_view15.lpy_Courseno15,lupy_avgscore_view15.lpy_Coursename15,lupy_avgscore_view15.lpy_Courseavgscore15 FROM lupy_avgscore_view15,Lupy_Courses15 WHERE (lupy_avgscore_view15.lpy_Courseno15 like ? OR lupy_avgscore_view15.lpy_Coursename15 like ?) AND lupy_avgscore_view15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND Lupy_Courses15.lpy_Tno15=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1,info);
            pstmt.setString(2,info);
            pstmt.setString(3,no);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                AvgScore avgScore = new AvgScore();
                avgScore.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                avgScore.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                avgScore.setLpy_Courseavgscore15(rst.getDouble("lpy_Courseavgscore15"));
                scoreList.add(avgScore);
            }
            return scoreList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //根据课程名和教师编号查询课程排名
    public ArrayList<StuCourseRank> findStuCourseRank(String name,String no) throws DaoException{
        ArrayList<StuCourseRank> stuCourseRanksList = new ArrayList<StuCourseRank>();
        String sql = "SELECT lpy_Sno15,lpy_Sname15,lupy_grade_view15.lpy_Courseno15,lupy_grade_view15.lpy_Coursename15,lpy_Grade15,RANK()OVER(ORDER BY lpy_Grade15 DESC) lpy_Rank15 FROM lupy_grade_view15,lupy_teacourse_view15 WHERE lupy_grade_view15.lpy_Courseno15=lupy_teacourse_view15.lpy_Courseno15  AND lupy_teacourse_view15.lpy_Tno15=? AND lupy_grade_view15.lpy_Coursename15=? AND lupy_grade_view15.lpy_Classname15=lupy_teacourse_view15.lpy_Classname15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setString(1,no);
            pstmt.setString(2,name);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                StuCourseRank stuCourseRank = new StuCourseRank();
                stuCourseRank.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuCourseRank.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuCourseRank.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuCourseRank.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuCourseRank.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuCourseRank.setLpy_Rank15(rst.getInt("lpy_Rank15"));
                stuCourseRanksList.add(stuCourseRank);
            }
            return stuCourseRanksList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //根据工号查询教师任课
    public ArrayList<TeaCourse> findByFuzzyOneTeaCourse(String no) throws DaoException{
        ArrayList<TeaCourse> teaList = new ArrayList<TeaCourse>();
        String sql="SELECT lpy_Coursename15 FROM lupy_teacourse_view15 WHERE lpy_Tno15=? GROUP BY lpy_Coursename15";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCourse teaCourse=new TeaCourse();
                teaCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                teaList.add(teaCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //查询学生选修课程
    public ArrayList<StuCourse> findAllStuCourse(String no) throws DaoException{
        ArrayList<StuCourse> stuCourses = new ArrayList<StuCourse>();
        String sql="SELECT Lupy_Students15.lpy_Sno15,Lupy_Students15.lpy_Sname15,Lupy_Class15.lpy_Classno15,Lupy_Class15.lpy_Classname15,Lupy_Courses15.lpy_Courseno15,Lupy_Courses15.lpy_Coursename15,Lupy_Courses15.lpy_Ccredit15,Lupy_Courses15.lpy_Chours15,Lupy_Courses15.lpy_Cterm15,Lupy_Teachers15.lpy_Tname15 FROM Lupy_Students15,Lupy_Setupinfo15,Lupy_Courses15,Lupy_Class15,Lupy_Teachers15 WHERE Lupy_Students15.lpy_Sno15=? AND Lupy_Students15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Setupinfo15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND Lupy_Setupinfo15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Teachers15.lpy_Tno15=Lupy_Courses15.lpy_Tno15";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCourse stuCourse=new StuCourse();
                stuCourse.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuCourse.setLpy_Classno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Classname15(rst.getString("lpy_Classno15"));
                stuCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuCourse.setLpy_Ccredit15(rst.getString("lpy_Ccredit15"));
                stuCourse.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuCourse.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuCourses.add(stuCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuCourses;
    }
    //根据学期查询学生选修课程
    public ArrayList<StuCourse> findAllStuCourse(String no,String term) throws DaoException{
        ArrayList<StuCourse> stuCourses = new ArrayList<StuCourse>();
        String sql="SELECT Lupy_Students15.lpy_Sno15,Lupy_Students15.lpy_Sname15,Lupy_Class15.lpy_Classno15,Lupy_Class15.lpy_Classname15,Lupy_Courses15.lpy_Courseno15,Lupy_Courses15.lpy_Coursename15,Lupy_Courses15.lpy_Ccredit15,Lupy_Courses15.lpy_Chours15,Lupy_Courses15.lpy_Cterm15,Lupy_Teachers15.lpy_Tname15 FROM Lupy_Students15,Lupy_Setupinfo15,Lupy_Courses15,Lupy_Class15,Lupy_Teachers15 WHERE Lupy_Students15.lpy_Sno15=? AND Lupy_Courses15.lpy_Cterm15=? AND Lupy_Students15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Setupinfo15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND Lupy_Setupinfo15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Teachers15.lpy_Tno15=Lupy_Courses15.lpy_Tno15";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            pstmt.setString(2,term);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCourse stuCourse=new StuCourse();
                stuCourse.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuCourse.setLpy_Classno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Classname15(rst.getString("lpy_Classno15"));
                stuCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuCourse.setLpy_Ccredit15(rst.getString("lpy_Ccredit15"));
                stuCourse.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuCourse.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuCourses.add(stuCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuCourses;
    }
    //根据学年查询学生选修课程
    public ArrayList<StuCourse> findAllStuYearCourse(String no,String year) throws DaoException{
        ArrayList<StuCourse> stuCourses = new ArrayList<StuCourse>();
        String sql="SELECT Lupy_Students15.lpy_Sno15,Lupy_Students15.lpy_Sname15,Lupy_Class15.lpy_Classno15,Lupy_Class15.lpy_Classname15,Lupy_Courses15.lpy_Courseno15,Lupy_Courses15.lpy_Coursename15,Lupy_Courses15.lpy_Ccredit15,Lupy_Courses15.lpy_Chours15,Lupy_Courses15.lpy_Cterm15,Lupy_Teachers15.lpy_Tname15 FROM Lupy_Students15,Lupy_Setupinfo15,Lupy_Courses15,Lupy_Class15,Lupy_Teachers15 WHERE Lupy_Students15.lpy_Sno15=? AND Lupy_Courses15.lpy_Cterm15 like ? AND Lupy_Students15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Setupinfo15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND Lupy_Setupinfo15.lpy_Classno15=Lupy_Class15.lpy_Classno15 AND Lupy_Teachers15.lpy_Tno15=Lupy_Courses15.lpy_Tno15";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            pstmt.setString(2,"%"+year+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCourse stuCourse=new StuCourse();
                stuCourse.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuCourse.setLpy_Classno15(rst.getString("lpy_Sno15"));
                stuCourse.setLpy_Classname15(rst.getString("lpy_Classno15"));
                stuCourse.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                stuCourse.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuCourse.setLpy_Ccredit15(rst.getString("lpy_Ccredit15"));
                stuCourse.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuCourse.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuCourse.setLpy_Tname15(rst.getString("lpy_Tname15"));
                stuCourses.add(stuCourse);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuCourses;
    }
    //查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuGrade(String no) throws DaoException{
        ArrayList<StuGradeInfo> stuGradeInfos = new ArrayList<StuGradeInfo>();
        String sql="SELECT lupy_grade_view15.lpy_Sno15,lupy_grade_view15.lpy_Sname15,lupy_grade_view15.lpy_Classname15,lupy_grade_view15.lpy_Coursename15,lupy_grade_view15.lpy_Credit15,Lupy_Courses15.lpy_Chours15,lupy_grade_view15.lpy_Cterm15,lupy_grade_view15.lpy_Grade15,(lupy_grade_view15.lpy_Grade15-50)/10 lpy_Gpa15 FROM lupy_grade_view15,Lupy_Courses15 WHERE lupy_grade_view15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND lupy_grade_view15.lpy_Sno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuGradeInfo.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Gpa15(rst.getDouble("lpy_Gpa15"));
                stuGradeInfos.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuGradeInfos;
    }
    //根据学期查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuGrade(String no,String term) throws DaoException{
        ArrayList<StuGradeInfo> stuGradeInfos = new ArrayList<StuGradeInfo>();
        String sql="SELECT lupy_grade_view15.lpy_Sno15,lupy_grade_view15.lpy_Sname15,lupy_grade_view15.lpy_Classname15,lupy_grade_view15.lpy_Coursename15,lupy_grade_view15.lpy_Credit15,Lupy_Courses15.lpy_Chours15,lupy_grade_view15.lpy_Cterm15,lupy_grade_view15.lpy_Grade15,(lupy_grade_view15.lpy_Grade15-50)/10 lpy_Gpa15 FROM lupy_grade_view15,Lupy_Courses15 WHERE lupy_grade_view15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND lupy_grade_view15.lpy_Sno15=? AND lupy_grade_view15.lpy_Cterm15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            pstmt.setString(2,term);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuGradeInfo.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Gpa15(rst.getDouble("lpy_Gpa15"));
                stuGradeInfos.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuGradeInfos;
    }
    //根据学年查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuYearGrade(String no,String year) throws DaoException{
        ArrayList<StuGradeInfo> stuGradeInfos = new ArrayList<StuGradeInfo>();
        String sql="SELECT lupy_grade_view15.lpy_Sno15,lupy_grade_view15.lpy_Sname15,lupy_grade_view15.lpy_Classname15,lupy_grade_view15.lpy_Coursename15,lupy_grade_view15.lpy_Credit15,Lupy_Courses15.lpy_Chours15,lupy_grade_view15.lpy_Cterm15,lupy_grade_view15.lpy_Grade15,(lupy_grade_view15.lpy_Grade15-50)/10 lpy_Gpa15 FROM lupy_grade_view15,Lupy_Courses15 WHERE lupy_grade_view15.lpy_Courseno15=Lupy_Courses15.lpy_Courseno15 AND lupy_grade_view15.lpy_Sno15=? AND lupy_grade_view15.lpy_Cterm15 like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            pstmt.setString(2,"%"+year+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuGradeInfo stuGradeInfo=new StuGradeInfo();
                stuGradeInfo.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuGradeInfo.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuGradeInfo.setLpy_Classname15(rst.getString("lpy_Classname15"));
                stuGradeInfo.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                stuGradeInfo.setLpy_Credit15(rst.getDouble("lpy_Credit15"));
                stuGradeInfo.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                stuGradeInfo.setLpy_Cterm15(rst.getString("lpy_Cterm15"));
                stuGradeInfo.setLpy_Grade15(rst.getDouble("lpy_Grade15"));
                stuGradeInfo.setLpy_Gpa15(rst.getDouble("lpy_Gpa15"));
                stuGradeInfos.add(stuGradeInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuGradeInfos;
    }
    //查询某个学生排名
    public StuRank findOneRank(String no) throws DaoException{
        StuRank stuRank = new StuRank();
        String sql = "SELECT * FROM lupy_rank_view15 WHERE lpy_Sno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                stuRank.setLpy_Sno15(rst.getString("lpy_Sno15"));
                stuRank.setLpy_Sname15(rst.getString("lpy_Sname15"));
                stuRank.setLpy_AvgGpa15(rst.getDouble("lpy_AvgGpa15"));
                stuRank.setLpy_Rank15(rst.getInt("lpy_Rank15"));
            }
            return stuRank;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询某个学生已修总学分
    public Students findOneCredit(String no) throws DaoException{
        Students students = new Students();
        String sql = "SELECT * FROM Lupy_Students15 WHERE lpy_Sno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                students.setLpy_Sno15(rst.getString("lpy_Sno15"));
                students.setLpy_Sname15(rst.getString("lpy_Sname15"));
                students.setLpy_Scredit15(rst.getDouble("lpy_Scredit15"));
            }
            return students;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //查询所有教师任课
    public ArrayList<Courses> allCourse() throws DaoException{
        ArrayList<Courses> courses = new ArrayList<Courses>();
        String sql = "SELECT Lupy_Teachers15.lpy_Tno15,Lupy_Teachers15.lpy_Tname15,Lupy_Courses15.lpy_Courseno15,Lupy_Courses15.lpy_Coursename15,Lupy_Courses15.lpy_Ccredit15,Lupy_Courses15.lpy_Chours15,Lupy_Courses15.lpy_Cterm15,Lupy_Courses15.lpy_Assessmentmethod15 FROM Lupy_Courses15,Lupy_Teachers15 WHERE Lupy_Courses15.lpy_Tno15=Lupy_Teachers15.lpy_Tno15";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()
        ){
            while(rst.next()){
                Courses courses1=new Courses();
                courses1.setLpy_Tno15(rst.getString("lpy_Tno15"));
                courses1.setLpy_Tname15(rst.getString("lpy_Tname15"));
                courses1.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                courses1.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                courses1.setLpy_Ccredit15((rst.getDouble("lpy_Ccredit15")));
                courses1.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                courses1.setLpy_Cterm15((rst.getString("lpy_Cterm15")));
                courses1.setLpy_Assessmentmethod15(rst.getString("lpy_Assessmentmethod15"));
                courses.add(courses1);
            }
            return courses;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //模糊查询教师任课
    public ArrayList<Courses> findByFuzzyCourse(String info) throws DaoException{
        ArrayList<Courses> courses = new ArrayList<Courses>();
        String sql = "SELECT Lupy_Teachers15.lpy_Tno15,Lupy_Teachers15.lpy_Tname15,Lupy_Courses15.lpy_Courseno15,Lupy_Courses15.lpy_Coursename15,Lupy_Courses15.lpy_Ccredit15,Lupy_Courses15.lpy_Chours15,Lupy_Courses15.lpy_Cterm15,Lupy_Courses15.lpy_Assessmentmethod15 FROM Lupy_Courses15,Lupy_Teachers15 WHERE Lupy_Courses15.lpy_Tno15=Lupy_Teachers15.lpy_Tno15 AND (Lupy_Teachers15.lpy_Tno15 like ? OR Lupy_Teachers15.lpy_Tname15 like ? OR Lupy_Courses15.lpy_Courseno15 like ? OR Lupy_Courses15.lpy_Coursename15 like ? OR Lupy_Courses15.lpy_Cterm15 like ? OR Lupy_Courses15.lpy_Assessmentmethod15 like ?)";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+info+"%");
            pstmt.setString(2,"%"+info+"%");
            pstmt.setString(3,"%"+info+"%");
            pstmt.setString(4,"%"+info+"%");
            pstmt.setString(5,"%"+info+"%");
            pstmt.setString(6,"%"+info+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Courses courses1=new Courses();
                courses1.setLpy_Tno15(rst.getString("lpy_Tno15"));
                courses1.setLpy_Tname15(rst.getString("lpy_Tname15"));
                courses1.setLpy_Courseno15(rst.getString("lpy_Courseno15"));
                courses1.setLpy_Coursename15(rst.getString("lpy_Coursename15"));
                courses1.setLpy_Ccredit15((rst.getDouble("lpy_Ccredit15")));
                courses1.setLpy_Chours15(rst.getDouble("lpy_Chours15"));
                courses1.setLpy_Cterm15((rst.getString("lpy_Cterm15")));
                courses1.setLpy_Assessmentmethod15(rst.getString("lpy_Assessmentmethod15"));
                courses.add(courses1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return courses;
    }
    //添加课程
    public boolean addCourse (Courses courses,String college) throws DaoException{
        String sql = "INSERT INTO Lupy_Courses15 VALUES(?,?,?,?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,courses.getLpy_Courseno15());
            pstmt.setString(2,courses.getLpy_Tno15());
            pstmt.setString(3,college);
            pstmt.setString(4,courses.getLpy_Coursename15());
            pstmt.setDouble(5,courses.getLpy_Ccredit15());
            pstmt.setDouble(6,courses.getLpy_Chours15());
            pstmt.setString(7,courses.getLpy_Cterm15());
            pstmt.setString(8,courses.getLpy_Assessmentmethod15());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //修改课程
    public boolean changeCourseInfo(Courses courses) throws DaoException{
        String sql="UPDATE Lupy_Courses15 SET lpy_Courseno15=?,lpy_Tno15=?,lpy_Coursename15=?,lpy_Ccredit15=?,lpy_Chours15=?,lpy_Cterm15=?,lpy_Assessmentmethod15=? WHERE lpy_Courseno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,courses.getLpy_Courseno15());
            pstmt.setString(2,courses.getLpy_Tno15());
            pstmt.setString(3,courses.getLpy_Coursename15());
            pstmt.setDouble(4,courses.getLpy_Ccredit15());
            pstmt.setDouble(5,courses.getLpy_Chours15());
            pstmt.setString(6,courses.getLpy_Cterm15());
            pstmt.setString(7,courses.getLpy_Assessmentmethod15());
            pstmt.setString(8,courses.getLpy_Courseno15());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //删除课程信息
    public boolean deleteCourse(String no)throws DaoException{
        String sql="DELETE FROM Lupy_Courses15 WHERE lpy_Courseno15=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //添加班级课程开设
    public boolean addClassCourse (String no1,String no2) throws DaoException{
        String sql = "INSERT INTO Lupy_Setupinfo15 VALUES(?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,no1);
            pstmt.setString(2,no2);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //修改班级课程开设
    public boolean changeClassCourseInfo(String no1,String no2,String no3,String no4) throws DaoException{
        String sql="UPDATE Lupy_Setupinfo15 SET lpy_Courseno15=?,lpy_Classno15=? WHERE lpy_Courseno15=? AND lpy_Classno15=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,no3);
            pstmt.setString(2,no4);
            pstmt.setString(3,no1);
            pstmt.setString(4,no2);
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //删除班级课程开设
    public boolean deleteClassCourse(String no1,String no2)throws DaoException{
        String sql="DELETE FROM Lupy_Setupinfo15 WHERE lpy_Courseno15=? AND lpy_Classno15=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no1);
            pstmt.setString(2,no2);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
}
package com.dao;

import com.model.*;

import java.util.ArrayList;

public interface UsersDao extends Dao {
    //检查系统管理员登录方法
    public Teachers checkAdLogin(Teachers teachers) throws DaoException;
    //检查普通教师登录方法
    public Teachers checkTeaLogin(Teachers teachers) throws DaoException;
    //检查学生登录方法
    public Students checkStuLogin(Students students) throws DaoException;
    //修改教师信息
    public boolean changeTeaInfo(Teachers teachers) throws DaoException;
    //修改学生信息
    public boolean changeStuInfo(Students students) throws DaoException;
    //根据工号查询教师
    public Teachers findTeaByNo(String no) throws DaoException;
    //根据学号查询学生
    public Students findStuByNo(String no) throws DaoException;
    //修改教师密码
    public boolean changeTeaPassword(Teachers teachers) throws DaoException;
    //修改学生密码
    public boolean changeStuPassword(Students students) throws DaoException;
    //查询所有课平均成绩
    public ArrayList<AvgScore> allAvgScore() throws DaoException;
    //模糊查询平均成绩
    public ArrayList<AvgScore> findByFuzzyAvgScore(String info) throws DaoException;
    //查询所有学生信息
    public ArrayList<StuInfo> AllStuInfo() throws DaoException;
    //查询所有教师信息
    public ArrayList<TeaInfo> AllTeaInfo() throws DaoException;
    //根据学号删除学生信息
    public boolean deleteStu(String no)throws DaoException;
    //根据教师工号删除教师信息
    public boolean deleteTea(String no)throws DaoException;
    //模糊查询学生信息
    public ArrayList<StuInfo> findByFuzzyStuInfo(String info)throws DaoException;
    //模糊查询教师信息
    public ArrayList<TeaInfo> findByFuzzyTeaInfo(String info)throws DaoException;
    //根据工号查询教师信息
    public TeaInfo findTeaInfoByNo(String no) throws DaoException;
    //根据学号查询学生信息
    public StuInfo findStuInfoByNo(String no) throws DaoException;
    //添加教师
    public boolean addTeacher (Teachers teachers) throws DaoException;
    //添加学生
    public boolean addStudent (Students students) throws DaoException;
    //查询所有学生成绩信息
    public ArrayList<StuGradeInfo> allStuGradeInfo() throws DaoException;
    //模糊查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyStuGradeInfo(String info) throws DaoException;
    //根据教师模糊查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyTeaStuGradeInfo(String info,String tea) throws DaoException;
    //根据学期查询成绩信息
    public ArrayList<StuGradeInfo> termStuGradeInfo(String term) throws DaoException;
    //根据学年查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyYearGradeInfo(String info) throws DaoException;
    //根据教师和学期查询成绩信息
    public ArrayList<StuGradeInfo> termTeaStuGradeInfo(String term,String tea) throws DaoException;
    //根据教师和学年查询成绩信息
    public ArrayList<StuGradeInfo> findByFuzzyYearTeaGradeInfo(String info,String tea) throws DaoException;
    //根据学号和课程名查询成绩信息
    public StuGradeInfo findTeaGradeInfoBySnoAndName(String no,String name) throws DaoException;
    //查询所有学生排名
    public ArrayList<StuRank> allStuRank() throws DaoException;
    //模糊查询学生排名
    public ArrayList<StuRank> findByFuzzyStuRank(String info) throws DaoException;
    //查询所有学生
    public ArrayList<Students> allStu() throws DaoException;
    //模糊查询学生
    public ArrayList<Students> findByFuzzyStu(String info) throws DaoException;
    //查询所有教师任课
    public ArrayList<TeaCourse> allTeaCourse() throws DaoException;
    //模糊查询教师任课
    public ArrayList<TeaCourse> findByFuzzyTeaCourse(String info) throws DaoException;
    //查询所有班级课程开设情况
    public ArrayList<ClassCourse> allClassCourse() throws DaoException;
    //模糊查询班级课程开设情况
    public ArrayList<ClassCourse> findByFuzzyClassCourse(String info) throws DaoException;
    //查询所有生源地
    public ArrayList<StuAddress> allStuAddress() throws DaoException;
    //根据课程名查课程号
    public String queryCoursenoByName(String name) throws DaoException;
    //添加成绩信息
    public boolean addStuGrade(String sno,String courseno,Double grade) throws DaoException;
    //更新绩点
    public boolean updateGPA() throws DaoException;
    //根据学号和课程号修改成绩
    public boolean updateGradeBySnoAndCourseno(String sno,String courseno,Double grade) throws DaoException;
    //根据学号和课程编号删除成绩信息
    public boolean deleteGradeBySnoAndCourseno(String sno,String courseno) throws DaoException;
    //根据教师编号模糊查询教师任课
    public ArrayList<TeaCourse> findByFuzzyTeaCourse(String info,String no) throws DaoException;
    //教师查询任教课平均成绩
    public ArrayList<AvgScore> allTeaAvgScore(String no) throws DaoException;
    //教师模糊查询任教课平均成绩
    public ArrayList<AvgScore> findByFuzzyTeaAvgScore(String info,String no) throws DaoException;
    //根据课程名和教师编号查询课程排名
    public ArrayList<StuCourseRank> findStuCourseRank(String name,String no) throws DaoException;
    //根据工号查询教师任课
    public ArrayList<TeaCourse> findByFuzzyOneTeaCourse(String no) throws DaoException;
    //查询学生选修课程
    public ArrayList<StuCourse> findAllStuCourse(String no) throws DaoException;
    //根据学期查询学生选修课程
    public ArrayList<StuCourse> findAllStuCourse(String no,String term) throws DaoException;
    //根据学年查询学生选修课程
    public ArrayList<StuCourse> findAllStuYearCourse(String no,String year) throws DaoException;
    //查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuGrade(String no) throws DaoException;
    //根据学期查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuGrade(String no,String term) throws DaoException;
    //根据学年查询学生成绩
    public ArrayList<StuGradeInfo> findAllStuYearGrade(String no,String year) throws DaoException;
    //查询某个学生排名
    public StuRank findOneRank(String no) throws DaoException;
    //查询某个学生已修总学分
    public Students findOneCredit(String no) throws DaoException;
    //查询所有教师任课
    public ArrayList<Courses> allCourse() throws DaoException;
    //模糊查询教师任课
    public ArrayList<Courses> findByFuzzyCourse(String info) throws DaoException;
    //添加课程
    public boolean addCourse (Courses courses,String college) throws DaoException;
    //修改课程
    public boolean changeCourseInfo(Courses courses) throws DaoException;
    //删除课程信息
    public boolean deleteCourse(String no)throws DaoException;
    //添加班级课程开设
    public boolean addClassCourse (String no1,String no2) throws DaoException;
    //修改班级课程开设
    public boolean changeClassCourseInfo(String no1,String no2,String no3,String no4) throws DaoException;
    //删除班级课程开设
    public boolean deleteClassCourse(String no1,String no2)throws DaoException;
}
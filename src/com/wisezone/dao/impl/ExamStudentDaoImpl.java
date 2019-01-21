package com.wisezone.dao.impl;

import com.wisezone.bean.ExamStudent;
import com.wisezone.dao.DBUitls;
import com.wisezone.dao.ExamStudentDao;

import java.util.List;

/**
 * ExamStudentDao的实现类
 */
public class ExamStudentDaoImpl extends DBUitls implements ExamStudentDao {
    @Override
    public boolean add(ExamStudent student) {
        //向examstudent表中插入数据的sql语句
        String sql = "insert into examstudent (type,id_card,exam_card,student_name,location,grade) values (?,?,?,?,?,?)";
        Object[] params = {student.getType(),student.getIdCard(),student.getExamCard(),student.getStudentName()
        ,student.getLocation(),student.getGrade()};
        int row = super.executeUpdate(sql, params);
        return row > 0 ? true : false;
    }

    @Override
    public boolean update(ExamStudent student) {
        //根据flow_id主键修改数据
        String sql = "update examstudent set type=?,id_card=?,exam_card=?,student_name=?,location=?,grade=? where flow_id=?";
        Object[] params = {student.getType(),student.getIdCard(),student.getExamCard(),student.getStudentName()
                ,student.getLocation(),student.getGrade(),student.getFlowId()};
        int row = super.executeUpdate(sql, params);
        return row > 0 ? true : false;
    }

    @Override
    public boolean remove(int flowId) {
        String sql = "delete from examstudent where flow_id=?";
        int row = super.executeUpdate(sql, flowId);
        return row > 0 ? true : false;
    }

    @Override
    public List<ExamStudent> queryAll() {
        //DButils类使用commonsBeanUitls工具实现，所以sql语句列的列名要和java bean属性名一致
        String sql = "select t.flow_id flowId,t.type,t.student_name studentName, t.exam_card examCard,t.grade,t.id_card idCard,t.location from examstudent t";
        List<ExamStudent> examStudents = super.queryList(ExamStudent.class, sql);
        return examStudents;
    }

    @Override
    public ExamStudent queryOne(int flowId) {
        String sql = "select t.flow_id flowId,t.type,t.student_name studentName, t.exam_card examCard,t.grade,t.id_card idCard,t.location from examstudent t "
                + " where t.flow_id = ?";
        ExamStudent examStudent = super.queryOne(ExamStudent.class, sql, flowId);
        return examStudent;
    }
}

package com.wisezone.ui;

import com.wisezone.bean.ExamStudent;
import com.wisezone.biz.ExamStudentBiz;
import com.wisezone.biz.impl.ExamStudentBizImpl;

import java.util.List;

/**
 * 测试类
 */
public class Client {
    //调用业务逻辑层
    public static ExamStudentBiz biz = new ExamStudentBizImpl();

    public static void add(){
        ExamStudent student = new ExamStudent();
        student.setExamCard("1111111");
        student.setIdCard("12222222");
        student.setGrade(85);
        student.setLocation("重庆");
        student.setStudentName("王麻子");
        student.setType(4);
        boolean result = biz.add(student);
        System.out.println(result ? "插入成功！" : "插入失败!");
    }

    public static void queryOne(){
        ExamStudent examStudent = biz.queryOne(6);
        System.out.println(examStudent);
    }

    public static void update(){
        ExamStudent examStudent = biz.queryOne(6);
        examStudent.setStudentName("李麻子");
        examStudent.setLocation("渝中区");
        boolean update = biz.update(examStudent);
        System.out.println(update ? "修改成功！":"修改失败！");
    }

    public static void remove(){
        boolean remove = biz.remove(6);
        System.out.println(remove ? "删除成功！":"删除失败！");
    }

    public static void queryAll(){
        List<ExamStudent> list = biz.queryAll();
        for (ExamStudent student : list) {
            System.out.println(student);
        }
    }
    public static void main(String[] args) {
        //测试添加
        //add();

        //测试根据id查询
        //queryOne();

        //测试修改的方法
        //update();

        //测试根据id删除
        //remove();

        //测试查询全部
        queryAll();
    }
}

package com.wisezone.biz;

import com.wisezone.bean.ExamStudent;

import java.util.List;

/**
 * ExamStudent业务逻辑层
 */
public interface ExamStudentBiz {
    /**
     * 对examStudent表的插入数据的方法
     * @param student
     * @return
     */
    boolean add(ExamStudent student);

    /**
     * 对examStudent的修改
     * @param student
     * @return
     */
    boolean update(ExamStudent student);

    /**
     * 根据主键删除examStudent
     * @param flowId
     * @return
     */
    boolean remove(int flowId);

    /**
     * 全查
     * @return
     */
    List<ExamStudent> queryAll();

    /**
     * 根据主键查询
     * @param flowId
     * @return
     */
    ExamStudent queryOne(int flowId);
}

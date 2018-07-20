package com.wechat.dao;

import com.wechat.bean.Mem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * @Author: Youchang Xu
 * @Description:
 * @Date: created in 22:41 2018/7/5
 * @Modified By:
 */
public interface MemRepository extends JpaRepository<Mem,Long> {
    /**
     * 查询聊天室列表
     * @return
     */
    @Query(value = "select distinct m.chatroom from Mem m ORDER BY m.id desc")
    List<String> findDistinctChatroomOderbyIdDesc();

    /**
     * 通过IsInGroup查询人员信息
     * @param i
     * @return
     */
    List<Mem> findAllByIsInGroup(String i);

    /**
     * 通过群聊名称查询人员信息
     * @param chatroom
     * @return
     */
    List<Mem> findAllByChatroom(String chatroom);




}

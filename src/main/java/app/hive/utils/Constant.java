package app.hive.utils;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: Constant
 * Description: 插件常量
 *
 * @author: 王晓文
 * @date: 2022/7/26 22:53
 */
public interface Constant {

    // ================================ 触发关键词 ================================ //

    /**
     * 搜索前缀
     */
    char PREFIX = 'q';
    /**
     * 获取帮助的触发KEY
     */
    String HELP_KEY = "搜题帮助";
    /**
     * 开启搜题的触发KEY
     */
    String SEARCH_ON_KEY = "开启搜题";

    /**
     * 关闭搜题的触发KEY
     */
    String SEARCH_OFF_KEY = "关闭搜题";

    /**
     * 赋予所有人权限的触发KEY
     */
    String ALL_HOST_ON_KEY = "开启所有人可变更搜题权限";

    /**
     * 收回所有人权限的触发KEY
     */
    String ALL_HOST_OFF_KEY = "关闭所有人可变更搜题权限";


    // ================================ KEY对应回复 ================================//


    /**
     * 帮助提示
     */
    String HELP = "输入：\nq问题\n\n例如：\nq我爱你";

    /**
     * 群搜索功能开启回复
     */
    String SEARCH_ON = "已开启本群的搜题搜题功能\n\n输入“搜题帮助”获取帮助";

    /**
     * 群搜索关闭关闭回复
     */
    String SEARCH_OFF = "已关闭本群的搜题功能";

    /**
     * 所有人权限开启回复
     */
    String ALL_HOST_ON = "已开启所有人可变更搜题";

    /**
     * 所有人权限关闭回复
     */
    String ALL_HOST_OFF = "现只允许特定人可变更搜题";


    // ================================ Format格式标本 ================================ //


    /**
     * 单个答案的格式化规范
     */
    String SINGLE_RESULT = "\n问题：\n%s\n\n选项：\n%s\n\n答案：%s\n\n出处：\n%s\n";
}

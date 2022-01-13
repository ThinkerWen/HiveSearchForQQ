package app.hive.utils;

public interface Constant {

    char PREFIX = 'q';

    boolean ALL_HOST = false;

    boolean ALL_GROUP = false;

    String SERACH_ON = "已开启群%s的搜题搜题功能\n\n输入q+问题搜索答案\n例：\nq在什么情况下N95口罩需要更换?";

    String SERACH_OFF = "已关闭群%s的搜题搜题功能";

    String ALL_HOST_ON = "已开启所有人可变更搜题";

    String ALL_HOST_OFF = "现只允许特定人可变更搜题";

    String ALL_GROUP_ON = "已开启所有群搜题";

    String ALL_GROUP_OFF = "现只允许特定群搜题";

    String SEARCH_ON_SCRIPT = "开启搜题";

    String SEARCH_OFF_SCRIPT = "关闭搜题";

    String ALL_HOST_ON_SCRIPT = "开启所有人可变更搜题";

    String ALL_HOST_OFF_SCRIPT = "关闭所有人可变更搜题";

    String ALL_GROUP_ON_SCRIPT = "开启所有群可搜题";

    String ALL_GROUP_OFF_SCRIPT = "关闭所有群可搜题";

}

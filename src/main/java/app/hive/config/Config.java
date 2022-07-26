package app.hive.config;

import app.hive.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2022. Jason Wang (wxw126mail@126.com)
 * Title: Config
 * Description:
 *
 * @author: 王晓文
 * @date: 2022/7/26 23:58
 */
public class Config implements Constant {

    public static final Config INSTANCE = new Config();
    private boolean enable = true;
    private boolean allHost = false;
    private String token = "free";
    private List<Long> hosts = new ArrayList<Long>(){{
        add(296854007L);
    }};
    private List<Long> groups = new ArrayList<Long>(){{
        add(726925125L);
    }};

    private Config() {}

    private static final class ConfigHolder {
        static final Config config = new Config();
    }

    public static Config getConfigInstance() {
        return ConfigHolder.config;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isAllHost() {
        return allHost;
    }

    public void setAllHost(boolean allHost) {
        this.allHost = allHost;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Long> getHosts() {
        return hosts;
    }

    public void addHost(Long host) {
        for (Long id : this.hosts)
            if (id.equals(host)) return;
        this.hosts.add(host);
    }

    public void removeHost(Long host) {
        this.hosts.remove(host);
    }

    public List<Long> getGroups() {
        return groups;
    }

    public void addGroup(Long group) {
        for (Long id : this.groups)
            if (id.equals(group)) return;
        this.groups.add(group);
    }

    public void removeGroup(Long group) {
        this.groups.remove(group);
    }
}
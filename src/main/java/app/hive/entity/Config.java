package app.hive.entity;

import app.hive.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class Config implements Constant {

    private Config() {
        this.enable = true;
        this.token = "free";
        this.host = new ArrayList<Long>(){{
            add(296854007L);
        }};
        this.group = new ArrayList<Long>(){{
            add(103172845L);
            add(791673513L);
        }};
    }

    private boolean enable;
    private boolean allHost = ALL_HOST;
    private boolean allGroup = ALL_GROUP;
    private String token;
    private List<Long> host;
    private List<Long> group;
    public static final Config INSTANCE = new Config();

    public boolean isAllHost() {
        return allHost;
    }

    public void setAllHost(boolean allHost) {
        this.allHost = allHost;
    }

    public boolean isAllGroup() {
        return allGroup;
    }

    public void setAllGroup(boolean allGroup) {
        this.allGroup = allGroup;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Long> getHost() {
        return host;
    }

    public void setHost(List<Long> host) {
        this.host = host;
    }

    public List<Long> getGroup() {
        return group;
    }

    public void setGroup(List<Long> group) {
        this.group = group;
    }
}

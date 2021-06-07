package com.webank.wedatasphere.linkis.manager.common.protocol.engine;

import com.webank.wedatasphere.linkis.protocol.message.RequestMethod;

import java.util.Map;


public class EngineAskRequest implements EngineRequest, RequestMethod {

    private Map<String, String> properties;

    private Map<String, Object> labels;

    private long timeOut;

    private String user;

    private String createService;

    private String description;

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, Object> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, Object> labels) {
        this.labels = labels;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreateService() {
        return createService;
    }

    public void setCreateService(String createService) {
        this.createService = createService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String method() {
        return "/engine/ask";
    }

    @Override
    public String toString() {
        return "EngineAskRequest{" +
                "labels=" + labels +
                ", timeOut=" + timeOut +
                ", user='" + user + '\'' +
                ", createService='" + createService + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.habeebcycle.awscicdcodepipeline.model;

import java.util.Date;
import java.util.Objects;

public class AwsBean {

    private int id;
    private String name;
    private String cloud;
    private String developer;
    private String version;
    private Date time;

    public AwsBean(int id, String name, String cloud, String developer, String version, Date time) {
        this.id = id;
        this.name = name;
        this.cloud = cloud;
        this.developer = developer;
        this.version = version;
        this.time = time;
    }

    public AwsBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AwsBean bean = (AwsBean) o;
        return Objects.equals(name, bean.name) &&
                Objects.equals(cloud, bean.cloud) &&
                Objects.equals(developer, bean.developer) &&
                Objects.equals(version, bean.version) &&
                Objects.equals(time, bean.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, cloud, developer, version, time);
    }
}

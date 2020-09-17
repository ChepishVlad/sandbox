package ru.vld.simplesite.model;

import java.util.Objects;

public class Group {

    private String groupName;
    private String groupHeader;
    private String groupFooter;
    private int groupId;

    public Group(){}

    public Group(String name, String header, String footer){
        this.groupName = name;
        this.groupHeader = header;
        this.groupFooter = footer;
    }

    public Group(String name, int id){
        this.groupName = name;
        this.groupId = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public Group setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    public Group setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public int getGroupId() {
        return groupId;
    }

    public Group setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", groupHeader='" + groupHeader + '\'' +
                ", groupFooter='" + groupFooter + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}

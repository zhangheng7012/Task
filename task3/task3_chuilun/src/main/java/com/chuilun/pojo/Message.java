package com.chuilun.pojo;

import java.util.List;

public class Message {
    // 留言id
    private Integer id;
    // 作品id
    private Integer workId;
    // 作品名称
    private String workName;
    // 父留言id
    private Integer parentMessageId;
    // 留言者昵称
    private String name;
    // 留言内容
    private String message;
    // 留言状态，精选true，普通false
    private Boolean status;
    // 留言创建时间
    private Long createAt;
    // 留言修改时间
    private Long updateAt;
    // 留言最后修改人
    private String updateBy;

    // 留言对应多个回复
    private List<Message> replies;

    public List<Message> getReplies() {
        return replies;
    }

    public void setReplies(List<Message> replies) {
        this.replies = replies;
    }

    public Message() {
    }

    public Message(Integer id, Integer workId, String workName,
                   Integer parentMessageId, String name, String message,
                   Boolean status, Long createAt, Long updateAt, String updateBy,
                   List<Message> replies) {
        this.id = id;
        this.workId = workId;
        this.workName = workName;
        this.parentMessageId = parentMessageId;
        this.name = name;
        this.message = message;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "  \n Message{" +
                "id=" + id +
                ", workId=" + workId +
                ", workName='" + workName + '\'' +
                ", parentMessageId=" + parentMessageId +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ",  \n replies=" + replies +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public Integer getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Integer parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}
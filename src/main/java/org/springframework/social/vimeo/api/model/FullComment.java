package org.springframework.social.vimeo.api.model;

import java.net.URL;
import java.util.Date;

/**
 * User: soldier
 * Date: 16.02.12
 * Time: 19:16
 */
public class FullComment extends Comment {
    private Date createDate;
    private URL permalink;
    private Integer replyToCommentId;
    private CommentType type;
    private ProPerson author;

    public FullComment(Integer id, String content, Date createDate, URL permalink, Integer replyToCommentId, CommentType type, ProPerson author) {
        super(id, content);
        this.createDate = createDate;
        this.permalink = permalink;
        this.replyToCommentId = replyToCommentId;
        this.type = type;
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public URL getPermalink() {
        return permalink;
    }

    public Integer getReplyToCommentId() {
        return replyToCommentId;
    }

    public CommentType getType() {
        return type;
    }

    public ProPerson getAuthor() {
        return author;
    }
}

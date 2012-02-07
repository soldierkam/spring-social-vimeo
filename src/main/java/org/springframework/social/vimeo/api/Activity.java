package org.springframework.social.vimeo.api;

import java.util.Date;
import java.util.List;

/**
 * User: soldier
 * Date: 2/7/12
 * Time: 9:08 PM
 */
public class Activity {

    private Integer id;
    private ActivityType type;
    private Date time;
    private Person user;
    private List<Video> videos;
    private List<Comment> comments;
    private Group group;
    private Forum forum;
    private Channel channel;

    public Activity(Integer id, ActivityType type, Date time, Person user, List<Video> video, List<Comment> comment, Group group, Forum forum, Channel channel) {
        this.id = id;
        this.type = type;
        this.time = time;
        this.user = user;
        this.videos = video;
        this.comments = comment;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public ActivityType getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public Person getUser() {
        return user;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Group getGroup() {
        return group;
    }

    public Forum getForum() {
        return forum;
    }

    public Channel getChannel() {
        return channel;
    }
}

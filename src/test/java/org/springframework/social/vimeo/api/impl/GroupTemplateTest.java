package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:23
 */
public class GroupTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testAll() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_all"), responseHeaders));

        Groups groups = vimeo.groupOperations().all("12345", null, null, null);
        assertEquals(50, groups.getOnThisPage().intValue());
        //TODO: check more!
    }

    @Test
    public void testGetModerators() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_moderators"), responseHeaders));

        GroupModerators moderators = vimeo.groupOperations().moderators("sencha", null, null);
        assertEquals(1, moderators.getOnThisPage().intValue());
        ProPerson moderator = moderators.getModerators().get(0);
        assertNotNull(moderator.getDisplayName());
        assertNotNull(moderator.getId());
        assertNotNull(moderator.getPlus());
        assertNotNull(moderator.getPortraits());
        assertNotNull(moderator.getProfileUrl());
        assertNotNull(moderator.getRealName());
        assertNotNull(moderator.getStaff());
        assertNotNull(moderator.getUsername());
        assertNotNull(moderator.getVideosUrl());
    }

    @Test
    public void testGetAddable() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_addable"), responseHeaders));

        Groups groups = vimeo.groupOperations().addable("2126499", null, null, null);
        assertEquals(48, groups.getOnThisPage().intValue());

        for (Group group : groups.getGroups()) {
            assertNotNull(group.getCalendar());
            assertNotNull(group.getCreatedOn());
            assertNotNull(group.getCreator());
            assertNotNull(group.getFeatured());
            assertNotNull(group.getId());
            assertNotNull(group.getModifiedOn());
            assertNotNull(group.getName());
            assertNotNull(group.getPermissions());
            assertNotNull(group.getTotalEvents());
            assertNotNull(group.getTotalFiles());
            assertNotNull(group.getTotalMembers());
            assertNotNull(group.getTotalThreads());
            assertNotNull(group.getTotalVideos());
            assertNotNull(group.getUrl());
        }
    }

    @Test
    public void testInfo() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_info"), responseHeaders));

        Group group = vimeo.groupOperations().info("35336");
        assertNotNull(group.getCalendar());
        assertNotNull(group.getCreatedOn());
        assertNotNull(group.getCreator());
        assertNotNull(group.getFeatured());
        assertNotNull(group.getId());
        assertNotNull(group.getModifiedOn());
        assertNotNull(group.getName());
        assertNotNull(group.getPermissions());
        assertNotNull(group.getTotalEvents());
        assertNotNull(group.getTotalFiles());
        assertNotNull(group.getTotalMembers());
        assertNotNull(group.getTotalThreads());
        assertNotNull(group.getTotalVideos());
        assertNotNull(group.getUrl());
    }

    @Test
    public void testGetMembers() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_members"), responseHeaders));

        People members = vimeo.groupOperations().members("35336");
        assertEquals(50, members.getOnThisPage().intValue());
        for (Person member : members.getMembers()) {
            assertNotNull(member.getPortraits());
            assertNotNull(member.getPlus());
            assertNotNull(member.getProfileUrl());
            assertNotNull(member.getRealName());
            assertNotNull(member.getStaff());
            assertNotNull(member.getVideosUrl());
            assertNotNull(member.getDisplayName());
            assertNotNull(member.getId());
            assertNotNull(member.getUsername());
        }
    }

    @Test
    public void testGetVideos() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_videos"), responseHeaders));

        Videos videos = vimeo.groupOperations().videos("35336", null, null, null);
        assertEquals(50, videos.getOnThisPage().intValue());
        for (Video video : videos.getVideos()) {
            assertNotNull(video.getAllowAdds());
            assertNotNull(video.getThumbnails());
            assertNotNull(video.getDescription());
            assertNotNull(video.getDuration());
            assertNotNull(video.getEmbedPrivacy());
            assertNotNull(video.getHd());
            assertNotNull(video.getHeight());
            assertNotNull(video.getId());
            assertNotNull(video.getLicense());
            assertNotNull(video.getModifiedDate());
            assertNotNull(video.getNumberOfComments());
            assertNotNull(video.getNumberOfLikes());
            assertNotNull(video.getNumberOfPlays());
            assertNotNull(video.getOwner());
            assertNotNull(video.getPrivacy());
            assertNotNull(video.getWidth());
            assertNotNull(video.getUploadDate());
            assertNotNull(video.getTitle());
            assertNotNull(video.getTranscoding());
            assertNotNull(video.getTitle());
        }
    }

    @Test
    public void testGetTopics() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_topics"), responseHeaders));

        Topics topics = vimeo.groupOperations().topics("35336", null, null);
        assertEquals(35, topics.getOnThisPage().intValue());
        for (Topic topic : topics.getTopics()) {
            assertNotNull(topic.getCreatedOn());
            assertNotNull(topic.getCreator());
            assertNotNull(topic.getId());
            assertNotNull(topic.getLocked());
            assertNotNull(topic.getName());
            assertNotNull(topic.getSticky());
        }
    }

    @Test
    public void testGetTopicComments() {
        mockServer.expect(requestTo("https://vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_topic_comments"), responseHeaders));

        FullComments comments = vimeo.groupOperations().topicComments("35336", "250811", null, null);
        assertEquals(2, comments.getOnThisPage().intValue());
        for (FullComment comment : comments.getComments()) {
            assertNotNull(comment.getContent());
            assertNotNull(comment.getId());
            assertNotNull(comment.getAuthor());
            assertNotNull(comment.getCreateDate());
            assertNotNull(comment.getPermalink());
            assertNotNull(comment.getReplyToCommentId());
            assertNotNull(comment.getType());
        }
    }
}

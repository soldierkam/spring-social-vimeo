package org.springframework.social.vimeo.api.impl;

import org.junit.Test;
import org.springframework.social.vimeo.api.model.*;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.headerContains;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * User: soldier
 * Date: 14.02.12
 * Time: 22:23
 */
public class GroupTemplateTest extends AbstractVimeoApiTest {

    @Test
    public void testAll() throws Exception {
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
                .andExpect(method(GET))
                .andExpect(headerContains("Authorization", "OAuth oauth_version"))
                .andRespond(withResponse(jsonResource("group_all"), responseHeaders));

        Groups groups = vimeo.groupOperations().all("12345", null, null, null);
        assertEquals(50, groups.getOnThisPage().intValue());
        Group group = groups.getGroups().get(0);
        assertEquals("109217", group.getId());
        assertEquals(Boolean.FALSE, group.getFeatured());
        assertEquals("Beyond Planet Earth Video Contest", group.getName());
        assertEquals("1st Place Winners:\nSame Same But Different by Mattias Burling\nBeyond Planet Earth by Luke Cahill\n\nRunner Up:\nBeyond Planet Earth: Mirrored by Rafael Bonilla Jr.\n\n\nWatch Museum astrophysicist and Beyond Planet Earth Curator Michael Shara explain his vision for the future: http://vimeo.com/29983176\n\nBeyond Planet Earth: The Future of Space Exploration,         a new exhibition opening at the American Museum of Natural History on November 19,         transports visitors to the Moon,         Mars,         and beyond as it boldly predicts humanity\u2019s next steps in space.\nFind out more at http://amnh.org/contest\n\n\nCONTEST INSTRUCTIONS\nEach video must begin with the contest slide,         available here:\nhttp://www.amnh.org/contest/amnh_vimeo_slide.png\n\nDEADLINE EXTENDED!\n\nSubmit your video by 11:59 pm ET on November 17,         2011.\n\nCONTEST JUDGES\nMichael Shara,         curator of Beyond Planet Earth\nH\u00e9l\u00e8ne Alonso,         Director of Exhibit Interactives and Media,         AMNH\nRuth Cohen,         Director of the Center for Lifelong Learning,         AMNH\nJesus Diaz,         Gizmodo\nBlake Whitman,         Vimeo\n\nCONTEST PRIZES\n- The winning video will be featured on amnh.org and shown at SpaceFest! at the American Museum of Natural History on January 15,         2012\n\nWinners will also receive:\n- Four tickets to Beyond Planet Earth: The Future of Space Exploration at the American Museum of Natural History\n- A $100 gift certificate to the Beyond Planet Earth shop\n- A year-long Vimeo Plus membership", group.getDescription());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-09-28 16:33:37"), group.getCreatedOn());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-02-09 05:33:49"), group.getModifiedOn());
        assertEquals(Integer.valueOf(35), group.getTotalVideos());
        assertEquals(Integer.valueOf(102), group.getTotalMembers());
        assertEquals(Integer.valueOf(1), group.getTotalThreads());
        assertEquals(Integer.valueOf(2), group.getTotalFiles());
        assertEquals(Integer.valueOf(3), group.getTotalEvents());
        assertEquals("http://vimeo.com/groups/beyondplanetearth", group.getUrl().get(0).toString());
        assertEquals("http://groupheader.vimeo.com.s3.amazonaws.com/351/35158_980.", group.getLogoUrl().toString());
        assertEquals("http://b.vimeocdn.com/ts/146/045/146045889_200.jpg", group.getThumbnailUrl().toString());
        GroupPermissions groupPermissions = group.getPermissions();
        assertEquals(false, groupPermissions.isCanUsersApply());
        assertEquals(GroupType.PUBLIC, groupPermissions.getGroupType());
        assertEquals(GroupRole.ALL, groupPermissions.get(PermissionName.WHO_CAN_ADD_VIDS));
        assertEquals(GroupRole.MEMBERS, groupPermissions.get(PermissionName.WHO_CAN_COMMENT));
        assertEquals(GroupRole.ALL, groupPermissions.get(PermissionName.WHO_CAN_CREATE_EVENTS));
        assertEquals(GroupRole.MEMBERS, groupPermissions.get(PermissionName.WHO_CAN_INVITE));
        assertEquals(GroupRole.MODS, groupPermissions.get(PermissionName.WHO_CAN_UPLOAD));
        assertEquals(GroupRole.MODS, groupPermissions.get(PermissionName.WHO_CAN_USE_FORUMS));
    }

    @Test
    public void testGetModerators() {
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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
        mockServer.expect(requestTo("https:/vimeo.com/api/rest/v2"))
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

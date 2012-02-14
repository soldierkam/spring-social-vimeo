package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.vimeo.api.model.*;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 6:27 PM
 */
public class VimeoModule extends SimpleModule {
    public VimeoModule() {
        super("Vimeo", new Version(1, 0, 0, ""));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Activity.class, ActivityMixin.class);
        context.setMixInAnnotations(Activities.class, ActivitiesMixin.class);
        context.setMixInAnnotations(Album.class, AlbumMixin.class);
        context.setMixInAnnotations(Albums.class, AlbumsMixin.class);
        context.setMixInAnnotations(Calendar.class, CalendarMixin.class);
        context.setMixInAnnotations(Channel.class, ChannelMixin.class);
        context.setMixInAnnotations(Channels.class, ChannelsMixin.class);
        context.setMixInAnnotations(ChannelInfo.class, ChannelInfoMixin.class);
        context.setMixInAnnotations(ChannelInfos.class, ChannelInfosMixin.class);
        context.setMixInAnnotations(Cast.class, CastMixin.class);
        context.setMixInAnnotations(Casts.class, CastsMixin.class);
        context.setMixInAnnotations(Collection.class, CollectionMixin.class);
        context.setMixInAnnotations(Comment.class, CommentMixin.class);
        context.setMixInAnnotations(Contact.class, ContactMixin.class);
        context.setMixInAnnotations(Contacts.class, ContactsMixin.class);
        context.setMixInAnnotations(Forum.class, ForumMixin.class);
        context.setMixInAnnotations(ForumThread.class, ForumThreadMixin.class);
        context.setMixInAnnotations(Group.class, GroupMixin.class);
        context.setMixInAnnotations(Groups.class, GroupsMixin.class);
        context.setMixInAnnotations(GroupActivity.class, GroupActivityMixin.class);
        context.setMixInAnnotations(GroupModerator.class, GroupModeratorMixin.class);
        context.setMixInAnnotations(GroupModerators.class, GroupModeratorsMixin.class);
        context.setMixInAnnotations(Image.class, ImageMixin.class);
        context.setMixInAnnotations(Moderator.class, ModeratorMixin.class);
        context.setMixInAnnotations(Moderators.class, ModeratorsMixin.class);
        context.setMixInAnnotations(People.class, PeopleMixin.class);
        context.setMixInAnnotations(Person.class, PersonMixin.class);
        context.setMixInAnnotations(Permissions.class, PermissionsMixin.class);
        context.setMixInAnnotations(ProPerson.class, ProPersonMixin.class);
        context.setMixInAnnotations(Quota.class, QuotaMixin.class);
        context.setMixInAnnotations(SimplePerson.class, SimplePersonMixin.class);
        context.setMixInAnnotations(Subscription.class, SubscriptionMixin.class);
        context.setMixInAnnotations(Subscriptions.class, SubscriptionsMixin.class);
        context.setMixInAnnotations(Tag.class, TagMixin.class);
        context.setMixInAnnotations(ThumbnailVideo.class, ThumbnailVideoMixin.class);
        context.setMixInAnnotations(Ticket.class, TicketMixin.class);
        context.setMixInAnnotations(UploadSpace.class, UploadSpaceMixin.class);
        context.setMixInAnnotations(User.class, UserMixin.class);
        context.setMixInAnnotations(Video.class, VideoMixin.class);
        context.setMixInAnnotations(Videos.class, VideosMixin.class);
    }

}

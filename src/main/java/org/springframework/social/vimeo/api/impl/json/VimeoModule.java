package org.springframework.social.vimeo.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.Module;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.vimeo.api.*;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 6:27 PM
 */
public class VimeoModule extends SimpleModule{
    public VimeoModule() {
        super("Vimeo", new Version(1, 0, 0, ""));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Video.class, VideoMixin.class);
        context.setMixInAnnotations(Videos.class, VideosMixin.class);
        context.setMixInAnnotations(Album.class, AlbumMixin.class);
        context.setMixInAnnotations(Albums.class, AlbumsMixin.class);
        context.setMixInAnnotations(Image.class, ImageMixin.class);
        context.setMixInAnnotations(Owner.class, OwnerMixin.class);
        context.setMixInAnnotations(Tag.class, TagMixin.class);
        context.setMixInAnnotations(ThumbnailVideo.class, ThumbnailVideoMixin.class);
    }
}

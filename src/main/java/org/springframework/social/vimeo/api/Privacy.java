package org.springframework.social.vimeo.api;

/**
 * User: soldier
 * Date: 2/4/12
 * Time: 9:05 PM
 */
public enum Privacy {
    ANYBODY,//anybody can view the video
    NOBODY,//only the owner can view the video
    CONTACTS,//only the owner's contacts can view the video
    USERS,//only specific users can view the video
    PASSWORDS,// the video will require a password
    DISABLED,//the video will not appear on Vimeo.com at all
}

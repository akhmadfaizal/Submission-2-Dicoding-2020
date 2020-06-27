package com.afi.bfaa.submission_2_githubuser.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private String name;
    private String company;
    private String location;
    private String email;
    private String blog;
    private String hireable;
    private String bio;

    protected User(Parcel in) {
        login = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nodeId = in.readString();
        avatarUrl = in.readString();
        gravatarId = in.readString();
        url = in.readString();
        htmlUrl = in.readString();
        followersUrl = in.readString();
        followingUrl = in.readString();
        gistsUrl = in.readString();
        starredUrl = in.readString();
        subscriptionsUrl = in.readString();
        organizationsUrl = in.readString();
        reposUrl = in.readString();
        eventsUrl = in.readString();
        receivedEventsUrl = in.readString();
        type = in.readString();
        byte tmpSiteAdmin = in.readByte();
        siteAdmin = tmpSiteAdmin == 0 ? null : tmpSiteAdmin == 1;
        name = in.readString();
        company= in.readString();
        email = in.readString();
        blog = in.readString();
        hireable = in.readString();
        bio = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getHireable() {
        return hireable;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nodeId);
        dest.writeString(avatarUrl);
        dest.writeString(gravatarId);
        dest.writeString(url);
        dest.writeString(htmlUrl);
        dest.writeString(followersUrl);
        dest.writeString(followingUrl);
        dest.writeString(gistsUrl);
        dest.writeString(starredUrl);
        dest.writeString(subscriptionsUrl);
        dest.writeString(organizationsUrl);
        dest.writeString(reposUrl);
        dest.writeString(eventsUrl);
        dest.writeString(receivedEventsUrl);
        dest.writeString(type);
        dest.writeByte((byte) (siteAdmin == null ? 0 : siteAdmin ? 1 : 2));
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(email);
        dest.writeString(blog);
        dest.writeString(hireable);
        dest.writeString(bio);
    }
}

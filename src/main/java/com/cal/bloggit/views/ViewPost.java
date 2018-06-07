package com.cal.bloggit.views;

public class ViewPost {
    private Long postId;

    private String title;

    private String body;

    private String author;

    private Long createdOn;

    private Long lastUpdated;

    private String summary;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewPost viewPost = (ViewPost) o;

        if (postId != null ? !postId.equals(viewPost.postId) : viewPost.postId != null) return false;
        if (title != null ? !title.equals(viewPost.title) : viewPost.title != null) return false;
        if (body != null ? !body.equals(viewPost.body) : viewPost.body != null) return false;
        if (author != null ? !author.equals(viewPost.author) : viewPost.author != null) return false;
        if (createdOn != null ? !createdOn.equals(viewPost.createdOn) : viewPost.createdOn != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(viewPost.lastUpdated) : viewPost.lastUpdated != null)
            return false;
        return summary != null ? summary.equals(viewPost.summary) : viewPost.summary == null;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ViewPost{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", createdOn=" + createdOn +
                ", lastUpdated=" + lastUpdated +
                ", summary='" + summary + '\'' +
                '}';
    }
}

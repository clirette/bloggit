package com.cal.bloggit.domains;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class DomainPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private String author;

    @Column
    private LocalDateTime createdOn;

    @Column
    private LocalDateTime lastUpdated;

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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainPost domainPost = (DomainPost) o;

        if (!postId.equals(domainPost.postId)) return false;
        if (!title.equals(domainPost.title)) return false;
        if (!body.equals(domainPost.body)) return false;
        if (!author.equals(domainPost.author)) return false;
        if (!createdOn.equals(domainPost.createdOn)) return false;
        return lastUpdated.equals(domainPost.lastUpdated);
    }

    @Override
    public int hashCode() {
        int result = postId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + createdOn.hashCode();
        result = 31 * result + lastUpdated.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DomainPost{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", createdOn=" + createdOn +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

package com.cal.bloggit.domains;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookmarks")
public class DomainBookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @Column
    private String title;

    @Column
    private String url;

    @Column
    private boolean visible;

    @Column
    private int priority;

    @Column
    private LocalDateTime lastUpdated;

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Long bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainBookmark domainBookmark = (DomainBookmark) o;

        if (visible != domainBookmark.visible) return false;
        if (priority != domainBookmark.priority) return false;
        if (bookmarkId != null ? !bookmarkId.equals(domainBookmark.bookmarkId) : domainBookmark.bookmarkId != null) return false;
        if (title != null ? !title.equals(domainBookmark.title) : domainBookmark.title != null) return false;
        return url != null ? url.equals(domainBookmark.url) : domainBookmark.url == null;
    }

    @Override
    public int hashCode() {
        int result = bookmarkId != null ? bookmarkId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (visible ? 1 : 0);
        result = 31 * result + priority;
        return result;
    }

    @Override
    public String toString() {
        return "DomainBookmark{" +
                "bookmarkId=" + bookmarkId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", visible=" + visible +
                ", priority=" + priority +
                '}';
    }
}

package com.cal.bloggit.views;

public class ViewBookmark {
    private Long bookmarkId;

    private String title;

    private String url;

    private String fullUrl;

    private boolean visible;

    private int priority;

    private Long lastUpdated;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
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

        ViewBookmark that = (ViewBookmark) o;

        if (visible != that.visible) return false;
        if (priority != that.priority) return false;
        if (bookmarkId != null ? !bookmarkId.equals(that.bookmarkId) : that.bookmarkId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;
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
        return "ViewBookmark{" +
                "bookmarkId=" + bookmarkId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", visible=" + visible +
                ", priority=" + priority +
                '}';
    }
}

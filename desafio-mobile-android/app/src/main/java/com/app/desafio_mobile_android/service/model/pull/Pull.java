package com.app.desafio_mobile_android.service.model.pull;

import android.os.Parcel;
import android.os.Parcelable;

import com.app.desafio_mobile_android.intrastructure.Constants;
import com.app.desafio_mobile_android.service.model.Owner;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pull implements Parcelable {
    private final static String STATE_CLOSED = "closed";

    @SerializedName("url")
    private String url;
    @SerializedName("id")
    private Integer id;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("diff_url")
    private String diffUrl;
    @SerializedName("patch_url")
    private String patchUrl;
    @SerializedName("issue_url")
    private String issueUrl;
    @SerializedName("number")
    private Integer number;
    @SerializedName("state")
    private String state;
    @SerializedName("locked")
    private Boolean locked;
    @SerializedName("title")
    private String title;
    @SerializedName("user")
    private Owner user;
    @SerializedName("body")
    private String body;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("closed_at")
    private Object closedAt;
    @SerializedName("merged_at")
    private Object mergedAt;
    @SerializedName("merge_commit_sha")
    private String mergeCommitSha;
    @SerializedName("assignee")
    private Object assignee;
    @SerializedName("assignees")
    private List<Object> assignees = null;
    @SerializedName("requested_reviewers")
    private List<Object> requestedReviewers = null;
    @SerializedName("milestone")
    private Object milestone;
    @SerializedName("commits_url")
    private String commitsUrl;
    @SerializedName("review_comments_url")
    private String reviewCommentsUrl;
    @SerializedName("review_comment_url")
    private String reviewCommentUrl;
    @SerializedName("comments_url")
    private String commentsUrl;
    @SerializedName("statuses_url")
    private String statusesUrl;
    @SerializedName("head")
    private PullHead head;
    @SerializedName("base")
    private PullBase base;
    @SerializedName("_links")
    private PullLink links;
    @SerializedName("author_association")
    private String authorAssociation;

    protected Pull(Parcel in) {
        url = in.readString();
        htmlUrl = in.readString();
        diffUrl = in.readString();
        patchUrl = in.readString();
        issueUrl = in.readString();
        state = in.readString();
        title = in.readString();
        user = in.readParcelable(Owner.class.getClassLoader());
        body = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        mergeCommitSha = in.readString();
        commitsUrl = in.readString();
        reviewCommentsUrl = in.readString();
        reviewCommentUrl = in.readString();
        commentsUrl = in.readString();
        statusesUrl = in.readString();
        head = in.readParcelable(PullHead.class.getClassLoader());
        base = in.readParcelable(PullBase.class.getClassLoader());
        links = in.readParcelable(PullLink.class.getClassLoader());
        authorAssociation = in.readString();
    }

    public static final Creator<Pull> CREATOR = new Creator<Pull>() {
        @Override
        public Pull createFromParcel(Parcel in) {
            return new Pull(in);
        }

        @Override
        public Pull[] newArray(int size) {
            return new Pull[size];
        }
    };

    public String dateCreate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DatePattern.DATE_ENGLISH);
        SimpleDateFormat defaultFormat = new SimpleDateFormat(Constants.DatePattern.DEFAULT_FORMAT);
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(getCreatedAt());
            return defaultFormat.format(convertedDate);
        } catch (ParseException e) {
            return "";
        }
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDiffUrl() {
        return diffUrl;
    }

    public String getPatchUrl() {
        return patchUrl;
    }

    public String getIssueUrl() {
        return issueUrl;
    }

    public Integer getNumber() {
        return number;
    }

    public String getState() {
        return state;
    }

    public Boolean getLocked() {
        return locked;
    }

    public String getTitle() {
        return title;
    }

    public Owner getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Object getClosedAt() {
        return closedAt;
    }

    public Object getMergedAt() {
        return mergedAt;
    }

    public String getMergeCommitSha() {
        return mergeCommitSha;
    }

    public Object getAssignee() {
        return assignee;
    }

    public List<Object> getAssignees() {
        return assignees;
    }

    public List<Object> getRequestedReviewers() {
        return requestedReviewers;
    }

    public Object getMilestone() {
        return milestone;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getReviewCommentsUrl() {
        return reviewCommentsUrl;
    }

    public String getReviewCommentUrl() {
        return reviewCommentUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public PullHead getHead() {
        return head;
    }

    public PullBase getBase() {
        return base;
    }

    public PullLink getLinks() {
        return links;
    }

    public String getAuthorAssociation() {
        return authorAssociation;
    }

    public boolean isClosed() {
        return getState().equalsIgnoreCase(STATE_CLOSED);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url);
        parcel.writeString(htmlUrl);
        parcel.writeString(diffUrl);
        parcel.writeString(patchUrl);
        parcel.writeString(issueUrl);
        parcel.writeString(state);
        parcel.writeString(title);
        parcel.writeParcelable(user, i);
        parcel.writeString(body);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(mergeCommitSha);
        parcel.writeString(commitsUrl);
        parcel.writeString(reviewCommentsUrl);
        parcel.writeString(reviewCommentUrl);
        parcel.writeString(commentsUrl);
        parcel.writeString(statusesUrl);
        parcel.writeParcelable(head, i);
        parcel.writeParcelable(base, i);
        parcel.writeParcelable(links, i);
        parcel.writeString(authorAssociation);
    }
}

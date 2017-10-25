package com.app.desafio_mobile_android.service.model.pull;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PullLink implements Parcelable {
    @SerializedName("self")
    private PullLinkItem self;
    @SerializedName("html")
    private PullLinkItem html;
    @SerializedName("issue")
    private PullLinkItem issue;
    @SerializedName("comments")
    private PullLinkItem comments;
    @SerializedName("review_comments")
    private PullLinkItem reviewComments;
    @SerializedName("review_comment")
    private PullLinkItem reviewComment;
    @SerializedName("commits")
    private PullLinkItem commits;
    @SerializedName("statuses")
    private PullLinkItem statuses;

    protected PullLink(Parcel in) {
        self = in.readParcelable(PullLinkItem.class.getClassLoader());
        html = in.readParcelable(PullLinkItem.class.getClassLoader());
        issue = in.readParcelable(PullLinkItem.class.getClassLoader());
        comments = in.readParcelable(PullLinkItem.class.getClassLoader());
        reviewComments = in.readParcelable(PullLinkItem.class.getClassLoader());
        reviewComment = in.readParcelable(PullLinkItem.class.getClassLoader());
        commits = in.readParcelable(PullLinkItem.class.getClassLoader());
        statuses = in.readParcelable(PullLinkItem.class.getClassLoader());
    }

    public static final Creator<PullLink> CREATOR = new Creator<PullLink>() {
        @Override
        public PullLink createFromParcel(Parcel in) {
            return new PullLink(in);
        }

        @Override
        public PullLink[] newArray(int size) {
            return new PullLink[size];
        }
    };

    public PullLinkItem getSelf() {
        return self;
    }

    public PullLinkItem getHtml() {
        return html;
    }

    public PullLinkItem getIssue() {
        return issue;
    }

    public PullLinkItem getComments() {
        return comments;
    }

    public PullLinkItem getReviewComments() {
        return reviewComments;
    }

    public PullLinkItem getReviewComment() {
        return reviewComment;
    }

    public PullLinkItem getCommits() {
        return commits;
    }

    public PullLinkItem getStatuses() {
        return statuses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(self, i);
        parcel.writeParcelable(html, i);
        parcel.writeParcelable(issue, i);
        parcel.writeParcelable(comments, i);
        parcel.writeParcelable(reviewComments, i);
        parcel.writeParcelable(reviewComment, i);
        parcel.writeParcelable(commits, i);
        parcel.writeParcelable(statuses, i);
    }
}

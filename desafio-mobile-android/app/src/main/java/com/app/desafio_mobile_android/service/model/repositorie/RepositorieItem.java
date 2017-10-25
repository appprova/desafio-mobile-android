package com.app.desafio_mobile_android.service.model.repositorie;

import android.os.Parcel;
import android.os.Parcelable;

import com.app.desafio_mobile_android.service.model.Owner;
import com.google.gson.annotations.SerializedName;

/**
 * Clase de mapeamento do objeto Repositorie - Item da lista de respositórios retornado pela API
 */

public class RepositorieItem implements Parcelable{

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("owner")
    private Owner owner;
    @SerializedName("private")
    private boolean _private;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("description")
    private String description;
    @SerializedName("fork")
    private boolean fork;
    @SerializedName("url")
    private String url;
    @SerializedName("forks_url")
    private String forksUrl;
    @SerializedName("keys_url")
    private String keysUrl;
    @SerializedName("collaborators_url")
    private String collaboratorsUrl;
    @SerializedName("teams_url")
    private String teamsUrl;
    @SerializedName("hooks_url")
    private String hooksUrl;
    @SerializedName("issue_events_url")
    private String issueEventsUrl;
    @SerializedName("events_url")
    private String eventsUrl;
    @SerializedName("assignees_url")
    private String assigneesUrl;
    @SerializedName("branches_url")
    private String branchesUrl;
    @SerializedName("tags_url")
    private String tagsUrl;
    @SerializedName("blobs_url")
    private String blobsUrl;
    @SerializedName("git_tags_url")
    private String gitTagsUrl;
    @SerializedName("git_refs_url")
    private String gitRefsUrl;
    @SerializedName("trees_url")
    private String treesUrl;
    @SerializedName("statuses_url")
    private String statusesUrl;
    @SerializedName("languages_url")
    private String languagesUrl;
    @SerializedName("stargazers_url")
    private String stargazersUrl;
    @SerializedName("contributors_url")
    private String contributorsUrl;
    @SerializedName("subscribers_url")
    private String subscribersUrl;
    @SerializedName("subscription_url")
    private String subscriptionUrl;
    @SerializedName("commits_url")
    private String commitsUrl;
    @SerializedName("git_commits_url")
    private String gitCommitsUrl;
    @SerializedName("comments_url")
    private String commentsUrl;
    @SerializedName("issue_comment_url")
    private String issueCommentUrl;
    @SerializedName("contents_url")
    private String contentsUrl;
    @SerializedName("compare_url")
    private String compareUrl;
    @SerializedName("merges_url")
    private String mergesUrl;
    @SerializedName("archive_url")
    private String archiveUrl;
    @SerializedName("downloads_url")
    private String downloadsUrl;
    @SerializedName("issues_url")
    private String issuesUrl;
    @SerializedName("pulls_url")
    private String pullsUrl;
    @SerializedName("milestones_url")
    private String milestonesUrl;
    @SerializedName("notifications_url")
    private String notificationsUrl;
    @SerializedName("labels_url")
    private String labelsUrl;
    @SerializedName("releases_url")
    private String releasesUrl;
    @SerializedName("deployments_url")
    private String deploymentsUrl;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("pushed_at")
    private String pushedAt;
    @SerializedName("git_url")
    private String gitUrl;
    @SerializedName("ssh_url")
    private String sshUrl;
    @SerializedName("clone_url")
    private String cloneUrl;
    @SerializedName("svn_url")
    private String svnUrl;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("size")
    private int size;
    @SerializedName("stargazers_count")
    private int stargazersCount;
    @SerializedName("watchers_count")
    private int watchersCount;
    @SerializedName("language")
    private String language;
    @SerializedName("has_issues")
    private boolean hasIssues;
    @SerializedName("has_projects")
    private boolean hasProjects;
    @SerializedName("has_downloads")
    private boolean hasDownloads;
    @SerializedName("has_wiki")
    private boolean hasWiki;
    @SerializedName("has_pages")
    private boolean hasPages;
    @SerializedName("forks_count")
    private int forksCount;
    @SerializedName("mirror_url")
    private Object mirrorUrl;
    @SerializedName("archived")
    private boolean archived;
    @SerializedName("open_issues_count")
    private int openIssuesCount;
    @SerializedName("forks")
    private int forks;
    @SerializedName("open_issues")
    private int openIssues;
    @SerializedName("watchers")
    private int watchers;
    @SerializedName("default_branch")
    private String defaultBranch;
    @SerializedName("score")
    private int score;

    protected RepositorieItem(Parcel in) {
        id = in.readInt();
        name = in.readString();
        fullName = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        _private = in.readByte() != 0;
        htmlUrl = in.readString();
        description = in.readString();
        fork = in.readByte() != 0;
        url = in.readString();
        forksUrl = in.readString();
        keysUrl = in.readString();
        collaboratorsUrl = in.readString();
        teamsUrl = in.readString();
        hooksUrl = in.readString();
        issueEventsUrl = in.readString();
        eventsUrl = in.readString();
        assigneesUrl = in.readString();
        branchesUrl = in.readString();
        tagsUrl = in.readString();
        blobsUrl = in.readString();
        gitTagsUrl = in.readString();
        gitRefsUrl = in.readString();
        treesUrl = in.readString();
        statusesUrl = in.readString();
        languagesUrl = in.readString();
        stargazersUrl = in.readString();
        contributorsUrl = in.readString();
        subscribersUrl = in.readString();
        subscriptionUrl = in.readString();
        commitsUrl = in.readString();
        gitCommitsUrl = in.readString();
        commentsUrl = in.readString();
        issueCommentUrl = in.readString();
        contentsUrl = in.readString();
        compareUrl = in.readString();
        mergesUrl = in.readString();
        archiveUrl = in.readString();
        downloadsUrl = in.readString();
        issuesUrl = in.readString();
        pullsUrl = in.readString();
        milestonesUrl = in.readString();
        notificationsUrl = in.readString();
        labelsUrl = in.readString();
        releasesUrl = in.readString();
        deploymentsUrl = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        pushedAt = in.readString();
        gitUrl = in.readString();
        sshUrl = in.readString();
        cloneUrl = in.readString();
        svnUrl = in.readString();
        homepage = in.readString();
        size = in.readInt();
        stargazersCount = in.readInt();
        watchersCount = in.readInt();
        language = in.readString();
        hasIssues = in.readByte() != 0;
        hasProjects = in.readByte() != 0;
        hasDownloads = in.readByte() != 0;
        hasWiki = in.readByte() != 0;
        hasPages = in.readByte() != 0;
        forksCount = in.readInt();
        archived = in.readByte() != 0;
        openIssuesCount = in.readInt();
        forks = in.readInt();
        openIssues = in.readInt();
        watchers = in.readInt();
        defaultBranch = in.readString();
        score = in.readInt();
    }

    public static final Creator<RepositorieItem> CREATOR = new Creator<RepositorieItem>() {
        @Override
        public RepositorieItem createFromParcel(Parcel in) {
            return new RepositorieItem(in);
        }

        @Override
        public RepositorieItem[] newArray(int size) {
            return new RepositorieItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(fullName);
        parcel.writeParcelable(owner, i);
        parcel.writeByte((byte) (_private ? 1 : 0));
        parcel.writeString(htmlUrl);
        parcel.writeString(description);
        parcel.writeByte((byte) (fork ? 1 : 0));
        parcel.writeString(url);
        parcel.writeString(forksUrl);
        parcel.writeString(keysUrl);
        parcel.writeString(collaboratorsUrl);
        parcel.writeString(teamsUrl);
        parcel.writeString(hooksUrl);
        parcel.writeString(issueEventsUrl);
        parcel.writeString(eventsUrl);
        parcel.writeString(assigneesUrl);
        parcel.writeString(branchesUrl);
        parcel.writeString(tagsUrl);
        parcel.writeString(blobsUrl);
        parcel.writeString(gitTagsUrl);
        parcel.writeString(gitRefsUrl);
        parcel.writeString(treesUrl);
        parcel.writeString(statusesUrl);
        parcel.writeString(languagesUrl);
        parcel.writeString(stargazersUrl);
        parcel.writeString(contributorsUrl);
        parcel.writeString(subscribersUrl);
        parcel.writeString(subscriptionUrl);
        parcel.writeString(commitsUrl);
        parcel.writeString(gitCommitsUrl);
        parcel.writeString(commentsUrl);
        parcel.writeString(issueCommentUrl);
        parcel.writeString(contentsUrl);
        parcel.writeString(compareUrl);
        parcel.writeString(mergesUrl);
        parcel.writeString(archiveUrl);
        parcel.writeString(downloadsUrl);
        parcel.writeString(issuesUrl);
        parcel.writeString(pullsUrl);
        parcel.writeString(milestonesUrl);
        parcel.writeString(notificationsUrl);
        parcel.writeString(labelsUrl);
        parcel.writeString(releasesUrl);
        parcel.writeString(deploymentsUrl);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(pushedAt);
        parcel.writeString(gitUrl);
        parcel.writeString(sshUrl);
        parcel.writeString(cloneUrl);
        parcel.writeString(svnUrl);
        parcel.writeString(homepage);
        parcel.writeInt(size);
        parcel.writeInt(stargazersCount);
        parcel.writeInt(watchersCount);
        parcel.writeString(language);
        parcel.writeByte((byte) (hasIssues ? 1 : 0));
        parcel.writeByte((byte) (hasProjects ? 1 : 0));
        parcel.writeByte((byte) (hasDownloads ? 1 : 0));
        parcel.writeByte((byte) (hasWiki ? 1 : 0));
        parcel.writeByte((byte) (hasPages ? 1 : 0));
        parcel.writeInt(forksCount);
        parcel.writeByte((byte) (archived ? 1 : 0));
        parcel.writeInt(openIssuesCount);
        parcel.writeInt(forks);
        parcel.writeInt(openIssues);
        parcel.writeInt(watchers);
        parcel.writeString(defaultBranch);
        parcel.writeInt(score);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean is_private() {
        return _private;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFork() {
        return fork;
    }

    public String getUrl() {
        return url;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public String getHooksUrl() {
        return hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public int getSize() {
        return size;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isHasIssues() {
        return hasIssues;
    }

    public boolean isHasProjects() {
        return hasProjects;
    }

    public boolean isHasDownloads() {
        return hasDownloads;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public boolean isHasPages() {
        return hasPages;
    }

    public int getForksCount() {
        return forksCount;
    }

    public Object getMirrorUrl() {
        return mirrorUrl;
    }

    public boolean isArchived() {
        return archived;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public int getForks() {
        return forks;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public int getScore() {
        return score;
    }
}

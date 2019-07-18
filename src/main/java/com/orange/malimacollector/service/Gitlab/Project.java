package com.orange.malimacollector.service.Gitlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    private long id;
    private String description;
    private String name;
    private String nameWithNamespace;
    private String path;
    private String pathWithNamespace;
    private String createdAt;
    private Object defaultBranch;
    private Object[] tagList;
    private String sshURLToRepo;
    private String httpURLToRepo;
    private String webURL;
    private Object readmeURL;
    private Object avatarURL;
    private long starCount;
    private long forksCount;
    private String lastActivityAt;
    private Namespace namespace;
    private Links links;
    private boolean emptyRepo;
    private boolean archived;
    private String visibility;
    private Owner owner;
    private boolean resolveOutdatedDiffDiscussions;
    private boolean containerRegistryEnabled;
    private boolean issuesEnabled;
    private boolean mergeRequestsEnabled;
    private boolean wikiEnabled;
    private boolean jobsEnabled;
    private boolean snippetsEnabled;
    private boolean sharedRunnersEnabled;
    private boolean lfsEnabled;
    private long creatorID;
    private String importStatus;
    private long openIssuesCount;
    private long ciDefaultGitDepth;
    private boolean publicJobs;
    private Object ciConfigPath;
    private Object[] sharedWithGroups;
    private boolean onlyAllowMergeIfPipelineSucceeds;
    private boolean requestAccessEnabled;
    private boolean onlyAllowMergeIfAllDiscussionsAreResolved;
    private boolean printingMergeRequestLinkEnabled;
    private String mergeMethod;
    private String externalAuthorizationClassificationLabel;
    private Permissions permissions;
    private boolean mirror;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("name_with_namespace")
    public String getNameWithNamespace() { return nameWithNamespace; }
    @JsonProperty("name_with_namespace")
    public void setNameWithNamespace(String value) { this.nameWithNamespace = value; }

    @JsonProperty("path")
    public String getPath() { return path; }
    @JsonProperty("path")
    public void setPath(String value) { this.path = value; }

    @JsonProperty("path_with_namespace")
    public String getPathWithNamespace() { return pathWithNamespace; }
    @JsonProperty("path_with_namespace")
    public void setPathWithNamespace(String value) { this.pathWithNamespace = value; }

    @JsonProperty("created_at")
    public String getCreatedAt() { return createdAt; }
    @JsonProperty("created_at")
    public void setCreatedAt(String value) { this.createdAt = value; }

    @JsonProperty("default_branch")
    public Object getDefaultBranch() { return defaultBranch; }
    @JsonProperty("default_branch")
    public void setDefaultBranch(Object value) { this.defaultBranch = value; }

    @JsonProperty("tag_list")
    public Object[] getTagList() { return tagList; }
    @JsonProperty("tag_list")
    public void setTagList(Object[] value) { this.tagList = value; }

    @JsonProperty("ssh_url_to_repo")
    public String getSSHURLToRepo() { return sshURLToRepo; }
    @JsonProperty("ssh_url_to_repo")
    public void setSSHURLToRepo(String value) { this.sshURLToRepo = value; }

    @JsonProperty("http_url_to_repo")
    public String getHTTPURLToRepo() { return httpURLToRepo; }
    @JsonProperty("http_url_to_repo")
    public void setHTTPURLToRepo(String value) { this.httpURLToRepo = value; }

    @JsonProperty("web_url")
    public String getWebURL() { return webURL; }
    @JsonProperty("web_url")
    public void setWebURL(String value) { this.webURL = value; }

    @JsonProperty("readme_url")
    public Object getReadmeURL() { return readmeURL; }
    @JsonProperty("readme_url")
    public void setReadmeURL(Object value) { this.readmeURL = value; }

    @JsonProperty("avatar_url")
    public Object getAvatarURL() { return avatarURL; }
    @JsonProperty("avatar_url")
    public void setAvatarURL(Object value) { this.avatarURL = value; }

    @JsonProperty("star_count")
    public long getStarCount() { return starCount; }
    @JsonProperty("star_count")
    public void setStarCount(long value) { this.starCount = value; }

    @JsonProperty("forks_count")
    public long getForksCount() { return forksCount; }
    @JsonProperty("forks_count")
    public void setForksCount(long value) { this.forksCount = value; }

    @JsonProperty("last_activity_at")
    public String getLastActivityAt() { return lastActivityAt; }
    @JsonProperty("last_activity_at")
    public void setLastActivityAt(String value) { this.lastActivityAt = value; }

    @JsonProperty("namespace")
    public Namespace getNamespace() { return namespace; }
    @JsonProperty("namespace")
    public void setNamespace(Namespace value) { this.namespace = value; }

    @JsonProperty("_links")
    public Links getLinks() { return links; }
    @JsonProperty("_links")
    public void setLinks(Links value) { this.links = value; }

    @JsonProperty("empty_repo")
    public boolean getEmptyRepo() { return emptyRepo; }
    @JsonProperty("empty_repo")
    public void setEmptyRepo(boolean value) { this.emptyRepo = value; }

    @JsonProperty("archived")
    public boolean getArchived() { return archived; }
    @JsonProperty("archived")
    public void setArchived(boolean value) { this.archived = value; }

    @JsonProperty("visibility")
    public String getVisibility() { return visibility; }
    @JsonProperty("visibility")
    public void setVisibility(String value) { this.visibility = value; }

    @JsonProperty("owner")
    public Owner getOwner() { return owner; }
    @JsonProperty("owner")
    public void setOwner(Owner value) { this.owner = value; }

    @JsonProperty("resolve_outdated_diff_discussions")
    public boolean getResolveOutdatedDiffDiscussions() { return resolveOutdatedDiffDiscussions; }
    @JsonProperty("resolve_outdated_diff_discussions")
    public void setResolveOutdatedDiffDiscussions(boolean value) { this.resolveOutdatedDiffDiscussions = value; }

    @JsonProperty("container_registry_enabled")
    public boolean getContainerRegistryEnabled() { return containerRegistryEnabled; }
    @JsonProperty("container_registry_enabled")
    public void setContainerRegistryEnabled(boolean value) { this.containerRegistryEnabled = value; }

    @JsonProperty("issues_enabled")
    public boolean getIssuesEnabled() { return issuesEnabled; }
    @JsonProperty("issues_enabled")
    public void setIssuesEnabled(boolean value) { this.issuesEnabled = value; }

    @JsonProperty("merge_requests_enabled")
    public boolean getMergeRequestsEnabled() { return mergeRequestsEnabled; }
    @JsonProperty("merge_requests_enabled")
    public void setMergeRequestsEnabled(boolean value) { this.mergeRequestsEnabled = value; }

    @JsonProperty("wiki_enabled")
    public boolean getWikiEnabled() { return wikiEnabled; }
    @JsonProperty("wiki_enabled")
    public void setWikiEnabled(boolean value) { this.wikiEnabled = value; }

    @JsonProperty("jobs_enabled")
    public boolean getJobsEnabled() { return jobsEnabled; }
    @JsonProperty("jobs_enabled")
    public void setJobsEnabled(boolean value) { this.jobsEnabled = value; }

    @JsonProperty("snippets_enabled")
    public boolean getSnippetsEnabled() { return snippetsEnabled; }
    @JsonProperty("snippets_enabled")
    public void setSnippetsEnabled(boolean value) { this.snippetsEnabled = value; }

    @JsonProperty("shared_runners_enabled")
    public boolean getSharedRunnersEnabled() { return sharedRunnersEnabled; }
    @JsonProperty("shared_runners_enabled")
    public void setSharedRunnersEnabled(boolean value) { this.sharedRunnersEnabled = value; }

    @JsonProperty("lfs_enabled")
    public boolean getLFSEnabled() { return lfsEnabled; }
    @JsonProperty("lfs_enabled")
    public void setLFSEnabled(boolean value) { this.lfsEnabled = value; }

    @JsonProperty("creator_id")
    public long getCreatorID() { return creatorID; }
    @JsonProperty("creator_id")
    public void setCreatorID(long value) { this.creatorID = value; }

    @JsonProperty("import_status")
    public String getImportStatus() { return importStatus; }
    @JsonProperty("import_status")
    public void setImportStatus(String value) { this.importStatus = value; }

    @JsonProperty("open_issues_count")
    public long getOpenIssuesCount() { return openIssuesCount; }
    @JsonProperty("open_issues_count")
    public void setOpenIssuesCount(long value) { this.openIssuesCount = value; }

    @JsonProperty("ci_default_git_depth")
    public long getCiDefaultGitDepth() { return ciDefaultGitDepth; }
    @JsonProperty("ci_default_git_depth")
    public void setCiDefaultGitDepth(long value) { this.ciDefaultGitDepth = value; }

    @JsonProperty("public_jobs")
    public boolean getPublicJobs() { return publicJobs; }
    @JsonProperty("public_jobs")
    public void setPublicJobs(boolean value) { this.publicJobs = value; }

    @JsonProperty("ci_config_path")
    public Object getCiConfigPath() { return ciConfigPath; }
    @JsonProperty("ci_config_path")
    public void setCiConfigPath(Object value) { this.ciConfigPath = value; }

    @JsonProperty("shared_with_groups")
    public Object[] getSharedWithGroups() { return sharedWithGroups; }
    @JsonProperty("shared_with_groups")
    public void setSharedWithGroups(Object[] value) { this.sharedWithGroups = value; }

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public boolean getOnlyAllowMergeIfPipelineSucceeds() { return onlyAllowMergeIfPipelineSucceeds; }
    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public void setOnlyAllowMergeIfPipelineSucceeds(boolean value) { this.onlyAllowMergeIfPipelineSucceeds = value; }

    @JsonProperty("request_access_enabled")
    public boolean getRequestAccessEnabled() { return requestAccessEnabled; }
    @JsonProperty("request_access_enabled")
    public void setRequestAccessEnabled(boolean value) { this.requestAccessEnabled = value; }

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public boolean getOnlyAllowMergeIfAllDiscussionsAreResolved() { return onlyAllowMergeIfAllDiscussionsAreResolved; }
    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public void setOnlyAllowMergeIfAllDiscussionsAreResolved(boolean value) { this.onlyAllowMergeIfAllDiscussionsAreResolved = value; }

    @JsonProperty("printing_merge_request_link_enabled")
    public boolean getPrintingMergeRequestLinkEnabled() { return printingMergeRequestLinkEnabled; }
    @JsonProperty("printing_merge_request_link_enabled")
    public void setPrintingMergeRequestLinkEnabled(boolean value) { this.printingMergeRequestLinkEnabled = value; }

    @JsonProperty("merge_method")
    public String getMergeMethod() { return mergeMethod; }
    @JsonProperty("merge_method")
    public void setMergeMethod(String value) { this.mergeMethod = value; }

    @JsonProperty("external_authorization_classification_label")
    public String getExternalAuthorizationClassificationLabel() { return externalAuthorizationClassificationLabel; }
    @JsonProperty("external_authorization_classification_label")
    public void setExternalAuthorizationClassificationLabel(String value) { this.externalAuthorizationClassificationLabel = value; }

    @JsonProperty("permissions")
    public Permissions getPermissions() { return permissions; }
    @JsonProperty("permissions")
    public void setPermissions(Permissions value) { this.permissions = value; }

    @JsonProperty("mirror")
    public boolean getMirror() { return mirror; }
    @JsonProperty("mirror")
    public void setMirror(boolean value) { this.mirror = value; }
}
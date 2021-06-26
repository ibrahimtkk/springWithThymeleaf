package com.hitit.interview.POJO;

public class IssueField {
    private String issueKey;
    private String issueName;
    private String projectKey;

    public IssueField() {}

    public IssueField(String issueKey, String issueName, String projectKey) {
        this.issueKey = issueKey;
        this.issueName = issueName;
        this.projectKey = projectKey;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }
}

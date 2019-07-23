package com.orange.malimacollector.entities.MattermostEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String id;
    private long createAt;
    private long updateAt;
    private long deleteAt;
    private String username;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private boolean emailVerified;
    private String authService;
    private String roles;
    private String locale;
    private NotifyProps notifyProps;
    private Props props;
    private long lastPasswordUpdate;
    private long lastPictureUpdate;
    private long failedAttempts;
    private boolean mfaActive;
    private Timezone timezone;
    private String termsOfServiceID;
    private long termsOfServiceCreateAt;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("create_at")
    public long getCreateAt() { return createAt; }
    @JsonProperty("create_at")
    public void setCreateAt(long value) { this.createAt = value; }

    @JsonProperty("update_at")
    public long getUpdateAt() { return updateAt; }
    @JsonProperty("update_at")
    public void setUpdateAt(long value) { this.updateAt = value; }

    @JsonProperty("delete_at")
    public long getDeleteAt() { return deleteAt; }
    @JsonProperty("delete_at")
    public void setDeleteAt(long value) { this.deleteAt = value; }

    @JsonProperty("username")
    public String getUsername() { return username; }
    @JsonProperty("username")
    public void setUsername(String value) { this.username = value; }

    @JsonProperty("first_name")
    public String getFirstName() { return firstName; }
    @JsonProperty("first_name")
    public void setFirstName(String value) { this.firstName = value; }

    @JsonProperty("last_name")
    public String getLastName() { return lastName; }
    @JsonProperty("last_name")
    public void setLastName(String value) { this.lastName = value; }

    @JsonProperty("nickname")
    public String getNickname() { return nickname; }
    @JsonProperty("nickname")
    public void setNickname(String value) { this.nickname = value; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("email_verified")
    public boolean getEmailVerified() { return emailVerified; }
    @JsonProperty("email_verified")
    public void setEmailVerified(boolean value) { this.emailVerified = value; }

    @JsonProperty("auth_service")
    public String getAuthService() { return authService; }
    @JsonProperty("auth_service")
    public void setAuthService(String value) { this.authService = value; }

    @JsonProperty("roles")
    public String getRoles() { return roles; }
    @JsonProperty("roles")
    public void setRoles(String value) { this.roles = value; }

    @JsonProperty("locale")
    public String getLocale() { return locale; }
    @JsonProperty("locale")
    public void setLocale(String value) { this.locale = value; }

    @JsonProperty("notify_props")
    public NotifyProps getNotifyProps() { return notifyProps; }
    @JsonProperty("notify_props")
    public void setNotifyProps(NotifyProps value) { this.notifyProps = value; }

    @JsonProperty("props")
    public Props getProps() { return props; }
    @JsonProperty("props")
    public void setProps(Props value) { this.props = value; }

    @JsonProperty("last_password_update")
    public long getLastPasswordUpdate() { return lastPasswordUpdate; }
    @JsonProperty("last_password_update")
    public void setLastPasswordUpdate(long value) { this.lastPasswordUpdate = value; }

    @JsonProperty("last_picture_update")
    public long getLastPictureUpdate() { return lastPictureUpdate; }
    @JsonProperty("last_picture_update")
    public void setLastPictureUpdate(long value) { this.lastPictureUpdate = value; }

    @JsonProperty("failed_attempts")
    public long getFailedAttempts() { return failedAttempts; }
    @JsonProperty("failed_attempts")
    public void setFailedAttempts(long value) { this.failedAttempts = value; }

    @JsonProperty("mfa_active")
    public boolean getMfaActive() { return mfaActive; }
    @JsonProperty("mfa_active")
    public void setMfaActive(boolean value) { this.mfaActive = value; }

    @JsonProperty("timezone")
    public Timezone getTimezone() { return timezone; }
    @JsonProperty("timezone")
    public void setTimezone(Timezone value) { this.timezone = value; }

    @JsonProperty("terms_of_service_id")
    public String getTermsOfServiceID() { return termsOfServiceID; }
    @JsonProperty("terms_of_service_id")
    public void setTermsOfServiceID(String value) { this.termsOfServiceID = value; }

    @JsonProperty("terms_of_service_create_at")
    public long getTermsOfServiceCreateAt() { return termsOfServiceCreateAt; }
    @JsonProperty("terms_of_service_create_at")
    public void setTermsOfServiceCreateAt(long value) { this.termsOfServiceCreateAt = value; }
}

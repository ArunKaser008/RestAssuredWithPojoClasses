package com.Pojos;

public class ProjectsAuthorizationPojo {

    public String clientId;
    public String clientSecret;
    public String password;
    public String userName;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProjectsAuthorizationPojo() {
    }

    /**
     *
     * @param password
     * @param clientId
     * @param clientSecret
     * @param userName
     */
    public ProjectsAuthorizationPojo(String clientId, String clientSecret, String password, String userName) {
        super();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.password = password;
        this.userName = userName;
    }

}
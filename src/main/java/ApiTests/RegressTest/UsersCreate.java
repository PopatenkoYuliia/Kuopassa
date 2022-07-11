package ApiTests.RegressTest;

import java.util.Date;

public class UsersCreate {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;

    public UsersCreate() {
    }

    public UsersCreate(String name, String job) {
        this.name = name;
        this.job = job;
    }


    public UsersCreate(String name, String job, String id, String createdAt, String updatedAt) {
        this.name = name;
        this.job = job;
        this.id=id;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}

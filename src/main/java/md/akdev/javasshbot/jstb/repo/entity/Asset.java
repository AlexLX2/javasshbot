package md.akdev.javasshbot.jstb.repo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "assets")
public class Asset {
    @Id
    private long id;

    private String name;
    private String ip;
    private String login;
    private String password;

    @Override
    public String toString(){
        return getName() + " | " + getIp() + "\n";
    }
}

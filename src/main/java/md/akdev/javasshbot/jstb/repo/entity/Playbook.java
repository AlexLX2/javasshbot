package md.akdev.javasshbot.jstb.repo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "playbooks")
public class Playbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "command")
    private String command;

    @Column(name = "\"asset_type_id\"")
    private Integer assetTypeId;

}
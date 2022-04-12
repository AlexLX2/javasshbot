package md.akdev.javasshbot.jstb.repo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "\"asset_types\"")
public class AssetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}
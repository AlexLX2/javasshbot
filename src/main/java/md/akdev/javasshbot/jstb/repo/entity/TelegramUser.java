package md.akdev.javasshbot.jstb.repo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tg_users")
public class TelegramUser {

    @Id
    @Column(name="chat_id")
    private Long chatId;

    @Column(name="active")
    private boolean active;

    @Column(name="username")
    private String userName;
}

package com.beyond.kkwoborrow.content.entity;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContentID")
    private long contentId;

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "SendTime")
    private LocalDateTime sendTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "UserType")
    private UserType userType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ChatID")
    private ChatList chatId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "NotificationID")
    private Notifications notificationId;

}
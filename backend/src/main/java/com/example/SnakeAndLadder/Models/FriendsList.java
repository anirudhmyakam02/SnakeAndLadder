package com.example.SnakeAndLadder.Models;

import java.time.LocalDateTime;
import java.util.UUID;

public class FriendsList {

    private UUID id;

    private UUID requester_id;
    private UUID addressee_id;

    private FriendsListEnum status;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}

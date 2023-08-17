package com.lordgasmic.bff.session.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("SessionDetails")
public class SessionDetails implements Serializable {
    private String username;
    private int roles;
    private String authToken;
}

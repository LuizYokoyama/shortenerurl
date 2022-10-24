package com.ls.shortnerurl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RedisHash("Urlmap")
public class UrlMap implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private String urlShortId;

    private String redirectUrl;


}

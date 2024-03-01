package org.surfsharing.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto implements Serializable {
    Long id;
    String title;
    String content;
    Long userId;
    Long groupeId;
    Integer likeCounter;
    boolean deleted;
}



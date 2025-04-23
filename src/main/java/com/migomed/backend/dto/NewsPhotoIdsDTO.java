package com.migomed.backend.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class NewsPhotoIdsDTO {
    private List<Long> photoIds;
    private List<Long> newsIds;
}

package com.appsdeveloperblog.photoapp.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponseModel {
    private String albumId;
    private String userId; 
    private String name;
    private String description; 
}

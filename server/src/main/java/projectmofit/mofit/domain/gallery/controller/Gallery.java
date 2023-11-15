package projectmofit.mofit.domain.gallery.controller;

import lombok.Data;

@Data
public class Gallery {

    private int index;
    private int groupId;
    private String content;
    private String date;
    private byte[] img;

}

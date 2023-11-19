package projectmofit.mofit.domain.gallery.dto;

import lombok.Data;

import java.sql.Blob;


@Data
public class Gallery {

    private int index;
    private int groupId;
    private String content;
    private int writer;
    private String date;
    private String img;
    private byte[] byteImg;
    private Object blobImg;
    protected String nickname;

}

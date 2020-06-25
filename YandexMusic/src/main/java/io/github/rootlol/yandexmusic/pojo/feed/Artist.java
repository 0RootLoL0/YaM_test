
package io.github.rootlol.yandexmusic.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Artist {

    @SerializedName("composer")
    private Boolean mComposer;
    @SerializedName("cover")
    private Cover mCover;
    @SerializedName("genres")
    private List<Object> mGenres;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("various")
    private Boolean mVarious;

    public Boolean getComposer() {
        return mComposer;
    }

    public void setComposer(Boolean composer) {
        mComposer = composer;
    }

    public Cover getCover() {
        return mCover;
    }

    public void setCover(Cover cover) {
        mCover = cover;
    }

    public List<Object> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Object> genres) {
        mGenres = genres;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getVarious() {
        return mVarious;
    }

    public void setVarious(Boolean various) {
        mVarious = various;
    }

}

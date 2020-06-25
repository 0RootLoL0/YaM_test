
package io.github.rootlol.yandexmusic.pojo.feed;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TracksToPlay {

    @SerializedName("albums")
    private List<Album> mAlbums;
    @SerializedName("artists")
    private List<Artist> mArtists;
    @SerializedName("available")
    private Boolean mAvailable;
    @SerializedName("availableForPremiumUsers")
    private Boolean mAvailableForPremiumUsers;
    @SerializedName("availableFullWithoutPermission")
    private Boolean mAvailableFullWithoutPermission;
    @SerializedName("coverUri")
    private String mCoverUri;
    @SerializedName("durationMs")
    private Long mDurationMs;
    @SerializedName("fileSize")
    private Long mFileSize;
    @SerializedName("id")
    private String mId;
    @SerializedName("lyricsAvailable")
    private Boolean mLyricsAvailable;
    @SerializedName("major")
    private Major mMajor;
    @SerializedName("normalization")
    private Normalization mNormalization;
    @SerializedName("ogImage")
    private String mOgImage;
    @SerializedName("previewDurationMs")
    private Long mPreviewDurationMs;
    @SerializedName("realId")
    private String mRealId;
    @SerializedName("rememberPosition")
    private Boolean mRememberPosition;
    @SerializedName("storageDir")
    private String mStorageDir;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;

    public List<Album> getAlbums() {
        return mAlbums;
    }

    public void setAlbums(List<Album> albums) {
        mAlbums = albums;
    }

    public List<Artist> getArtists() {
        return mArtists;
    }

    public void setArtists(List<Artist> artists) {
        mArtists = artists;
    }

    public Boolean getAvailable() {
        return mAvailable;
    }

    public void setAvailable(Boolean available) {
        mAvailable = available;
    }

    public Boolean getAvailableForPremiumUsers() {
        return mAvailableForPremiumUsers;
    }

    public void setAvailableForPremiumUsers(Boolean availableForPremiumUsers) {
        mAvailableForPremiumUsers = availableForPremiumUsers;
    }

    public Boolean getAvailableFullWithoutPermission() {
        return mAvailableFullWithoutPermission;
    }

    public void setAvailableFullWithoutPermission(Boolean availableFullWithoutPermission) {
        mAvailableFullWithoutPermission = availableFullWithoutPermission;
    }

    public String getCoverUri() {
        return mCoverUri;
    }

    public void setCoverUri(String coverUri) {
        mCoverUri = coverUri;
    }

    public Long getDurationMs() {
        return mDurationMs;
    }

    public void setDurationMs(Long durationMs) {
        mDurationMs = durationMs;
    }

    public Long getFileSize() {
        return mFileSize;
    }

    public void setFileSize(Long fileSize) {
        mFileSize = fileSize;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Boolean getLyricsAvailable() {
        return mLyricsAvailable;
    }

    public void setLyricsAvailable(Boolean lyricsAvailable) {
        mLyricsAvailable = lyricsAvailable;
    }

    public Major getMajor() {
        return mMajor;
    }

    public void setMajor(Major major) {
        mMajor = major;
    }

    public Normalization getNormalization() {
        return mNormalization;
    }

    public void setNormalization(Normalization normalization) {
        mNormalization = normalization;
    }

    public String getOgImage() {
        return mOgImage;
    }

    public void setOgImage(String ogImage) {
        mOgImage = ogImage;
    }

    public Long getPreviewDurationMs() {
        return mPreviewDurationMs;
    }

    public void setPreviewDurationMs(Long previewDurationMs) {
        mPreviewDurationMs = previewDurationMs;
    }

    public String getRealId() {
        return mRealId;
    }

    public void setRealId(String realId) {
        mRealId = realId;
    }

    public Boolean getRememberPosition() {
        return mRememberPosition;
    }

    public void setRememberPosition(Boolean rememberPosition) {
        mRememberPosition = rememberPosition;
    }

    public String getStorageDir() {
        return mStorageDir;
    }

    public void setStorageDir(String storageDir) {
        mStorageDir = storageDir;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}

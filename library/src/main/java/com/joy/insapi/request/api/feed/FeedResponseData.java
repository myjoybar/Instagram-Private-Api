package com.joy.insapi.request.api.feed;


import com.joy.insapi.response.InsBaseResponseData;
import com.joy.insapi.request.api.mediacomments.MediaCommentResponseData;

import java.util.ArrayList;
import java.util.List;

public class FeedResponseData extends InsBaseResponseData {


  private int num_results;
  private boolean more_available;
  private String next_max_id = "";
  private boolean auto_load_more_enabled;
  private List<ItemsBean> items = new ArrayList<>();

  public int getNum_results() {
    return num_results;
  }

  public void setNum_results(int num_results) {
    this.num_results = num_results;
  }

  public boolean isMore_available() {
    return more_available;
  }

  public void setMore_available(boolean more_available) {
    this.more_available = more_available;
  }

  public String getNext_max_id() {
    return next_max_id;
  }

  public void setNext_max_id(String next_max_id) {
    this.next_max_id = next_max_id;
  }

  public boolean isAuto_load_more_enabled() {
    return auto_load_more_enabled;
  }

  public void setAuto_load_more_enabled(boolean auto_load_more_enabled) {
    this.auto_load_more_enabled = auto_load_more_enabled;
  }

  public List<ItemsBean> getItems() {
    return items;
  }

  public void setItems(List<ItemsBean> items) {
    this.items = items;
  }

  public static class ItemsBean {

    private int taken_at;
    private long pk;
    private String id = "";
    private long device_timestamp;
    private int media_type; //1 photo 2 video
    private String code = "";
    private String client_cache_key = "";
    private int filter_type;
    private boolean comment_likes_enabled;
    private boolean comment_threading_enabled;
    private boolean has_more_comments;
    private int max_num_visible_preview_comments;
    private boolean can_view_more_preview_comments;
    private int comment_count;
    private String inline_composer_display_condition = "";
    private ImageVersions2Bean image_versions2 = new ImageVersions2Bean();
    private List<VideoVersionsBean> video_versions = new ArrayList<>();

    private boolean has_audio;
    private double video_duration;
    private double view_count;


    private int original_width;
    private int original_height;


    private UserBean user = new UserBean();
    private boolean can_viewer_reshare;
    private Object caption;
    private boolean caption_is_edited;
    private int like_count;
    private boolean has_liked;
    private String boosted_status = "";
    ;
    private String boost_unavailable_reason = "";
    private boolean direct_reply_to_author_enabled;
    private boolean photo_of_you;
    private FbUserTagsBean fb_user_tags = new FbUserTagsBean();
    private boolean can_viewer_save;
    private String organic_tracking_token = "";
    private LocationBean location = new LocationBean();
    private double lat;
    private double lng;
    private List<PreviewComments> preview_comments = new ArrayList<>();
    private List<MediaCommentResponseData.CommentsBean> comments = new ArrayList<>();//主动添加的字段，获取到每条post的Comments后，会往里面添加数据

    private List<String> top_likers; //"top_likers": ["nickcatbb"]
    private List<LikersBean> likers = new ArrayList<>();//获取到每条post的likers后，会往里面添加数据
    private List<FacepileTopLikersBean> facepile_top_likers;

    public int getTaken_at() {
      return taken_at;
    }

    public void setTaken_at(int taken_at) {
      this.taken_at = taken_at;
    }

    public long getPk() {
      return pk;
    }

    public void setPk(long pk) {
      this.pk = pk;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public long getDevice_timestamp() {
      return device_timestamp;
    }

    public void setDevice_timestamp(long device_timestamp) {
      this.device_timestamp = device_timestamp;
    }

    public int getMedia_type() {
      return media_type;
    }

    public void setMedia_type(int media_type) {
      this.media_type = media_type;
    }

    public void setVideo_versions(List<VideoVersionsBean> video_versions) {
      this.video_versions = video_versions;
    }

    public boolean isHas_audio() {
      return has_audio;
    }

    public void setHas_audio(boolean has_audio) {
      this.has_audio = has_audio;
    }

    public double getVideo_duration() {
      return video_duration;
    }

    public void setVideo_duration(double video_duration) {
      this.video_duration = video_duration;
    }

    public double getView_count() {
      return view_count;
    }

    public void setView_count(double view_count) {
      this.view_count = view_count;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getClient_cache_key() {
      return client_cache_key;
    }

    public void setClient_cache_key(String client_cache_key) {
      this.client_cache_key = client_cache_key;
    }

    public int getFilter_type() {
      return filter_type;
    }

    public void setFilter_type(int filter_type) {
      this.filter_type = filter_type;
    }

    public boolean isComment_likes_enabled() {
      return comment_likes_enabled;
    }

    public void setComment_likes_enabled(boolean comment_likes_enabled) {
      this.comment_likes_enabled = comment_likes_enabled;
    }

    public boolean isComment_threading_enabled() {
      return comment_threading_enabled;
    }

    public void setComment_threading_enabled(boolean comment_threading_enabled) {
      this.comment_threading_enabled = comment_threading_enabled;
    }

    public boolean isHas_more_comments() {
      return has_more_comments;
    }

    public void setHas_more_comments(boolean has_more_comments) {
      this.has_more_comments = has_more_comments;
    }

    public int getMax_num_visible_preview_comments() {
      return max_num_visible_preview_comments;
    }

    public void setMax_num_visible_preview_comments(int max_num_visible_preview_comments) {
      this.max_num_visible_preview_comments = max_num_visible_preview_comments;
    }

    public boolean isCan_view_more_preview_comments() {
      return can_view_more_preview_comments;
    }

    public void setCan_view_more_preview_comments(boolean can_view_more_preview_comments) {
      this.can_view_more_preview_comments = can_view_more_preview_comments;
    }

    public int getComment_count() {
      return comment_count;
    }

    public void setComment_count(int comment_count) {
      this.comment_count = comment_count;
    }

    public String getInline_composer_display_condition() {
      return inline_composer_display_condition;
    }

    public void setInline_composer_display_condition(String inline_composer_display_condition) {
      this.inline_composer_display_condition = inline_composer_display_condition;
    }

    public ImageVersions2Bean getImage_versions2() {
      return image_versions2;
    }

    public void setImage_versions2(ImageVersions2Bean image_versions2) {
      this.image_versions2 = image_versions2;
    }


    public int getOriginal_width() {
      return original_width;
    }

    public void setOriginal_width(int original_width) {
      this.original_width = original_width;
    }

    public int getOriginal_height() {
      return original_height;
    }

    public void setOriginal_height(int original_height) {
      this.original_height = original_height;
    }

    public UserBean getUser() {
      return user;
    }

    public void setUser(UserBean user) {
      this.user = user;
    }

    public boolean isCan_viewer_reshare() {
      return can_viewer_reshare;
    }

    public void setCan_viewer_reshare(boolean can_viewer_reshare) {
      this.can_viewer_reshare = can_viewer_reshare;
    }

    public Object getCaption() {
      return caption;
    }

    public void setCaption(Object caption) {
      this.caption = caption;
    }

    public boolean isCaption_is_edited() {
      return caption_is_edited;
    }

    public void setCaption_is_edited(boolean caption_is_edited) {
      this.caption_is_edited = caption_is_edited;
    }

    public int getLike_count() {
      return like_count;
    }

    public void setLike_count(int like_count) {
      this.like_count = like_count;
    }

    public boolean isHas_liked() {
      return has_liked;
    }

    public void setHas_liked(boolean has_liked) {
      this.has_liked = has_liked;
    }

    public String getBoosted_status() {
      return boosted_status;
    }

    public void setBoosted_status(String boosted_status) {
      this.boosted_status = boosted_status;
    }

    public String getBoost_unavailable_reason() {
      return boost_unavailable_reason;
    }

    public void setBoost_unavailable_reason(String boost_unavailable_reason) {
      this.boost_unavailable_reason = boost_unavailable_reason;
    }

    public boolean isDirect_reply_to_author_enabled() {
      return direct_reply_to_author_enabled;
    }

    public void setDirect_reply_to_author_enabled(boolean direct_reply_to_author_enabled) {
      this.direct_reply_to_author_enabled = direct_reply_to_author_enabled;
    }

    public boolean isPhoto_of_you() {
      return photo_of_you;
    }

    public void setPhoto_of_you(boolean photo_of_you) {
      this.photo_of_you = photo_of_you;
    }

    public FbUserTagsBean getFb_user_tags() {
      return fb_user_tags;
    }

    public void setFb_user_tags(FbUserTagsBean fb_user_tags) {
      this.fb_user_tags = fb_user_tags;
    }

    public boolean isCan_viewer_save() {
      return can_viewer_save;
    }

    public void setCan_viewer_save(boolean can_viewer_save) {
      this.can_viewer_save = can_viewer_save;
    }

    public String getOrganic_tracking_token() {
      return organic_tracking_token;
    }

    public void setOrganic_tracking_token(String organic_tracking_token) {
      this.organic_tracking_token = organic_tracking_token;
    }

    public LocationBean getLocation() {
      return location;
    }

    public void setLocation(LocationBean location) {
      this.location = location;
    }

    public double getLat() {
      return lat;
    }

    public void setLat(double lat) {
      this.lat = lat;
    }

    public double getLng() {
      return lng;
    }

    public void setLng(double lng) {
      this.lng = lng;
    }

    public List<?> getPreview_comments() {
      return preview_comments;
    }

    public void setPreview_comments(List<PreviewComments> preview_comments) {
      this.preview_comments = preview_comments;
    }

    public List<String> getTop_likers() {
      return top_likers;
    }

    public void setTop_likers(List<String> top_likers) {
      this.top_likers = top_likers;
    }

    public List<LikersBean> getLikers() {
      return likers;
    }

    public void setLikers(List<LikersBean> likers) {
      this.likers = likers;
    }

    public List<FacepileTopLikersBean> getFacepile_top_likers() {
      return facepile_top_likers;
    }

    public void setFacepile_top_likers(List<FacepileTopLikersBean> facepile_top_likers) {
      this.facepile_top_likers = facepile_top_likers;
    }

    public List<MediaCommentResponseData.CommentsBean> getComments() {
      return comments;
    }

    public void setComments(List<MediaCommentResponseData.CommentsBean> comments) {
      this.comments = comments;
    }

    public List<VideoVersionsBean> getVideo_versions() {
      return video_versions;
    }

    public static class ImageVersions2Bean {

      private List<CandidatesBean> candidates;

      public List<CandidatesBean> getCandidates() {
        return candidates;
      }

      public void setCandidates(List<CandidatesBean> candidates) {
        this.candidates = candidates;
      }

      public static class CandidatesBean {

        /**
         * width : 434 height : 434 url : https://scontent-lax3-2.cdninstagram.com/vp/c890b3be0129ddf390a2507a9a74dae6/5D498601/t51
         * .2885-15/e35/51104310_2131468546967921_5981674435899677046_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram
         * .com&ig_cache_key=MTk4NDg0NDA1NjUzMTc0MzE2Ng%3D%3D.2
         */

        private int width;
        private int height;
        private String url;

        public int getWidth() {
          return width;
        }

        public void setWidth(int width) {
          this.width = width;
        }

        public int getHeight() {
          return height;
        }

        public void setHeight(int height) {
          this.height = height;
        }

        public String getUrl() {
          return url;
        }

        public void setUrl(String url) {
          this.url = url;
        }
      }
    }

    public static class VideoVersionsBean {

      private int type;
      private int width;
      private int height;
      private String url;
      private String id;

      public int getType() {
        return type;
      }

      public void setType(int type) {
        this.type = type;
      }

      public int getWidth() {
        return width;
      }

      public void setWidth(int width) {
        this.width = width;
      }

      public int getHeight() {
        return height;
      }

      public void setHeight(int height) {
        this.height = height;
      }

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }
    }

    public static class UserBean {

      /**
       * pk : 322961280 username : wwwaitinglwt full_name : Dengdeng is_private : false
       * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/d43de92d3959e2adae992a5292ed44ce/5D3D709E/t51
       * .2885-19/s150x150/26303917_299353870587151_4749317017067061248_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
       * profile_pic_id : 1688273965849642530_322961280 is_verified : false
       * has_anonymous_profile_picture : false can_boost_post : true can_see_organic_insights : true
       * show_insights_terms : false reel_auto_archive : unset is_unpublished : false
       * allowed_commenter_type : any
       */

      private long pk;
      private String username;
      private String full_name;
      private boolean is_private;
      private String profile_pic_url;
      private String profile_pic_id;
      private boolean is_verified;
      private boolean has_anonymous_profile_picture;
      private boolean can_boost_post;
      private boolean can_see_organic_insights;
      private boolean show_insights_terms;
      private String reel_auto_archive;
      private boolean is_unpublished;
      private String allowed_commenter_type;

      public long getPk() {
        return pk;
      }

      public void setPk(long pk) {
        this.pk = pk;
      }

      public String getUsername() {
        return username;
      }

      public void setUsername(String username) {
        this.username = username;
      }

      public String getFull_name() {
        return full_name;
      }

      public void setFull_name(String full_name) {
        this.full_name = full_name;
      }

      public boolean isIs_private() {
        return is_private;
      }

      public void setIs_private(boolean is_private) {
        this.is_private = is_private;
      }

      public String getProfile_pic_url() {
        return profile_pic_url;
      }

      public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
      }

      public String getProfile_pic_id() {
        return profile_pic_id;
      }

      public void setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
      }

      public boolean isIs_verified() {
        return is_verified;
      }

      public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
      }

      public boolean isHas_anonymous_profile_picture() {
        return has_anonymous_profile_picture;
      }

      public void setHas_anonymous_profile_picture(boolean has_anonymous_profile_picture) {
        this.has_anonymous_profile_picture = has_anonymous_profile_picture;
      }

      public boolean isCan_boost_post() {
        return can_boost_post;
      }

      public void setCan_boost_post(boolean can_boost_post) {
        this.can_boost_post = can_boost_post;
      }

      public boolean isCan_see_organic_insights() {
        return can_see_organic_insights;
      }

      public void setCan_see_organic_insights(boolean can_see_organic_insights) {
        this.can_see_organic_insights = can_see_organic_insights;
      }

      public boolean isShow_insights_terms() {
        return show_insights_terms;
      }

      public void setShow_insights_terms(boolean show_insights_terms) {
        this.show_insights_terms = show_insights_terms;
      }

      public String getReel_auto_archive() {
        return reel_auto_archive;
      }

      public void setReel_auto_archive(String reel_auto_archive) {
        this.reel_auto_archive = reel_auto_archive;
      }

      public boolean isIs_unpublished() {
        return is_unpublished;
      }

      public void setIs_unpublished(boolean is_unpublished) {
        this.is_unpublished = is_unpublished;
      }

      public String getAllowed_commenter_type() {
        return allowed_commenter_type;
      }

      public void setAllowed_commenter_type(String allowed_commenter_type) {
        this.allowed_commenter_type = allowed_commenter_type;
      }
    }

    public static class FbUserTagsBean {

      private List<?> in;

      public List<?> getIn() {
        return in;
      }

      public void setIn(List<?> in) {
        this.in = in;
      }
    }

    public static class LocationBean {

      /**
       * pk : 242881705 name : Tianducheng address : city : short_name : Tianducheng lng :
       * 120.16666666667 lat : 30.25 external_source : facebook_places facebook_places_id :
       * 581020678612884
       */

      private long pk;
      private String name;
      private String address;
      private String city;
      private String short_name;
      private double lng;
      private double lat;
      private String external_source;
      private long facebook_places_id;

      public long getPk() {
        return pk;
      }

      public void setPk(long pk) {
        this.pk = pk;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public String getAddress() {
        return address;
      }

      public void setAddress(String address) {
        this.address = address;
      }

      public String getCity() {
        return city;
      }

      public void setCity(String city) {
        this.city = city;
      }

      public String getShort_name() {
        return short_name;
      }

      public void setShort_name(String short_name) {
        this.short_name = short_name;
      }

      public double getLng() {
        return lng;
      }

      public void setLng(double lng) {
        this.lng = lng;
      }

      public double getLat() {
        return lat;
      }

      public void setLat(double lat) {
        this.lat = lat;
      }

      public String getExternal_source() {
        return external_source;
      }

      public void setExternal_source(String external_source) {
        this.external_source = external_source;
      }

      public long getFacebook_places_id() {
        return facebook_places_id;
      }

      public void setFacebook_places_id(long facebook_places_id) {
        this.facebook_places_id = facebook_places_id;
      }
    }

    public static class LikersBean {

      /**
       * pk : 10018260970 username : cyrildon10 full_name : Cyril Chuks Joseph is_private : false
       * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/344d3cf955a6bf3cb15d484d10a04a8a/5D448F5E/t51
       * .2885-19/s150x150/49338701_870479930009386_8579057497128566784_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
       * profile_pic_id : 1950288130608645223_10018260970 is_verified : false
       */

      private long pk;
      private String username = "";
      private String full_name = "";
      private boolean is_private;
      private String profile_pic_url = "";
      private String profile_pic_id = "";
      private boolean is_verified;

      public long getPk() {
        return pk;
      }

      public void setPk(long pk) {
        this.pk = pk;
      }

      public String getUsername() {
        return username;
      }

      public void setUsername(String username) {
        this.username = username;
      }

      public String getFull_name() {
        return full_name;
      }

      public void setFull_name(String full_name) {
        this.full_name = full_name;
      }

      public boolean isIs_private() {
        return is_private;
      }

      public void setIs_private(boolean is_private) {
        this.is_private = is_private;
      }

      public String getProfile_pic_url() {
        return profile_pic_url;
      }

      public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
      }

      public String getProfile_pic_id() {
        return profile_pic_id;
      }

      public void setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
      }

      public boolean isIs_verified() {
        return is_verified;
      }

      public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
      }

      @Override
      public String toString() {
        return "LikersBean{" + "pk=" + pk + ", username='" + username + '\'' + ", full_name='"
            + full_name + '\'' + ", is_private=" + is_private + ", profile_pic_url='"
            + profile_pic_url + '\'' + ", profile_pic_id='" + profile_pic_id + '\''
            + ", is_verified=" + is_verified + '}';
      }
    }

    public static class FacepileTopLikersBean {

      /**
       * pk : 6664755214 username : nickcatbb full_name : 大嘿 is_private : false profile_pic_url :
       * https://scontent-lax3-2.cdninstagram.com/vp/a54ccd53b565f2fc3d1ed819afb179f9/5D2DA4F4/t51
       * .2885-19/s150x150/24254630_804278533088488_2262600939175149568_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
       * profile_pic_id : 1662140735656332254_6664755214 is_verified : false
       */

      private long pk;
      private String username = "";
      private String full_name = "";
      private boolean is_private;
      private String profile_pic_url = "";
      private String profile_pic_id = "";
      private boolean is_verified;

      public long getPk() {
        return pk;
      }

      public void setPk(long pk) {
        this.pk = pk;
      }

      public String getUsername() {
        return username;
      }

      public void setUsername(String username) {
        this.username = username;
      }

      public String getFull_name() {
        return full_name;
      }

      public void setFull_name(String full_name) {
        this.full_name = full_name;
      }

      public boolean isIs_private() {
        return is_private;
      }

      public void setIs_private(boolean is_private) {
        this.is_private = is_private;
      }

      public String getProfile_pic_url() {
        return profile_pic_url;
      }

      public void setProfile_pic_url(String profile_pic_url) {
        this.profile_pic_url = profile_pic_url;
      }

      public String getProfile_pic_id() {
        return profile_pic_id;
      }

      public void setProfile_pic_id(String profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
      }

      public boolean isIs_verified() {
        return is_verified;
      }

      public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
      }

      @Override
      public String toString() {
        return "FacepileTopLikersBean{" + "pk=" + pk + ", username='" + username + '\''
            + ", full_name='" + full_name + '\'' + ", is_private"
            + "=" + is_private + ", profile_pic_url='" + profile_pic_url + '\''
            + ", profile_pic_id='" + profile_pic_id + '\'' + ", " +
            "is_verified=" + is_verified + '}';
      }
    }


    public static class PreviewComments {

      /**
       * pk : 18020311288050549 user_id : 5508759949 text : աɾɾյյƙƙƙթթթ type : 0 created_at :
       * 1547115671 created_at_utc : 1547115671 content_type : comment status : Active bit_flags : 0
       * user : {"pk":5508759949,"username":"shane007808","full_name":"Shane
       * Wood","is_private":false, "profile_pic_url":"https://scontent-lax3-2.cdninstagram.com/vp/c3d6a81f05c990438e177ed7fad59711/5D466A91/t51
       * .2885-19/s150x150/43020807_941960579326420_5922667258739425280_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com",
       * "profile_pic_id":"1894777662556574394_5508759949","is_verified":false} did_report_as_spam :
       * false share_enabled : false media_id : 1925422897176694875
       */

      private long pk;
      private long user_id;
      private String text = "";
      private int type;
      private int created_at;
      private int created_at_utc;
      private String content_type = "";
      private String status = "";
      private int bit_flags;
      private UserBean user = new UserBean();
      private boolean did_report_as_spam;
      private boolean share_enabled;
      private long media_id;

      public long getPk() {
        return pk;
      }

      public void setPk(long pk) {
        this.pk = pk;
      }

      public long getUser_id() {
        return user_id;
      }

      public void setUser_id(long user_id) {
        this.user_id = user_id;
      }

      public String getText() {
        return text;
      }

      public void setText(String text) {
        this.text = text;
      }

      public int getType() {
        return type;
      }

      public void setType(int type) {
        this.type = type;
      }

      public int getCreated_at() {
        return created_at;
      }

      public void setCreated_at(int created_at) {
        this.created_at = created_at;
      }

      public int getCreated_at_utc() {
        return created_at_utc;
      }

      public void setCreated_at_utc(int created_at_utc) {
        this.created_at_utc = created_at_utc;
      }

      public String getContent_type() {
        return content_type;
      }

      public void setContent_type(String content_type) {
        this.content_type = content_type;
      }

      public String getStatus() {
        return status;
      }

      public void setStatus(String status) {
        this.status = status;
      }

      public int getBit_flags() {
        return bit_flags;
      }

      public void setBit_flags(int bit_flags) {
        this.bit_flags = bit_flags;
      }

      public UserBean getUser() {
        return user;
      }

      public void setUser(UserBean user) {
        this.user = user;
      }

      public boolean isDid_report_as_spam() {
        return did_report_as_spam;
      }

      public void setDid_report_as_spam(boolean did_report_as_spam) {
        this.did_report_as_spam = did_report_as_spam;
      }

      public boolean isShare_enabled() {
        return share_enabled;
      }

      public void setShare_enabled(boolean share_enabled) {
        this.share_enabled = share_enabled;
      }

      public long getMedia_id() {
        return media_id;
      }

      public void setMedia_id(long media_id) {
        this.media_id = media_id;
      }


    }
  }
}

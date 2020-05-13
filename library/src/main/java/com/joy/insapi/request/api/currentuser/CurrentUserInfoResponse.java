package com.joy.insapi.request.api.currentuser;

import com.joy.insapi.response.InsBaseResponseData;
import java.util.List;

/**
 * Created by Joy on 2020-03-28
 */
public class CurrentUserInfoResponse extends InsBaseResponseData {

  /**
   * user : {"pk":18093275983,"username":"hansj_1009","full_name":"hansj_1009","is_private":false,"profile_pic_url":"https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s150x150/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=845351bba9e1b1a46a7ca18529e53d8b&oe=5EAA68F6","profile_pic_id":"2221785639142502797_18093275983","is_verified":false,"has_anonymous_profile_picture":false,"biography":"I love eat","can_link_entities_in_bio":true,"biography_with_entities":{"raw_text":"I love eat","entities":[]},"external_url":"","reel_auto_archive":"on","hd_profile_pic_versions":[{"width":320,"height":320,"url":"https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s320x320/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=4d28a0e35f4773421b9be9b03a92da2d&oe=5EAA958E"}],"hd_profile_pic_url_info":{"url":"https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=1bafe34e516a5ce19503bf1a6d4a1edd&oe=5EA7518E","width":550,"height":550},"show_conversion_edit_entry":true,"allowed_commenter_type":"any","is_business":false,"account_type":1,"professional_conversion_suggested_account_type":2,"is_call_to_action_enabled":null,"phone_number":"+8613251012096","country_code":86,"national_number":13251012096,"gender":3,"email":"","trusted_username":"hansj_1009","trust_days":14}
   */

  private UserBean user;

  public UserBean getUser() {
    return user;
  }

  public void setUser(UserBean user) {
    this.user = user;
  }

  public static class UserBean {

    /**
     * pk : 18093275983
     * username : hansj_1009
     * full_name : hansj_1009
     * is_private : false
     * profile_pic_url : https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s150x150/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=845351bba9e1b1a46a7ca18529e53d8b&oe=5EAA68F6
     * profile_pic_id : 2221785639142502797_18093275983
     * is_verified : false
     * has_anonymous_profile_picture : false
     * biography : I love eat
     * can_link_entities_in_bio : true
     * biography_with_entities : {"raw_text":"I love eat","entities":[]}
     * external_url :
     * reel_auto_archive : on
     * hd_profile_pic_versions : [{"width":320,"height":320,"url":"https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s320x320/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=4d28a0e35f4773421b9be9b03a92da2d&oe=5EAA958E"}]
     * hd_profile_pic_url_info : {"url":"https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=1bafe34e516a5ce19503bf1a6d4a1edd&oe=5EA7518E","width":550,"height":550}
     * show_conversion_edit_entry : true
     * allowed_commenter_type : any
     * is_business : false
     * account_type : 1
     * professional_conversion_suggested_account_type : 2
     * is_call_to_action_enabled : null
     * phone_number : +8613251012096
     * country_code : 86
     * national_number : 13251012096
     * gender : 3
     * email :
     * trusted_username : hansj_1009
     * trust_days : 14
     */

    private long pk;
    private String username;
    private String full_name;
    private boolean is_private;
    private String profile_pic_url;
    private String profile_pic_id;
    private boolean is_verified;
    private boolean has_anonymous_profile_picture;
    private String biography;
    private boolean can_link_entities_in_bio;
    private BiographyWithEntitiesBean biography_with_entities;
    private String external_url;
    private String reel_auto_archive;
    private HdProfilePicUrlInfoBean hd_profile_pic_url_info;
    private boolean show_conversion_edit_entry;
    private String allowed_commenter_type;
    private boolean is_business;
    private int account_type;
    private int professional_conversion_suggested_account_type;
    private Object is_call_to_action_enabled;
    private String phone_number;
    private int country_code;
    private long national_number;
    private int gender;
    private String email;
    private String trusted_username;
    private int trust_days;
    private List<HdProfilePicVersionsBean> hd_profile_pic_versions;

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

    public String getBiography() {
      return biography;
    }

    public void setBiography(String biography) {
      this.biography = biography;
    }

    public boolean isCan_link_entities_in_bio() {
      return can_link_entities_in_bio;
    }

    public void setCan_link_entities_in_bio(boolean can_link_entities_in_bio) {
      this.can_link_entities_in_bio = can_link_entities_in_bio;
    }

    public BiographyWithEntitiesBean getBiography_with_entities() {
      return biography_with_entities;
    }

    public void setBiography_with_entities(BiographyWithEntitiesBean biography_with_entities) {
      this.biography_with_entities = biography_with_entities;
    }

    public String getExternal_url() {
      return external_url;
    }

    public void setExternal_url(String external_url) {
      this.external_url = external_url;
    }

    public String getReel_auto_archive() {
      return reel_auto_archive;
    }

    public void setReel_auto_archive(String reel_auto_archive) {
      this.reel_auto_archive = reel_auto_archive;
    }

    public HdProfilePicUrlInfoBean getHd_profile_pic_url_info() {
      return hd_profile_pic_url_info;
    }

    public void setHd_profile_pic_url_info(HdProfilePicUrlInfoBean hd_profile_pic_url_info) {
      this.hd_profile_pic_url_info = hd_profile_pic_url_info;
    }

    public boolean isShow_conversion_edit_entry() {
      return show_conversion_edit_entry;
    }

    public void setShow_conversion_edit_entry(boolean show_conversion_edit_entry) {
      this.show_conversion_edit_entry = show_conversion_edit_entry;
    }

    public String getAllowed_commenter_type() {
      return allowed_commenter_type;
    }

    public void setAllowed_commenter_type(String allowed_commenter_type) {
      this.allowed_commenter_type = allowed_commenter_type;
    }

    public boolean isIs_business() {
      return is_business;
    }

    public void setIs_business(boolean is_business) {
      this.is_business = is_business;
    }

    public int getAccount_type() {
      return account_type;
    }

    public void setAccount_type(int account_type) {
      this.account_type = account_type;
    }

    public int getProfessional_conversion_suggested_account_type() {
      return professional_conversion_suggested_account_type;
    }

    public void setProfessional_conversion_suggested_account_type(
        int professional_conversion_suggested_account_type) {
      this.professional_conversion_suggested_account_type = professional_conversion_suggested_account_type;
    }

    public Object getIs_call_to_action_enabled() {
      return is_call_to_action_enabled;
    }

    public void setIs_call_to_action_enabled(Object is_call_to_action_enabled) {
      this.is_call_to_action_enabled = is_call_to_action_enabled;
    }

    public String getPhone_number() {
      return phone_number;
    }

    public void setPhone_number(String phone_number) {
      this.phone_number = phone_number;
    }

    public int getCountry_code() {
      return country_code;
    }

    public void setCountry_code(int country_code) {
      this.country_code = country_code;
    }

    public long getNational_number() {
      return national_number;
    }

    public void setNational_number(long national_number) {
      this.national_number = national_number;
    }

    public int getGender() {
      return gender;
    }

    public void setGender(int gender) {
      this.gender = gender;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getTrusted_username() {
      return trusted_username;
    }

    public void setTrusted_username(String trusted_username) {
      this.trusted_username = trusted_username;
    }

    public int getTrust_days() {
      return trust_days;
    }

    public void setTrust_days(int trust_days) {
      this.trust_days = trust_days;
    }

    public List<HdProfilePicVersionsBean> getHd_profile_pic_versions() {
      return hd_profile_pic_versions;
    }

    public void setHd_profile_pic_versions(List<HdProfilePicVersionsBean> hd_profile_pic_versions) {
      this.hd_profile_pic_versions = hd_profile_pic_versions;
    }

    public static class BiographyWithEntitiesBean {

      /**
       * raw_text : I love eat
       * entities : []
       */

      private String raw_text;
      private List<?> entities;

      public String getRaw_text() {
        return raw_text;
      }

      public void setRaw_text(String raw_text) {
        this.raw_text = raw_text;
      }

      public List<?> getEntities() {
        return entities;
      }

      public void setEntities(List<?> entities) {
        this.entities = entities;
      }
    }

    public static class HdProfilePicUrlInfoBean {

      /**
       * url : https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=1bafe34e516a5ce19503bf1a6d4a1edd&oe=5EA7518E
       * width : 550
       * height : 550
       */

      private String url;
      private int width;
      private int height;

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
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
    }

    public static class HdProfilePicVersionsBean {

      /**
       * width : 320
       * height : 320
       * url : https://scontent-lax3-1.cdninstagram.com/v/t51.2885-19/s320x320/81378895_2725129640859570_9109603051877957632_n.jpg?_nc_ht=scontent-lax3-1.cdninstagram.com&_nc_ohc=ErUIDQxDCAYAX8C-apZ&oh=4d28a0e35f4773421b9be9b03a92da2d&oe=5EAA958E
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
}

package com.joy.insapi.request.api.userinfo;


import com.joy.insapi.response.InsBaseResponseData;

import java.util.ArrayList;
import java.util.List;

public class UserInfoResponseData extends InsBaseResponseData {


	/**
	 * user : {"pk":6500982440,"username":"pidan_baby","full_name":"粘人小皮蛋🐱","is_private":false,"profile_pic_url":"https://scontent-lax3-2
	 * .cdninstagram.com/vp/228c87f039923072abf04410eb952967/5D4FBC83/t51.2885-19/s150x150/33816578_2076413865764693_6202158729358475264_n
	 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com","profile_pic_id":"1809442931342413711_6500982440","is_verified":false,
	 * "has_anonymous_profile_picture":false,"media_count":30,"geo_media_count":0,"follower_count":3277,"following_count":10,
	 * "following_tag_count":0,"biography":"","external_url":"","can_boost_post":false,"can_see_organic_insights":false,"show_insights_terms":false,
	 * "can_convert_to_business":true,"can_create_sponsor_tags":false,"can_be_tagged_as_sponsor":false,"total_igtv_videos":0,"total_ar_effects":0,
	 * "reel_auto_archive":"on","is_profile_action_needed":false,"usertags_count":0,"usertag_review_enabled":false,"is_needy":false,
	 * "is_interest_account":false,"has_chaining":true,"hd_profile_pic_versions":[{"width":320,"height":320,"url":"https://scontent-lax3-2
	 * .cdninstagram.com/vp/d615b59cbede8428bb3a55f162fea5ad/5D35C7FB/t51.2885-19/s320x320/33816578_2076413865764693_6202158729358475264_n
	 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com"},{"width":640,"height":640,"url":"https://scontent-lax3-2.cdninstagram
	 * .com/vp/6be1636b4c811d45ec49c1caa833d91d/5D488D40/t51.2885-19/s640x640/33816578_2076413865764693_6202158729358475264_n
	 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com"}],"hd_profile_pic_url_info":{"url":"https://scontent-lax3-2.cdninstagram
	 * .com/vp/ec818ba026492e6a790078c51373889f/5D3F3EFB/t51.2885-19/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2
	 * .cdninstagram.com","width":1080,"height":1080},"has_placed_orders":false,"can_tag_products_from_merchants":false,
	 * "show_business_conversion_icon":false,"show_conversion_edit_entry":true,"aggregate_promote_engagement":true,"allowed_commenter_type":"any",
	 * "is_video_creator":false,"has_profile_video_feed":false,"has_highlight_reels":false,"is_eligible_to_show_fb_cross_sharing_nux":false,
	 * "page_id_for_new_suma_biz_account":null,"can_be_reported_as_fraud":false,"is_business":false,"account_type":1,
	 * "is_call_to_action_enabled":null,"include_direct_blacklist_status":true,"can_follow_hashtag":false,"is_potential_business":false,
	 * "feed_post_reshare_disabled":false,"besties_count":0,"show_besties_badge":true,"recently_bestied_by_count":0,"auto_expand_chaining":false,
	 * "highlight_reshare_disabled":false}
	 */

	private UserBean user = new UserBean();

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public static class UserBean {
		/**
		 * pk : 6500982440
		 * username : pidan_baby
		 * full_name : 粘人小皮蛋🐱
		 * is_private : false
		 * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/228c87f039923072abf04410eb952967/5D4FBC83/t51
		 * .2885-19/s150x150/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
		 * profile_pic_id : 1809442931342413711_6500982440
		 * is_verified : false
		 * has_anonymous_profile_picture : false
		 * media_count : 30
		 * geo_media_count : 0
		 * follower_count : 3277
		 * following_count : 10
		 * following_tag_count : 0
		 * biography :
		 * external_url :
		 * can_boost_post : false
		 * can_see_organic_insights : false
		 * show_insights_terms : false
		 * can_convert_to_business : true
		 * can_create_sponsor_tags : false
		 * can_be_tagged_as_sponsor : false
		 * total_igtv_videos : 0
		 * total_ar_effects : 0
		 * reel_auto_archive : on
		 * is_profile_action_needed : false
		 * usertags_count : 0
		 * usertag_review_enabled : false
		 * is_needy : false
		 * is_interest_account : false
		 * has_chaining : true
		 * hd_profile_pic_versions : [{"width":320,"height":320,"url":"https://scontent-lax3-2.cdninstagram
		 * .com/vp/d615b59cbede8428bb3a55f162fea5ad/5D35C7FB/t51.2885-19/s320x320/33816578_2076413865764693_6202158729358475264_n
		 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com"},{"width":640,"height":640,"url":"https://scontent-lax3-2.cdninstagram
		 * .com/vp/6be1636b4c811d45ec49c1caa833d91d/5D488D40/t51.2885-19/s640x640/33816578_2076413865764693_6202158729358475264_n
		 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com"}]
		 * hd_profile_pic_url_info : {"url":"https://scontent-lax3-2.cdninstagram.com/vp/ec818ba026492e6a790078c51373889f/5D3F3EFB/t51
		 * .2885-19/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com","width":1080,"height":1080}
		 * has_placed_orders : false
		 * can_tag_products_from_merchants : false
		 * show_business_conversion_icon : false
		 * show_conversion_edit_entry : true
		 * aggregate_promote_engagement : true
		 * allowed_commenter_type : any
		 * is_video_creator : false
		 * has_profile_video_feed : false
		 * has_highlight_reels : false
		 * is_eligible_to_show_fb_cross_sharing_nux : false
		 * page_id_for_new_suma_biz_account : null
		 * can_be_reported_as_fraud : false
		 * is_business : false
		 * account_type : 1
		 * is_call_to_action_enabled : null
		 * include_direct_blacklist_status : true
		 * can_follow_hashtag : false
		 * is_potential_business : false
		 * feed_post_reshare_disabled : false
		 * besties_count : 0
		 * show_besties_badge : true
		 * recently_bestied_by_count : 0
		 * auto_expand_chaining : false
		 * highlight_reshare_disabled : false
		 */

		private long pk;
		private String username;
		private String full_name;
		private boolean is_private;
		private String profile_pic_url;
		private String profile_pic_id;
		private boolean is_verified;
		private boolean has_anonymous_profile_picture;
		private int media_count;
		private int geo_media_count;
		private int follower_count;
		private int following_count;
		private int following_tag_count;
		private String biography;
		private String external_url;
		private boolean can_boost_post;
		private boolean can_see_organic_insights;
		private boolean show_insights_terms;
		private boolean can_convert_to_business;
		private boolean can_create_sponsor_tags;
		private boolean can_be_tagged_as_sponsor;
		private int total_igtv_videos;
		private int total_ar_effects;
		private String reel_auto_archive;
		private boolean is_profile_action_needed;
		private int usertags_count;
		private boolean usertag_review_enabled;
		private boolean is_needy;
		private boolean is_interest_account;
		private boolean has_chaining;
		private HdProfilePicUrlInfoBean hd_profile_pic_url_info;
		private boolean has_placed_orders;
		private boolean can_tag_products_from_merchants;
		private boolean show_business_conversion_icon;
		private boolean show_conversion_edit_entry;
		private boolean aggregate_promote_engagement;
		private String allowed_commenter_type;
		private boolean is_video_creator;
		private boolean has_profile_video_feed;
		private boolean has_highlight_reels;
		private boolean is_eligible_to_show_fb_cross_sharing_nux;
		private Object page_id_for_new_suma_biz_account;
		private boolean can_be_reported_as_fraud;
		private boolean is_business;
		private int account_type;
		private Object is_call_to_action_enabled;
		private boolean include_direct_blacklist_status;
		private boolean can_follow_hashtag;
		private boolean is_potential_business;
		private boolean feed_post_reshare_disabled;
		private int besties_count;
		private boolean show_besties_badge;
		private int recently_bestied_by_count;
		private boolean auto_expand_chaining;
		private boolean highlight_reshare_disabled;
		private List<HdProfilePicVersionsBean> hd_profile_pic_versions = new ArrayList<>(0);

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

		public int getMedia_count() {
			return media_count;
		}

		public void setMedia_count(int media_count) {
			this.media_count = media_count;
		}

		public int getGeo_media_count() {
			return geo_media_count;
		}

		public void setGeo_media_count(int geo_media_count) {
			this.geo_media_count = geo_media_count;
		}

		public int getFollower_count() {
			return follower_count;
		}

		public void setFollower_count(int follower_count) {
			this.follower_count = follower_count;
		}

		public int getFollowing_count() {
			return following_count;
		}

		public void setFollowing_count(int following_count) {
			this.following_count = following_count;
		}

		public int getFollowing_tag_count() {
			return following_tag_count;
		}

		public void setFollowing_tag_count(int following_tag_count) {
			this.following_tag_count = following_tag_count;
		}

		public String getBiography() {
			return biography;
		}

		public void setBiography(String biography) {
			this.biography = biography;
		}

		public String getExternal_url() {
			return external_url;
		}

		public void setExternal_url(String external_url) {
			this.external_url = external_url;
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

		public boolean isCan_convert_to_business() {
			return can_convert_to_business;
		}

		public void setCan_convert_to_business(boolean can_convert_to_business) {
			this.can_convert_to_business = can_convert_to_business;
		}

		public boolean isCan_create_sponsor_tags() {
			return can_create_sponsor_tags;
		}

		public void setCan_create_sponsor_tags(boolean can_create_sponsor_tags) {
			this.can_create_sponsor_tags = can_create_sponsor_tags;
		}

		public boolean isCan_be_tagged_as_sponsor() {
			return can_be_tagged_as_sponsor;
		}

		public void setCan_be_tagged_as_sponsor(boolean can_be_tagged_as_sponsor) {
			this.can_be_tagged_as_sponsor = can_be_tagged_as_sponsor;
		}

		public int getTotal_igtv_videos() {
			return total_igtv_videos;
		}

		public void setTotal_igtv_videos(int total_igtv_videos) {
			this.total_igtv_videos = total_igtv_videos;
		}

		public int getTotal_ar_effects() {
			return total_ar_effects;
		}

		public void setTotal_ar_effects(int total_ar_effects) {
			this.total_ar_effects = total_ar_effects;
		}

		public String getReel_auto_archive() {
			return reel_auto_archive;
		}

		public void setReel_auto_archive(String reel_auto_archive) {
			this.reel_auto_archive = reel_auto_archive;
		}

		public boolean isIs_profile_action_needed() {
			return is_profile_action_needed;
		}

		public void setIs_profile_action_needed(boolean is_profile_action_needed) {
			this.is_profile_action_needed = is_profile_action_needed;
		}

		public int getUsertags_count() {
			return usertags_count;
		}

		public void setUsertags_count(int usertags_count) {
			this.usertags_count = usertags_count;
		}

		public boolean isUsertag_review_enabled() {
			return usertag_review_enabled;
		}

		public void setUsertag_review_enabled(boolean usertag_review_enabled) {
			this.usertag_review_enabled = usertag_review_enabled;
		}

		public boolean isIs_needy() {
			return is_needy;
		}

		public void setIs_needy(boolean is_needy) {
			this.is_needy = is_needy;
		}

		public boolean isIs_interest_account() {
			return is_interest_account;
		}

		public void setIs_interest_account(boolean is_interest_account) {
			this.is_interest_account = is_interest_account;
		}

		public boolean isHas_chaining() {
			return has_chaining;
		}

		public void setHas_chaining(boolean has_chaining) {
			this.has_chaining = has_chaining;
		}

		public HdProfilePicUrlInfoBean getHd_profile_pic_url_info() {
			return hd_profile_pic_url_info;
		}

		public void setHd_profile_pic_url_info(HdProfilePicUrlInfoBean hd_profile_pic_url_info) {
			this.hd_profile_pic_url_info = hd_profile_pic_url_info;
		}

		public boolean isHas_placed_orders() {
			return has_placed_orders;
		}

		public void setHas_placed_orders(boolean has_placed_orders) {
			this.has_placed_orders = has_placed_orders;
		}

		public boolean isCan_tag_products_from_merchants() {
			return can_tag_products_from_merchants;
		}

		public void setCan_tag_products_from_merchants(boolean can_tag_products_from_merchants) {
			this.can_tag_products_from_merchants = can_tag_products_from_merchants;
		}

		public boolean isShow_business_conversion_icon() {
			return show_business_conversion_icon;
		}

		public void setShow_business_conversion_icon(boolean show_business_conversion_icon) {
			this.show_business_conversion_icon = show_business_conversion_icon;
		}

		public boolean isShow_conversion_edit_entry() {
			return show_conversion_edit_entry;
		}

		public void setShow_conversion_edit_entry(boolean show_conversion_edit_entry) {
			this.show_conversion_edit_entry = show_conversion_edit_entry;
		}

		public boolean isAggregate_promote_engagement() {
			return aggregate_promote_engagement;
		}

		public void setAggregate_promote_engagement(boolean aggregate_promote_engagement) {
			this.aggregate_promote_engagement = aggregate_promote_engagement;
		}

		public String getAllowed_commenter_type() {
			return allowed_commenter_type;
		}

		public void setAllowed_commenter_type(String allowed_commenter_type) {
			this.allowed_commenter_type = allowed_commenter_type;
		}

		public boolean isIs_video_creator() {
			return is_video_creator;
		}

		public void setIs_video_creator(boolean is_video_creator) {
			this.is_video_creator = is_video_creator;
		}

		public boolean isHas_profile_video_feed() {
			return has_profile_video_feed;
		}

		public void setHas_profile_video_feed(boolean has_profile_video_feed) {
			this.has_profile_video_feed = has_profile_video_feed;
		}

		public boolean isHas_highlight_reels() {
			return has_highlight_reels;
		}

		public void setHas_highlight_reels(boolean has_highlight_reels) {
			this.has_highlight_reels = has_highlight_reels;
		}

		public boolean isIs_eligible_to_show_fb_cross_sharing_nux() {
			return is_eligible_to_show_fb_cross_sharing_nux;
		}

		public void setIs_eligible_to_show_fb_cross_sharing_nux(boolean is_eligible_to_show_fb_cross_sharing_nux) {
			this.is_eligible_to_show_fb_cross_sharing_nux = is_eligible_to_show_fb_cross_sharing_nux;
		}

		public Object getPage_id_for_new_suma_biz_account() {
			return page_id_for_new_suma_biz_account;
		}

		public void setPage_id_for_new_suma_biz_account(Object page_id_for_new_suma_biz_account) {
			this.page_id_for_new_suma_biz_account = page_id_for_new_suma_biz_account;
		}

		public boolean isCan_be_reported_as_fraud() {
			return can_be_reported_as_fraud;
		}

		public void setCan_be_reported_as_fraud(boolean can_be_reported_as_fraud) {
			this.can_be_reported_as_fraud = can_be_reported_as_fraud;
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

		public Object getIs_call_to_action_enabled() {
			return is_call_to_action_enabled;
		}

		public void setIs_call_to_action_enabled(Object is_call_to_action_enabled) {
			this.is_call_to_action_enabled = is_call_to_action_enabled;
		}

		public boolean isInclude_direct_blacklist_status() {
			return include_direct_blacklist_status;
		}

		public void setInclude_direct_blacklist_status(boolean include_direct_blacklist_status) {
			this.include_direct_blacklist_status = include_direct_blacklist_status;
		}

		public boolean isCan_follow_hashtag() {
			return can_follow_hashtag;
		}

		public void setCan_follow_hashtag(boolean can_follow_hashtag) {
			this.can_follow_hashtag = can_follow_hashtag;
		}

		public boolean isIs_potential_business() {
			return is_potential_business;
		}

		public void setIs_potential_business(boolean is_potential_business) {
			this.is_potential_business = is_potential_business;
		}

		public boolean isFeed_post_reshare_disabled() {
			return feed_post_reshare_disabled;
		}

		public void setFeed_post_reshare_disabled(boolean feed_post_reshare_disabled) {
			this.feed_post_reshare_disabled = feed_post_reshare_disabled;
		}

		public int getBesties_count() {
			return besties_count;
		}

		public void setBesties_count(int besties_count) {
			this.besties_count = besties_count;
		}

		public boolean isShow_besties_badge() {
			return show_besties_badge;
		}

		public void setShow_besties_badge(boolean show_besties_badge) {
			this.show_besties_badge = show_besties_badge;
		}

		public int getRecently_bestied_by_count() {
			return recently_bestied_by_count;
		}

		public void setRecently_bestied_by_count(int recently_bestied_by_count) {
			this.recently_bestied_by_count = recently_bestied_by_count;
		}

		public boolean isAuto_expand_chaining() {
			return auto_expand_chaining;
		}

		public void setAuto_expand_chaining(boolean auto_expand_chaining) {
			this.auto_expand_chaining = auto_expand_chaining;
		}

		public boolean isHighlight_reshare_disabled() {
			return highlight_reshare_disabled;
		}

		public void setHighlight_reshare_disabled(boolean highlight_reshare_disabled) {
			this.highlight_reshare_disabled = highlight_reshare_disabled;
		}

		public List<HdProfilePicVersionsBean> getHd_profile_pic_versions() {
			return hd_profile_pic_versions;
		}

		public void setHd_profile_pic_versions(List<HdProfilePicVersionsBean> hd_profile_pic_versions) {
			this.hd_profile_pic_versions = hd_profile_pic_versions;
		}

		public static class HdProfilePicUrlInfoBean {
			/**
			 * url : https://scontent-lax3-2.cdninstagram.com/vp/ec818ba026492e6a790078c51373889f/5D3F3EFB/t51
			 * .2885-19/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
			 * width : 1080
			 * height : 1080
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
			 * url : https://scontent-lax3-2.cdninstagram.com/vp/d615b59cbede8428bb3a55f162fea5ad/5D35C7FB/t51.2885-19/s320x320/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
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

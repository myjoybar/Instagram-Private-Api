package com.joy.insapi.request.api.mediacomments;

import com.google.gson.annotations.SerializedName;
import com.joy.insapi.response.InsBaseResponseData;

import java.util.ArrayList;
import java.util.List;

public class MediaCommentResponseData extends InsBaseResponseData {


	/**
	 * comment_likes_enabled : true
	 * comments : [{"pk":17908565473063069,"user_id":6454676505,"text":"Cool","type":0,"created_at":1511165503,"created_at_utc":1511165503,
	 * "content_type":"comment","status":"Active","bit_flags":0,"user":{"pk":6454676505,"username":"testjanna.123","full_name":"test",
	 * "is_private":false,"profile_pic_url":"https://scontent-lax3-2.cdninstagram.com/vp/f9170b657bb73959aecd56b7c0db82ff/5D30E184/t51
	 * .2885-19/s150x150/23668524_129473441067955_4767250927889416192_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com",
	 * "profile_pic_id":"1649959113733477598_6454676505","is_verified":false},"did_report_as_spam":false,"share_enabled":false,
	 * "has_liked_comment":false,"comment_like_count":0,"inline_composer_display_condition":"never"}]
	 * comment_count : 1
	 * caption : {"pk":17849694811209756,"user_id":6500982440,"text":"我是粘人的小皮蛋😉","type":1,"created_at":1511164255,"created_at_utc":1511164255,
	 * "content_type":"comment","status":"Active","bit_flags":0,"user":{"pk":6500982440,"username":"pidan_baby","full_name":"粘人小皮蛋🐱",
	 * "is_private":false,"profile_pic_url":"https://scontent-lax3-2.cdninstagram.com/vp/228c87f039923072abf04410eb952967/5D4FBC83/t51
	 * .2885-19/s150x150/33816578_2076413865764693_6202158729358475264_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com",
	 * "profile_pic_id":"1809442931342413711_6500982440","is_verified":false},"did_report_as_spam":false,"share_enabled":false,
	 * "has_translation":true}
	 * caption_is_edited : true
	 * has_more_comments : false
	 * has_more_headload_comments : false
	 * media_header_display : none
	 * display_realtime_typing_indicator : true
	 * preview_comments : []
	 * can_view_more_preview_comments : false
	 */

	private boolean comment_likes_enabled;
	private int comment_count;
	private CaptionBean caption = new CaptionBean();
	private boolean caption_is_edited;
	private boolean has_more_comments;
	private boolean has_more_headload_comments;
	private String media_header_display;
	private boolean display_realtime_typing_indicator;
	private boolean can_view_more_preview_comments;
	private List<CommentsBean> comments = new ArrayList<>();
	private List<PreviewComments> preview_comments = new ArrayList<>();

	public boolean isComment_likes_enabled() {
		return comment_likes_enabled;
	}

	public void setComment_likes_enabled(boolean comment_likes_enabled) {
		this.comment_likes_enabled = comment_likes_enabled;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public CaptionBean getCaption() {
		return caption;
	}

	public void setCaption(CaptionBean caption) {
		this.caption = caption;
	}

	public boolean isCaption_is_edited() {
		return caption_is_edited;
	}

	public void setCaption_is_edited(boolean caption_is_edited) {
		this.caption_is_edited = caption_is_edited;
	}

	public boolean isHas_more_comments() {
		return has_more_comments;
	}

	public void setHas_more_comments(boolean has_more_comments) {
		this.has_more_comments = has_more_comments;
	}

	public boolean isHas_more_headload_comments() {
		return has_more_headload_comments;
	}

	public void setHas_more_headload_comments(boolean has_more_headload_comments) {
		this.has_more_headload_comments = has_more_headload_comments;
	}

	public String getMedia_header_display() {
		return media_header_display;
	}

	public void setMedia_header_display(String media_header_display) {
		this.media_header_display = media_header_display;
	}

	public boolean isDisplay_realtime_typing_indicator() {
		return display_realtime_typing_indicator;
	}

	public void setDisplay_realtime_typing_indicator(boolean display_realtime_typing_indicator) {
		this.display_realtime_typing_indicator = display_realtime_typing_indicator;
	}

	public boolean isCan_view_more_preview_comments() {
		return can_view_more_preview_comments;
	}

	public void setCan_view_more_preview_comments(boolean can_view_more_preview_comments) {
		this.can_view_more_preview_comments = can_view_more_preview_comments;
	}

	public List<CommentsBean> getComments() {
		return comments;
	}

	public void setComments(List<CommentsBean> comments) {
		this.comments = comments;
	}

	public List<PreviewComments> getPreview_comments() {
		return preview_comments;
	}

	public void setPreview_comments(List<PreviewComments> preview_comments) {
		this.preview_comments = preview_comments;
	}

	public static class CaptionBean {
		/**
		 * pk : 17849694811209756
		 * user_id : 6500982440
		 * text : 我是粘人的小皮蛋😉
		 * type : 1
		 * created_at : 1511164255
		 * created_at_utc : 1511164255
		 * content_type : comment
		 * status : Active
		 * bit_flags : 0
		 * user : {"pk":6500982440,"username":"pidan_baby","full_name":"粘人小皮蛋🐱","is_private":false,"profile_pic_url":"https://scontent-lax3-2
		 * .cdninstagram.com/vp/228c87f039923072abf04410eb952967/5D4FBC83/t51.2885-19/s150x150/33816578_2076413865764693_6202158729358475264_n
		 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com","profile_pic_id":"1809442931342413711_6500982440","is_verified":false}
		 * did_report_as_spam : false
		 * share_enabled : false
		 * has_translation : true
		 */

		private long pk;
		private long user_id;
		private String text;
		private int type;
		private int created_at;
		private int created_at_utc;
		private String content_type;
		@SerializedName("status")
		private String statusX;
		private int bit_flags;
		private UserBean user = new UserBean();
		private boolean did_report_as_spam;
		private boolean share_enabled;
		private boolean has_translation;

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

		public String getStatusX() {
			return statusX;
		}

		public void setStatusX(String statusX) {
			this.statusX = statusX;
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

		public boolean isHas_translation() {
			return has_translation;
		}

		public void setHas_translation(boolean has_translation) {
			this.has_translation = has_translation;
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
			 */

			private long pk;
			private String username;
			private String full_name;
			private boolean is_private;
			private String profile_pic_url;
			private String profile_pic_id;
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
		}
	}

	public static class PreviewComments {

		/**
		 * pk : 18020311288050549
		 * user_id : 5508759949
		 * text : աɾɾյյƙƙƙթթթ
		 * type : 0
		 * created_at : 1547115671
		 * created_at_utc : 1547115671
		 * content_type : comment
		 * status : Active
		 * bit_flags : 0
		 * user : {"pk":5508759949,"username":"shane007808","full_name":"Shane Wood","is_private":false,
		 * "profile_pic_url":"https://scontent-lax3-2.cdninstagram.com/vp/c3d6a81f05c990438e177ed7fad59711/5D466A91/t51
		 * .2885-19/s150x150/43020807_941960579326420_5922667258739425280_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com",
		 * "profile_pic_id":"1894777662556574394_5508759949","is_verified":false}
		 * did_report_as_spam : false
		 * share_enabled : false
		 * media_id : 1925422897176694875
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
		public static class UserBean {
			/**
			 * pk : 322961280
			 * username : wwwaitinglwt
			 * full_name : Dengdeng
			 * is_private : false
			 * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/d43de92d3959e2adae992a5292ed44ce/5D3D709E/t51
			 * .2885-19/s150x150/26303917_299353870587151_4749317017067061248_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
			 * profile_pic_id : 1688273965849642530_322961280
			 * is_verified : false
			 * has_anonymous_profile_picture : false
			 * can_boost_post : true
			 * can_see_organic_insights : true
			 * show_insights_terms : false
			 * reel_auto_archive : unset
			 * is_unpublished : false
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


	}
	public static class CommentsBean {
		/**
		 * pk : 17908565473063069
		 * user_id : 6454676505
		 * text : Cool
		 * type : 0
		 * created_at : 1511165503
		 * created_at_utc : 1511165503
		 * content_type : comment
		 * status : Active
		 * bit_flags : 0
		 * user : {"pk":6454676505,"username":"testjanna.123","full_name":"test","is_private":false,"profile_pic_url":"https://scontent-lax3-2
		 * .cdninstagram.com/vp/f9170b657bb73959aecd56b7c0db82ff/5D30E184/t51.2885-19/s150x150/23668524_129473441067955_4767250927889416192_n
		 * .jpg?_nc_ht=scontent-lax3-2.cdninstagram.com","profile_pic_id":"1649959113733477598_6454676505","is_verified":false}
		 * did_report_as_spam : false
		 * share_enabled : false
		 * has_liked_comment : false
		 * comment_like_count : 0
		 * inline_composer_display_condition : never
		 */

		private long pk;
		private long user_id;
		private String text;
		private int type;
		private int created_at;
		private int created_at_utc;
		private String content_type;
		@SerializedName("status")
		private String statusX;
		private int bit_flags;
		private UserBeanX user = new UserBeanX();
		private boolean did_report_as_spam;
		private boolean share_enabled;
		private boolean has_liked_comment;
		private int comment_like_count;
		private String inline_composer_display_condition;

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

		public String getStatusX() {
			return statusX;
		}

		public void setStatusX(String statusX) {
			this.statusX = statusX;
		}

		public int getBit_flags() {
			return bit_flags;
		}

		public void setBit_flags(int bit_flags) {
			this.bit_flags = bit_flags;
		}

		public UserBeanX getUser() {
			return user;
		}

		public void setUser(UserBeanX user) {
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

		public boolean isHas_liked_comment() {
			return has_liked_comment;
		}

		public void setHas_liked_comment(boolean has_liked_comment) {
			this.has_liked_comment = has_liked_comment;
		}

		public int getComment_like_count() {
			return comment_like_count;
		}

		public void setComment_like_count(int comment_like_count) {
			this.comment_like_count = comment_like_count;
		}

		public String getInline_composer_display_condition() {
			return inline_composer_display_condition;
		}

		public void setInline_composer_display_condition(String inline_composer_display_condition) {
			this.inline_composer_display_condition = inline_composer_display_condition;
		}

		public static class UserBeanX {
			/**
			 * pk : 6454676505
			 * username : testjanna.123
			 * full_name : test
			 * is_private : false
			 * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/f9170b657bb73959aecd56b7c0db82ff/5D30E184/t51
			 * .2885-19/s150x150/23668524_129473441067955_4767250927889416192_n.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
			 * profile_pic_id : 1649959113733477598_6454676505
			 * is_verified : false
			 */

			private long pk;
			private String username;
			private String full_name;
			private boolean is_private;
			private String profile_pic_url;
			private String profile_pic_id;
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
		}
	}
}

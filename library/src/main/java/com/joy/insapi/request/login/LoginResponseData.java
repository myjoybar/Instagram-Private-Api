package com.joy.insapi.request.login;


import com.joy.insapi.request.InsBaseResponseData;

public class LoginResponseData extends InsBaseResponseData {

	/**
	 * logged_in_user : {"pk":10171477409,"username":"joy.dingtone","full_name":"Joy","is_private":false,"profile_pic_url":"https://instagram
	 * .fjed2-2.fna.fbcdn.net/vp/a926e27e7b76da4a02f480a6897aff11/5D2CF3F1/t51.2885-19/44884218_345707102882519_2446069589734326272_n
	 * .jpg?_nc_ht=instagram.fjed2-2.fna.fbcdn.net","is_verified":false,"has_anonymous_profile_picture":true,"can_boost_post":false,
	 * "is_business":false,"account_type":1,"is_call_to_action_enabled":null,"can_see_organic_insights":false,"show_insights_terms":false,
	 * "reel_auto_archive":"unset","has_placed_orders":false,"allowed_commenter_type":"any","nametag":{"mode":1,"gradient":0,"emoji":"😀",
	 * "selfie_sticker":0},"allow_contacts_sync":false,"phone_number":""}
	 * status : ok
	 */

	private LoggedInUserBean logged_in_user = new LoggedInUserBean();

	@Override
	public String toString() {
		return "LoginResponseData{" + "logged_in_user=" + logged_in_user.toString() + '}';
	}

	public LoggedInUserBean getLogged_in_user() {
		return logged_in_user;
	}

	public void setLogged_in_user(LoggedInUserBean logged_in_user) {
		this.logged_in_user = logged_in_user;
	}


	public static class LoggedInUserBean {
		/**
		 * pk : 10171477409
		 * username : joy.dingtone
		 * full_name : Joy
		 * is_private : false
		 * profile_pic_url : https://instagram.fjed2-2.fna.fbcdn.net/vp/a926e27e7b76da4a02f480a6897aff11/5D2CF3F1/t51
		 * .2885-19/44884218_345707102882519_2446069589734326272_n.jpg?_nc_ht=instagram.fjed2-2.fna.fbcdn.net
		 * is_verified : false
		 * has_anonymous_profile_picture : true
		 * can_boost_post : false
		 * is_business : false
		 * account_type : 1
		 * is_call_to_action_enabled : null
		 * can_see_organic_insights : false
		 * show_insights_terms : false
		 * reel_auto_archive : unset
		 * has_placed_orders : false
		 * allowed_commenter_type : any
		 * nametag : {"mode":1,"gradient":0,"emoji":"😀","selfie_sticker":0}
		 * allow_contacts_sync : false
		 * phone_number :
		 */

		private long pk;
		private String username = "";
		private String full_name= "";
		private boolean is_private;
		private String profile_pic_url= "";
		private boolean is_verified;
		private boolean has_anonymous_profile_picture;
		private boolean can_boost_post;
		private boolean is_business;
		private int account_type;
		private Object is_call_to_action_enabled;
		private boolean can_see_organic_insights;
		private boolean show_insights_terms;
		private String reel_auto_archive= "";
		private boolean has_placed_orders;
		private String allowed_commenter_type= "";
		private NametagBean nametag = new NametagBean();
		private boolean allow_contacts_sync;
		private String phone_number= "";

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

		public boolean isHas_placed_orders() {
			return has_placed_orders;
		}

		public void setHas_placed_orders(boolean has_placed_orders) {
			this.has_placed_orders = has_placed_orders;
		}

		public String getAllowed_commenter_type() {
			return allowed_commenter_type;
		}

		public void setAllowed_commenter_type(String allowed_commenter_type) {
			this.allowed_commenter_type = allowed_commenter_type;
		}

		public NametagBean getNametag() {
			return nametag;
		}

		public void setNametag(NametagBean nametag) {
			this.nametag = nametag;
		}

		public boolean isAllow_contacts_sync() {
			return allow_contacts_sync;
		}

		public void setAllow_contacts_sync(boolean allow_contacts_sync) {
			this.allow_contacts_sync = allow_contacts_sync;
		}

		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}


		@Override
		public String toString() {
			return "LoggedInUserBean{" + "pk=" + pk + ", username='" + username + '\'' + ", full_name='" + full_name + '\'' + ", is_private=" + is_private + ", profile_pic_url='" + profile_pic_url + '\'' + ", is_verified=" + is_verified + ", has_anonymous_profile_picture=" + has_anonymous_profile_picture + ", can_boost_post=" + can_boost_post + ", is_business=" + is_business + ", account_type=" + account_type + ", is_call_to_action_enabled=" + is_call_to_action_enabled + ", can_see_organic_insights=" + can_see_organic_insights + ", show_insights_terms=" + show_insights_terms + ", reel_auto_archive='" + reel_auto_archive + '\'' + ", has_placed_orders=" + has_placed_orders + ", allowed_commenter_type='" + allowed_commenter_type + '\'' + ", nametag=" + nametag.toString() + ", allow_contacts_sync=" + allow_contacts_sync + ", phone_number='" + phone_number + '\'' + '}';
		}

		public static class NametagBean {
			/**
			 * mode : 1
			 * gradient : 0
			 * emoji : 😀
			 * selfie_sticker : 0
			 */

			private int mode;
			private int gradient;
			private String emoji = "";
			private int selfie_sticker;

			public int getMode() {
				return mode;
			}

			public void setMode(int mode) {
				this.mode = mode;
			}

			public int getGradient() {
				return gradient;
			}

			public void setGradient(int gradient) {
				this.gradient = gradient;
			}

			public String getEmoji() {
				return emoji;
			}

			public void setEmoji(String emoji) {
				this.emoji = emoji;
			}

			public int getSelfie_sticker() {
				return selfie_sticker;
			}

			public void setSelfie_sticker(int selfie_sticker) {
				this.selfie_sticker = selfie_sticker;
			}

			@Override
			public String toString() {
				return "NametagBean{" + "mode=" + mode + ", gradient=" + gradient + ", emoji='" + emoji + '\'' + ", selfie_sticker=" + selfie_sticker + '}';
			}
		}
	}
}

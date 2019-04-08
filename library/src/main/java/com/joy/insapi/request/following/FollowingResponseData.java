package com.joy.insapi.request.following;


import com.joy.insapi.request.InsBaseResponseData;

import java.util.ArrayList;
import java.util.List;

public class FollowingResponseData extends InsBaseResponseData {

	private Object sections;
	private boolean big_list;
	private String next_max_id = "";
	private int page_size;
	private List<UsersBean> users = new ArrayList<>();

	public Object getSections() {
		return sections;
	}

	public void setSections(Object sections) {
		this.sections = sections;
	}

	public boolean isBig_list() {
		return big_list;
	}

	public void setBig_list(boolean big_list) {
		this.big_list = big_list;
	}

	public String getNext_max_id() {
		return next_max_id;
	}

	public void setNext_max_id(String next_max_id) {
		this.next_max_id = next_max_id;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public List<UsersBean> getUsers() {
		return users;
	}

	public void setUsers(List<UsersBean> users) {
		this.users = users;
	}

	public static class UsersBean {
		/**
		 * pk : 25025320
		 * username : instagram
		 * full_name : Instagram
		 * is_private : false
		 * profile_pic_url : https://scontent-lax3-2.cdninstagram.com/vp/5d86b9264b0baaf19c70b8ca02c2a0f6/5D29E55B/t51
		 * .2885-19/s150x150/14719833_310540259320655_1605122788543168512_a.jpg?_nc_ht=scontent-lax3-2.cdninstagram.com
		 * profile_pic_id : 1360316971354486387_25025320
		 * is_verified : true
		 * has_anonymous_profile_picture : false
		 * is_favorite : false
		 * latest_reel_media : 1554163918
		 */

		private long pk;
		private String username = "";
		private String full_name = "";
		private boolean is_private;
		private String profile_pic_url = "";
		private String profile_pic_id = "";
		private boolean is_verified;
		private boolean has_anonymous_profile_picture;
		private boolean is_favorite;
		private int latest_reel_media;

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

		public boolean isIs_favorite() {
			return is_favorite;
		}

		public void setIs_favorite(boolean is_favorite) {
			this.is_favorite = is_favorite;
		}

		public int getLatest_reel_media() {
			return latest_reel_media;
		}

		public void setLatest_reel_media(int latest_reel_media) {
			this.latest_reel_media = latest_reel_media;
		}
	}
}

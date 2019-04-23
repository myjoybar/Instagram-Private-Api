package com.joy.insapi.request.api.followingcreate;


import com.joy.insapi.response.InsBaseResponseData;

public class FollowingCreateResponseData extends InsBaseResponseData {


	/**
	 * friendship_status : {"following":true,"followed_by":false,"blocking":false,"muting":false,"is_private":false,"incoming_request":false,
	 * "outgoing_request":false,"is_bestie":false}
	 */

	private FriendshipStatusBean friendship_status = new FriendshipStatusBean();

	public FriendshipStatusBean getFriendship_status() {
		return friendship_status;
	}

	public void setFriendship_status(FriendshipStatusBean friendship_status) {
		this.friendship_status = friendship_status;
	}

	public static class FriendshipStatusBean {
		/**
		 * following : true
		 * followed_by : false
		 * blocking : false
		 * muting : false
		 * is_private : false
		 * incoming_request : false
		 * outgoing_request : false
		 * is_bestie : false
		 */

		private boolean following;
		private boolean followed_by;
		private boolean blocking;
		private boolean muting;
		private boolean is_private;
		private boolean incoming_request;
		private boolean outgoing_request;
		private boolean is_bestie;

		public boolean isFollowing() {
			return following;
		}

		public void setFollowing(boolean following) {
			this.following = following;
		}

		public boolean isFollowed_by() {
			return followed_by;
		}

		public void setFollowed_by(boolean followed_by) {
			this.followed_by = followed_by;
		}

		public boolean isBlocking() {
			return blocking;
		}

		public void setBlocking(boolean blocking) {
			this.blocking = blocking;
		}

		public boolean isMuting() {
			return muting;
		}

		public void setMuting(boolean muting) {
			this.muting = muting;
		}

		public boolean isIs_private() {
			return is_private;
		}

		public void setIs_private(boolean is_private) {
			this.is_private = is_private;
		}

		public boolean isIncoming_request() {
			return incoming_request;
		}

		public void setIncoming_request(boolean incoming_request) {
			this.incoming_request = incoming_request;
		}

		public boolean isOutgoing_request() {
			return outgoing_request;
		}

		public void setOutgoing_request(boolean outgoing_request) {
			this.outgoing_request = outgoing_request;
		}

		public boolean isIs_bestie() {
			return is_bestie;
		}

		public void setIs_bestie(boolean is_bestie) {
			this.is_bestie = is_bestie;
		}
	}
}

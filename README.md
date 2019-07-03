# Instagram-Private-Api


## API
 - login(String userName, String pwd)
 - getUserInfoByUserId(String userId)
 - getUserInfoByUserName(String userName)
 - getFeed()
 - getFeedLiked()
 - getFollowers()
 - getFollowing()
 - getMediaLikers()
 - getMediaComments()
 - followingCreate(String userId)
 - followingCancel(String userId)
 - mediaLike(String mediaID)
 - mediaUnLike(String mediaID)
 

## Installation
### Gradle Dependency

#####   Add the library to your project build.gradle

```gradle
compile 'com.joybar.insapi:library:1.2.5'

```

## Sample Usage

### 使用


#### 1. Login
```java
 
LoginRequest loginRequest = new LoginRequest(userName, pwd);
    loginRequest.execute(new InsRequestCallBack<LoginResponseData>() {
      @Override
      public void onSuccess(int statusCode, LoginResponseData insBaseData) {
        LLog.d(TAG, insBaseData.toString());

      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        LLog.d(TAG, String.format("errorCode= %s , errorMsg = %s", errorCode, errorMsg));
      }

```

#### 2. getUserInfo
```java
 
 private void getUserInfoByUserId(String userId) {
    UserInfoWithIDRequest userInfoRequest = new UserInfoWithIDRequest(userId);
    userInfoRequest.execute(new InsRequestCallBack<UserInfoResponseData>() {
      @Override
      public void onSuccess(int statusCode, UserInfoResponseData insBaseData) {
        Log.d(TAG, "getUserInfo onSuccess " + insBaseData.getUser().getUsername());
      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "getUserInfo onFailure = " + errorMsg);
      }
    });
  }
  
```

#### 3. follow someone
```java
 private void followingCreate(String userId) {

    FollowingCreateRequest followingCreateRequest = new FollowingCreateRequest(userId);
    followingCreateRequest.execute(new InsRequestCallBack<FollowingCreateResponseData>() {
      @Override
      public void onSuccess(int statusCode, FollowingCreateResponseData insBaseData) {
        if (insBaseData.getFriendship_status().isFollowing()) {
          Log.d(TAG, "follow onSuccess ");
        } else {
          Log.d(TAG, "follow Failure ");
        }


      }

      @Override
      public void onFailure(int errorCode, String errorMsg) {
        Log.d(TAG, "follow onFailure = " + errorMsg);
      }
    });
  }


```



#### 5. 其它使用方法详见demo注释

## License

    Copyright 2018 MyJoybar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.   
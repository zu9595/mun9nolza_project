/**
 * 
 */
		Kakao.init('3417f296b9ba3b697980f5786262df50'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized()); // sdk초기화여부판단

		//카카오로그인	
		function kakaoLogin() {
			Kakao.Auth.login({
						success : function(response) {
							Kakao.API.request({
										url : '/v2/user/me',
										success : function(response) {
											console.log(response);
											console.log(response.kakao_account.profile.nickname);
											location.href = "socialLogin.do?userName="
													+ response.kakao_account.profile.nickname
													+ "&email="
													+ response.kakao_account.email
													+ "&gender="//male,female
													+ response.kakao_account.gender;
										},
										fail : function(error) {
											console.log(error)
										},
									})
						},
						fail : function(error) {
							console.log(error)
						},
					})
		}
	
		//수정필요
		//카카오로그아웃  
		/*function kakaoLogout() {
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : '/v1/user/unlink',
					success : function(response) {
						console.log(response);
						Kakao.Auth.logout(function() {
							location.href = 'main.do';
						});
						deleteCookie();
					},
					fail : function(error) {
						console.log(error)
					},
				})
				Kakao.Auth.setAccessToken(undefined);
			}
			
			
      		
      		
		}
		
		function deleteCookie() {
			document.cookie = 'authorize-access-token=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		}*/
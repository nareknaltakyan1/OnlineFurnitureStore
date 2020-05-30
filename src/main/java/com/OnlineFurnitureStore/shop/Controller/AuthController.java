package com.OnlineFurnitureStore.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthController {

//    @Autowired
//    private AuthManager authManager;
//
//    @PostMapping(value = "/login")
//    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
//        return authManager.loginRequest(loginDTO);
//    }
//
//    @PostMapping(value = "/logout")
//    public ResponseEntity<?> logout() {
//        return authManager.logoutRequest();
//
//    }
//
//    /**
//     * get new idtoken from cognito, when old token is expired
//     *
//     * @return ResponseEntity object, with status code and AuthenticationResponse object
//     */
//    @PostMapping(value = "/refreshToken")
//    public ResponseEntity<?> refreshToken(@RequestBody @Valid RefreshTokenDTO refreshTokenDTO) {
//        return authManager.refreshToken(refreshTokenDTO);
//    }
//
//    @PutMapping(value = "/forgot-password/{username}")
//    public ResponseEntity<?> forgotPassword(@PathVariable(name = "username") @NotNull String username) {
//        return authManager.forgotPassword(username);
//    }
//
//    @PutMapping(value = "/reset-password")
//    public ResponseEntity<?> resetPassword(@RequestBody @Valid ResetPasswordDTO resetPasswordDTO) {
//        return authManager.resetPassword(resetPasswordDTO);
//    }

}

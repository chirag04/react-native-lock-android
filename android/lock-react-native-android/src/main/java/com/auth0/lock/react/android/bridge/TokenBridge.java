/*
 * TokenBridge.java
 *
 * Copyright (c) 2015 Auth0 (http://auth0.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.auth0.lock.react.android.bridge;


import com.auth0.core.Token;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class TokenBridge implements LockReactBridge {

    private static final String ACCESS_TOKEN_KEY = "accessToken";
    private static final String ID_TOKEN_KEY = "idToken";
    private static final String REFRESH_TOKEN_KEY = "refreshToken";
    private static final String TyPE_KEY = "type";
    
    private Token token;

    public TokenBridge(Token token) {
        this.token = token;
    }

    public WritableMap toMap() {
        WritableMap tokenMap = null;
        if (token != null) {
            tokenMap = Arguments.createMap();
            tokenMap.putString(ACCESS_TOKEN_KEY, token.getAccessToken());
            tokenMap.putString(ID_TOKEN_KEY, token.getIdToken());
            tokenMap.putString(REFRESH_TOKEN_KEY, token.getRefreshToken());
            tokenMap.putString(TyPE_KEY, token.getType());
        }
        return tokenMap;
    }
}
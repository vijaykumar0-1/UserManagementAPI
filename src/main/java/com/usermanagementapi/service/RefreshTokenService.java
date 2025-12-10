package com.usermanagementapi.service;

import com.usermanagementapi.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(String userId);
    RefreshToken verifyExpiration(RefreshToken token);
    void deleteByUserId(String userId);
    Optional<RefreshToken> findByToken(String token);
}

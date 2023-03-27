package com.security.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.security.modal.CachedValue;
import com.sun.jdi.PrimitiveValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class LoginAttemptService {
    public static final int MAX_ATTEMPT = 3;
    public static final int BLOCK_DURATION_PER_SECOND = 40;

    private final LoadingCache<String, CachedValue> attemptsCache;

    public LoginAttemptService() {
        attemptsCache = CacheBuilder.newBuilder()
                .expireAfterWrite(BLOCK_DURATION_PER_SECOND, TimeUnit.SECONDS)
                .build(new CacheLoader<String, CachedValue>() {
                    @Override
                    public CachedValue load(String s) throws Exception {
                        return new CachedValue(0, LocalDateTime.now());
                    }
                });
    }

    public void loginFailed(final String key) {
        CachedValue cachedValue = new CachedValue();
        try {
            cachedValue = attemptsCache.get(key);
            cachedValue.setAttempts(cachedValue.getAttempts() + 1);
        } catch (ExecutionException e) {
            cachedValue.setAttempts(0);
            log.error("Attempts to login exception");
        }

        if (isBlocked(key) && cachedValue.getBlockedTimestamp() == null) {
            cachedValue.setBlockedTimestamp(LocalDateTime.now());
        }
        attemptsCache.put(key, cachedValue);
    }

    public boolean isBlocked(String key) {
        try {
            return attemptsCache.get(key).getAttempts() >= MAX_ATTEMPT;
        } catch (ExecutionException e) {
            log.error("Attempts to login exception");
            return false;
        }
    }
}

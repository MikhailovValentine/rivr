/*
 * Copyright (c) 2013 Nu Echo Inc. All rights reserved.
 */

package com.nuecho.rivr.core.channel.synchronous.step;

import com.nuecho.rivr.core.channel.*;
import com.nuecho.rivr.core.util.*;

/**
 * Step wrapping a {@link Throwable}. This kind of step tells that a fatal error
 * occurred in the dialogue.
 * 
 * @param <O> type of {@link OutputTurn}
 * @param <L> type of {@link LastTurn}
 * @author Nu Echo Inc.
 */
public final class ErrorStep<O extends OutputTurn, L extends LastTurn> implements Step<O, L> {

    private final Throwable mThrowable;

    public ErrorStep(Throwable throwable) {
        Assert.notNull(throwable, "throwable");
        mThrowable = throwable;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

    @Override
    public String toString() {
        return "Error: " + mThrowable.toString();
    }
}

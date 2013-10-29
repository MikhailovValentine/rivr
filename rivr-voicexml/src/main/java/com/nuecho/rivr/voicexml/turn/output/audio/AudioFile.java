/*
 * Copyright (c) 2002-2003 Nu Echo Inc. All rights reserved.
 */
package com.nuecho.rivr.voicexml.turn.output.audio;

import javax.json.*;

import com.nuecho.rivr.voicexml.turn.output.fetch.*;
import com.nuecho.rivr.voicexml.util.json.*;

/**
 * A <code>AudioFile</code> represents an audio file with an optional synthesis
 * text backup.
 * 
 * @author Nu Echo Inc.
 * @see SynthesisText
 * @see ResourceFetchConfiguration
 */
public final class AudioFile extends AudioItem {
    public static final String AUDIO_FILE_ELEMENT_TYPE = "audioFile";
    private static final String RESOURCE_FETCH_CONFIGURATION_PROPERTY = "resourceFetchConfiguration";
    private static final String LOCATION_PROPERTY = "location";
    private static final String EXPRESSION_PROPERTY = "expression";
    private static final String ALTERNATE_PROPERTY = "alternate";

    private String mLocation;
    private String mExpression;
    private SynthesisText mAlternate;
    private ResourceFetchConfiguration mResourceFetchConfiguration;

    public static AudioFile fromLocation(String location) {
        AudioFile audioFile = new AudioFile();
        audioFile.mLocation = location;
        return audioFile;
    }

    public static AudioFile fromExpression(String expression) {
        AudioFile audioFile = new AudioFile();
        audioFile.mExpression = expression;
        return audioFile;
    }

    public static AudioFile fromLocation(String location, SynthesisText alternate) {
        AudioFile audioFile = fromLocation(location);
        audioFile.setAlternate(alternate);
        return audioFile;
    }

    public static AudioFile fromExpression(String expression, SynthesisText alternate) {
        AudioFile audioFile = fromExpression(expression);
        audioFile.setAlternate(alternate);
        return audioFile;
    }

    public static AudioFile fromLocation(String location, String alternate) {
        AudioFile audioFile = fromLocation(location);
        audioFile.setAlternate(alternate);
        return audioFile;
    }

    public static AudioFile fromExpression(String expression, String alternate) {
        AudioFile audioFile = fromExpression(expression);
        audioFile.setAlternate(alternate);
        return audioFile;
    }

    /**
     * @param resourceFetchConfiguration The resource fetch configuration. Null
     *            reverts to VoiceXML default value.
     */
    public void setResourceFetchConfiguration(ResourceFetchConfiguration resourceFetchConfiguration) {
        mResourceFetchConfiguration = resourceFetchConfiguration;
    }

    public void setAlternate(SynthesisText alternate) {
        mAlternate = alternate;
    }

    public void setAlternate(String alternate) {
        mAlternate = new SynthesisText(alternate);
    }

    @Override
    public String getElementType() {
        return AUDIO_FILE_ELEMENT_TYPE;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getExpression() {
        return mExpression;
    }

    public SynthesisText getAlternate() {
        return mAlternate;
    }

    public ResourceFetchConfiguration getResourceFetchConfiguration() {
        return mResourceFetchConfiguration;
    }

    @Override
    protected void addJsonProperties(JsonObjectBuilder builder) {
        JsonUtils.add(builder, LOCATION_PROPERTY, mLocation);
        JsonUtils.add(builder, EXPRESSION_PROPERTY, mExpression);
        JsonUtils.add(builder, RESOURCE_FETCH_CONFIGURATION_PROPERTY, mResourceFetchConfiguration);
        JsonUtils.add(builder, ALTERNATE_PROPERTY, mAlternate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (mExpression == null ? 0 : mExpression.hashCode());
        result = prime * result + (mLocation == null ? 0 : mLocation.hashCode());
        result = prime * result + (mResourceFetchConfiguration == null ? 0 : mResourceFetchConfiguration.hashCode());
        result = prime * result + (mAlternate == null ? 0 : mAlternate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AudioFile other = (AudioFile) obj;
        if (mExpression == null) {
            if (other.mExpression != null) return false;
        } else if (!mExpression.equals(other.mExpression)) return false;
        if (mLocation == null) {
            if (other.mLocation != null) return false;
        } else if (!mLocation.equals(other.mLocation)) return false;
        if (mResourceFetchConfiguration == null) {
            if (other.mResourceFetchConfiguration != null) return false;
        } else if (!mResourceFetchConfiguration.equals(other.mResourceFetchConfiguration)) return false;
        if (mAlternate == null) {
            if (other.mAlternate != null) return false;
        } else if (!mAlternate.equals(other.mAlternate)) return false;
        return true;
    }

}
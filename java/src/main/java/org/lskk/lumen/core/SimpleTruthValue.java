package org.lskk.lumen.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.annotation.Nullable;
import java.io.Serializable;

/**
 * Created by ceefour on 19/01/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type", defaultImpl = SimpleTruthValue.class)
@JsonSubTypes(@JsonSubTypes.Type(name = "SimpleTruthValue", value = SimpleTruthValue.class))
public class SimpleTruthValue implements Serializable {

    private Float strength;
    private Float confidence;
    private Integer count;

    public SimpleTruthValue() {
    }

    public SimpleTruthValue(Float strength, Float confidence, Integer count) {
        this.strength = strength;
        this.confidence = confidence;
        this.count = count;
    }

    public SimpleTruthValue(@Nullable float[] truthValue) {
        this.strength = truthValue != null && truthValue.length >= 1 ? truthValue[0] : null;
        this.confidence = truthValue != null && truthValue.length >= 2 ? truthValue[1] : null;
        this.count = truthValue != null && truthValue.length >= 3 ? (int)truthValue[2] : null;
    }

    /**
     * A floating-point value ranging from 0 to 1, with 0 denoting the classical Boolean false, and 1.0 denoting true.
     * @return
     */
    public Float getStrength() {
        return strength;
    }

    public void setStrength(Float strength) {
        this.strength = strength;
    }

    /**
     * A floating point value ranging from 0 to 1, expressing the certainty of the strength, with 0 denoting completely uncertain, and 1 denoting completely confident.
     * @return
     */
    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    /**
     * A raw count (integer) of having seen some event.
     * @return
     */
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

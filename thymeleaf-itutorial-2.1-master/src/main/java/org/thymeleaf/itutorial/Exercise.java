/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package org.thymeleaf.itutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.thymeleaf.itutorial.ModelAttribute.*;

public enum Exercise {

    EXERCISE01("exercise01", "Exercise 1: bean values", false, Arrays.asList(PRODUCT)),
    EXERCISE02("exercise02", "Exercise 2: simple formatting", false, Arrays.asList(PRODUCT)),
    EXERCISE03("exercise03", "Exercise 3: string concatenation", false, Arrays.asList(PRODUCT)),
    EXERCISE04("exercise04", "Exercise 4: internationalization", true, Arrays.asList(MESSAGES_EN, MESSAGES_ES, MESSAGES_FR)),
    EXERCISE05("exercise05", "Exercise 5: escaped and unescaped text", false, Arrays.asList(HTML)),
    EXERCISE06("exercise06", "Exercise 6: iteration", false, Arrays.asList(PRODUCT_LIST)),
    EXERCISE07("exercise07", "Exercise 7: iteration stats", false, Arrays.asList(PRODUCT_LIST)),
    EXERCISE08("exercise08", "Exercise 8: conditions", false, Arrays.asList(PRODUCT_LIST)),
    EXERCISE09("exercise09", "Exercise 9: more on conditions", false, Arrays.asList(CUSTOMER_LIST, GENDER, PAYMENT_METHOD)),
    EXERCISE10("exercise10", "Exercise 10: Spring expression language", false, new ArrayList()),
    EXERCISE11("exercise11", "Exercise 11: links", false, new ArrayList()),
    EXERCISE12("exercise12", "Exercise 12: forms", false, Arrays.asList(CUSTOMER, GENDER, PAYMENT_METHOD)),
    EXERCISE13("exercise13", "Exercise 13: inlining", false, Arrays.asList(CUSTOMER_NAME)),
    EXERCISE14("exercise14", "Exercise 14: same template fragments", false, new ArrayList()),
    EXERCISE15("exercise15", "Exercise 15: parameterizable fragments", false, new ArrayList()),
    EXERCISE16("exercise16", "Exercise 16: literal substitutions", false, Arrays.asList(CUSTOMER_NAME)),
    EXERCISE17("exercise17", "Exercise 17: comments", false, new ArrayList()),
    EXERCISE18("exercise18", "Exercise 18: data-* syntax", false, new ArrayList()),
    EXERCISE19("exercise19", "Exercise 19: conditional th:remove", false, Arrays.asList(CUSTOMER_LIST)),
    EXERCISE20("exercise20", "Exercise 20: conversion service", false, Arrays.asList(AMOUNT, RELEASE_DATE)),
    EXERCISE21("exercise21", "Exercise 21: template uri variables", false, Arrays.asList(PRODUCT_ID, PRODUCT_NAME));

    private final String path;
    private final String description;
    private final boolean i18nExercise;
    private final List<ModelAttribute> attributes;

    private Exercise(final String path, final String description, final boolean i18nExercise,
            final List<ModelAttribute> attributes) {
        this.path = path;
        this.description = description;
        this.i18nExercise = i18nExercise;
        this.attributes = attributes;
    }

    /** Get Exercise with provided index. */
    public static Exercise get(final int index) {
        for (Exercise exercise : values()) {
            if (index == exercise.ordinal() + 1) {
                return exercise;
            }
        }
        throw new EnumConstantNotPresentException(Exercise.class, index + "");
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public boolean isI18nExercise() {
        return i18nExercise;
    }

    public List<ModelAttribute> getAttributes() {
        return attributes;
    }

    public boolean hasAttributes() {
        return attributes != null && !attributes.isEmpty();
    }

    public int getIndex() {
        return ordinal() + 1;
    }

    /** Return previous exercise or null. */
    public Exercise getPrevious() {
        int index = getIndex();
        if (index > 1) {
            return Exercise.get(index - 1);
        }
        return null;
    }

    /** Return next exercise or null. */
    public Exercise getNext() {
        int nextIndex = getIndex() + 1;
        int size = values().length;
        if (nextIndex <= size) {
            return Exercise.get(nextIndex);
        }
        return null;
    }

    public static Exercise[] basicExercises() {
        Exercise[] basicExercises = {
            EXERCISE01, EXERCISE02, EXERCISE03, EXERCISE04, EXERCISE05, EXERCISE06, EXERCISE07,
            EXERCISE08, EXERCISE09, EXERCISE10, EXERCISE11, EXERCISE12, EXERCISE13};
        return basicExercises;
    }

    public static Exercise[] twoDotOneExercises() {
        Exercise[] twoDotOneExercises = {
            EXERCISE14, EXERCISE15, EXERCISE16, EXERCISE17, EXERCISE18, EXERCISE19, EXERCISE20,
            EXERCISE21};
        return twoDotOneExercises;
    }
}

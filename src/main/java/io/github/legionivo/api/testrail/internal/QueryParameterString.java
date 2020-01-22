/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Kunal Shah
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.legionivo.api.testrail.internal;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * String representing query parameters of a URL.
 */
public final class QueryParameterString {

    private final StringBuilder queryParamStringBuilder = new StringBuilder();

    @JsonAnySetter
    public void addQueryParameter(String key, String value) {
        if (queryParamStringBuilder.length() > 0) {
            queryParamStringBuilder.append('&');
        }
        queryParamStringBuilder.append(URLEncoder.encode(key, StandardCharsets.UTF_8)).append('=').append(URLEncoder.encode(value, StandardCharsets.UTF_8));
    }

    @Override
    public String toString() {
        return queryParamStringBuilder.toString();
    }
}

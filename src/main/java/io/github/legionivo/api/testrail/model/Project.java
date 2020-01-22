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

/**
 *
 */
package io.github.legionivo.api.testrail.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.legionivo.api.testrail.TestRail;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * TestRail project.
 */
@Data
public class Project {

    private int id;

    @JsonView({TestRail.Projects.Add.class, TestRail.Projects.Update.class})
    private String name;

    @JsonView({TestRail.Projects.Add.class, TestRail.Projects.Update.class})
    private String announcement;

    @JsonView({TestRail.Projects.Add.class, TestRail.Projects.Update.class})
    @Getter(value = AccessLevel.PRIVATE)
    private Boolean showAnnouncement;

    @JsonView(TestRail.Projects.Update.class)
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private Boolean isCompleted;

    private Date completedOn;

    private String url;

    @JsonView({TestRail.Projects.Add.class, TestRail.Projects.Update.class})
    private Integer suiteMode;

    public Boolean isCompleted() {
        return getIsCompleted();
    }

    public Project setCompleted(boolean isCompleted) {
        return setIsCompleted(isCompleted);
    }

    public Boolean isShowAnnouncement() {
        return getShowAnnouncement();
    }
}

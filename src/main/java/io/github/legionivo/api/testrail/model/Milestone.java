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

package io.github.legionivo.api.testrail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.legionivo.api.testrail.TestRail;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * TestRail milestone.
 */
@Data
public class Milestone {

    private int id;

    @JsonView({TestRail.Milestones.Add.class, TestRail.Milestones.Update.class})
    private String name;

    @JsonView({TestRail.Milestones.Add.class, TestRail.Milestones.Update.class})
    private String description;

    @JsonProperty(value = "project_id")
    private int projectId;

    @JsonView({TestRail.Milestones.Add.class, TestRail.Milestones.Update.class})
    @JsonProperty(value = "due_on")
    private Date dueOn;

    @JsonView({TestRail.Milestones.Update.class})
    @JsonProperty(value = "is_completed")
    @Getter(value = AccessLevel.PRIVATE)
    @Setter(value = AccessLevel.PRIVATE)
    private Boolean isCompleted;

    public Boolean isCompleted() {
        return getIsCompleted();
    }

    public Milestone setCompleted(boolean isCompleted) {
        return setIsCompleted(isCompleted);
    }

    @JsonProperty(value = "completed_on")
    private Date completedOn;

    private String url;

    @JsonView({TestRail.Milestones.Update.class})
    @JsonProperty(value = "is_started")
    private boolean isStarted;

    private Milestone[] milestones;

    @JsonView({TestRail.Milestones.Add.class, TestRail.Milestones.Update.class})
    @JsonProperty(value = "parent_id")
    private int parentId;

    @JsonView({TestRail.Milestones.Add.class, TestRail.Milestones.Update.class})
    @JsonProperty(value = "start_on")
    private Date startOn;

    @JsonProperty(value = "started_on")
    private Date startedOn;
}

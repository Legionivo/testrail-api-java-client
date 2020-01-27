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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import io.github.legionivo.api.testrail.TestRail;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

/**
 * TestRail run.
 */
@Data
public class Run {

    private int id;

    @JsonView({TestRail.Runs.Add.class, TestRail.Runs.Update.class})
    private String name;

    @JsonView({TestRail.Runs.Add.class, TestRail.Runs.Update.class})
    private String description;

    private String url;

    private int projectId;

    private Integer planId;

    @JsonView(TestRail.Runs.Add.class)
    private Integer suiteId;

    @JsonView({TestRail.Runs.Add.class, TestRail.Runs.Update.class})
    private Integer milestoneId;

    @JsonView({TestRail.Runs.Add.class, TestRail.Plans.Add.class, TestRail.Plans.AddEntry.class})
    private Integer assignedtoId;

    @JsonView({TestRail.Runs.Add.class, TestRail.Runs.Update.class, TestRail.Plans.Add.class, TestRail.Plans.AddEntry.class})
    private Boolean includeAll;

    @JsonProperty("case_ids")
    @JsonView({TestRail.Runs.Add.class, TestRail.Runs.Update.class, TestRail.Plans.Add.class, TestRail.Plans.AddEntry.class})
    private List<Integer> caseIds;

    private Date createdOn;

    private int createdBy;

    @JsonProperty
    @Getter(onMethod_ = {@JsonIgnore})
    private boolean isCompleted;

    private Date completedOn;

    @JsonProperty("config")
    private String config;

    @JsonProperty("config_ids")
    @JsonView({TestRail.Plans.Add.class, TestRail.Plans.AddEntry.class})
    private List<Integer> configIds;

    private int passedCount;

    private int blockedCount;

    private int untestedCount;

    private int retestCount;

    private int failedCount;

    private int customStatus1Count;

    private int customStatus2Count;

    private int customStatus3Count;

    private int customStatus4Count;

    private int customStatus5Count;

    private int customStatus6Count;

    private int customStatus7Count;

}

/*
/*
 *     Copyright 2017 Hewlett-Packard Development Company, L.P.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.hp.application.automation.tools.octane.actions.dto;

import com.hp.mqm.client.model.ListItem;

/**
 * Created by kashbi on 25/09/2016.
 */
@SuppressWarnings({"squid:S2699", "squid:S3658", "squid:S2259", "squid:S1872", "squid:S2925", "squid:S109"})
public class TestFramework {
    private String type = "list_node";
    private String logical_name;
    private String name;
    private Long id;

    public static TestFramework fromListItem(ListItem item) {
        TestFramework type = new TestFramework();
        type.logical_name = item.getLogicalName();
        type.id = item.getId();
        type.name = item.getName();
        return type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogical_name() {
        return logical_name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
package org.kamenkov.java_kanban.task;

import org.kamenkov.java_kanban.Status;

public interface Task {

    /**
     * Gets summary of {@link Task}.
     * @return summary.
     */
    String getSummary();

    /**
     * Update summary of {@link Task}
     * @param summary {@link String} that should be saved in summary.
     */
    void setSummary(String summary);

    /**
     * Gets description of {@link Task}.
     * @return description.
     */
    String getDescription();

    /**
     * Update description of {@link Task}
     * @param description {@link String} that should be saved in description.
     */
    void setDescription(String description);

    /**
     * Gets status of {@link Task}.
     * @return status.
     */
    Status getStatus();

    /**
     * Update status of {@link Task}
     * @param status {@link Status} that should be saved in status.
     */
    void setStatus(Status status);

    /**
     * Gets id of {@link Task}.
     * @return unique id of {@link Task}.
     */
    Long getId();

    /**
     * Update unique id of {@link Task}.
     * @param id {@link Long} that should be saved in id.
     */
    void setId(Long id);

}
